package daos;

import java.util.List;

import javax.persistence.EntityTransaction;

import htqlbv_entities.NhanVien;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class NhanVienDaos extends GeneralCRUD<NhanVien> {
	@SuppressWarnings("unchecked")
	public List<NhanVien> getBacSy() {
		return manager.createNativeQuery(
				"select a.* from NhanVien a inner join TaiKhoan b on a.IDNhanVien = b.IDNhanVien where b.Loai like N'Bác Sỹ'",
				NhanVien.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<NhanVien> getNhanVien(String username, String password) {
		return manager.createNativeQuery(
				"select a.* from NhanVien a inner join TaiKhoan b on a.IDNhanVien=b.IDNhanVien where b.Username like '"
						+ username + "' and b.Matkhau like '" + password + "'",
				NhanVien.class).getResultList();
	}

	public NhanVien getTheoID(String id) {
		return manager.find(NhanVien.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<NhanVien> timTheoID(String id) {
		String s = "select * from [dbo].[NhanVien] where [IDNhanVien] = '" + id + "'";
		return manager.createNativeQuery(s, NhanVien.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<NhanVien> timTheoTen(String ten) {
		String s = "select * from [dbo].[NhanVien] where [Ten] like '" + ten + "'";
		return manager.createNativeQuery(s, NhanVien.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<NhanVien> timTheoSDT(String SDT) {
		String s = "select * from [dbo].[NhanVien] where [SDT] = '" + SDT + "'";
		return manager.createNativeQuery(s, NhanVien.class).getResultList();
	}

	public boolean xoaTheoID(String id) {

		NhanVien nhanVien = manager.find(NhanVien.class, id);
		if (nhanVien != null) {
			try {
				manager.getTransaction().begin();
				manager.remove(nhanVien);
				flushAndClear();
				manager.getTransaction().commit();
				return true;
			} catch (Exception e) {
				manager.getTransaction().rollback();
			}
		}
		return false;
	}

	public boolean themNhanVien(NhanVien t) {
		try {
			manager.getTransaction().begin();
			manager.persist(t);
			flushAndClear();
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		return false;
	}
}
