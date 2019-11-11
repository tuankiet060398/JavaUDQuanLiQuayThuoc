package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Gui_HuongDanSuDung.Gui_HuongDan_NhanBenh;
import daos.NhanVienNhanBenhDaos;
import htqlbv_entities.BenhNhan;
import htqlbv_entities.NhanVien;

/**
 * 
 * @author Doãn Trần Tuấn Đạt - 16035741 Ngô Tuấn Kiệt - 16044771
 *
 */
public class Gui_NhanVienNhanBenh extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	///////////////
	private NhanVien nhanVien;
	///////////////
	private JPasswordField txtmkc, txtmkm, txtnlmkm;
	private JTabbedPane tbpqlcn;
	private JLabel lblmanv, lbltennv, lblhonv, lblsdtnv, lbldiacchinv, lblngaysinhnv, lblmkc, lblmkm, lblnlmkm;
	private JTextField txtmanv, txthonv, txttennv, txtsdtnv, txtdiachinv, txtngaysinhnv;
	private JButton btnDoimk, btnHuy;
	///////////////
	private JTabbedPane tbp;
	private JButton btnDangXuat, btnTimbn, btnThem, btnLuu, btnCapNhat, btnChuyen;
	private JLabel lblTenDn;
	private JTextField txtidbn, txthobn, txttenbn, txtdiachibn, txtsdtbn, txttimbn;
	private JComboBox<String> cmbTim, cmbTimbs;
	private JTable table;
	private DefaultTableModel tablemodel;
	private NhanVienNhanBenhDaos nhanVienNhanBenhDaos;
	private List<BenhNhan> dsbn;
	private List<NhanVien> dsnv;
	private JButton btnHelp;

	public Gui_NhanVienNhanBenh(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		nhanVienNhanBenhDaos = new NhanVienNhanBenhDaos();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);
		setResizable(true);
		setTitle("Nhân Viên Nhận Bệnh");
		setIconImage(new ImageIcon(getClass()
				.getResource("/ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png"))
						.getImage());
		Box bt = Box.createVerticalBox();// Cái này là quản lý chung của cả frame
		/**
		 * Cái này là tiêu đề
		 */
		////////////////////////////////
		Box b1 = Box.createHorizontalBox();
		b1.setMaximumSize(getMaximumSize());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(new JLabel(
				new ImageIcon(getClass().getResource("/ima/if_cv_job_seeker_employee_unemployee_work_2620524.png"))));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTenDn = new JLabel(nhanVien.getHo() + " " + nhanVien.getTen()));
		lblTenDn.setFont(new Font("Times new Roman", Font.BOLD, 20));
		lblTenDn.setForeground(Color.RED);
		b1.add(Box.createHorizontalStrut(400));
		b1.add(btnDangXuat = new JButton("Đăng Xuất",
				new ImageIcon(getClass().getResource("/ima/if_Logout_105217.png"))));
		bt.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnHelp = new JButton("Trợ giúp",
				new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png"))));
		bt.add(b1);
		bt.add(Box.createVerticalStrut(10));
		/////////////////////////////////
		/**
		 * Cái này là quản lý bệnh nhân
		 */
		/////////////////////////////////
		Box bqlbn = Box.createVerticalBox(); // bqlbn là box chung quản lý toàn bộ quản lý bệnh nhân

		Box bqlbn1 = Box.createHorizontalBox(); // bqlbn1 là box để quản lý dòng trên cùng
		Box bqlbn1_ThongTin = Box.createVerticalBox();
		bqlbn1_ThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));
		Box bqlbn1_ThongTin_IdBN = Box.createHorizontalBox();
		bqlbn1_ThongTin_IdBN.add(new JLabel("Mã số bệnh nhân: "));
		bqlbn1_ThongTin_IdBN.add(Box.createHorizontalStrut(20));// Khoảng cách giữa chữ và textfield
		bqlbn1_ThongTin_IdBN.add(txtidbn = new JTextField());
		txtidbn.setPreferredSize(getPreferredSize());
		Box bqlbn1_ThongTin_Ho = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ho.add(new JLabel("Họ: "));
		bqlbn1_ThongTin_Ho.add(Box.createHorizontalStrut(100));
		bqlbn1_ThongTin_Ho.add(txthobn = new JTextField());
		txthobn.setPreferredSize(getPreferredSize());
		Box bqlbn1_ThongTin_Ten = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ten.add(new JLabel("Tên: "));
		bqlbn1_ThongTin_Ten.add(Box.createHorizontalStrut(95));
		bqlbn1_ThongTin_Ten.add(txttenbn = new JTextField());
		txttenbn.setPreferredSize(getPreferredSize());
		Box bqlbn1_ThongTin_Sdt = Box.createHorizontalBox();
		bqlbn1_ThongTin_Sdt.add(new JLabel("Số điện thoại: "));
		bqlbn1_ThongTin_Sdt.add(Box.createHorizontalStrut(45));
		bqlbn1_ThongTin_Sdt.add(txtsdtbn = new JTextField());
		txtsdtbn.setPreferredSize(getPreferredSize());
		Box bqlbn1_ThongTin_DiaChi = Box.createHorizontalBox();
		bqlbn1_ThongTin_DiaChi.add(new JLabel("Địa chỉ: "));
		bqlbn1_ThongTin_DiaChi.add(Box.createHorizontalStrut(80));
		bqlbn1_ThongTin_DiaChi.add(txtdiachibn = new JTextField());
		txtdiachibn.setPreferredSize(getPreferredSize());

		bqlbn1_ThongTin.add(bqlbn1_ThongTin_IdBN);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ho);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ten);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Sdt);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_DiaChi);

		Box bqlbn1_TimKiem_BenhNhan_BacSi = Box.createVerticalBox();
		Box bqlbn1_TimKiem = Box.createVerticalBox();
		bqlbn1_TimKiem.setBorder(BorderFactory.createTitledBorder("Tìm kiếm bệnh nhân: "));
		Box bqlbn1_TimKiem_1 = Box.createHorizontalBox();
		String[] chon = { "Theo tên", "Theo số điện thoại" };
		bqlbn1_TimKiem_1.add(Box.createHorizontalStrut(5));
		bqlbn1_TimKiem_1.add(cmbTim = new JComboBox<String>(chon));
		cmbTim.setMaximumSize(new Dimension(30, 20));
		bqlbn1_TimKiem_1.add(Box.createHorizontalStrut(10));
		bqlbn1_TimKiem_1.add(txttimbn = new JTextField());
		bqlbn1_TimKiem_1.add(Box.createHorizontalStrut(10));// Khoảng cách giữa các phần tử trong box tìm kiếm
		bqlbn1_TimKiem_1.add(btnTimbn = new JButton("Tìm",
				new ImageIcon(getClass().getResource("/ima/if_search_magnifying_glass_find_103857.png"))));
		bqlbn1_TimKiem.add(bqlbn1_TimKiem_1);
		bqlbn1_TimKiem.add(Box.createVerticalStrut(60));
		bqlbn1_TimKiem_BenhNhan_BacSi.add(bqlbn1_TimKiem);

		Box bqlbn1_TimKiem_BS = Box.createVerticalBox();
		bqlbn1_TimKiem_BS.setBorder(BorderFactory.createTitledBorder("Tìm kiếm bác sỹ"));
		Box bqlbn1_TimKiem_BS_1 = Box.createHorizontalBox();
		bqlbn1_TimKiem_BS_1.add(new JLabel("Tên Bác Sỹ"));
		bqlbn1_TimKiem_BS_1.add(Box.createHorizontalStrut(20));
		bqlbn1_TimKiem_BS_1.add(cmbTimbs = new JComboBox<String>());
		bqlbn1_TimKiem_BS_1.add(Box.createHorizontalStrut(20));

		bqlbn1_TimKiem_BS.add(bqlbn1_TimKiem_BS_1);
		bqlbn1_TimKiem_BS.add(Box.createVerticalStrut(60));
		bqlbn1_TimKiem_BenhNhan_BacSi.add(bqlbn1_TimKiem_BS);

		bqlbn1.add(bqlbn1_ThongTin);
		bqlbn1.add(Box.createHorizontalStrut(10));// Giản cách giữa hai box thông tin và tìm kiếm
		bqlbn1.add(bqlbn1_TimKiem_BenhNhan_BacSi);

		Box bqlbn2_ChucNang = Box.createVerticalBox(); // bqlbn2_ChucNang là quản lý dòng các nút chức năng
		bqlbn2_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bqlbn2_ChucNang.setMaximumSize(getMaximumSize());
		Box bqlbn2_ChucNang_1 = Box.createHorizontalBox();
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1
				.add(btnThem = new JButton("Thêm", new ImageIcon(getClass().getResource("/ima/if_7_330410.png"))));
		btnThem.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1.add(btnCapNhat = new JButton("Cập nhật",
				new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png"))));
		btnCapNhat.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1
				.add(btnLuu = new JButton("Lưu", new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png"))));
		btnLuu.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1.add(btnChuyen = new JButton("Chuyển bệnh nhân",
				new ImageIcon(getClass().getResource("/ima/if_control-next-move-forward-future_3209403.png"))));
		btnChuyen.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));

		bqlbn2_ChucNang.add(bqlbn2_ChucNang_1);

		Box bqlbn3_Danhsach = Box.createVerticalBox(); // bqlbn3_Danhsach là quản lý cái bảng danh sách
		bqlbn3_Danhsach.setBorder(BorderFactory.createTitledBorder("Danh sách bệnh nhân"));
		Box bqlbn3_Danhsach_1 = Box.createHorizontalBox();
		String[] header = { "Mã số bệnh nhân", "Họ", "Tên", "Số điện thoại", "Địa chỉ" };
		tablemodel = new DefaultTableModel(header, 0);
		bqlbn3_Danhsach_1.add(new JScrollPane(table = new JTable(tablemodel)));
		table.setDefaultEditor(Object.class, null);
		bqlbn3_Danhsach.add(bqlbn3_Danhsach_1);

		bqlbn.add(bqlbn1);
		bqlbn.add(bqlbn2_ChucNang);
		bqlbn.add(bqlbn3_Danhsach);
		/////////////////////////////////
		/**
		 * Cái này là quản lý cá nhân
		 */
		/////////////////////////////////
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
		/////////////////////////////////
		/**
		 * Cái này là quản lý các tab
		 */
		/////////////////////////////////
		tbp = new JTabbedPane();
		tbp.addTab("Quản lý cá nhân", new ImageIcon(getClass().getResource("/ima/if_personal-information_47997.png")),
				tbpqlcn);
		tbp.addTab("Quản lý bệnh nhân", new ImageIcon(getClass().getResource("/ima/if_8_375259.png")), bqlbn);
		tbp.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		tbp.setTabPlacement(JTabbedPane.LEFT);
		/////////////////////////////////
		/**
		 * Xử lý trạng thái ban đầu
		 */
		/////////////////////////////////
		txtmanv.setEditable(false);
		txttennv.setEditable(false);
		txthonv.setEditable(false);
		txtngaysinhnv.setEditable(false);
		txtdiachinv.setEditable(false);
		txtsdtnv.setEditable(false);

		txtidbn.setEditable(false);
		txttenbn.setEditable(false);
		txthobn.setEditable(false);
		txtsdtbn.setEditable(false);
		txtdiachibn.setEditable(false);

		btnLuu.setEnabled(false);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(false);

		cmbTimbs.setEnabled(false);

		/////////////////////////////////
		bt.add(tbp);
		add(bt);
		setLocationRelativeTo(null);
		setVisible(true);
		/////////////////////////////////
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ThemAction();

			}
		});
		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LuuAction();
				System.out.println("a");

			}
		});
		btnCapNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CapNhatAction();

			}
		});
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (table.isEnabled())
					ChonDongTrongBangBenhNhan();

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
				// TODO Auto-generated method stub

			}
		});
		btnChuyen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChuyenBenhNhan();

			}
		});
		btnTimbn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TimBenhNhan();

			}
		});
		btnDangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (chon == 0) {
					new Gui_DangNhap();
					dispose();
				}

			}
		});
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Gui_HuongDan_NhanBenh().setVisible(true);

			}
		});
		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoaTrangDoiMatKhau();
			}
		});
		btnDoimk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DoiMatKhau();

			}
		});
		/////////////////////////////////
		LoadBenhNhanVaoBang();
		LoadTenBacSi();
		HienThiThongTinCaNhan();
	}

	/**
	 * các hàm xử lý
	 */
	////////////////////////////////////////////////////////////////////////////////////
	private void XoaTrangDoiMatKhau() {
		txtmkc.setText("");
		txtmkm.setText("");
		txtnlmkm.setText("");
	}

	private void LoadTenBacSi() {
		dsnv = new ArrayList<>();
		dsnv = nhanVienNhanBenhDaos.GetBacSy();
		for (int i = 0; i < dsnv.size(); i++) {
			String s = dsnv.get(i).getHo() + " " + dsnv.get(i).getTen();
			cmbTimbs.addItem(s);
		}

	}

	private void LoadBenhNhanVaoBang() {
		dsbn = new ArrayList<>();
		dsbn = nhanVienNhanBenhDaos.LayBenhNhanTuSQL();
		for (int i = 0; i < dsbn.size(); i++) {
			String s[] = { dsbn.get(i).getIDBenhNhan(), dsbn.get(i).getHo(), dsbn.get(i).getTenBN(),
					dsbn.get(i).getSDT(), dsbn.get(i).getDiaChi() };
			tablemodel.addRow(s);
		}
	}

	private void XoaTrangBenhNhan() {
		txtidbn.setText("");
		txttenbn.setText("");
		txthobn.setText("");
		txtsdtbn.setText("");
		txtdiachibn.setText("");

	}

	private void XoaBangBenhNhan() {
		int a = tablemodel.getRowCount();
		for (int i = a - 1; i >= 0; i--) {
			tablemodel.removeRow(i);
		}
	}

	private void ChonDongTrongBangBenhNhan() {
		int a = table.getSelectedRow();
		txtidbn.setText(table.getValueAt(a, 0).toString());
		txthobn.setText(table.getValueAt(a, 1).toString());
		txttenbn.setText(table.getValueAt(a, 2).toString());
		txtsdtbn.setText(table.getValueAt(a, 3).toString());
		txtdiachibn.setText(table.getValueAt(a, 4).toString());
	}

	private void TrangThaiTextBenhNhan(boolean a) {
		txtidbn.setEditable(a);
		txttenbn.setEditable(a);
		txthobn.setEditable(a);
		txtsdtbn.setEditable(a);
		txtdiachibn.setEditable(a);
	}

	private void HienThiThongTinCaNhan() {
		txtmanv.setText(nhanVien.getIDNhanVien());
		txttennv.setText(nhanVien.getTen());
		txthonv.setText(nhanVien.getHo());
		txtdiachinv.setText(nhanVien.getDiaChi());
		txtsdtnv.setText(nhanVien.getSDT());
		txtngaysinhnv.setText(nhanVien.getNgaySinh().toString());
	}

	////////////////////////////////////////////////////////////////////////////////////////
	private void ThemAction() {
		if (btnThem.getText().equalsIgnoreCase("Thêm")) {
			TrangThaiTextBenhNhan(true);
			btnThem.setText("Hủy");
			btnThem.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
			btnCapNhat.setEnabled(false);
			btnChuyen.setEnabled(false);
			btnLuu.setEnabled(true);
			txtidbn.requestFocus();
		} else if (btnThem.getText().equalsIgnoreCase("Hủy")) {
			TrangThaiTextBenhNhan(false);
			btnThem.setText("Thêm");
			btnThem.setIcon(new ImageIcon(getClass().getResource("/ima/if_7_330410.png")));
			btnCapNhat.setEnabled(true);
			btnChuyen.setEnabled(true);
			btnLuu.setEnabled(false);

		}
	}

	private void LuuAction() {
		if (btnThem.getText().equalsIgnoreCase("Hủy")) {
			BenhNhan benhNhan = new BenhNhan();
			benhNhan.setIDBenhNhan(txtidbn.getText());
			benhNhan.setHo(txthobn.getText());
			benhNhan.setTenBN(txttenbn.getText());
			benhNhan.setDiaChi(txtdiachibn.getText());
			benhNhan.setSDT(txtsdtbn.getText());
			nhanVienNhanBenhDaos.ThemBenhNhanVaoDataBase(benhNhan);
			XoaBangBenhNhan();
			LoadBenhNhanVaoBang();
			XoaTrangBenhNhan();
		} else if (btnCapNhat.getText().equals("Hủy")) {
			if (table.getSelectedRow() >= 0) {
				BenhNhan benhNhan = new BenhNhan();
				benhNhan.setIDBenhNhan(txtidbn.getText());
				benhNhan.setHo(txthobn.getText());
				benhNhan.setTenBN(txttenbn.getText());
				benhNhan.setDiaChi(txtdiachibn.getText());
				benhNhan.setSDT(txtsdtbn.getText());
				nhanVienNhanBenhDaos.SuaBenhNhanVaoDatabase(benhNhan);
				XoaBangBenhNhan();
				LoadBenhNhanVaoBang();
				XoaTrangBenhNhan();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Chưa chọn bệnh nhân để cập nhật");
				XoaTrangBenhNhan();
			}
		} else if (btnChuyen.getText().equals("Hủy")) {

			if (table.getSelectedRow() >= 0) {
				BenhNhan benhNhan = new BenhNhan();
				benhNhan.setIDBenhNhan(txtidbn.getText());
				benhNhan.setHo(txthobn.getText());
				benhNhan.setTenBN(txttenbn.getText());
				benhNhan.setDiaChi(txtdiachibn.getText());
				benhNhan.setSDT(txtsdtbn.getText());
				NhanVien nhanVien = new NhanVien();
				nhanVien = dsnv.get(cmbTimbs.getSelectedIndex());
				nhanVienNhanBenhDaos.ChuyenBenhNhanQuaBacSy(nhanVien, benhNhan);
				XoaBangBenhNhan();
				XoaTrangBenhNhan();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Chưa chọn bệnh nhân để chuyển");
				txttimbn.setText("");
			}

		}

	}

	private void CapNhatAction() {
		if (btnCapNhat.getText().equals("Cập nhật")) {
			TrangThaiTextBenhNhan(true);
			btnCapNhat.setText("Hủy");
			btnCapNhat.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
			btnThem.setEnabled(false);
			btnChuyen.setEnabled(false);
			btnLuu.setEnabled(true);
			table.setEnabled(true);

			XoaTrangBenhNhan();
		} else if (btnCapNhat.getText().equals("Hủy")) {
			TrangThaiTextBenhNhan(false);
			btnCapNhat.setText("Cập nhật");
			btnCapNhat.setIcon(new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png")));
			btnThem.setEnabled(true);
			btnChuyen.setEnabled(true);
			btnLuu.setEnabled(false);
			table.getSelectionModel().clearSelection();
			table.setEnabled(true);

			XoaTrangBenhNhan();
			XoaBangBenhNhan();
			txttimbn.setText("");
			LoadBenhNhanVaoBang();
		}
	}

	public void ChuyenBenhNhan() {
		if (btnChuyen.getText().equals("Chuyển bệnh nhân")) {
			btnChuyen.setText("Hủy");
			btnChuyen.setIcon(new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
			btnLuu.setText("Chuyển");
			btnLuu.setIcon(
					new ImageIcon(getClass().getResource("/ima/if_control-next-move-forward-future_3209403.png")));
			btnThem.setEnabled(false);
			btnCapNhat.setEnabled(false);
			cmbTimbs.setEnabled(true);
			btnLuu.setEnabled(true);

			table.setEnabled(true);
		} else if (btnChuyen.getText().equals("Hủy")) {
			XoaBangBenhNhan();
			txttimbn.setText("");
			btnChuyen.setText("Chuyển bệnh nhân");
			btnChuyen.setIcon(
					new ImageIcon(getClass().getResource("/ima/if_control-next-move-forward-future_3209403.png")));
			btnLuu.setText("Lưu");
			btnLuu.setIcon(new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png")));
			btnThem.setEnabled(true);
			btnCapNhat.setEnabled(true);
			cmbTimbs.setEnabled(false);
			btnLuu.setEnabled(false);

			table.getSelectionModel().clearSelection();
			table.setEnabled(false);
			LoadBenhNhanVaoBang();
			XoaTrangBenhNhan();
		}
	}

	public void TimBenhNhan() {
		if (cmbTim.getSelectedIndex() == 0 && !txttimbn.getText().isEmpty()) {
			XoaBangBenhNhan();
			dsbn = new ArrayList<>();
			dsbn = nhanVienNhanBenhDaos.TimBenhNhanTheoTen(txttimbn.getText());
			if (dsbn != null) {
				for (int i = 0; i < dsbn.size(); i++) {
					String s[] = { dsbn.get(i).getIDBenhNhan(), dsbn.get(i).getHo(), dsbn.get(i).getTenBN(),
							dsbn.get(i).getSDT(), dsbn.get(i).getDiaChi() };
					tablemodel.addRow(s);
				}
				txttimbn.setText("");
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy");
				XoaBangBenhNhan();
				LoadBenhNhanVaoBang();
			}

		} else if (cmbTim.getSelectedIndex() == 1 && !txttimbn.getText().isEmpty()) {
			XoaBangBenhNhan();
			dsbn = new ArrayList<>();
			dsbn = nhanVienNhanBenhDaos.TimBenhNhanTheoSDT(txttimbn.getText());
			if (!dsbn.isEmpty()) {
				for (int i = 0; i < dsbn.size(); i++) {
					String s[] = { dsbn.get(i).getIDBenhNhan(), dsbn.get(i).getHo(), dsbn.get(i).getTenBN(),
							dsbn.get(i).getSDT(), dsbn.get(i).getDiaChi() };
					tablemodel.addRow(s);
				}
				txttimbn.setText("");
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy");
				XoaBangBenhNhan();
				LoadBenhNhanVaoBang();
			}

		} else if (txttimbn.getText().equals("")) {
			XoaBangBenhNhan();
			LoadBenhNhanVaoBang();
		}
	}

	/////////////////////////////////////////////////////////////////////////
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
		if (!nhanVienNhanBenhDaos.CheckMatKhauCu(nhanVien, mkc)) {
			JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu cũ không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!mkm.equals(nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Nhập lại mật khẩu mới không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!nhanVienNhanBenhDaos.DoiMatKhau(nhanVien, nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Đổi mật khẩu không thành công");
			XoaTrangDoiMatKhau();
			return false;
		}
		JOptionPane.showMessageDialog(new JFrame(), "Đổi mật khẩu thành công");
		new Gui_DangNhap();
		dispose();
		return true;
	}
}
