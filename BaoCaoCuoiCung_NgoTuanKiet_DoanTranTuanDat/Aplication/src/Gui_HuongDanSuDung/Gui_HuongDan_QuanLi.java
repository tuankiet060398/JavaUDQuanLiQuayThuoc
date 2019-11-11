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
public class Gui_HuongDan_QuanLi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextArea txta;
	private JButton btnok;

	public Gui_HuongDan_QuanLi() {
		setSize(400, 300);
		setVisible(true);
		setTitle("Hướng dẫn sử dụng: Quản lí");
		setIconImage(new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png")).getImage());
		txta = new TextArea(100, 50);
		String s = "======================= HƯỚNG DẪN SỬ DỤNG =======================\r\n" + 
				" Giao diện dành cho nhân viên Quản lí\r\n" + 
				" Nhân viên quản lí được cấp các chức năng:\r\n" + 
				" Quản lí bệnh nhân, quản lí nhân viên, quản lí tài khoản, quản lí toa thuốc, quản lí cá nhân\r\n" + 
				"- Quản lí bệnh nhân:Xóa bệnh nhân\r\n" + 
				"	Các bệnh nhân hiện trên màn hình là các bệnh nhân đã và đang khám trong phòng khám.\r\n" + 
				"	Click vào 1 bệnh nhân ở dưới bảng để hiện các thông tin lên các ô trong phần “Thông tin bệnh nhân”\r\n" + 
				"	Nhấn “Xóa” để xóa các bệnh nhân ba năm chưa khám lại\r\n" + 
				"- Quản lí nhân viên: Thêm nhân viên, Sửa nhân viên, Xóa nhân viên, Tải lại danh sách nhân viên, Tìm nhân viên\r\n" + 
				"	+Thêm: \r\n" + 
				"		Bước 1: Nhấn “Thêm”\r\n" + 
				"		Bước 2: Điền thông tin nhân viên\r\n" + 
				"		Bước 3: Nhấn “Lưu” để thêm nhân viên vào cơ sở dữ liệu hoặc nhấn “Hủy” để bỏ thao tác thêm nhân viên\r\n" + 
				"	+Sửa:\r\n" + 
				"		Bước 1: Chọn 1 nhân viên trong bảng\r\n" + 
				"		Bước 2: Nhập lại thông tin cần được chỉnh sửa vào các ô phần “Thông tin nhân viên”\r\n" + 
				"		Bước 3: Nhấn “Lưu” để cập nhật nhân viên vào cơ sở dữ liệu hoặc nhấn “Hủy” để bỏ thao tác sửa nhân viên\r\n" + 
				"	+Tải lại danh sách: Nhấn “Tải lại danh sách” để tải lại danh sách tất cả các nhân viên\r\n" + 
				"	+Xóa:\r\n" + 
				"		Bước 1: Chọn 1 nhân viên cần xóa\r\n" + 
				"		Bước 2: Sau khi có thông báo xóa thành công, nhấn “oke”\r\n" + 
				"	+Tìm nhân viên:\r\n" + 
				"		Bước 1: Chọn tiêu chí cần tìm\r\n" + 
				"		Bước 2: Nhập dữ liệu tìm\r\n" + 
				"		Bước 3: Nhấn “Tìm”\r\n" + 
				"- Quản lí tài khoản: Thêm tài khoản, Sửa tài khoản\r\n" + 
				"	+Thêm tài khoản:\r\n" + 
				"		Bước 1: Nhấn “Thêm”\r\n" + 
				"		Bước 2: Điền thông tin tài khoản\r\n" + 
				"		Bước 3: Nhấn “Lưu” để thêm tài khoản vào cơ sở dữ liệu hoặc nhấn “Hủy” để bỏ thao tác thêm tài khoản\r\n" + 
				"	+Sửa tài khoản:\r\n" + 
				"		Bước 1: Chọn 1 tài khoản trong bảng\r\n" + 
				"		Bước 2: Nhập lại thông tin cần được chỉnh sửa vào các ô phần “Thông tin tài khoản”\r\n" + 
				"- Quản lí cá nhân: xem thông tin, đổi mật khẩu, đăng xuất\r\n" + 
				"	+ Xem thông tin: nhấn vào tab Xem thông tin để xem thông tin\r\n" + 
				"	+ Đổi mật khẩu:\r\n" + 
				"		bước 1: nhập mật khẩu cũ \r\n" + 
				"		bước 2: nhập mật khẩu mới\r\n" + 
				"		bước 3: nhập lại mật khẩu mới\r\n" + 
				"		bước 4: nhấn “Đổi mật khẩu” để thay đổi mật khẩu hoặc nhấn “Hủy” để xóa các thông tin đã nhập.\r\n" + 
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
