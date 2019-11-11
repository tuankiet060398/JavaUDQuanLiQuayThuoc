package daos;

import java.util.List;

import htqlbv_entities.NhanVien;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class DangNhapDaos {
	private NhanVienDaos nhanVienDaos;
	public DangNhapDaos() {
		nhanVienDaos = new NhanVienDaos();
	}
	public NhanVien LoginNhanVien(String username,String password)
	{
		List<NhanVien> dsnv =  nhanVienDaos.getNhanVien(username, password);
		NhanVien nhanVien = null;
		if(!dsnv.isEmpty()) {
			nhanVien = dsnv.get(0);
		}
		return nhanVien;
	}
}
