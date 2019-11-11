package aplication;

import java.time.LocalDate;
import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.smart.SmartLookAndFeel;

import daos.BenhAnDaos;
import daos.BenhNhanDaos;
import daos.NhanVienDaos;
import daos.TaiKhoanDaos;
import daos.ThuocDaos;
import gui.Gui_DangNhap;
import htqlbv_entities.BenhAn;
import htqlbv_entities.BenhNhan;
import htqlbv_entities.NhanVien;
import htqlbv_entities.TaiKhoan;
import htqlbv_entities.Thuoc;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class Main_App {
	public static void main(String[] args) {
		try {

            Properties props = new Properties();
            
            props.put("logoString", "my company"); 
            props.put("licenseKey", "INSERT YOUR LICENSE KEY HERE");
            
            props.put("selectionBackgroundColor", "180 240 197"); 
            props.put("menuSelectionBackgroundColor", "180 240 197"); 
            
            props.put("controlColor", "218 254 230");
            props.put("controlColorLight", "218 254 230");
            props.put("controlColorDark", "180 240 197"); 

            props.put("buttonColor", "218 230 254");
            props.put("buttonColorLight", "255 255 255");
            props.put("buttonColorDark", "244 242 232");

            props.put("rolloverColor", "218 254 230"); 
            props.put("rolloverColorLight", "218 254 230"); 
            props.put("rolloverColorDark", "180 240 197"); 

            props.put("windowTitleForegroundColor", "0 0 0");
            props.put("windowTitleBackgroundColor", "180 240 197"); 
            props.put("windowTitleColorLight", "218 254 230"); 
            props.put("windowTitleColorDark", "180 240 197"); 
            props.put("windowBorderColor", "218 254 230");
            
            // set your theme
            SmartLookAndFeel.setCurrentTheme(props);
            // select the Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            new Gui_DangNhap();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
/**
 * Thêm dữ liệu vào database
 */
///////////////////////////////////////////////////////////////////////////		
		NhanVienDaos nhanVienDaos = new NhanVienDaos();
		TaiKhoanDaos taiKhoanDaos = new TaiKhoanDaos();
		BenhAnDaos benhAnDaos = new BenhAnDaos();
		BenhNhanDaos benhNhanDaos = new BenhNhanDaos();
		ThuocDaos thuocDaos = new ThuocDaos();
		
		NhanVien nhanVien1 = new NhanVien("nhanvien1","Quang" , "Trịnh Đình", "Phan Văn Trị, Gò Vấp", "0334054618", LocalDate.of(1998, 12, 25));
		TaiKhoan taiKhoan1 = new TaiKhoan("taikhoan1", "Nhân Viên Nhận Bệnh", "nvnb1", "123", LocalDate.of(2017, 04, 11)) ;
		
		nhanVien1.setTaiKhoan(taiKhoan1);
		taiKhoan1.setNhanVien(nhanVien1);
		
		NhanVien nhanVien2 = new NhanVien("nhanvien2","Hùng" , "Nguyễn Phi", "Tân Bình", "0397026798", LocalDate.of(1998,7, 26));
		TaiKhoan taiKhoan2 = new TaiKhoan("taikhoan2", "Bác Sỹ", "bs1", "123", LocalDate.of(2017, 04, 11)) ;
		
		nhanVien2.setTaiKhoan(taiKhoan2);
		taiKhoan2.setNhanVien(nhanVien2);
		
		NhanVien nhanVien3 = new NhanVien("nhanvien3","Luân" , "Nguyễn Thành", "Bình Thạnh", "0321456987", LocalDate.of(1975, 2, 26));
		TaiKhoan taiKhoan3 = new TaiKhoan("taikhoan3", "Bác Sỹ", "bs2", "123", LocalDate.of(2017, 05, 11)) ;
		
		nhanVien3.setTaiKhoan(taiKhoan3);
		taiKhoan3.setNhanVien(nhanVien3);
		
		NhanVien nhanVien4 = new NhanVien("nhanvien4","Tài" , "Bạch Tấn", "Quận 12", "0214569852", LocalDate.of(1995, 2, 26));
		TaiKhoan taiKhoan4 = new TaiKhoan("taikhoan4", "Bác Sỹ", "bs3", "123", LocalDate.of(2017, 04, 11)) ;
		
		nhanVien4.setTaiKhoan(taiKhoan4);
		taiKhoan4.setNhanVien(nhanVien4);

		NhanVien nhanVien5 = new NhanVien("nhanvien5", "Kiệt", "Ngô Tuấn", "Quận 2", "0321455216", LocalDate.of(1966, 2, 11));
		TaiKhoan taiKhoan5 = new TaiKhoan("taikhoan5", "Nhân Viên Nhận Bệnh", "nvnb2", "123", LocalDate.of(2000, 2, 11));
		
		nhanVien5.setTaiKhoan(taiKhoan5);
		taiKhoan5.setNhanVien(nhanVien5);
		
		NhanVien nhanVien6 = new NhanVien("nhanvien6", "Lực", "Võ Tấn", "Quận 5", "032564852", LocalDate.of(1998, 02, 11));
		TaiKhoan taiKhoan6 = new TaiKhoan("taikhoan6", "Nhân Viên Phát Thuốc", "nvpt1", "123", LocalDate.of(2002, 2, 11));

		nhanVien6.setTaiKhoan(taiKhoan6);
		taiKhoan6.setNhanVien(nhanVien6);
		
		NhanVien nhanVien7 = new NhanVien("nhanvien7", "Đạt", "Doãn Trần Tuấn", "Quận 1", "0321563214", LocalDate.of(1998, 07, 31));
		TaiKhoan taiKhoan7 = new TaiKhoan("taikhoan7", "Quản Lý", "quanli1", "123", LocalDate.of(2006, 2, 11));
		
		nhanVien7.setTaiKhoan(taiKhoan7);
		taiKhoan7.setNhanVien(nhanVien7);
		
		nhanVienDaos.Them(nhanVien1);
		taiKhoanDaos.Them(taiKhoan1);
		nhanVienDaos.Them(nhanVien2);
		taiKhoanDaos.Them(taiKhoan2);
		nhanVienDaos.Them(nhanVien3);
		taiKhoanDaos.Them(taiKhoan3);
		nhanVienDaos.Them(nhanVien4);
		taiKhoanDaos.Them(taiKhoan4);
		nhanVienDaos.Them(nhanVien5);
		taiKhoanDaos.Them(taiKhoan5);
		nhanVienDaos.Them(nhanVien6);
		taiKhoanDaos.Them(taiKhoan6);
		nhanVienDaos.Them(nhanVien7);
		taiKhoanDaos.Them(taiKhoan7);
		
		BenhNhan benhNhan1 = new BenhNhan("bn1", "Bủm", "Trần Thành", "0236541235", "Gò Vấp");
		BenhNhan benhNhan2 = new BenhNhan("bn2","Quang","Nguyễn Lê Nhật","0321564235","Gò Vấp");
		BenhNhan benhNhan3 = new BenhNhan("bn3", "Mai", "Nguyễn Giang", "0325648624", "Gò Vấp");
		
		benhNhanDaos.Them(benhNhan1);
		benhNhanDaos.Them(benhNhan2);
		benhNhanDaos.Them(benhNhan3);
		
		
		BenhAn benhAn1 = new BenhAn(LocalDate.now(), null);
		benhAn1.setBenhNhan(benhNhan2);
		benhAn1.setNhanVien(nhanVien2);
		
		BenhAn benhAn2 = new BenhAn(LocalDate.now(), null);
		benhAn2.setBenhNhan(benhNhan2);
		benhAn2.setNhanVien(nhanVien4);
		
		BenhAn benhAn3 = new BenhAn(LocalDate.now(), null);
		benhAn3.setBenhNhan(benhNhan3);
		benhAn3.setNhanVien(nhanVien2);

		benhAnDaos.Them(benhAn1);
		benhAnDaos.Them(benhAn2);
		benhAnDaos.Them(benhAn3);

		Thuoc thuoc1 = new Thuoc(10000, "TH1", "Thuốc Cảm");
		Thuoc thuoc2 = new Thuoc(20000, "TH2", "Thuốc Ho");
		Thuoc thuoc3 = new Thuoc(30000, "TH3", "Thuốc Giảm Đau");
		Thuoc thuoc4 = new Thuoc(40000, "TH4", "Thuốc Hạ Sốt");
		Thuoc thuoc5 = new Thuoc(60000, "TH5", "Thuốc Tránh Thai");
		Thuoc thuoc6 = new Thuoc(60000, "TH6", "Thuốc Thận");
		Thuoc thuoc7 = new Thuoc(50000, "TH7", "Thuốc Gan");
		Thuoc thuoc8 = new Thuoc(50000, "TH8", "Thuốc Phổi");
		

		thuocDaos.Them(thuoc1);
		thuocDaos.Them(thuoc2);
		thuocDaos.Them(thuoc3);
		thuocDaos.Them(thuoc4);
		thuocDaos.Them(thuoc5);
		thuocDaos.Them(thuoc6);
		thuocDaos.Them(thuoc7);
		thuocDaos.Them(thuoc8);

/////////////////////////////////////////////////////////////////////////////////////////

		
}
}

