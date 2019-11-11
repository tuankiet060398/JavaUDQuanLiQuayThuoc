package Gui_HuongDanSuDung;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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
public class Gui_HuongDan_BacSi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextComponent txta;
	private JButton btnok;

	public Gui_HuongDan_BacSi() {
		setSize(400, 300);
		setVisible(true);
		setTitle("Hướng dẫn sử dụng: Bác sĩ");
		setIconImage(new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png")).getImage());
		txta = new TextArea(100, 50);
		String s = "============================================= HƯỚNG DẪN SỬ DỤNG =====================================================\r\n" + 
				" Giao diện dành cho bác sĩ\r\n" + 
				" Nhân viên nhận bệnh được cấp các chức năng:\r\n" + 
				" quản lí cá nhân, Khám bệnh\r\n" + 
				"\r\n" + 
				"- Quản lí cá nhân: xem thông tin, đổi mật khẩu, đăng xuất\r\n" + 
				"	+ Xem thông tin: nhấn vào tab Xem thông tin để xem thông tin\r\n" + 
				"	+ Đổi mật khẩu:\r\n" + 
				"		bước 1: nhập mật khẩu cũ \r\n" + 
				"		bước 2: nhập mật khẩu mới\r\n" + 
				"		bước 3: nhập lại mật khẩu mới\r\n" + 
				"		bước 4: nhấn “Đổi mật khẩu” để thay đổi mật khẩu hoặc nhấn “Hủy” để xóa các thông tin đã nhập.\r\n" + 
				"- Quản lí bệnh nhân: Ghi tình trạng bệnh, Cho toa thuốc\r\n" + 
				"	+ Ghi tình trạng bệnh: \r\n" + 
				"		* Khám và ghi lại bệnh tình của bệnh nhân, nếu cần phải đi xét nghiệm thì đánh vào ô xét nghiệm \r\n" + 
				"		ghi lại phiếu xét nghiệm đó\r\n" + 
				"		* Gọi bệnh nhân: nhấn \"Gọi bệnh nhân\" để đưa bệnh nhân tiếp theo ở hàng chờ vào khám\r\n" + 
				"	+ Cho toa thuốc: Sau khi đã khám xong cho bệnh nhân thì bác sĩ phải cho toa thuốc\r\n" + 
				"		* Thêm thuốc vào toa: chọn thuốc có trong bảng \"Kho thuốc\", nhấn \"Thêm thuốc vào toa\"\r\n" + 
				"					Nếu thêm dư một thuốc nào đó, chọn nó trong \"Toa thuốc\", nhấn \"Xóa\" để bỏ ra khỏi toa\r\n" + 
				"		* Lưu lại toa thuốc:\r\n" + 
				"		bước 1: nhập mã toa thuốc\r\n" + 
				"		bước 2: chọn thuốc ở bảng \"Kho thuốc\" để đưa vào \"Toa thuốc\"(cách thực hiện đã miêu tả ở trên)\r\n" + 
				"		bước 3: nhập ghi chú\r\n" + 
				"		bước 4: nhấn \"Lưu\" để lưu toa thuốc\r\n" + 
				"	\r\n" + 
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
		});	}
}
