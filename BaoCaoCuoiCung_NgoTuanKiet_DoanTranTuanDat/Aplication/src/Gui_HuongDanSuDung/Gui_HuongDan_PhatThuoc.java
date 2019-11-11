package Gui_HuongDanSuDung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public class Gui_HuongDan_PhatThuoc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextArea txta;
	private JButton btnok;

	public Gui_HuongDan_PhatThuoc() {
		setSize(400, 300);
		setVisible(true);
		setTitle("Hướng dẫn sử dụng: nhân viên phát thuốc");
		setIconImage(new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png")).getImage());
		txta = new TextArea(100, 50);
		String s = "================ HƯỚNG DẪN SỬ DỤNG ==================\r\n"
				+ "Giao diện dành cho nhân viên phát thuốc.\r\n"
				+ "Các toa thuốc hiện trên màn hình chính là các toa thuốc được các bác sĩ kê cho bệnh nhân mà chưa được phát \r\n"
				+ "Các toa thuốc sẽ được phát theo thứ tự từ trên xuống dưới của bảng “danh sách toa thuốc”\r\n"
				+ "Chức năng:\r\n" + "* Quản lí cá nhân: xem thông tin, đổi mật khẩu, đăng xuất\r\n"
				+ "- xem thông tin: nhấn vào tab Xem thông tin để xem thông tin\r\n" + "- đổi mật khẩu:\r\n"
				+ "	+ bước 1: nhập mật khẩu cũ \r\n" + "	+ bước 2: nhập mật khẩu mới\r\n"
				+ "	+ bước 3: nhập lại mật khẩu mới\r\n"
				+ "	+ bước 4: nhấn “Đổi mật khẩu” để thay đổi mật khẩu hoặc nhấn “Hủy” để xóa các thông tin đã nhập.\r\n"
				+ "* Quản lí toa thuốc: Phát thuốc\r\n" + "- phát thuốc: \r\n"
				+ "	+ buớc 1: Xem thông tin toa thuốc thật kĩ\r\n"
				+ "	+ buớc 2: nhấn \"Phát thuốc” để phát thuốc cho bệnh nhân tương ứng với toa thuốc\r\n"
				+ "-	Đăng xuất: Nhấn “Đăng xuất” để đăng xuất ra khỏi tài khoản hiện hành\r\n" + "";
		txta.setText(s);
		txta.setEditable(false);
		txta.setFont(new Font("Arial", NORMAL, 14));
		add(txta, BorderLayout.CENTER);
		add(btnok = new JButton("Đã hiểu!"), BorderLayout.SOUTH);
		btnok.setFont(new Font("Time New Romans", Font.BOLD, 14));
		btnok.setAlignmentX(CENTER_ALIGNMENT);
		btnok.setSize(30, 20);
		btnok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
