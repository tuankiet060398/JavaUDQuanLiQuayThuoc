package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.swing.JTextField;

import daos.DangNhapDaos;
import htqlbv_entities.NhanVien;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class Gui_DangNhap extends JFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private JLabel lbllogOn, lbluseName, lblpassWord, lblLoaiDN;
	private JTextField txtuserName;
	private JPasswordField txtpassWord;
	private JButton btnlogOn, btnExit;
	private JComboBox<String> cmbLoaidb;
	private DangNhapDaos dangNhapDaos;

	public Gui_DangNhap() {
		dangNhapDaos = new DangNhapDaos();

		setTitle("Phòng khám đa khoa ROYAL");
		setSize(1000, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setIconImage(new ImageIcon(getClass().getResource("/ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png")).getImage());

		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		pNorth.add(lbllogOn = new JLabel("Đăng nhập"));
		lbllogOn.setForeground(Color.DARK_GRAY);
		lbllogOn.setFont(new Font("Time new Romans", Font.BOLD, 40));
		JPanel pTrai;
		add(pTrai = new JPanel(), BorderLayout.WEST);
		pTrai.add(new JLabel(new ImageIcon(getClass().getResource("/ima/5_2.png"))));

		Box bp = Box.createVerticalBox();
		add(bp, BorderLayout.CENTER);
		bp.add(Box.createVerticalStrut(50));
		Box b1 = Box.createHorizontalBox();
//		JPanel pn1 = new JPanel();
//		pn1.add(b1);
//		bp.add(pn1);
		bp.add(b1);
		bp.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(10));
		b1.setPreferredSize(new Dimension(20, 20));

		b1.add(lbluseName = new JLabel("User Name"));
		lbluseName.setFont(new Font("Time new Romans", Font.PLAIN, 18));
		b1.add(Box.createHorizontalStrut(35));
		b1.add(txtuserName = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		bp.add(Box.createVerticalStrut(90));

		Box b2 = Box.createHorizontalBox();
		bp.add(b2);
		bp.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblpassWord = new JLabel("PassWord"));
		lblpassWord.setFont(new Font("Time new Romans", Font.PLAIN, 18));
		b2.add(Box.createHorizontalStrut(43));
		b2.add(txtpassWord = new JPasswordField());
		txtpassWord.setSize(new Dimension(0, 0));
		b2.add(Box.createHorizontalStrut(20));
		bp.add(Box.createVerticalStrut(100));
		
		Box b3 = Box.createHorizontalBox();
		String s[] = { "Nhân Viên Nhận Bệnh", "Bác Sỹ", "Nhân Viên Phát Thuốc", "Quản Lý" };
		cmbLoaidb = new JComboBox<>(s);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblLoaiDN = new JLabel("Loại tài khoản"));
		lblLoaiDN.setFont(new Font("Time new Romans", Font.PLAIN, 18));
		b3.add(Box.createHorizontalStrut(15));
		b3.add(cmbLoaidb);
		b3.add(Box.createHorizontalStrut(20));
		bp.add(b3);
		bp.add(Box.createVerticalStrut(100));

		Box bd = Box.createHorizontalBox();
		bd.add(Box.createVerticalStrut(20));
		add(bd, BorderLayout.SOUTH);
		bd.add(Box.createHorizontalStrut(100));
		bd.add(Box.createHorizontalStrut(20));
		bd.add(btnlogOn = new JButton("Đăng nhập", new ImageIcon(getClass().getResource("/ima/if_login_54230.png"))));
		btnlogOn.setMaximumSize(getMaximumSize());
		bd.add(Box.createHorizontalStrut(10));
		bd.add(btnExit = new JButton("Thoát", new ImageIcon(getClass().getResource("/ima/if_logout_59277.png"))));
		btnExit.setMaximumSize(getMaximumSize());
		bd.add(Box.createHorizontalStrut(100));
		setVisible(true);
		setResizable(false);
		
		//////////////////////////////////////////////

		btnlogOn.addActionListener(this);
		btnExit.addActionListener(this);
		txtpassWord.addKeyListener(this);
		txtuserName.addKeyListener(this);
		cmbLoaidb.addKeyListener(this);

	}

	private void DangNhapAction() {
		String username, password = "";
		username = txtuserName.getText();
		char a[] = txtpassWord.getPassword();
		
		for (int i = 0; i < a.length; i++) {
			password = password + a[i];
		}
		String loai = cmbLoaidb.getItemAt(cmbLoaidb.getSelectedIndex());
		if (loai.equalsIgnoreCase("Nhân Viên Nhận Bệnh")) {
			NhanVien nhanVien = dangNhapDaos.LoginNhanVien(username, password);
			if (nhanVien != null && nhanVien.getTaiKhoan().getLoai().equalsIgnoreCase("Nhân Viên Nhận Bệnh")) {
				new Gui_NhanVienNhanBenh(nhanVien).setVisible(true);
				;
				dispose();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Đăng nhập không thành công");
			}

		} else if (loai.equalsIgnoreCase("Nhân Viên Phát Thuốc")) {
			NhanVien nhanVien = dangNhapDaos.LoginNhanVien(username, password);
			if (nhanVien != null && nhanVien.getTaiKhoan().getLoai().equalsIgnoreCase("Nhân Viên Phát Thuốc")) {
				new Gui_NhanVienPhatThuoc(nhanVien).setVisible(true);
				;
				dispose();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Đăng nhập không thành công");
			}
		} else if (loai.equalsIgnoreCase("Bác Sỹ")) {
			NhanVien nhanVien = dangNhapDaos.LoginNhanVien(username, password);
			if (nhanVien != null && nhanVien.getTaiKhoan().getLoai().equalsIgnoreCase("Bác Sỹ")) {
				new Gui_BacSi(nhanVien).setVisible(true);
				;
				dispose();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Đăng nhập không thành công");
			}
		}
		if (loai.equalsIgnoreCase("Quản Lý")) {
			NhanVien nhanVien = dangNhapDaos.LoginNhanVien(username, password);
			if (nhanVien != null && nhanVien.getTaiKhoan().getLoai().equalsIgnoreCase("Quản Lý")) {
				new Gui_QuanLy(nhanVien).setVisible(true);
				;
				dispose();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Đăng nhập không thành công");
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnExit)) {
			System.exit(0);
		}
		if (o.equals(btnlogOn)) {
			DangNhapAction();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			btnlogOn.requestFocus(true);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}