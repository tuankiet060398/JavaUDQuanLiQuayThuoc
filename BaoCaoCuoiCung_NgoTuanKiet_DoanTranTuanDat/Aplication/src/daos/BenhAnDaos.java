package daos;

import java.util.List;

import htqlbv_entities.BenhAn;

/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class BenhAnDaos extends GeneralCRUD<BenhAn>{
	public BenhAn layBenhAnTheoID(int id) {
		return manager.find(BenhAn.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<BenhAn> layBenhAntheoIDBenhNhan(String id) {
		return manager.createNativeQuery("select * from BenhAn where IDBenhNhan = '"+id+"' and TenBenh is null ",
				BenhAn.class).getResultList();
	}
}
