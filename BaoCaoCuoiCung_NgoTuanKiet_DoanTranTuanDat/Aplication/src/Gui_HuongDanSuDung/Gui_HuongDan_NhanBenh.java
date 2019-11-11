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
public class Gui_HuongDan_NhanBenh extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private TextArea txta;
private JButton btnok;

public Gui_HuongDan_NhanBenh() {
	setSize(400, 300);
	setVisible(true);
	setTitle("Hướng dẫn sử dụng: Nhân viên nhận bệnh");
	setIconImage(new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png")).getImage());
	txta = new TextArea(100, 50);
	String s = "============================================= HƯỚNG DẪN SỬ DỤNG =====================================================\r\n" + 
			" Giao diện dành cho nhân viên nhận bệnh\r\n" + 
			" Nhân viên nhận bệnh được cấp các chức năng:\r\n" + 
			" quản lí cá nhân, quản lí bệnh nhân\r\n" + 
			"\r\n" + 
			"- Quản lí cá nhân: xem thông tin, đổi mật khẩu, đăng xuất\r\n" + 
			"	+ Xem thông tin: nhấn vào tab Xem thông tin để xem thông tin\r\n" + 
			"	+ Đổi mật khẩu:\r\n" + 
			"		bước 1: nhập mật khẩu cũ \r\n" + 
			"		bước 2: nhập mật khẩu mới\r\n" + 
			"		bước 3: nhập lại mật khẩu mới\r\n" + 
			"		bước 4: nhấn “Đổi mật khẩu” để thay đổi mật khẩu hoặc nhấn “Hủy” để xóa các thông tin đã nhập.\r\n" + 
			"- Quản lí bệnh nhân: Thêm bệnh nhân, Cập nhật bệnh nhân, Chuyển bệnh nhân, Tìm bệnh nhân\r\n" + 
			"	+ Thêm bệnh nhân: Thêm bệnh nhân mới vào hệ thống, bệnh nhân thêm mới là người chưa từng khám ở phòng khám này\r\n" + 
			"		bước 1: nhấn \"Thêm\"\r\n" + 
			"		bước 2: nhập đầy đủ thông tin bệnh nhân\r\n" + 
			"		bước 3: nhấn \"Lưu\" để lưu bệnh nhân hoặc nhấn \"Hủy\" để hủy thao tác thêm mới bệnh nhân\r\n" + 
			"	+ Cập nhật bệnh nhân: Bệnh nhân đã có trong hệ thống nhưng sai thông tin\r\n" + 
			"		bước 1: nhấn \"Cập nhật\"\r\n" + 
			"		bước 2: chọn bệnh nhân trong bảng phía dưới\r\n" + 
			"		bước 3: nhập lại thông tin đúng của bệnh nhân ở các ô phía trên\r\n" + 
			"		bước 4: nhấn \"Lưu\" để lưu để lưu bệnh nhân hoặc nhấn \"Hủy\" để hủy thao tác cập nhật bệnh nhân\r\n" + 
			"	+ Chuyển bệnh nhân: chuyển một bệnh nhân ở hàng chờ vào phòng khám của bác sĩ\r\n" + 
			"		bước 1: nhấn \"Chuyển bệnh nhân\"\r\n" + 
			"		bước 2: chọn một bệnh nhân ở bảng bên dưới\r\n" + 
			"		bước 3: nhấn \"Chuyển\" để chuyển bệnh nhân đi hoặc nhấn \"Hủy\" để hủy thao tác chuyển\r\n" + 
			"	+ Tìm bệnh nhân: Tìm 1 bệnh nhân đã có trong hệ thống\r\n" + 
			"		Bước 1: Chọn tiêu chí cần tìm\r\n" + 
			"		Bước 2: Nhập dữ liệu tìm\r\n" + 
			"		Bước 3: Nhấn “Tìm”\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"";
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
