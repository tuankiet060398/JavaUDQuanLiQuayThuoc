package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Gui_HuongDanSuDung.Gui_HuongDan_BacSi;
import daos.BacSiDaos;
import daos.BenhAnDaos;
import daos.BenhNhanDaos;
import daos.ChiTietKhoThuocDaos;
import daos.DonXetNghiemDaos;
import daos.NhanVienDaos;
import daos.ThuocDaos;
import daos.ToaThuocDaos;
import htqlbv_entities.BenhAn;
import htqlbv_entities.BenhNhan;
import htqlbv_entities.ChiTietKhoThuoc;
import htqlbv_entities.DonXetNghiem;
import htqlbv_entities.NhanVien;
import htqlbv_entities.Thuoc;
import htqlbv_entities.ToaThuoc;

/**
 * 
 * @author Doãn Trần Tuấn Đạt - 16035741 Ngô Tuấn Kiệt - 16044771
 *
 */
public class Gui_BacSi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDangXuat;
	private JTabbedPane tbpqlcn;
	private JLabel lblmanv;
	private JTextField txtmanv;
	private JLabel lblhonv;
	private JTextField txthonv;
	private JLabel lbltennv;
	private JTextField txttennv;
	private JLabel lblsdtnv;
	private JTextField txtsdtnv;
	private JLabel lblngaysinhnv;
	private JTextField txtngaysinhnv;
	private JLabel lbldiacchinv;
	private JTextField txtdiachinv;
	private JLabel lblmkc;
	private JPasswordField txtmkc;
	private JLabel lblmkm;
	private JPasswordField txtmkm;
	private JLabel lblnlmkm;
	private JPasswordField txtnlmkm;
	private JButton btnDoimk;
	private JButton btnHuy;
	private JTabbedPane tbp;
	private JTextField txtidbn;
	private JTextField txthobn;
	private JTextField txttenbn;
	private JTextField txtsdtbn;
	private JTextField txtdiachibn;
	private JButton btnLuu;
	private JButton btnChuyenBenhNhan;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JTextField txtidba;
	private JTextField txtnlba;
	private JTextField txttenba;
	private JCheckBox tbox_XetNghiem;
	private JTextField txtIDThuoc;
	private JTextField txtTenThuoc;
	private JTabbedPane tabKhamBenh;
	private DefaultTableModel tablemodel_KhoThuoc;
	private JTable table_KhoThuoc;
	private JButton btn_Them_ToaThuoc;
	private JTextField txtSoLuongThuoc;
	private JTextField txtGhiChu;
	private JButton btn_Xoa;
	private DefaultTableModel tablemodel_ToaThuoc;
	private JTable table_ToaThuoc;
	private BacSiDaos bacSiDaos;
	private NhanVienDaos nhanVienDaos;
	private BenhNhanDaos benhNhanDaos;
	private BenhAnDaos benhAnDaos;
	private ThuocDaos thuocDaos;
	private ToaThuocDaos toaThuocDaos;
	private ChiTietKhoThuocDaos chiTietKhoThuocDaos;
	private DonXetNghiemDaos donXetNghiemDaos;

	private List<BenhAn> list;
	private List<Thuoc> dsThuoc;

	private JTextField txtKetQua;
	private JTextField txtIDXetNghiem;
	private JButton btn_Luu_ToaThuoc;
	private JTextField txtIDToaThuoc;
	private JTextField txtIDBenhan_trenToaThuoc;
	private JLabel lblTenDn;

	private NhanVien nhanVien;
	private JButton btnHelp;
	private JTextField txtNoiDung;

	public Gui_BacSi(NhanVien nhanVien) {
		bacSiDaos = new BacSiDaos();
		this.nhanVien = nhanVien;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle("Bác sĩ");
		setIconImage(new ImageIcon(getClass()
				.getResource("/ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png"))
						.getImage());

		bacSiDaos = new daos.BacSiDaos();
		nhanVienDaos = new NhanVienDaos();
		benhNhanDaos = new BenhNhanDaos();
		benhAnDaos = new BenhAnDaos();
		thuocDaos = new ThuocDaos();
		toaThuocDaos = new ToaThuocDaos();
		chiTietKhoThuocDaos = new ChiTietKhoThuocDaos();
		donXetNghiemDaos = new DonXetNghiemDaos();
		Box bt = Box.createVerticalBox();// Cái này là quản lý chung của cả frame
		/**
		 * Cái này là tiêu đề
		 */
		////////////////////////////////
		Box b1 = Box.createHorizontalBox();
		b1.setMaximumSize(getMaximumSize());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(new JLabel(new ImageIcon(getClass().getResource("/ima/if_9_375256.png"))));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTenDn = new JLabel(nhanVien.getHo() + " " + nhanVien.getTen()));
		lblTenDn.setFont(new Font("Times new Roman", Font.BOLD, 20));
		lblTenDn.setForeground(Color.RED);
		b1.add(Box.createHorizontalStrut(400));
		b1.add(btnDangXuat = new JButton("Đăng Xuất",
				new ImageIcon(getClass().getResource("/ima/if_Logout_105217.png"))));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnHelp = new JButton("Trợ giúp",
				new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png"))));
		bt.add(b1);

		/*
		 * Phần này là quản lí cá nhân
		 */
		tbpqlcn = new JTabbedPane();
		Box bqlcn_XemThongTin, bqlcn_DoiMatKhau;
		bqlcn_XemThongTin = Box.createVerticalBox();// bqlcn_XemThongTin quản lý chung của xem thông tin
		Box bqlcn_XemThongTin_Manv = Box.createHorizontalBox();
		bqlcn_XemThongTin_Manv.add(Box.createHorizontalStrut(10));
		bqlcn_XemThongTin_Manv.add(lblmanv = new JLabel("Mã số nhân viên:"));
		lblmanv.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_XemThongTin_Manv.add(Box.createHorizontalStrut(50));
		bqlcn_XemThongTin_Manv.add(txtmanv = new JTextField());
		bqlcn_XemThongTin_Manv.add(Box.createHorizontalStrut(50));
		Box bqlcn_XemThongTin_Ho = Box.createHorizontalBox();
		bqlcn_XemThongTin_Ho.add(Box.createHorizontalStrut(10));
		bqlcn_XemThongTin_Ho.add(lblhonv = new JLabel("Họ:"));
		lblhonv.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_XemThongTin_Ho.add(Box.createHorizontalStrut(130));
		bqlcn_XemThongTin_Ho.add(txthonv = new JTextField());
		bqlcn_XemThongTin_Ho.add(Box.createHorizontalStrut(50));
		Box bqlcn_XemThongTin_Ten = Box.createHorizontalBox();
		bqlcn_XemThongTin_Ten.add(Box.createHorizontalStrut(10));
		bqlcn_XemThongTin_Ten.add(lbltennv = new JLabel("Tên:"));
		lbltennv.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_XemThongTin_Ten.add(Box.createHorizontalStrut(125));
		bqlcn_XemThongTin_Ten.add(txttennv = new JTextField());
		bqlcn_XemThongTin_Ten.add(Box.createHorizontalStrut(50));
		Box bqlcn_XemThongTin_Sdt = Box.createHorizontalBox();
		bqlcn_XemThongTin_Sdt.add(Box.createHorizontalStrut(10));
		bqlcn_XemThongTin_Sdt.add(lblsdtnv = new JLabel("Số điện thoại:"));
		lblsdtnv.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_XemThongTin_Sdt.add(Box.createHorizontalStrut(70));
		bqlcn_XemThongTin_Sdt.add(txtsdtnv = new JTextField());
		bqlcn_XemThongTin_Sdt.add(Box.createHorizontalStrut(50));
		Box bqlcn_XemThongTin_NgaySinh = Box.createHorizontalBox();
		bqlcn_XemThongTin_NgaySinh.add(Box.createHorizontalStrut(10));
		bqlcn_XemThongTin_NgaySinh.add(lblngaysinhnv = new JLabel("Ngày sinh:"));
		lblngaysinhnv.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_XemThongTin_NgaySinh.add(Box.createHorizontalStrut(90));
		bqlcn_XemThongTin_NgaySinh.add(txtngaysinhnv = new JTextField());
		bqlcn_XemThongTin_NgaySinh.add(Box.createHorizontalStrut(50));
		Box bqlcn_XemThongTin_Diachi = Box.createHorizontalBox();
		bqlcn_XemThongTin_Diachi.add(Box.createHorizontalStrut(10));
		bqlcn_XemThongTin_Diachi.add(lbldiacchinv = new JLabel("Địa chỉ:"));
		lbldiacchinv.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_XemThongTin_Diachi.add(Box.createHorizontalStrut(110));
		bqlcn_XemThongTin_Diachi.add(txtdiachinv = new JTextField());
		bqlcn_XemThongTin_Diachi.add(Box.createHorizontalStrut(50));

		bqlcn_XemThongTin.add(Box.createVerticalStrut(10));
		bqlcn_XemThongTin.add(bqlcn_XemThongTin_Manv);
		bqlcn_XemThongTin.add(Box.createVerticalStrut(30));
		bqlcn_XemThongTin.add(bqlcn_XemThongTin_Ho);
		bqlcn_XemThongTin.add(Box.createVerticalStrut(30));
		bqlcn_XemThongTin.add(bqlcn_XemThongTin_Ten);
		bqlcn_XemThongTin.add(Box.createVerticalStrut(30));
		bqlcn_XemThongTin.add(bqlcn_XemThongTin_Sdt);
		bqlcn_XemThongTin.add(Box.createVerticalStrut(30));
		bqlcn_XemThongTin.add(bqlcn_XemThongTin_NgaySinh);
		bqlcn_XemThongTin.add(Box.createVerticalStrut(30));
		bqlcn_XemThongTin.add(bqlcn_XemThongTin_Diachi);
		bqlcn_XemThongTin.add(Box.createVerticalStrut(150));

		bqlcn_DoiMatKhau = Box.createVerticalBox();// bqlcn_DoiMatKhau là quản lý chung của đổi mật khẩu
		Box bqlcn_DoiMatKhau_mkc = Box.createHorizontalBox();
		bqlcn_DoiMatKhau_mkc.add(Box.createHorizontalStrut(20));
		bqlcn_DoiMatKhau_mkc.add(lblmkc = new JLabel("Nhập lại mật khẩu cũ"));
		lblmkc.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_DoiMatKhau_mkc.add(Box.createHorizontalStrut(50));
		bqlcn_DoiMatKhau_mkc.add(txtmkc = new JPasswordField());
		bqlcn_DoiMatKhau_mkc.add(Box.createHorizontalStrut(20));
		Box bqlcn_DoiMatKhau_mkm = Box.createHorizontalBox();
		bqlcn_DoiMatKhau_mkm.add(Box.createHorizontalStrut(20));
		bqlcn_DoiMatKhau_mkm.add(lblmkm = new JLabel("Nhập mật khẩu mới"));
		lblmkm.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_DoiMatKhau_mkm.add(Box.createHorizontalStrut(60));
		bqlcn_DoiMatKhau_mkm.add(txtmkm = new JPasswordField());
		bqlcn_DoiMatKhau_mkm.add(Box.createHorizontalStrut(20));
		Box bqlcn_DoiMatKhau_nlmkm = Box.createHorizontalBox();
		bqlcn_DoiMatKhau_nlmkm.add(Box.createHorizontalStrut(20));
		bqlcn_DoiMatKhau_nlmkm.add(lblnlmkm = new JLabel("Nhập lại mật khẩu mới"));
		lblnlmkm.setFont(new Font("Times new roman", Font.PLAIN, 16));
		bqlcn_DoiMatKhau_nlmkm.add(Box.createHorizontalStrut(40));
		bqlcn_DoiMatKhau_nlmkm.add(txtnlmkm = new JPasswordField());
		bqlcn_DoiMatKhau_nlmkm.add(Box.createHorizontalStrut(20));
		Box bqlcn_DoiMatKhau_button = Box.createHorizontalBox();
		bqlcn_DoiMatKhau_button.add(Box.createHorizontalStrut(20));
		bqlcn_DoiMatKhau_button.add(btnDoimk = new JButton("Đổi mật khẩu",
				new ImageIcon(getClass().getResource("/ima/if_Access_field_pin_input_password_2629858 .png"))));
		btnDoimk.setSize(new Dimension(50, 20));
		bqlcn_DoiMatKhau_button.add(Box.createHorizontalStrut(50));
		bqlcn_DoiMatKhau_button
				.add(btnHuy = new JButton("Hủy", new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png"))));
		btnHuy.setMaximumSize(new Dimension(150, 60));
		bqlcn_DoiMatKhau_button.add(Box.createHorizontalStrut(20));
		bqlcn_DoiMatKhau.add(Box.createVerticalStrut(10));
		bqlcn_DoiMatKhau.add(bqlcn_DoiMatKhau_mkc);
		bqlcn_DoiMatKhau.add(Box.createVerticalStrut(45));
		bqlcn_DoiMatKhau.add(bqlcn_DoiMatKhau_mkm);
		bqlcn_DoiMatKhau.add(Box.createVerticalStrut(45));
		bqlcn_DoiMatKhau.add(bqlcn_DoiMatKhau_nlmkm);
		bqlcn_DoiMatKhau.add(Box.createVerticalStrut(45));
		bqlcn_DoiMatKhau.add(bqlcn_DoiMatKhau_button);
		bqlcn_DoiMatKhau.add(Box.createVerticalStrut(200));
		tbpqlcn.addTab("Xem Thông tin",
				new ImageIcon(getClass().getResource("/ima/if_icon-85-folder-information_314768.png")),
				bqlcn_XemThongTin);
		tbpqlcn.addTab("Đổi mật khẩu",
				new ImageIcon(getClass().getResource("/ima/if_Access_field_pin_input_password_2629858 .png")),
				bqlcn_DoiMatKhau);
		tbpqlcn.setFont(new Font("Times new Roman", Font.PLAIN, 20));

		/*
		 * Phần này là Khám bệnh
		 */

		tabKhamBenh = new JTabbedPane();
		tabKhamBenh.setMaximumSize(getMaximumSize());
		Box bKhamBenh_GhiThongTin = Box.createVerticalBox(); // bqlbn là box chung quản lý toàn bộ quản lý bệnh nhân

		Box bqlbn1 = Box.createHorizontalBox(); // bqlbn1 là box để quản lý dòng trên cùng
		bqlbn1.setMaximumSize(getMaximumSize());

		Box bqlbn1_ThongTin = Box.createVerticalBox();// box thông tin bệnh nhân
		bqlbn1_ThongTin.setMaximumSize(getMaximumSize());
		bqlbn1_ThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));
		Box bqlbn1_ThongTin_ID = Box.createHorizontalBox();
		bqlbn1_ThongTin_ID.add(Box.createHorizontalStrut(20));
		bqlbn1_ThongTin_ID.add(new JLabel("Mã số bệnh nhân: "));
		bqlbn1_ThongTin_ID.add(Box.createHorizontalStrut(20));// Khoảng cách giữa chữ và textfield
		bqlbn1_ThongTin_ID.add(txtidbn = new JTextField());
		Box bqlbn1_ThongTin_Ho = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ho.add(Box.createHorizontalStrut(20));
		bqlbn1_ThongTin_Ho.add(new JLabel("Họ: "));
		bqlbn1_ThongTin_Ho.add(Box.createHorizontalStrut(100));
		bqlbn1_ThongTin_Ho.add(txthobn = new JTextField());
		Box bqlbn1_ThongTin_Ten = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ten.add(Box.createHorizontalStrut(20));
		bqlbn1_ThongTin_Ten.add(new JLabel("Tên: "));
		bqlbn1_ThongTin_Ten.add(Box.createHorizontalStrut(95));
		bqlbn1_ThongTin_Ten.add(txttenbn = new JTextField());
		Box bqlbn1_ThongTin_Sdt = Box.createHorizontalBox();
		bqlbn1_ThongTin_Sdt.add(Box.createHorizontalStrut(20));
		bqlbn1_ThongTin_Sdt.add(new JLabel("Số điện thoại: "));
		bqlbn1_ThongTin_Sdt.add(Box.createHorizontalStrut(44));
		bqlbn1_ThongTin_Sdt.add(txtsdtbn = new JTextField());
		Box bqlbn1_ThongTin_DiaChi = Box.createHorizontalBox();
		bqlbn1_ThongTin_DiaChi.add(Box.createHorizontalStrut(20));
		bqlbn1_ThongTin_DiaChi.add(new JLabel("Địa chỉ: "));
		bqlbn1_ThongTin_DiaChi.add(Box.createHorizontalStrut(77));
		bqlbn1_ThongTin_DiaChi.add(txtdiachibn = new JTextField());
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5)); // Khoảng cách giữa các dòng
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_ID);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ho);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ten);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Sdt);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_DiaChi);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1.add(bqlbn1_ThongTin);

		/*
		 * Phần này là Ghi tình trạng bệnh nhân
		 */
		Box bqlbn1_GhiBenh = Box.createVerticalBox();
		bqlbn1_GhiBenh.setMinimumSize(getMinimumSize());
		bqlbn1_GhiBenh.setBorder(BorderFactory.createTitledBorder("Ghi tình trạng bệnh"));

		Box bqlbn1_GhiBenh_ID = Box.createHorizontalBox();
		bqlbn1_GhiBenh_ID.add(Box.createHorizontalStrut(20));
		bqlbn1_GhiBenh_ID.add(new JLabel("Mã số bệnh án: "));
		bqlbn1_GhiBenh_ID.add(Box.createHorizontalStrut(55));// Khoảng cách giữa chữ và textfield
		bqlbn1_GhiBenh_ID.add(txtidba = new JTextField());
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_ID);

		Box bqlbn1_GhiBenh_NgayLap = Box.createHorizontalBox();
		bqlbn1_GhiBenh_NgayLap.add(Box.createHorizontalStrut(20));
		bqlbn1_GhiBenh_NgayLap.add(new JLabel("Ngày lập: "));
		bqlbn1_GhiBenh_NgayLap.add(Box.createHorizontalStrut(88));// Khoảng cách giữa chữ và textfield
		bqlbn1_GhiBenh_NgayLap.add(txtnlba = new JTextField());
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_NgayLap);

		Box bqlbn1_GhiBenh_TenBenh = Box.createHorizontalBox();
		bqlbn1_GhiBenh_TenBenh.add(Box.createHorizontalStrut(20));
		bqlbn1_GhiBenh_TenBenh.add(new JLabel("Tên bệnh: "));
		bqlbn1_GhiBenh_TenBenh.add(Box.createHorizontalStrut(84));// Khoảng cách giữa chữ và textfield
		bqlbn1_GhiBenh_TenBenh.add(txttenba = new JTextField());
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_TenBenh);

		Box bqlbn1_GhiBenh_CbXetNghiem = Box.createHorizontalBox();
		bqlbn1_GhiBenh_CbXetNghiem.add(tbox_XetNghiem = new JCheckBox("Xét nghiệm"));
		tbox_XetNghiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bqlbn1_GhiBenh_CbXetNghiem.setAlignmentX(RIGHT_ALIGNMENT);
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_CbXetNghiem);

		Box bqlbn1_GhiBenh_XetNghiem_Ma = Box.createHorizontalBox();
		bqlbn1_GhiBenh_XetNghiem_Ma.add(Box.createHorizontalStrut(20));
		bqlbn1_GhiBenh_XetNghiem_Ma.add(new JLabel("Mã số đơn xét nghiệm:"));
		bqlbn1_GhiBenh_XetNghiem_Ma.add(Box.createHorizontalStrut(19));// Khoảng cách giữa chữ và textfield
		bqlbn1_GhiBenh_XetNghiem_Ma.add(txtIDXetNghiem = new JTextField());
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_XetNghiem_Ma);

		Box bqlbn1_GhiBenh_XetNghiem_NoiDung = Box.createHorizontalBox();
		bqlbn1_GhiBenh_XetNghiem_NoiDung.add(Box.createHorizontalStrut(20));
		bqlbn1_GhiBenh_XetNghiem_NoiDung.add(new JLabel("Nội dung:"));
		bqlbn1_GhiBenh_XetNghiem_NoiDung.add(Box.createHorizontalStrut(90));// Khoảng cách giữa chữ và textfield
		bqlbn1_GhiBenh_XetNghiem_NoiDung.add(txtNoiDung = new JTextField());
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_XetNghiem_NoiDung);

		Box bqlbn1_GhiBenh_XetNghiem_KetQua = Box.createHorizontalBox();
		bqlbn1_GhiBenh_XetNghiem_KetQua.add(Box.createHorizontalStrut(20));
		bqlbn1_GhiBenh_XetNghiem_KetQua.add(new JLabel("Kết quả:"));
		bqlbn1_GhiBenh_XetNghiem_KetQua.add(Box.createHorizontalStrut(98));// Khoảng cách giữa chữ và textfield
		bqlbn1_GhiBenh_XetNghiem_KetQua.add(txtKetQua = new JTextField());
		bqlbn1_GhiBenh.add(bqlbn1_GhiBenh_XetNghiem_KetQua);
		bqlbn1_GhiBenh.add(Box.createVerticalStrut(10));

		bqlbn1.add(bqlbn1_GhiBenh);

		Box bqlbn2_ChucNang = Box.createVerticalBox(); // bqlbn2_ChucNang là quản lý dòng các nút chức năng
		bqlbn2_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bqlbn2_ChucNang.setMaximumSize(getMaximumSize());
		Box bqlbn2_ChucNang_1 = Box.createHorizontalBox();
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));

		bqlbn2_ChucNang_1
				.add(btnLuu = new JButton("Lưu", new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png"))));
		btnLuu.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));

		bqlbn2_ChucNang_1.add(btnChuyenBenhNhan = new JButton("Gọi bệnh nhân",
				new ImageIcon(getClass().getResource("/ima/if_control-next-move-forward-future_3209403.png"))));
		btnChuyenBenhNhan.setMaximumSize(getMaximumSize());

		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));

		bqlbn2_ChucNang.add(bqlbn2_ChucNang_1);

		Box bqlbn3_Danhsach = Box.createVerticalBox(); // bqlbn3_Danhsach là bảng danh sách bệnh nhân
		bqlbn3_Danhsach.setBorder(BorderFactory.createTitledBorder("Danh sách bệnh nhân"));
		Box bqlbn3_Danhsach_1 = Box.createHorizontalBox();
		String[] header = { "Mã số bệnh nhân", "Họ", "Tên", "Số điện thoại", "Địa chỉ" };
		tablemodel = new DefaultTableModel(header, 0);
		bqlbn3_Danhsach_1.add(new JScrollPane(table = new JTable(tablemodel)));
		table.setDefaultEditor(Object.class, null);
		bqlbn3_Danhsach.add(bqlbn3_Danhsach_1);

		bKhamBenh_GhiThongTin.add(bqlbn1);
		bKhamBenh_GhiThongTin.add(bqlbn2_ChucNang);
		bKhamBenh_GhiThongTin.add(bqlbn3_Danhsach);

		tabKhamBenh.addTab("Ghi tình trạng bệnh",
				new ImageIcon(getClass().getResource("/ima/if_prescription_45215.png")), bKhamBenh_GhiThongTin);
		/*
		 * Phần sau là tab Toa thuốc
		 */

		// Box bToathuoc = Box.createVerticalBox();

		Box bToathuoc = Box.createVerticalBox();
		Box bToathuoc_GhiThongTin = Box.createVerticalBox();

		bToathuoc_GhiThongTin.setBorder(BorderFactory.createTitledBorder("Cho toa thuốc"));

		Box bToathuoc_GhiThongTin_IDBenhAn = Box.createHorizontalBox();
		bToathuoc_GhiThongTin_IDBenhAn.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_IDBenhAn.add(new JLabel("Mã bệnh án: "));
		bToathuoc_GhiThongTin_IDBenhAn.add(Box.createHorizontalStrut(5));
		bToathuoc_GhiThongTin_IDBenhAn.add(txtIDBenhan_trenToaThuoc = new JTextField());
		bToathuoc_GhiThongTin_IDBenhAn.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin.add(bToathuoc_GhiThongTin_IDBenhAn);

		Box bToathuoc_GhiThongTin_IDToa = Box.createHorizontalBox();
		bToathuoc_GhiThongTin_IDToa.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_IDToa.add(new JLabel("Mã toa thuốc: "));
		bToathuoc_GhiThongTin_IDToa.add(Box.createHorizontalStrut(0));
		bToathuoc_GhiThongTin_IDToa.add(txtIDToaThuoc = new JTextField());
		bToathuoc_GhiThongTin_IDToa.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin.add(bToathuoc_GhiThongTin_IDToa);

		Box bToathuoc_GhiThongTin_ID = Box.createHorizontalBox();
		bToathuoc_GhiThongTin_ID.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_ID.add(new JLabel("Mã thuốc: "));
		bToathuoc_GhiThongTin_ID.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_ID.add(txtIDThuoc = new JTextField());
		bToathuoc_GhiThongTin_ID.add(Box.createHorizontalStrut(20));
		txtIDThuoc.setEditable(false);
		bToathuoc_GhiThongTin.add(bToathuoc_GhiThongTin_ID);

		Box bToathuoc_GhiThongTin_TenThuoc = Box.createHorizontalBox();
		bToathuoc_GhiThongTin_TenThuoc.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_TenThuoc.add(new JLabel("Tên thuốc: "));
		bToathuoc_GhiThongTin_TenThuoc.add(Box.createHorizontalStrut(15));
		bToathuoc_GhiThongTin_TenThuoc.add(txtTenThuoc = new JTextField());
		bToathuoc_GhiThongTin_TenThuoc.add(Box.createHorizontalStrut(20));
		txtTenThuoc.setEditable(false);
		bToathuoc_GhiThongTin.add(bToathuoc_GhiThongTin_TenThuoc);

		Box bToathuoc_GhiThongTin_SoLuong = Box.createHorizontalBox();
		bToathuoc_GhiThongTin_SoLuong.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_SoLuong.add(new JLabel("Số lượng "));
		bToathuoc_GhiThongTin_SoLuong.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_SoLuong.add(txtSoLuongThuoc = new JTextField());
		bToathuoc_GhiThongTin_SoLuong.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin.add(bToathuoc_GhiThongTin_SoLuong);

		Box bToathuoc_GhiThongTin_GhiChu = Box.createHorizontalBox();
		bToathuoc_GhiThongTin_GhiChu.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin_GhiChu.add(new JLabel("Ghi chú: "));
		bToathuoc_GhiThongTin_GhiChu.add(Box.createHorizontalStrut(26));
		bToathuoc_GhiThongTin_GhiChu.add(txtGhiChu = new JTextField());
		bToathuoc_GhiThongTin_GhiChu.add(Box.createHorizontalStrut(20));
		bToathuoc_GhiThongTin.add(bToathuoc_GhiThongTin_GhiChu);

		bToathuoc.add(bToathuoc_GhiThongTin);

		/*
		 * Bảng kho thuốc
		 */
		Box b_KhoThuoc = Box.createVerticalBox(); // b_KhoThuoc là bảng danh sách kho thuốc mà bác sĩ có thể chọn để đưa
													// vào toa thuốc
		b_KhoThuoc.setBorder(BorderFactory.createTitledBorder("Kho thuốc"));
		Box b_KhoThuoc_1 = Box.createHorizontalBox();
		String[] header_KhoThuoc = { "Mã thuốc", "Tên thuốc", "Đơn giá" };
		tablemodel_KhoThuoc = new DefaultTableModel(header_KhoThuoc, 0);
		b_KhoThuoc_1.add(new JScrollPane(table_KhoThuoc = new JTable(tablemodel_KhoThuoc)));
		table_KhoThuoc.setDefaultEditor(Object.class, null);
		b_KhoThuoc.add(b_KhoThuoc_1);
		bToathuoc.add(b_KhoThuoc);

		/*
		 * 2 nút Thêm và Xóa thuốc ra khỏi Toa thuốc
		 */

		Box b_ThemAndXoa = Box.createVerticalBox();
		b_ThemAndXoa.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		b_ThemAndXoa.setMaximumSize(getMaximumSize());

		Box b_ThemAndXoa_1 = Box.createHorizontalBox();
		b_ThemAndXoa_1.setMaximumSize(getMaximumSize());
		b_ThemAndXoa_1.add(Box.createHorizontalStrut(10));

		b_ThemAndXoa_1.add(btn_Them_ToaThuoc = new JButton("Thêm thuốc vào toa",
				new ImageIcon(getClass().getResource("/ima/if_arrow-down_1055120.png"))));
		btn_Them_ToaThuoc.setMaximumSize(getMaximumSize());
		b_ThemAndXoa_1.add(Box.createHorizontalStrut(10));

		b_ThemAndXoa_1.add(
				btn_Xoa = new JButton("Xóa", new ImageIcon(getClass().getResource("/ima/if_user-trash_118932.png"))));
		btn_Xoa.setMaximumSize(getMaximumSize());
		b_ThemAndXoa_1.add(Box.createHorizontalStrut(10));

		b_ThemAndXoa_1.add(btn_Luu_ToaThuoc = new JButton("Lưu",
				new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png"))));
		btn_Luu_ToaThuoc.setMaximumSize(getMaximumSize());
		b_ThemAndXoa_1.add(Box.createHorizontalStrut(10));

		b_ThemAndXoa.add(b_ThemAndXoa_1);

		bToathuoc.add(b_ThemAndXoa);
		/*
		 * Đây là phần danh sách các thuốc có trong toa thuốc mà bác sĩ đc chọn
		 */

		Box b_ToaThuoc_BacSiChon = Box.createVerticalBox(); // b_ToaThuoc là bảng danh sách thuốc mà bác sĩ đã chọn (Toa
															// thuốc)
		b_ToaThuoc_BacSiChon.setBorder(BorderFactory.createTitledBorder("Toa thuốc"));
		Box b_ToaThuoc_1 = Box.createHorizontalBox();
		String[] header_ToaThuoc = { "Mã thuốc", "Tên thuốc", "Số lượng" };
		tablemodel_ToaThuoc = new DefaultTableModel(header_ToaThuoc, 0);
		b_ToaThuoc_1.add(new JScrollPane(table_ToaThuoc = new JTable(tablemodel_ToaThuoc)));
		table_ToaThuoc.setDefaultEditor(Object.class, null);
		b_ToaThuoc_BacSiChon.add(b_ToaThuoc_1);

		bToathuoc.add(b_ToaThuoc_BacSiChon);

		tabKhamBenh.addTab("Cho toa thuốc",
				new ImageIcon(getClass().getResource("/ima/if_Prescription_addigtion_drugs_Drug_1_3122425.png")),
				bToathuoc);
		tabKhamBenh.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		/////////////////////////////////
		/**
		 * Cái này là quản lý các tab
		 */
		/////////////////////////////////
		tbp = new JTabbedPane();
		tbp.addTab("Quản lý cá nhân", new ImageIcon(getClass().getResource("/ima/if_personal-information_47997.png")),
				tbpqlcn);
		tbp.addTab("Khám bệnh", new ImageIcon(getClass().getResource("/ima/if_Artboard_15_3874674.png")), tabKhamBenh);
		tbp.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		tbp.setTabPlacement(JTabbedPane.LEFT);
		/////////////////////////////////
		txtidbn.setEditable(false);
		txthobn.setEditable(false);
		txtdiachibn.setEditable(false);
		txttenbn.setEditable(false);
		txtsdtbn.setEditable(false);
		txtIDXetNghiem.setEnabled(false);
		txtKetQua.setEnabled(false);
		txtNoiDung.setEnabled(false);
		txtnlba.setEditable(false);

		btn_Xoa.setEnabled(false);
		btn_Them_ToaThuoc.setEnabled(false);
		txtidba.setEditable(false);
		txtIDBenhan_trenToaThuoc.setEnabled(false);

		txtmanv.setEditable(false);
		txtdiachinv.setEditable(false);
		txthonv.setEditable(false);
		txttennv.setEditable(false);
		txtngaysinhnv.setEditable(false);
		txtsdtnv.setEditable(false);

		btnLuu.setEnabled(false);
		////////////
		bt.add(tbp);
		add(bt);
		ThongTinNhanVien();
		setVisible(true);
		////////////////////////////////

		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LuuAction();
			}
		});
		/////////
		LoadBenhNhanVaoBang();
		////////////////////
		LoadThuocVaoBangKhoThuoc();

		/////////////////////////
		tbox_XetNghiem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (tbox_XetNghiem.isSelected()) {
					txtIDXetNghiem.setEnabled(true);
					txtKetQua.setEnabled(true);
					txtNoiDung.setEnabled(true);
				} else {
					txtIDXetNghiem.setEnabled(false);
					txtKetQua.setEnabled(false);
					txtNoiDung.setEnabled(false);
				}

			}
		});
		/////////////////////////

		table_KhoThuoc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_KhoThuoc.getSelectedRow();
				txtIDThuoc.setText(table_KhoThuoc.getValueAt(row, 0).toString());
				txtTenThuoc.setText(table_KhoThuoc.getValueAt(row, 1).toString());
				btn_Them_ToaThuoc.setEnabled(true);

			}
		});
		//////////////
		btn_Them_ToaThuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table_ToaThuoc.getRowCount();
				boolean bool = false;

				String s[] = { txtIDThuoc.getText(), txtTenThuoc.getText(), txtSoLuongThuoc.getText() };

				if (txtSoLuongThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(new JPanel(), "Số lượng trống");
				} else {
					for (int i = 0; i < row; i++) {
						if (table_ToaThuoc.getValueAt(i, 0).toString().equalsIgnoreCase(txtIDThuoc.getText())) {
							int dong = TraVe1Dong();
							int newnum = Integer.parseInt(txtSoLuongThuoc.getText());
							int oldnum = Integer.parseInt(tablemodel_ToaThuoc.getValueAt(dong, 2).toString());
							String totalnum = Integer.toString(newnum + oldnum);
							tablemodel_ToaThuoc.setValueAt(totalnum, dong, 2);
							bool = true;
							break;
						}
					}
					if (bool == false) {
						tablemodel_ToaThuoc.addRow(s);
					}

				}

				XoaTrangThuoc();
			}

			////////////////////////////
			public void XoaTrangThuoc() {

				txtIDThuoc.setText("");
				txtTenThuoc.setText("");
				txtSoLuongThuoc.setText("");

				btn_Them_ToaThuoc.setEnabled(false);

			}
		});
		///////////////

		////////////////

		btn_Xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_ToaThuoc.getSelectedRow();
				tablemodel_ToaThuoc.removeRow(row);
				btn_Xoa.setEnabled(false);

			}
		});
		////////////
		table_ToaThuoc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Xoa.setEnabled(true);

			}
		});
		///////////////////////
		btn_Luu_ToaThuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtIDToaThuoc.getText().equals("") || txtIDBenhan_trenToaThuoc.getText().equals("")
						|| txtGhiChu.getText().equals("")) {
					JOptionPane.showMessageDialog(new JPanel(), "Nhập dữ liệu toa thuốc");
				} else {
					ToaThuoc toathuoc = new ToaThuoc();
					toathuoc.setIDToaThuoc(txtIDToaThuoc.getText());
					toathuoc.setGhiChu(txtGhiChu.getText());
					toathuoc.setTrangThai(false);

					BenhAn benhAn = benhAnDaos.layBenhAnTheoID(Integer.parseInt(txtIDBenhan_trenToaThuoc.getText()));
					toathuoc.setBenhAn(benhAn);
					toaThuocDaos.Them(toathuoc);

					int row = table_ToaThuoc.getRowCount();

					for (int i = 0; i < row; i++) {
						ChiTietKhoThuoc chitiet = new ChiTietKhoThuoc();
						Thuoc thuoc = thuocDaos.GetbyID(tablemodel_ToaThuoc.getValueAt(i, 0).toString());
						chitiet.setIDThuoc(thuoc);

						chitiet.setIDToaThuoc(toathuoc);
						chitiet.setSoLuong(Integer.parseInt(tablemodel_ToaThuoc.getValueAt(i, 2).toString()));
						chiTietKhoThuocDaos.Them(chitiet);
					}
					JOptionPane.showMessageDialog(new JPanel(), "Lưu thành công!");
					XoaTrangToaThuoc();
					XoaBangToaThuoc();
				}

			}

			private void XoaTrangToaThuoc() {
				txtIDBenhan_trenToaThuoc.setText("");
				txtIDToaThuoc.setText("");
				txtIDThuoc.setText("");
				txtTenThuoc.setText("");
				txtSoLuongThuoc.setText("");
				txtGhiChu.setText("");
			}
		});
		btnChuyenBenhNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtidbn.setText(table.getValueAt(0, 0).toString());
				txthobn.setText(table.getValueAt(0, 1).toString());
				txttenbn.setText(table.getValueAt(0, 2).toString());
				txtsdtbn.setText(table.getValueAt(0, 3).toString());
				txtdiachibn.setText(table.getValueAt(0, 4).toString());

				LoadBenhAnVaoTextField_IDBenhNhan(txtidbn.getText());

				tablemodel.removeRow(0);

				txtIDBenhan_trenToaThuoc.setText(txtidba.getText());
				XoaTrangThuoc();
				btnLuu.setEnabled(true);

			}

			private void LoadBenhAnVaoTextField_IDBenhNhan(String id) {
				List<BenhAn> benhan = benhAnDaos.layBenhAntheoIDBenhNhan(id);

				BenhAn ba = benhan.get(0);
				txtidba.setText(Integer.toString(ba.getIdBenhAn()));
				txtnlba.setText(ba.getNgayLap().toString());
				txttenba.setText(ba.getTenBenh());
			}

			private void XoaTrangThuoc() {
				txtIDToaThuoc.setText("");
				txtIDThuoc.setText("");
				txtTenThuoc.setText("");
				txtSoLuongThuoc.setText("");
				txtGhiChu.setText("");
				btn_Them_ToaThuoc.setEnabled(false);

			}
		});
		btnDoimk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DoiMatKhau();

			}
		});
		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoaTrangDoiMatKhau();

			}
		});
		btnDangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Gui_DangNhap();
				dispose();

			}
		});
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Gui_HuongDan_BacSi().setVisible(true);
			}
		});
	}

	private int TraVe1Dong() {
		int dong = 0;
		int row = tablemodel_ToaThuoc.getRowCount();

		for (int i = 0; i < row; i++) {

			String a = tablemodel_ToaThuoc.getValueAt(i, 0).toString();
			String b = txtIDThuoc.getText();
			if (a.equalsIgnoreCase(b))
				dong = i;
		}

		return dong;
	}

	private void LoadThuocVaoBangKhoThuoc() {
		dsThuoc = new ArrayList<>();
		dsThuoc = bacSiDaos.LayThuocTuSQL();
		for (int i = 0; i < dsThuoc.size(); i++) {
			String s[] = { dsThuoc.get(i).getIDThuoc(), dsThuoc.get(i).getTenThuoc(),
					Double.toString(dsThuoc.get(i).getDonGia()) };
			tablemodel_KhoThuoc.addRow(s);
		}
	}

	public void LoadBenhNhanVaoBang() {
		list = new ArrayList<>();
		list = bacSiDaos.LayBenhAnTuSQL();
		BenhNhan bn;
		List<BenhNhan> list_benhnhan = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTenBenh() == null
					&& list.get(i).getNhanVien().getIDNhanVien().equalsIgnoreCase(nhanVien.getIDNhanVien())) {
				bn = list.get(i).getBenhNhan();
				list_benhnhan.add(bn);
			}
		}
		for (int i = 0; i < list_benhnhan.size(); i++) {
			String s[] = { list_benhnhan.get(i).getIDBenhNhan(), list_benhnhan.get(i).getHo(),
					list_benhnhan.get(i).getTenBN(), list_benhnhan.get(i).getSDT(), list_benhnhan.get(i).getDiaChi() };
			tablemodel.addRow(s);
		}
	}

	private void LuuAction() {

		String tam = txtnlba.getText();
		int dem = 0, flag = 0;
		int year = 0, month = 0, day = 0;
		for (int i = 0; i < tam.length(); i++) {
			if (tam.charAt(i) == '-' && dem == 0) {
				year = Integer.parseInt(tam.substring(0, i));
				dem++;
				flag = i;
			} else if (tam.charAt(i) == '-' && dem == 1) {
				month = Integer.parseInt(tam.substring(flag + 1, i));
				day = Integer.parseInt(tam.substring(i + 1, tam.length()));
				break;
			}
		}
		BenhAn ba = benhAnDaos.layBenhAnTheoID(Integer.parseInt(txtidba.getText()));

		try {
			ba.setNgayLap(LocalDate.of(year, month, day));
		} catch (Exception e) {

			JOptionPane.showMessageDialog(new JPanel(), "Ngày nhập không hợp lệ!");
		}

		if (txttenba.getText().equals("")) {
			System.out.println("haha");
			JOptionPane.showMessageDialog(new JPanel(), "Tên bệnh không được rỗng");
			System.out.println("hihi");
		} else {
			ba.setTenBenh(txttenba.getText());
			BenhNhan benhNhan = benhNhanDaos.getBenhNhanTheoID(txtidbn.getText());
			ba.setBenhNhan(benhNhan);

			NhanVien nhanVien = nhanVienDaos.getTheoID(txtmanv.getText());
			ba.setNhanVien(nhanVien);

			bacSiDaos.SuaBenhAn(ba);

			if (tbox_XetNghiem.isSelected()) {
				DonXetNghiem don = new DonXetNghiem();
				don.setIDXetNghiem(txtIDXetNghiem.getText());
				don.setNoiDung(txtNoiDung.getText());
				don.setKetQua(txtKetQua.getText());
				don.setBenhAn(benhAnDaos.layBenhAnTheoID(Integer.parseInt(txtidba.getText())));
				donXetNghiemDaos.Them(don);

			}
			JOptionPane.showMessageDialog(new JPanel(), "Lưu thành công");
			XoaTrangBenhNhan();

			btnLuu.setEnabled(false);
		}

	}

	private void XoaBangToaThuoc() {
		int row = table_ToaThuoc.getRowCount();
		for (int i = 0; i < row; i++) {
			tablemodel_ToaThuoc.removeRow(i);

		}
	}

	private void XoaTrangBenhNhan() {
		txtidbn.setText("");
		txttenbn.setText("");
		txthobn.setText("");
		txtsdtbn.setText("");
		txtdiachibn.setText("");

		txtnlba.setText("");
		txttenba.setText("");
		tbox_XetNghiem.setSelected(false);
		txtIDXetNghiem.setText("");
		txtKetQua.setText("");
		txtNoiDung.setText("");

	}

	private void ThongTinNhanVien() {
		txtmanv.setText(nhanVien.getIDNhanVien());
		txttennv.setText(nhanVien.getTen());
		txthonv.setText(nhanVien.getHo());
		txtsdtnv.setText(nhanVien.getSDT());
		txtngaysinhnv.setText(nhanVien.getNgaySinh().toString());
		txtdiachinv.setText(nhanVien.getDiaChi());
	}

	private boolean DoiMatKhau() {
		String mkc = "", mkm = "", nlmkm = "";
		char a[], b[], c[];
		a = txtmkc.getPassword();
		b = txtmkm.getPassword();
		c = txtnlmkm.getPassword();
		for (int i = 0; i < a.length; i++) {
			mkc = mkc + a[i];
		}
		for (int i = 0; i < b.length; i++) {
			mkm = mkm + b[i];
		}
		for (int i = 0; i < c.length; i++) {
			nlmkm = nlmkm + c[i];
		}
		if (!bacSiDaos.CheckMatKhauCu(nhanVien, mkc)) {
			JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu cũ không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!mkm.equals(nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Nhập lại mật khẩu mới không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!bacSiDaos.DoiMatKhau(nhanVien, nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Đổi mật khẩu không thành công");
			XoaTrangDoiMatKhau();
			return false;
		}
		JOptionPane.showMessageDialog(new JFrame(), "Đổi mật khẩu thành công");
		new Gui_DangNhap();
		dispose();
		return true;
	}

	private void XoaTrangDoiMatKhau() {
		txtmkc.setText("");
		txtmkm.setText("");
		txtnlmkm.setText("");
	}

}
