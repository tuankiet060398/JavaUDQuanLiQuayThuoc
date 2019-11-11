package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import Gui_HuongDanSuDung.Gui_HuongDan_PhatThuoc;
import daos.BenhNhanDaos;
import daos.NhanVienPhatThuocDaos;
import htqlbv_entities.BenhNhan;
import htqlbv_entities.ChiTietKhoThuoc;
import htqlbv_entities.NhanVien;
import htqlbv_entities.ToaThuoc;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class Gui_NhanVienPhatThuoc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnDong;
	private NhanVien nhanVien;
	// Khai bao cho tab quan ly toa thuoc
	private JLabel lblToaThuocID, lblDonGia, lblGhiChu;
	private JTextField txtToaThuocID, txtDonGia, txtGhiChu;
	private JTable tableToaThuoc, tableChiTietToa;
	private DefaultTableModel modelToaThuoc, modelChiTietToa;
	private JButton btnPhat;

	// Khai bao quan ly ca nhan

	private JPasswordField txtmkc,txtmkm,txtnlmkm;
	private JTabbedPane tbpqlcn;
	private JLabel lblmanv,lbltennv,lblhonv,lblsdtnv,lbldiacchinv,lblngaysinhnv,lblmkc,lblTenDn,lblmkm,lblnlmkm;
	private JTextField txtmanv,txthonv,txttennv,txtsdtnv,txtdiachinv,txtngaysinhnv;
	private JButton btnDoimk,btnHuy;

	// Su kien
	private List<ToaThuoc> dstt;
	private NhanVienPhatThuocDaos nhanVienPhatThuocDaos;
	private BenhNhanDaos benhNhanDaos;

	private JTextField txtidbn;

	private JTextField txthobn;

	private JTextField txttenbn;

	private JTextField txtsdtbn;

	private JTextField txtdcbn;

	private JButton btnHelp;

	public Gui_NhanVienPhatThuoc(NhanVien nhanVien) {
		this.nhanVien= nhanVien;
		nhanVienPhatThuocDaos = new NhanVienPhatThuocDaos();
		benhNhanDaos = new BenhNhanDaos();
		setSize(1100,700);
		setTitle("Nhân viên phát thuốc");
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png")).getImage());

		// ------------------------------------------------------------------------------
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		pNorth.add(new JLabel(new ImageIcon(getClass().getResource("/ima/if_Dental_checkup_3522335.png"))));
		pNorth.add(lblTenDn = new JLabel(nhanVien.getHo()+" " + nhanVien.getTen()));
		lblTenDn.setFont(new Font("Times new Roman", Font.BOLD, 20));
		lblTenDn.setForeground(Color.RED);
		pNorth.add(Box.createHorizontalStrut(500));
		pNorth.add(btnDong = new JButton("Đăng xuất",new ImageIcon(getClass().getResource("/ima/if_Logout_105217.png"))));
		
		pNorth.add(Box.createHorizontalStrut(7));
		pNorth.add(btnHelp = new JButton("Trợ giúp",new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png"))));
		add(pNorth, BorderLayout.NORTH);

		// ------------------------------------------------------------------------------
		JTabbedPane tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.LEFT);

		/*
		 * Giao dien quan ly toa thuoc
		 */
		Box bToaThuoc = Box.createVerticalBox();
		Box bTT1, bTT2, bTT3, BTT4;
		Box bTT1_1, bTT1_2, bTT1_3;

		Box bNorth = Box.createHorizontalBox();
		
		bTT1 = Box.createVerticalBox();
		
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
		bTT1_3.add(lblGhiChu = new JLabel("Ghi chú"));
		bTT1_3.add(Box.createHorizontalStrut(10));
		bTT1_3.add(txtGhiChu = new JTextField());
		bNorth.add(bTT1);
		
		Box bbenhnhan = Box.createVerticalBox();
		bbenhnhan.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));
		Box bbenhnhan_2;
		bbenhnhan.add(bbenhnhan_2 = Box.createHorizontalBox());
		bbenhnhan.add(Box.createVerticalStrut(10));
		bbenhnhan_2.add(new JLabel("Mã bệnh nhân"));
		bbenhnhan_2.add(Box.createHorizontalStrut(10));
		bbenhnhan_2.add(txtidbn = new JTextField());
		
		Box bbenhnhan_3;
		bbenhnhan.add(bbenhnhan_3 = Box.createHorizontalBox());
		bbenhnhan.add(Box.createVerticalStrut(10));
		bbenhnhan_3.add(new JLabel("Họ"));
		bbenhnhan_3.add(Box.createHorizontalStrut(70));
		bbenhnhan_3.add(txthobn = new JTextField());
		
		Box bbenhnhan_4;
		bbenhnhan.add(bbenhnhan_4 = Box.createHorizontalBox());
		bbenhnhan.add(Box.createVerticalStrut(10));
		bbenhnhan_4.add(new JLabel("Tên"));
		bbenhnhan_4.add(Box.createHorizontalStrut(65));
		bbenhnhan_4.add(txttenbn = new JTextField());
		
		Box bbenhnhan_5;
		bbenhnhan.add(bbenhnhan_5 = Box.createHorizontalBox());
		bbenhnhan.add(Box.createVerticalStrut(10));
		bbenhnhan_5.add(new JLabel("Số điện thoại"));
		bbenhnhan_5.add(Box.createHorizontalStrut(15));
		bbenhnhan_5.add(txtsdtbn = new JTextField());
		
		Box bbenhnhan_6;
		bbenhnhan.add(bbenhnhan_6 = Box.createHorizontalBox());
		bbenhnhan.add(Box.createVerticalStrut(10));
		bbenhnhan_6.add(new JLabel("Địa chỉ"));
		bbenhnhan_6.add(Box.createHorizontalStrut(50));
		bbenhnhan_6.add(txtdcbn = new JTextField());
		
		
		bNorth.add(bbenhnhan);
		
		bToaThuoc.add(bNorth);
		
		lblGhiChu.setPreferredSize(lblToaThuocID.getPreferredSize());
		lblDonGia.setPreferredSize(lblToaThuocID.getPreferredSize());

		// ***********************
		bToaThuoc.add(BTT4 = Box.createHorizontalBox());
		BTT4.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		BTT4.add(Box.createHorizontalStrut(450));
		BTT4.add(btnPhat = new JButton("Phát Thuốc",new ImageIcon(getClass().getResource("/ima/if_6_3319634.png"))));
		BTT4.setMaximumSize(getMaximumSize());
		btnPhat.setMaximumSize(new Dimension(150, 50));
		// ***********************
		bToaThuoc.add(bTT2 = Box.createVerticalBox());
		bTT2.setBorder(BorderFactory.createTitledBorder("Chi tiết toa thuốc"));

		String[] headersCTTT = "Mã thuốc;Tên thuốc;Số lượng;Đơn giá".split(";");
		modelChiTietToa = new DefaultTableModel(headersCTTT, 0);
		JScrollPane scrollCTTT = new JScrollPane();
		scrollCTTT.setViewportView(tableChiTietToa = new JTable(modelChiTietToa));
		tableChiTietToa.setRowHeight(20);
		tableChiTietToa.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bTT2.add(scrollCTTT);

		// ***********************
		bToaThuoc.add(bTT3 = Box.createVerticalBox());
		bTT3.setBorder(BorderFactory.createTitledBorder("Danh sách toa thuốc"));

		String[] headersTT = "Mã toa thuốc;Đơn giá;Ghi chú".split(";");
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
		Box bqlcn_XemThongTin,bqlcn_DoiMatKhau;
		bqlcn_XemThongTin = Box.createVerticalBox();//bqlcn_XemThongTin quản lý chung của xem thông tin
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
		
		bqlcn_DoiMatKhau = Box.createVerticalBox();//bqlcn_DoiMatKhau là quản lý chung của đổi mật khẩu
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
		bqlcn_DoiMatKhau_button.add(btnDoimk = new JButton("Đổi mật khẩu",new ImageIcon(getClass().getResource("/ima/if_Access_field_pin_input_password_2629858 .png"))));
		btnDoimk.setSize(new Dimension(50, 20));
		bqlcn_DoiMatKhau_button.add(Box.createHorizontalStrut(50));
		bqlcn_DoiMatKhau_button.add(btnHuy = new JButton("Hủy",new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png"))));
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
		tbpqlcn.addTab("Xem Thông tin",new ImageIcon(getClass().getResource("/ima/if_icon-85-folder-information_314768.png")),bqlcn_XemThongTin);
		tbpqlcn.addTab("Đổi mật khẩu", new ImageIcon(getClass().getResource("/ima/if_Access_field_pin_input_password_2629858 .png")),bqlcn_DoiMatKhau);
		tbpqlcn.setFont(new Font("Times new Roman", Font.PLAIN, 20));

		/*
		 * Phan ket noi tab va gan su kien
		 */
		tab.addTab("Quản lý cá nhân",new ImageIcon(getClass().getResource("/ima/if_personal-information_47997.png")), tbpqlcn);
		tab.addTab("Quản lý toa thuốc",new ImageIcon(getClass().getResource("/ima/if_receipt_3583272.png")), bToaThuoc);
		tab.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		
		///////////////////////////////////////////////////////
		tableToaThuoc.setDefaultEditor(Object.class, null);
		tableChiTietToa.setDefaultEditor(Object.class, null);
		tableChiTietToa.setEnabled(false);
		tableToaThuoc.setEnabled(false);

		txtToaThuocID.setEditable(false);
		txtDonGia.setEditable(false);
		txtGhiChu.setEditable(false);
		
		txtmanv.setEditable(false);
		txttennv.setEditable(false);
		txthonv.setEditable(false);
		txtdiachinv.setEditable(false);
		txtngaysinhnv.setEditable(false);
		txtdiachinv.setEditable(false);
		txtsdtnv.setEditable(false);
		///////////////////////////////////////////////////////
		
		btnHelp.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new Gui_HuongDan_PhatThuoc().setVisible(true);
				
			}
		});
		btnPhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PhatThuoc();
			}
		});
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int chon = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn đăng xuất","Warning",JOptionPane.YES_NO_OPTION);
				if(chon == 0)
				{
					new Gui_DangNhap();
					dispose();
				}
				
				
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
		///////////////////////////////////////////////////////
		LoadDanhSachToaThuoc();
		LoadDanhSachChiTietThuoc();
		LoadThongTinCaNhan();
		KhoaTxtBenhNhan();
		///////////////////////////////////////////////////////
		add(tab, BorderLayout.CENTER);
		setVisible(true);
	}
	private void KhoaTxtBenhNhan() {
		txtidbn.setEditable(false);
		txthobn.setEditable(false);
		txttenbn.setEditable(false);
		txtsdtbn.setEditable(false);
		txtdcbn.setEditable(false);
		
	}
	private void LoadDanhSachToaThuoc() {
		dstt = new ArrayList<>();
		dstt = nhanVienPhatThuocDaos.GetListToaThuocChuaPhat();
		if (!dstt.isEmpty()) {
			for (int i = 0; i < dstt.size(); i++) {
				String a[] = { dstt.get(i).getIDToaThuoc(),
						nhanVienPhatThuocDaos.TinhDonGiaToaThuoc(dstt.get(i).getIDToaThuoc()).toString(),
						dstt.get(i).getGhiChu() };
				modelToaThuoc.addRow(a);
			}
		}
	}

	private void LoadDanhSachChiTietThuoc() {
		if (tableToaThuoc.getRowCount() > 0) {
			tableToaThuoc.setRowSelectionInterval(0, 0);
			SetTextToaThuoc();
			setTextBenhNhan(txtToaThuocID.getText());
			int a = tableToaThuoc.getSelectedRow();
			String idtoa = modelToaThuoc.getValueAt(a, 0).toString();
			List<ChiTietKhoThuoc> dskt = new ArrayList<>();
			dskt = nhanVienPhatThuocDaos.getChiTietKhoThuoc(idtoa);
			if (!dskt.isEmpty()) {
				XoaBangChiTietToaThuoc();
				for (int i = 0; i < dskt.size(); i++) {
					String b[] = { dskt.get(i).getIDThuoc().getIDThuoc(), dskt.get(i).getIDThuoc().getTenThuoc(),
							Integer.toString(dskt.get(i).getSoLuong()),
							Double.toString(dskt.get(i).getIDThuoc().getDonGia()) };
					modelChiTietToa.addRow(b);
				}
			}
		}
	}
	private void XoaBangChiTietToaThuoc() {
		int a = modelChiTietToa.getRowCount();
		for (int i = a - 1; i >= 0; i--) {
			modelChiTietToa.removeRow(i);
		}
	}

	private void XoaBangToaThuoc() {
		int a = modelToaThuoc.getRowCount();
		for (int i = a - 1; i >= 0; i--) {
			modelToaThuoc.removeRow(i);
		}
	}

	private void SetTextToaThuoc() {
		txtToaThuocID.setText(tableToaThuoc.getValueAt(0, 0).toString());
		txtDonGia.setText(tableToaThuoc.getValueAt(0, 1).toString());
		txtGhiChu.setText(tableToaThuoc.getValueAt(0, 2).toString());
	}
	private void setTextBenhNhan(String id) {
		List<BenhNhan> list = new ArrayList<>();
		BenhNhan bn = new BenhNhan();
		list = benhNhanDaos.TimTheoIDToathuoc(id);
		bn = list.get(0);
		txtidbn.setText(bn.getIDBenhNhan());
		txthobn.setText(bn.getHo());
		txttenbn.setText(bn.getTenBN());
		txtsdtbn.setText(bn.getSDT());
		txtdcbn.setText(bn.getDiaChi());
	}

	private void PhatThuoc() {
		if(tableToaThuoc.getRowCount()>0) {
			dstt.get(0).setTrangThai(true);
			if (nhanVienPhatThuocDaos.CapNhatTrangThaiToaThuoc(dstt.get(0))) {
				XoaBangToaThuoc();
				XoaBangChiTietToaThuoc();
				LoadDanhSachToaThuoc();
				LoadDanhSachChiTietThuoc();
				XoaTrangTxtBenhNhan();
				setTextBenhNhan(txtToaThuocID.getText());
				
				
			}
		}else
		{
			JOptionPane.showMessageDialog(new JFrame(),"Không có toa thuốc để phát");
		}

	}
	private void XoaTrangTxtBenhNhan() {
		txtidbn.setText("");
		txthobn.setText("");
		txttenbn.setText("");
		txtsdtbn.setText("");
		txtdcbn.setText("");
	}
	private void LoadThongTinCaNhan() {
		txtmanv.setText(nhanVien.getIDNhanVien());
		txtdiachinv.setText(nhanVien.getDiaChi());
		txthonv.setText(nhanVien.getHo());
		txttennv.setText(nhanVien.getTen());
		txtsdtnv.setText(nhanVien.getSDT());
		txtngaysinhnv.setText(nhanVien.getNgaySinh().toString());
	}
	private void XoaTrangDoiMatKhau()
	{
		txtmkc.setText("");
		txtmkm.setText("");
		txtnlmkm.setText("");
	}
	private boolean DoiMatKhau()
	{
		String mkc= "",mkm = "",nlmkm = "";
		char a[],b[],c[];
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
		if(!nhanVienPhatThuocDaos.CheckMatKhauCu(nhanVien, mkc)) {
			System.out.println(mkc);
			JOptionPane.showMessageDialog(new JFrame(),"Mật khẩu cũ không khớp");
			XoaTrangDoiMatKhau();
			return false;
		}else if(!mkm.equals(nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(),"Nhập lại mật khẩu mới không khớp");
			XoaTrangDoiMatKhau();
			return false;
		}else if(!nhanVienPhatThuocDaos.DoiMatKhau(nhanVien, nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(),"Đổi mật khẩu không thành công");
			XoaTrangDoiMatKhau();
			return false;
		}
		JOptionPane.showMessageDialog(new JFrame(),"Đổi mật khẩu thành công");
		new Gui_DangNhap();
		dispose();
		return true;
	}
}
