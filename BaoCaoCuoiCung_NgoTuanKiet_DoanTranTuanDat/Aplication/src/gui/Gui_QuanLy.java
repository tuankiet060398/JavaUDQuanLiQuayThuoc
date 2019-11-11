package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

import Gui_HuongDanSuDung.Gui_HuongDan_QuanLi;
import daos.QuanLyDaos;
import htqlbv_entities.BenhAn;
import htqlbv_entities.BenhNhan;
import htqlbv_entities.ChiTietKhoThuoc;
import htqlbv_entities.NhanVien;
import htqlbv_entities.TaiKhoan;
import htqlbv_entities.Thuoc;
import htqlbv_entities.ToaThuoc;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class Gui_QuanLy extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnDong;

	private QuanLyDaos quanLyDaos;

	private List<BenhNhan> dsBenhNhan;
	private List<TaiKhoan> dsTaiKhoan;
	private List<ToaThuoc> dsToaThuoc;
	private List<NhanVien> dsNhanVien;

	// Khai bao cho tab quan ly benh nhan
	private JLabel lblBenhNhanID, lblHoBenhNhan, lblTenBenhNhan, lblSDTBenhNhan, lblDiaChiBenhNhan, lblXoaBenhNhan;
	private JTextField txtBenhNhanID, txtHoBenhNhan, txtTenBenhNhan, txtSDTBenhNhan, txtDiaChiBenhNhan;
	private JButton btnXoaBenhNhan;
	private JTable tableBenhNhan;
	private DefaultTableModel modelBenhNhan;

	// Khai bao cho tab quan ly nhan vien
	private JLabel lblNhanVienID, lblHoNhanVien, lblTenNhanVien, lblSDTNhanVien, lblNSNhanVien, lblDiaChiNhanVien;
	private JTextField txtNhanVienID, txtHoNhanVien, txtTenNhanVien, txtSDTNhanVien, txtDiaChiNhanVien, txtTimNhanVien;
	private DatePicker datePicker;
	private JButton btnThemNV, btnSuaNV, btnLuuNV, btnTimNV, btnXoaNV, btnCapNhat;
	private JComboBox<String> cbbTimNhanVien;
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;

	// Khai bao cho tab quan ly tai khoan
	private JLabel lblTenTaiKhoan, lblMatKhau, lblLoaiTaiKhoan, lblNVID;
	private JTextField txtTenTaiKhoan, txtMatKhau, txtNVID;
	private JButton btnThemTaiKhoan, btnSuaTaiKhoan, btnLuuTaiKhoan;
	private JComboBox<String> cbbLoaiTaiKhoan;
	private JTable tableTaiKhoan;
	private DefaultTableModel modelTaiKhoan;

	// Khai bao cho tab quan ly toa thuoc
	private JLabel lblToaThuocID, lblDonGia, lblGhiChu, lblTrangThai;
	private JTextField txtToaThuocID, txtDonGia, txtGhiChu, txtTrangThai;
	private JTable tableToaThuoc, tableChiTietToa;
	private DefaultTableModel modelToaThuoc, modelChiTietToa;

	// Khai bao quan ly ca nhan
	private NhanVien nhanVien;
	private JPasswordField txtmkc, txtmkm, txtnlmkm;
	private JTabbedPane tbpqlcn;
	private JLabel lblmanv, lbltennv, lblhonv, lblsdtnv, lbldiacchinv, lblngaysinhnv, lblmkc, lblTenDn, lblmkm,
			lblnlmkm;
	private JTextField txtmanv, txthonv, txttennv, txtsdtnv, txtdiachinv, txtngaysinhnv;
	private JButton btnDoimk, btnHuy;

	private JButton btnHelp;

	public Gui_QuanLy(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		setSize(1100, 700);
		setTitle("Nhân Viên Quản Lý");
		setResizable(true);
		setIconImage(new ImageIcon(getClass().getResource("/ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png")).getImage());

		// ------------------------------------------------------------------------------
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		pNorth.add(new JLabel(new ImageIcon(getClass().getResource("/ima/if_Manager_131484.png"))));
		pNorth.add(lblTenDn = new JLabel(nhanVien.getHo() + " " + nhanVien.getTen()));
		lblTenDn.setFont(new Font("Times new Roman", Font.BOLD, 20));
		lblTenDn.setForeground(Color.RED);
		pNorth.add(Box.createHorizontalStrut(500));
		pNorth.add(btnDong = new JButton("Đăng xuất", new ImageIcon(getClass().getResource("/ima/if_Logout_105217.png"))));
		pNorth.add(Box.createHorizontalStrut(7));
		pNorth.add(btnHelp = new JButton("Trợ giúp", new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png"))));
		add(pNorth, BorderLayout.NORTH);

		quanLyDaos = new QuanLyDaos();

		dsBenhNhan = new ArrayList<BenhNhan>();
		dsTaiKhoan = new ArrayList<TaiKhoan>();
		new ArrayList<Thuoc>();
		new ArrayList<ChiTietKhoThuoc>();
		dsToaThuoc = new ArrayList<ToaThuoc>();
		dsNhanVien = new ArrayList<NhanVien>();

		// ------------------------------------------------------------------------------
		JTabbedPane tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.LEFT);

		/*
		 * Giao dien quan ly benh nhan
		 */
		Box bBenhNhan = Box.createVerticalBox();
		Box bBN1, bBN2, bBN3;
		Box bBN_TT, bBN_TT1, bBN_TT2, bBN_TT3, bBN_TT4, bBN_TT5;
		Box bBN_CN;

		bBenhNhan.add(bBN1 = Box.createHorizontalBox());
		bBN1.setMaximumSize(new Dimension(1000, 1));

		bBN1.add(bBN_TT = Box.createVerticalBox());
		bBN_TT.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));

		bBN_TT.add(bBN_TT1 = Box.createHorizontalBox());
		bBN_TT.add(Box.createVerticalStrut(10));
		bBN_TT1.add(lblBenhNhanID = new JLabel("Mã số bệnh nhân"));
		bBN_TT1.add(Box.createHorizontalStrut(10));
		bBN_TT1.add(txtBenhNhanID = new JTextField());

		bBN_TT.add(bBN_TT2 = Box.createHorizontalBox());
		bBN_TT.add(Box.createVerticalStrut(10));
		bBN_TT2.add(lblHoBenhNhan = new JLabel("Họ"));
		bBN_TT2.add(Box.createHorizontalStrut(10));
		bBN_TT2.add(txtHoBenhNhan = new JTextField());

		bBN_TT.add(bBN_TT3 = Box.createHorizontalBox());
		bBN_TT.add(Box.createVerticalStrut(10));
		bBN_TT3.add(lblTenBenhNhan = new JLabel("Tên"));
		bBN_TT3.add(Box.createHorizontalStrut(10));
		bBN_TT3.add(txtTenBenhNhan = new JTextField());

		bBN_TT.add(bBN_TT4 = Box.createHorizontalBox());
		bBN_TT.add(Box.createVerticalStrut(10));
		bBN_TT4.add(lblSDTBenhNhan = new JLabel("Số điện thoại"));
		bBN_TT4.add(Box.createHorizontalStrut(10));
		bBN_TT4.add(txtSDTBenhNhan = new JTextField());

		bBN_TT.add(bBN_TT5 = Box.createHorizontalBox());
		bBN_TT5.add(lblDiaChiBenhNhan = new JLabel("Địa chỉ"));
		bBN_TT5.add(Box.createHorizontalStrut(10));
		bBN_TT5.add(txtDiaChiBenhNhan = new JTextField());

		lblTenBenhNhan.setPreferredSize(lblBenhNhanID.getPreferredSize());
		lblDiaChiBenhNhan.setPreferredSize(lblBenhNhanID.getPreferredSize());
		lblHoBenhNhan.setPreferredSize(lblBenhNhanID.getPreferredSize());
		lblSDTBenhNhan.setPreferredSize(lblBenhNhanID.getPreferredSize());

		// ***********************
		bBenhNhan.add(bBN2 = Box.createVerticalBox());
		bBN2.add(bBN_CN = Box.createHorizontalBox());
		bBN_CN.add(Box.createHorizontalGlue());
		bBN_CN.add(lblXoaBenhNhan = new JLabel("Xóa bệnh nhân ba năm chưa khám lại"));
		lblXoaBenhNhan.setFont(new Font("serif", Font.PLAIN, 17));
		bBN_CN.add(Box.createHorizontalStrut(14));
		bBN_CN.add(btnXoaBenhNhan = new JButton("Xóa", new ImageIcon(getClass().getResource("/ima/if_user-trash_118932.png"))));
		btnXoaBenhNhan.setMaximumSize(new Dimension(2000, 200));
		bBN_CN.add(Box.createHorizontalStrut(15));

		// ***********************
		bBenhNhan.add(bBN3 = Box.createVerticalBox());
		bBN3.setBorder(BorderFactory.createTitledBorder("Danh sách bệnh nhân"));

		String[] headersBN = "Mã số bệnh nhân;Họ;Tên;Số điện thoại;Địa chỉ".split(";");
		modelBenhNhan = new DefaultTableModel(headersBN, 0);
		JScrollPane scrollBN = new JScrollPane();
		scrollBN.setViewportView(tableBenhNhan = new JTable(modelBenhNhan));
		tableBenhNhan.setRowHeight(20);
		tableBenhNhan.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bBN3.add(scrollBN);

		/*
		 * Giao dien quan ly nhan vien
		 */
		Box bNhanVien = Box.createVerticalBox();
		Box bNV1, bNV2, bNV3;
		Box bNV_TT, bNV_TT1, bNV_TT2, bNV_TT3, bNV_TT4, bNV_TT5, bNV_TT6;
		Box bNV_TK, bNV_TK1, bNV_CN;

		bNhanVien.add(bNV1 = Box.createHorizontalBox());

		bNV1.add(bNV_TT = Box.createVerticalBox());
		bNV_TT.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

		bNV_TT.add(bNV_TT1 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT1.add(lblNhanVienID = new JLabel("Mã số nhân viên"));
		bNV_TT1.add(Box.createHorizontalStrut(10));
		bNV_TT1.add(txtNhanVienID = new JTextField());

		bNV_TT.add(bNV_TT2 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT2.add(lblHoNhanVien = new JLabel("Họ"));
		bNV_TT2.add(Box.createHorizontalStrut(10));
		bNV_TT2.add(txtHoNhanVien = new JTextField());

		bNV_TT.add(bNV_TT3 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT3.add(lblTenNhanVien = new JLabel("Tên"));
		bNV_TT3.add(Box.createHorizontalStrut(10));
		bNV_TT3.add(txtTenNhanVien = new JTextField());

		bNV_TT.add(bNV_TT4 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT4.add(lblSDTNhanVien = new JLabel("Số điện thoại"));
		bNV_TT4.add(Box.createHorizontalStrut(10));
		bNV_TT4.add(txtSDTNhanVien = new JTextField());

		bNV_TT.add(bNV_TT5 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT5.add(lblDiaChiNhanVien = new JLabel("Địa chỉ"));
		bNV_TT5.add(Box.createHorizontalStrut(10));
		bNV_TT5.add(txtDiaChiNhanVien = new JTextField());

		bNV_TT.add(bNV_TT6 = Box.createHorizontalBox());
		bNV_TT6.add(lblNSNhanVien = new JLabel("Ngày sinh"));
		bNV_TT6.add(Box.createHorizontalStrut(10));
		bNV_TT6.add(datePicker = new DatePicker());

		lblTenNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblDiaChiNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblHoNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblSDTNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblNSNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());

		// ***********************
		bNV1.add(bNV_TK = Box.createVerticalBox());
		bNV_TK.setMinimumSize(getMinimumSize());
		bNV_TK.setBorder(BorderFactory.createTitledBorder("Tìm kiếm nhân viên"));
		bNV_TK.add(bNV_TK1 = Box.createHorizontalBox());
		String[] timKiemNV = { "Tìm theo ID", "Tìm theo tên", "Tìm theo số điện thoại" };
		bNV_TK1.add(cbbTimNhanVien = new JComboBox<String>(timKiemNV));
		bNV_TK1.add(Box.createHorizontalStrut(10));
		bNV_TK1.add(txtTimNhanVien = new JTextField(1));
		bNV_TK1.add(Box.createHorizontalStrut(10));
		bNV_TK1.add(btnTimNV = new JButton("Tìm", new ImageIcon(getClass().getResource("/ima/if_search_magnifying_glass_find_103857.png"))));
		bNV_TK.add(Box.createVerticalStrut(185));

		// ***********************
		bNhanVien.add(bNV2 = Box.createVerticalBox());
		bNV2.add(bNV_CN = Box.createHorizontalBox());
		bNV2.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bNV_CN.add(btnThemNV = new JButton("Thêm", new ImageIcon(getClass().getResource("/ima/if_7_330410.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(btnSuaNV = new JButton("Sửa", new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(btnLuuNV = new JButton("Lưu", new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(btnCapNhat = new JButton("Tải lại danh sách", new ImageIcon(getClass().getResource("/ima/if_--07_1720774.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(btnXoaNV = new JButton("Xóa", new ImageIcon(getClass().getResource("/ima/if_user-trash_118932.png"))));

		btnThemNV.setMaximumSize(getMaximumSize());
		btnSuaNV.setMaximumSize(getMaximumSize());
		btnLuuNV.setMaximumSize(getMaximumSize());
		btnXoaNV.setMaximumSize(getMaximumSize());
		btnCapNhat.setMaximumSize(getMaximumSize());

		// ***********************
		bNhanVien.add(bNV3 = Box.createVerticalBox());
		bNV3.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));

		String[] headersNV = "Mã số nhân viên;Họ;Tên;Số điện thoại;Địa chỉ;Ngày sinh".split(";");
		modelNhanVien = new DefaultTableModel(headersNV, 0);
		JScrollPane scrollNV = new JScrollPane();
		scrollNV.setViewportView(tableNhanVien = new JTable(modelNhanVien));
		tableNhanVien.setRowHeight(20);
		tableNhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bNV3.add(scrollNV);

		btnLuuNV.setEnabled(false);

		/*
		 * Giao diện quan ly tai khoan
		 */
		Box bTaiKhoan = Box.createVerticalBox();
		Box bTK1, bTK2, bTK3;
		Box bTK1_1, bTK1_2, bTK1_3, bTK1_4, bTK_CN;

		bTaiKhoan.add(bTK1 = Box.createVerticalBox());
		bTK1.setBorder(BorderFactory.createTitledBorder("Thông tin tài khoản"));
		bTK1.setMaximumSize(new Dimension(1000, 200));

		bTK1.add(bTK1_4 = Box.createHorizontalBox());
		bTK1.add(Box.createVerticalStrut(10));
		bTK1_4.add(lblNVID = new JLabel("Mã nhân viên"));
		bTK1_4.add(Box.createHorizontalStrut(10));
		bTK1_4.add(txtNVID = new JTextField());

		bTK1.add(bTK1_1 = Box.createHorizontalBox());
		bTK1.add(Box.createVerticalStrut(10));
		bTK1_1.add(lblTenTaiKhoan = new JLabel("Tên tài khoản"));
		bTK1_1.add(Box.createHorizontalStrut(10));
		bTK1_1.add(txtTenTaiKhoan = new JTextField());

		bTK1.add(bTK1_2 = Box.createHorizontalBox());
		bTK1.add(Box.createVerticalStrut(10));
		bTK1_2.add(lblMatKhau = new JLabel("Mật khẩu"));
		bTK1_2.add(Box.createHorizontalStrut(10));
		bTK1_2.add(txtMatKhau = new JTextField());

		bTK1.add(bTK1_3 = Box.createHorizontalBox());
		bTK1_3.add(lblLoaiTaiKhoan = new JLabel("Loại tài khoản"));
		bTK1_3.add(Box.createHorizontalStrut(10));
		String[] loaiTaiKhoan = { "Nhân Viên Nhận Bệnh", "Bác Sĩ", "Nhân Viên Phát Thuốc", "Quản Lý" };
		bTK1_3.add(cbbLoaiTaiKhoan = new JComboBox<String>(loaiTaiKhoan));
		bTK1_3.add(Box.createHorizontalStrut(420));

		lblTenTaiKhoan.setPreferredSize(lblLoaiTaiKhoan.getPreferredSize());
		lblMatKhau.setPreferredSize(lblLoaiTaiKhoan.getPreferredSize());
		lblNVID.setPreferredSize(lblLoaiTaiKhoan.getPreferredSize());

		// ***********************
		bTaiKhoan.add(bTK2 = Box.createVerticalBox());
		bTK2.add(bTK_CN = Box.createHorizontalBox());
		bTK2.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bTK2.setMaximumSize(new Dimension(1000, 200));
		bTK_CN.add(btnThemTaiKhoan = new JButton("Thêm", new ImageIcon(getClass().getResource("/ima/if_7_330410.png"))));
		bTK_CN.add(Box.createHorizontalStrut(10));
		bTK_CN.add(btnSuaTaiKhoan = new JButton("Sửa", new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png"))));
		bTK_CN.add(Box.createHorizontalStrut(10));
		bTK_CN.add(btnLuuTaiKhoan = new JButton("Lưu", new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png"))));

		btnThemTaiKhoan.setMaximumSize(getMaximumSize());
		btnSuaTaiKhoan.setMaximumSize(getMaximumSize());
		btnLuuTaiKhoan.setMaximumSize(getMaximumSize());

		btnLuuTaiKhoan.setEnabled(false);

		// ***********************
		bTaiKhoan.add(bTK3 = Box.createVerticalBox());
		bTK3.setBorder(BorderFactory.createTitledBorder("Danh sách tài khoản"));

		String[] headersTK = "Mã nhân viên;Tên tài khoản;Mật khẩu;Loại tài khoản".split(";");
		modelTaiKhoan = new DefaultTableModel(headersTK, 0);
		JScrollPane scrollTK = new JScrollPane();
		scrollTK.setViewportView(tableTaiKhoan = new JTable(modelTaiKhoan));
		tableTaiKhoan.setRowHeight(20);
		tableTaiKhoan.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bTK3.add(scrollTK);

		/*
		 * Giao dien quan ly toa thuoc
		 */
		Box bToaThuoc = Box.createVerticalBox();
		Box bTT1, bTT2, bTT3;
		Box bTT1_1, bTT1_2, bTT1_3, bTT1_4;

		bToaThuoc.add(bTT1 = Box.createVerticalBox());
		bTT1.setBorder(BorderFactory.createTitledBorder("Thông tin toa thuốc"));

		bTT1.add(bTT1_1 = Box.createHorizontalBox());
		bTT1.add(Box.createVerticalStrut(10));
		bTT1_1.add(lblToaThuocID = new JLabel("Mã toa thuốc"));
		bTT1_1.add(Box.createHorizontalStrut(10));
		bTT1_1.add(txtToaThuocID = new JTextField());

		bTT1.add(bTT1_2 = Box.createHorizontalBox());
		bTT1.add(Box.createVerticalStrut(10));
		bTT1_2.add(lblDonGia = new JLabel("Đơn giá"));
		bTT1_2.add(Box.createHorizontalStrut(10));
		bTT1_2.add(txtDonGia = new JTextField());

		bTT1.add(bTT1_3 = Box.createHorizontalBox());
		bTT1.add(Box.createVerticalStrut(10));
		bTT1_3.add(lblGhiChu = new JLabel("Ghi chú"));
		bTT1_3.add(Box.createHorizontalStrut(10));
		bTT1_3.add(txtGhiChu = new JTextField());

		bTT1.add(bTT1_4 = Box.createHorizontalBox());
		bTT1_4.add(lblTrangThai = new JLabel("Trạng thái"));
		bTT1_4.add(Box.createHorizontalStrut(10));
		bTT1_4.add(txtTrangThai = new JTextField());

		lblGhiChu.setPreferredSize(lblToaThuocID.getPreferredSize());
		lblDonGia.setPreferredSize(lblToaThuocID.getPreferredSize());
		lblTrangThai.setPreferredSize(lblToaThuocID.getPreferredSize());
		txtTrangThai.setMinimumSize(txtToaThuocID.getPreferredSize());

		// ***********************
		bToaThuoc.add(bTT2 = Box.createVerticalBox());
		bTT2.setBorder(BorderFactory.createTitledBorder("Chi tiết toa thuốc"));

		String[] headersCTTT = "Mã thuốc;Tên thuốc;Đơn giá;Số lượng;Tổng giá".split(";");
		modelChiTietToa = new DefaultTableModel(headersCTTT, 0);
		JScrollPane scrollCTTT = new JScrollPane();
		scrollCTTT.setViewportView(tableChiTietToa = new JTable(modelChiTietToa));
		tableChiTietToa.setRowHeight(20);
		tableChiTietToa.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bTT2.add(scrollCTTT);

		// ***********************
		bToaThuoc.add(bTT3 = Box.createVerticalBox());
		bTT3.setBorder(BorderFactory.createTitledBorder("Danh sách toa thuốc"));

		String[] headersTT = "Mã toa thuốc;Đơn giá;Ghi chú;Trạng thái".split(";");
		modelToaThuoc = new DefaultTableModel(headersTT, 0);
		JScrollPane scrollTT = new JScrollPane();
		scrollTT.setViewportView(tableToaThuoc = new JTable(modelToaThuoc));
		tableToaThuoc.setRowHeight(20);
		tableToaThuoc.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bTT3.add(scrollTT);

		/*
		 * Giao dien quan ly ca nhan
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
		bqlcn_DoiMatKhau_button.add(btnHuy = new JButton("Hủy", new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png"))));
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
		tbpqlcn.addTab("Xem Thông tin", new ImageIcon(getClass().getResource("/ima/if_icon-85-folder-information_314768.png")),
				bqlcn_XemThongTin);
		tbpqlcn.addTab("Đổi mật khẩu", new ImageIcon(getClass().getResource("/ima/if_Access_field_pin_input_password_2629858 .png")),
				bqlcn_DoiMatKhau);
		tbpqlcn.setFont(new Font("Times new Roman", Font.PLAIN, 20));

		txtmanv.setEditable(false);
		txttennv.setEditable(false);
		txthonv.setEditable(false);
		txtdiachinv.setEditable(false);
		txtngaysinhnv.setEditable(false);
		txtdiachinv.setEditable(false);
		txtsdtnv.setEditable(false);
		/*
		 * Phan ket noi tab va gan su kien
		 */
		tab.addTab("Quản lý bệnh nhân", new ImageIcon(getClass().getResource("/ima/if_8_375259.png")), bBenhNhan);
		tab.addTab("Quản lý nhân viên", new ImageIcon(getClass().getResource("/ima/if_group_318580.png")), bNhanVien);
		tab.addTab("Quản lý tài khoản", new ImageIcon(getClass().getResource("/ima/if_Account_1891016.png")), bTaiKhoan);

		tab.addTab("Quản lý toa thuốc", new ImageIcon(getClass().getResource("/ima/if_receipt_3583272.png")), bToaThuoc);
		tab.addTab("Quản lý cá nhân", new ImageIcon(getClass().getResource("/ima/if_personal-information_47997.png")), tbpqlcn);
		add(tab, BorderLayout.CENTER);
		loadData();

		setJtable(tableBenhNhan);
		setJtable(tableToaThuoc);
		setJtable(tableNhanVien);
		setJtable(tableTaiKhoan);

		btnXoaBenhNhan.addActionListener(this);

		tableToaThuoc.addMouseListener(this);
		tableBenhNhan.addMouseListener(this);
		tableTaiKhoan.addMouseListener(this);
		tableNhanVien.addMouseListener(this);

		btnThemNV.addActionListener(this);
		btnSuaNV.addActionListener(this);
		btnXoaNV.addActionListener(this);
		btnLuuNV.addActionListener(this);
		btnTimNV.addActionListener(this);
		btnCapNhat.addActionListener(this);

		btnThemTaiKhoan.addActionListener(this);
		btnSuaTaiKhoan.addActionListener(this);
		btnLuuTaiKhoan.addActionListener(this);

		btnDong.addActionListener(this);

		btnDoimk.addActionListener(this);
		btnHuy.addActionListener(this);
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Gui_HuongDan_QuanLi().setVisible(true);

			}
		});
		nonEditable();

		Loadthongtinnhanvien();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void Loadthongtinnhanvien() {
		txtmanv.setText(nhanVien.getIDNhanVien());
		txtdiachinv.setText(nhanVien.getDiaChi());
		txthonv.setText(nhanVien.getHo());
		txttennv.setText(nhanVien.getTen());
		txtsdtnv.setText(nhanVien.getSDT());
		txtngaysinhnv.setText(nhanVien.getNgaySinh().toString());
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
		if (!quanLyDaos.CheckMatKhauCu(nhanVien, mkc)) {
			JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu cũ không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!mkm.equals(nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Nhập lại mật khẩu mới không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!quanLyDaos.DoiMatKhau(nhanVien, nlmkm)) {
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

	private void setJtable(JTable table) {
		if (table.getRowCount() >= 0) {
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.getSelectionModel().setSelectionInterval(0, 0);
		}
	}

	private void nonEditable() {
		txtBenhNhanID.setEditable(false);
		txtHoBenhNhan.setEditable(false);
		txtDiaChiBenhNhan.setEditable(false);
		txtSDTBenhNhan.setEditable(false);
		txtTenBenhNhan.setEditable(false);

		txtGhiChu.setEditable(false);
		txtDonGia.setEditable(false);
		txtToaThuocID.setEditable(false);
		txtTrangThai.setEditable(false);

		txtNhanVienID.setEditable(false);
		txtHoNhanVien.setEditable(false);
		txtTenNhanVien.setEditable(false);
		txtSDTNhanVien.setEditable(false);
		txtDiaChiNhanVien.setEditable(false);

		txtTenTaiKhoan.setEditable(false);
		txtMatKhau.setEditable(false);
		txtNVID.setEditable(false);
	}

	@SuppressWarnings("rawtypes")
	private void editable(Class t) {
		if (t.equals(NhanVien.class)) {
			txtNhanVienID.setEditable(true);
			txtHoNhanVien.setEditable(true);
			txtTenNhanVien.setEditable(true);
			txtSDTNhanVien.setEditable(true);
			txtDiaChiNhanVien.setEditable(true);
		} else if (t.equals(TaiKhoan.class)) {
			txtTenTaiKhoan.setEditable(true);
			txtMatKhau.setEditable(true);
			txtNVID.setEditable(true);
		}
	}

	@SuppressWarnings("rawtypes")
	private void xoaTextField(Class t) {
		if (t.equals(NhanVien.class)) {
			txtNhanVienID.setText("");
			txtHoNhanVien.setText("");
			txtTenNhanVien.setText("");
			txtSDTNhanVien.setText("");
			txtDiaChiNhanVien.setText("");
			datePicker.setDate(null);
		} else if (t.equals(TaiKhoan.class)) {
			txtTenTaiKhoan.setText("");
			txtMatKhau.setText("");
			txtNVID.setText("");
		}
	}

	@SuppressWarnings("rawtypes")
	private void loadTextField(Class t) {
		int row = 0;

		if (t.equals(BenhNhan.class)) {
			row = tableBenhNhan.getSelectedRow();

			txtBenhNhanID.setText(tableBenhNhan.getValueAt(row, 0).toString());
			txtHoBenhNhan.setText(tableBenhNhan.getValueAt(row, 1).toString());
			txtTenBenhNhan.setText(tableBenhNhan.getValueAt(row, 2).toString());
			txtSDTBenhNhan.setText(tableBenhNhan.getValueAt(row, 3).toString());
			txtDiaChiBenhNhan.setText(tableBenhNhan.getValueAt(row, 4).toString());
		} else if (t.equals(NhanVien.class)) {
			row = tableNhanVien.getSelectedRow();

			txtNhanVienID.setText(tableNhanVien.getValueAt(row, 0).toString());
			txtHoNhanVien.setText(tableNhanVien.getValueAt(row, 1).toString());
			txtTenNhanVien.setText(tableNhanVien.getValueAt(row, 2).toString());
			txtSDTNhanVien.setText(tableNhanVien.getValueAt(row, 3).toString());
			txtDiaChiNhanVien.setText(tableNhanVien.getValueAt(row, 4).toString());
			LocalDate date = LocalDate.parse(tableNhanVien.getValueAt(row, 5).toString());
			datePicker.setDate(date);
		} else if (t.equals(TaiKhoan.class)) {
			row = tableTaiKhoan.getSelectedRow();

			txtNVID.setText(tableTaiKhoan.getValueAt(row, 0).toString());
			txtTenTaiKhoan.setText(tableTaiKhoan.getValueAt(row, 1).toString());
			txtMatKhau.setText(tableTaiKhoan.getValueAt(row, 2).toString());
			String s = tableTaiKhoan.getValueAt(row, 3).toString();

			if (s.equalsIgnoreCase("Nhân Viên Nhận Bệnh")) {
				cbbLoaiTaiKhoan.setSelectedIndex(0);
			} else if (s.equalsIgnoreCase("Bác Sỹ")) {
				cbbLoaiTaiKhoan.setSelectedIndex(1);
			} else if (s.equalsIgnoreCase("Quản Lý")) {
				cbbLoaiTaiKhoan.setSelectedIndex(3);
			} else if (s.equalsIgnoreCase("Nhân viên phát thuốc")) {
				cbbLoaiTaiKhoan.setSelectedIndex(2);
			}

		} else if (t.equals(ToaThuoc.class)) {
			row = tableToaThuoc.getSelectedRow();

			txtToaThuocID.setText(tableToaThuoc.getValueAt(row, 0).toString());
			txtDonGia.setText(tableToaThuoc.getValueAt(row, 1).toString());
			txtGhiChu.setText(tableToaThuoc.getValueAt(row, 2).toString());
			txtTrangThai.setText(tableToaThuoc.getValueAt(row, 3).toString());
		}
	}

	private void loadData() {
		dsBenhNhan = quanLyDaos.getAllBenhNhan();
		for (int i = 0; i < dsBenhNhan.size(); i++) {
			String s[] = { dsBenhNhan.get(i).getIDBenhNhan(), dsBenhNhan.get(i).getHo(), dsBenhNhan.get(i).getTenBN(),
					dsBenhNhan.get(i).getSDT(), dsBenhNhan.get(i).getDiaChi() };
			modelBenhNhan.addRow(s);
		}

		dsNhanVien = quanLyDaos.getAllNhanVien();
		for (int i = 0; i < dsNhanVien.size(); i++) {
			String s[] = { dsNhanVien.get(i).getIDNhanVien(), dsNhanVien.get(i).getHo(), dsNhanVien.get(i).getTen(),
					dsNhanVien.get(i).getSDT(), dsNhanVien.get(i).getDiaChi(),
					dsNhanVien.get(i).getNgaySinh().toString() };
			modelNhanVien.addRow(s);
		}

		dsTaiKhoan = quanLyDaos.getAllTaiKhoan();
		for (int i = 0; i < dsTaiKhoan.size(); i++) {
			String s[] = { dsTaiKhoan.get(i).getIDTaiKhoan(), dsTaiKhoan.get(i).getUsername(),
					dsTaiKhoan.get(i).getMatkhau(), dsTaiKhoan.get(i).getLoai() };
			modelTaiKhoan.addRow(s);
		}

		dsToaThuoc = quanLyDaos.getAllToaThuoc();
		for (int i = 0; i < dsToaThuoc.size(); i++) {
			String trangthai = "";
			String tongGia = "";
			tongGia = Double.toString(quanLyDaos.getTongGiaToaThuocTheoID(dsToaThuoc, i));
			if (dsToaThuoc.get(i).isTrangThai() == false) {
				trangthai = "Chưa phát";
			} else {
				trangthai = "Đã phát";
			}
			String s[] = { dsToaThuoc.get(i).getIDToaThuoc(), tongGia, dsToaThuoc.get(i).getGhiChu(), trangthai };
			modelToaThuoc.addRow(s);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnThemNV)) { // Nhan vien
			if (btnThemNV.getText().equalsIgnoreCase("thêm")) {
				btnThemNV.setText("Hủy");
				btnThemNV.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
				btnLuuNV.setEnabled(true);
				btnSuaNV.setEnabled(false);
				btnXoaNV.setEnabled(false);
				tableNhanVien.setEnabled(false);
				xoaTextField(NhanVien.class);
				txtNhanVienID.requestFocus();
				btnCapNhat.setEnabled(false);
				btnTimNV.setEnabled(false);
				editable(NhanVien.class);
			} else {
				btnThemNV.setText("Thêm");
				btnThemNV.setIcon(new ImageIcon(getClass().getResource("/ima/if_7_330410.png")));
				btnLuuNV.setEnabled(false);
				btnSuaNV.setEnabled(true);
				btnXoaNV.setEnabled(true);
				tableNhanVien.setEnabled(true);
				loadTextField(NhanVien.class);
				btnCapNhat.setEnabled(true);
				btnTimNV.setEnabled(true);
				nonEditable();
			}
		} else if (object.equals(btnSuaNV)) {
			if (btnSuaNV.getText().equalsIgnoreCase("sửa")) {
				btnSuaNV.setText("Hủy");
				btnSuaNV.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
				btnLuuNV.setEnabled(true);
				btnThemNV.setEnabled(false);
				btnXoaNV.setEnabled(false);
				tableNhanVien.setEnabled(false);
				btnCapNhat.setEnabled(false);
				btnTimNV.setEnabled(false);
				txtHoNhanVien.requestFocus();
				editable(NhanVien.class);
				txtNhanVienID.setEnabled(false);
			} else {
				btnSuaNV.setText("Sửa");
				btnSuaNV.setIcon(new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png")));
				loadTextField(NhanVien.class);
				btnLuuNV.setEnabled(false);
				btnThemNV.setEnabled(true);
				btnXoaNV.setEnabled(true);
				tableNhanVien.setEnabled(true);
				btnCapNhat.setEnabled(true);
				btnTimNV.setEnabled(true);
				txtNhanVienID.setEnabled(true);
				nonEditable();
			}
		} else if (object.equals(btnXoaNV)) {
			int row = tableNhanVien.getSelectedRow();

			if (quanLyDaos.xoaNhanVienTheoID(txtNhanVienID.getText())) {
				modelNhanVien.removeRow(row);
				tableNhanVien.getSelectionModel().setSelectionInterval(0, 0);

				modelTaiKhoan.setRowCount(0);
				dsTaiKhoan = quanLyDaos.getAllTaiKhoan();
				for (int i = 0; i < dsTaiKhoan.size(); i++) {
					String s[] = { dsTaiKhoan.get(i).getIDTaiKhoan(), dsTaiKhoan.get(i).getUsername(),
							dsTaiKhoan.get(i).getMatkhau(), dsTaiKhoan.get(i).getLoai() };
					modelTaiKhoan.addRow(s);
				}
				tableTaiKhoan.getSelectionModel().setSelectionInterval(0, 0);

				JOptionPane.showMessageDialog(null, "Xóa thành công", "", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (object.equals(btnLuuNV)) {
			if (btnThemNV.getText().equalsIgnoreCase("hủy")) {
				if (!txtNhanVienID.getText().isEmpty()) {
					NhanVien nhanVien = new NhanVien();
					nhanVien.setIDNhanVien(txtNhanVienID.getText().trim());
					nhanVien.setTen(txtTenNhanVien.getText().trim());
					nhanVien.setHo(txtHoNhanVien.getText().trim());
					nhanVien.setSDT(txtSDTNhanVien.getText().trim());
					nhanVien.setDiaChi(txtDiaChiNhanVien.getText().trim());
					LocalDate date = datePicker.getDate();
					if (date == null)
						date = LocalDate.now();
					nhanVien.setNgaySinh(date);

					if (quanLyDaos.themNhanVien(nhanVien)) {

						String s[] = { txtNhanVienID.getText().trim(), txtHoNhanVien.getText().trim(),
								txtTenNhanVien.getText().trim(), txtSDTNhanVien.getText().trim(),
								txtDiaChiNhanVien.getText().trim(), date.toString() };
						modelNhanVien.addRow(s);
						JOptionPane.showMessageDialog(null, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Thêm không thành công", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
					btnThemNV.setText("Thêm");
					btnLuuNV.setEnabled(false);
					btnSuaNV.setEnabled(true);
					btnXoaNV.setEnabled(true);
					tableNhanVien.setEnabled(true);
					tableNhanVien.getSelectionModel().setSelectionInterval(0, 0);
					loadTextField(NhanVien.class);
					btnCapNhat.setEnabled(true);
					btnTimNV.setEnabled(true);
					nonEditable();
				} else {
					JOptionPane.showMessageDialog(null, "Mã nhân viên không được để trống", "",
							JOptionPane.INFORMATION_MESSAGE);
					txtNhanVienID.requestFocus();
				}
			} else {
				if (!txtNhanVienID.getText().isEmpty()) {
					String maNV = txtNhanVienID.getText().trim();
					String tenNV = txtTenNhanVien.getText().trim();
					String hoNV = txtHoNhanVien.getText().trim();
					String sdtNV = txtSDTNhanVien.getText().trim();
					String diaChi = txtDiaChiNhanVien.getText().trim();
					LocalDate date = datePicker.getDate();

					if (date == null)
						date = LocalDate.now();

					NhanVien nhanVien = new NhanVien(maNV, tenNV, hoNV, diaChi, sdtNV, date);
					if (quanLyDaos.suaThongTinNhanVien(nhanVien)) {
						modelNhanVien.setRowCount(0);
						dsNhanVien = quanLyDaos.getAllNhanVien();
						for (int i = 0; i < dsNhanVien.size(); i++) {
							String s[] = { dsNhanVien.get(i).getIDNhanVien(), dsNhanVien.get(i).getHo(),
									dsNhanVien.get(i).getTen(), dsNhanVien.get(i).getSDT(),
									dsNhanVien.get(i).getDiaChi(), dsNhanVien.get(i).getNgaySinh().toString() };
							modelNhanVien.addRow(s);
						}
						JOptionPane.showMessageDialog(null, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Sửa không thành công", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
					btnSuaNV.setText("Sửa");
					btnLuuNV.setEnabled(false);
					btnThemNV.setEnabled(true);
					btnXoaNV.setEnabled(true);
					tableNhanVien.setEnabled(true);
					btnCapNhat.setEnabled(true);
					btnTimNV.setEnabled(true);
					nonEditable();
				}
			}
		} else if (object.equals(btnThemTaiKhoan)) {
			if (btnThemTaiKhoan.getText().equalsIgnoreCase("thêm")) {
				btnThemTaiKhoan.setText("Hủy");
				btnThemTaiKhoan.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
				btnLuuTaiKhoan.setEnabled(true);
				btnSuaTaiKhoan.setEnabled(false);
				tableTaiKhoan.setEnabled(false);
				xoaTextField(TaiKhoan.class);
				txtNVID.requestFocus();
				editable(TaiKhoan.class);
			} else {
				btnThemTaiKhoan.setText("Thêm");
				btnThemTaiKhoan.setIcon(new ImageIcon(getClass().getResource("/ima/if_7_330410.png")));
				btnLuuTaiKhoan.setEnabled(false);
				btnSuaTaiKhoan.setEnabled(true);
				tableTaiKhoan.setEnabled(true);
				loadTextField(TaiKhoan.class);
				nonEditable();
			}
		} else if (object.equals(btnSuaTaiKhoan)) {
			if (btnSuaTaiKhoan.getText().equalsIgnoreCase("sửa")) {
				btnSuaTaiKhoan.setText("Hủy");
				btnSuaTaiKhoan.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
				btnThemTaiKhoan.setEnabled(false);
				btnLuuTaiKhoan.setEnabled(true);
				tableTaiKhoan.setEnabled(false);
				editable(TaiKhoan.class);
				txtNVID.setEnabled(false);
				txtTenTaiKhoan.requestFocus();
			} else {
				btnSuaTaiKhoan.setText("Sửa");
				btnSuaTaiKhoan.setIcon(new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png")));
				btnLuuTaiKhoan.setEnabled(false);
				btnThemTaiKhoan.setEnabled(true);
				tableTaiKhoan.setEnabled(true);
				txtNVID.setEnabled(true);
				loadTextField(TaiKhoan.class);
				nonEditable();
			}
		} else if (object.equals(btnLuuTaiKhoan)) {
			if (btnThemTaiKhoan.getText().equalsIgnoreCase("hủy")) {
				TaiKhoan taiKhoan = new TaiKhoan();

				if (txtTenTaiKhoan.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tên tài khoản không được để trống", "",
							JOptionPane.INFORMATION_MESSAGE);
					txtTenTaiKhoan.requestFocus();
				} else if (txtMatKhau.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống", "",
							JOptionPane.INFORMATION_MESSAGE);
					txtMatKhau.requestFocus();
				} else if (txtNhanVienID.getText().trim() != "") {
					taiKhoan.setIDTaiKhoan(txtNVID.getText().trim());
					taiKhoan.setUsername(txtTenTaiKhoan.getText().trim());
					taiKhoan.setMatkhau(txtMatKhau.getText().trim());
					taiKhoan.setLoai(cbbLoaiTaiKhoan.getSelectedItem().toString());
					taiKhoan.setNgayBatDau(LocalDate.now());

					NhanVien nhanVien = quanLyDaos.getNhanVienTheoID(txtNVID.getText().trim());
					taiKhoan.setNhanVien(nhanVien);

					if (quanLyDaos.themTaiKhoan(taiKhoan)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);

						String s[] = { taiKhoan.getIDTaiKhoan(), taiKhoan.getUsername(), taiKhoan.getMatkhau(),
								taiKhoan.getLoai() };
						modelTaiKhoan.addRow(s);
					} else {
						JOptionPane.showMessageDialog(null, "Thêm không thành công", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
					btnThemTaiKhoan.setText("Thêm");
					btnLuuTaiKhoan.setEnabled(false);
					btnSuaTaiKhoan.setEnabled(true);
					tableTaiKhoan.setEnabled(true);
					loadTextField(TaiKhoan.class);
					nonEditable();
				} else {
					JOptionPane.showMessageDialog(null, "Mã tài khoản không được để trống", "",
							JOptionPane.INFORMATION_MESSAGE);
					txtNhanVienID.requestFocus();
				}
			} else {
				TaiKhoan taiKhoan = new TaiKhoan();

				if (txtTenTaiKhoan.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tên tài khoản không được để trống", "",
							JOptionPane.INFORMATION_MESSAGE);
					txtTenTaiKhoan.requestFocus();
				} else if (txtMatKhau.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống", "",
							JOptionPane.INFORMATION_MESSAGE);
					txtMatKhau.requestFocus();
				} else if (txtNhanVienID.getText().trim() != "") {
					taiKhoan.setIDTaiKhoan(txtNVID.getText());
					taiKhoan.setUsername(txtTenTaiKhoan.getText());
					taiKhoan.setMatkhau(txtMatKhau.getText());
					taiKhoan.setLoai(cbbLoaiTaiKhoan.getSelectedItem().toString());
					taiKhoan.setNgayBatDau(LocalDate.now());

					NhanVien nhanVien = quanLyDaos.getNhanVienTheoID(txtNVID.getText());
					taiKhoan.setNhanVien(nhanVien);

					if (quanLyDaos.suaThongTinTaiKhoan(taiKhoan)) {
						modelTaiKhoan.setRowCount(0);
						dsTaiKhoan = quanLyDaos.getAllTaiKhoan();
						for (int i = 0; i < dsTaiKhoan.size(); i++) {
							String s[] = { dsTaiKhoan.get(i).getIDTaiKhoan(), dsTaiKhoan.get(i).getUsername(),
									dsTaiKhoan.get(i).getMatkhau(), dsTaiKhoan.get(i).getLoai() };
							modelTaiKhoan.addRow(s);
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Thêm không thành công", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
					btnSuaTaiKhoan.setText("Sửa");
					btnLuuTaiKhoan.setEnabled(false);
					btnThemTaiKhoan.setEnabled(true);
					tableTaiKhoan.setEnabled(true);
					nonEditable();
				}
			}
		} else if (object.equals(btnCapNhat)) {
			modelNhanVien.setRowCount(0);
			dsNhanVien = quanLyDaos.getAllNhanVien();
			for (int i = 0; i < dsNhanVien.size(); i++) {
				String s[] = { dsNhanVien.get(i).getIDNhanVien(), dsNhanVien.get(i).getHo(), dsNhanVien.get(i).getTen(),
						dsNhanVien.get(i).getSDT(), dsNhanVien.get(i).getDiaChi(),
						dsNhanVien.get(i).getNgaySinh().toString() };
				modelNhanVien.addRow(s);
				tableNhanVien.getSelectionModel().setSelectionInterval(0, 0);
			}
		} else if (object.equals(btnTimNV)) {
			if (cbbTimNhanVien.getSelectedIndex() == 0 && !txtTimNhanVien.getText().isEmpty()) {
				dsNhanVien = quanLyDaos.timNhanVienTheoID(txtTimNhanVien.getText());

				if (dsNhanVien.size() > 0) {
					modelNhanVien.setRowCount(0);
					for (int i = 0; i < dsNhanVien.size(); i++) {
						String s[] = { dsNhanVien.get(i).getIDNhanVien(), dsNhanVien.get(i).getHo(),
								dsNhanVien.get(i).getTen(), dsNhanVien.get(i).getSDT(), dsNhanVien.get(i).getDiaChi(),
								dsNhanVien.get(i).getNgaySinh().toString() };
						modelNhanVien.addRow(s);
					}
					txtTimNhanVien.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Không tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);
				dsNhanVien = quanLyDaos.getAllNhanVien();
			} else if (cbbTimNhanVien.getSelectedIndex() == 1 && !txtTimNhanVien.getText().isEmpty()) {
				dsNhanVien = quanLyDaos.timNhanVienTheoTen(txtTimNhanVien.getText());

				if (dsNhanVien.size() > 0) {
					modelNhanVien.setRowCount(0);
					for (int i = 0; i < dsNhanVien.size(); i++) {
						String s[] = { dsNhanVien.get(i).getIDNhanVien(), dsNhanVien.get(i).getHo(),
								dsNhanVien.get(i).getTen(), dsNhanVien.get(i).getSDT(), dsNhanVien.get(i).getDiaChi(),
								dsNhanVien.get(i).getNgaySinh().toString() };
						modelNhanVien.addRow(s);
					}
					txtTimNhanVien.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Không tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);
				dsNhanVien = quanLyDaos.getAllNhanVien();
			} else if (cbbTimNhanVien.getSelectedIndex() == 2 && !txtTimNhanVien.getText().isEmpty()) {
				dsNhanVien = quanLyDaos.timNhanVienTheoSDT(txtTimNhanVien.getText());

				if (dsNhanVien.size() > 0) {
					modelNhanVien.setRowCount(0);
					for (int i = 0; i < dsNhanVien.size(); i++) {
						String s[] = { dsNhanVien.get(i).getIDNhanVien(), dsNhanVien.get(i).getHo(),
								dsNhanVien.get(i).getTen(), dsNhanVien.get(i).getSDT(), dsNhanVien.get(i).getDiaChi(),
								dsNhanVien.get(i).getNgaySinh().toString() };
						modelNhanVien.addRow(s);
					}
					txtTimNhanVien.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Không tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);
				dsNhanVien = quanLyDaos.getAllNhanVien();
			}
		} else if (object.equals(btnXoaBenhNhan)) {
			int currentYear = LocalDate.now().getYear(), count = 0;
			List<BenhAn> benhAns = quanLyDaos.getAllBenhAn();

			for (int i = 0; i < benhAns.size(); i++) {
				int year = quanLyDaos.getNamLapBenhAn(benhAns, i);
				if (currentYear - year >= 2) {
					quanLyDaos.xoaBenhNhanTheoID(benhAns.get(i).getBenhNhan().getIDBenhNhan());
					count++;
				}
			}
			if (count == 0) {
				JOptionPane.showMessageDialog(null, "Không có bệnh nhân bị xóa", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Đã xóa " + count + " bệnh nhân", "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (object.equals(btnDong)) {
			int chon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất", "Warning",
					JOptionPane.YES_NO_OPTION);
			if (chon == 0) {
				new Gui_DangNhap();
				dispose();
			}
		} else if (object.equals(btnDoimk)) {
			DoiMatKhau();
		} else if (object.equals(btnHuy)) {
			XoaTrangDoiMatKhau();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object object = e.getSource();

		if (object.equals(tableToaThuoc)) {
			int row = tableToaThuoc.getSelectedRow();
			loadTextField(ToaThuoc.class);

			modelChiTietToa.setRowCount(0);
			List<Thuoc> thuocs = new ArrayList<Thuoc>();
			thuocs = quanLyDaos.getThuocTheoToa(tableToaThuoc.getValueAt(row, 0).toString());

			for (int i = 0; i < thuocs.size(); i++) {
				int soLuong = quanLyDaos.getSoLuongThuoc(tableToaThuoc.getValueAt(row, 0).toString(),
						thuocs.get(i).getIDThuoc());
				double tongGia = 0;
				tongGia = soLuong * thuocs.get(i).getDonGia();

				String s[] = { thuocs.get(i).getIDThuoc(), thuocs.get(i).getTenThuoc(),
						Double.toString(thuocs.get(i).getDonGia()), Integer.toString(soLuong),
						Double.toString(tongGia) };
				modelChiTietToa.addRow(s);
			}
		} else if (object.equals(tableBenhNhan)) {
			loadTextField(BenhNhan.class);
		} else if (object.equals(tableNhanVien) && tableNhanVien.isEnabled()) {
			loadTextField(NhanVien.class);
		} else if (object.equals(tableTaiKhoan) && tableTaiKhoan.isEnabled()) {
			loadTextField(TaiKhoan.class);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
