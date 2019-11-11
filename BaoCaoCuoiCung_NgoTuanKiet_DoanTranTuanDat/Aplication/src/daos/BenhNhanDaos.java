package daos;

import java.util.List;

import htqlbv_entities.BenhNhan;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class BenhNhanDaos extends GeneralCRUD<BenhNhan> {
	@SuppressWarnings("unchecked")
	public List<BenhNhan> TimTheoTen(String tenbn) {
		String ho = "",ten = "";
		int dem = 0;
		for(int i = tenbn.length()-1;i>=0;i--)
		{
			if(tenbn.charAt(i)== ' ')
			{
				dem++;
			}
			if(dem==1)
			{
				ten = ten + tenbn.substring(i+1, tenbn.length());
				ho = ho + tenbn.substring(0,i);
				break;
			}
		}
		if(!ho.isEmpty() && !ten.isEmpty())
		{
			String a = "select * from BenhNhan c where c.Ho like N'%"+ho+"%' and c.TenBN like N'%"+ten+"%'";
			return manager.createNativeQuery(a,BenhNhan.class).getResultList();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<BenhNhan> TimTheoSDT(String sdt){
		String a = "select * from BenhNhan c where c.SDT like '"+sdt+"'";
		return manager.createNativeQuery(a,BenhNhan.class).getResultList();
	}
	public boolean xoaTheoID(String id) {
		BenhNhan benhNhan = manager.find(BenhNhan.class, id);
		if (benhNhan != null) {
			manager.getTransaction().begin();
	        manager.remove(benhNhan);
	        manager.getTransaction().commit();
	        return true;
		}
		return false;
	}
	public BenhNhan getBenhNhanTheoID(String id) {
		return manager.find(BenhNhan.class, id);
	}
	
	public List<BenhNhan> TimTheoIDToathuoc(String id) {
		String a = "select bn.IDBenhNhan, bn.DiaChi, bn.Ho, bn.SDT, bn.TenBN from ToaThuoc tt inner join BenhAn ba on tt.IdBenhAn=ba.IdBenhAn inner join BenhNhan bn on ba.IDBenhNhan = bn.IDBenhNhan\r\n" + 
				"where tt.IDToaThuoc like '"+id+"'";
		return manager.createNativeQuery(a, BenhNhan.class).getResultList();
	}
}
