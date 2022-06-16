package memberProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginAfterWindow extends JFrame{

	public LoginAfterWindow(String loginID) {
		
		JButton btn_update = new JButton("회원정보 수정");
		JButton btn_grade = new JButton("성적관리");
		JButton btn_logout = new JButton("로그아웃");
		
		setLayout(new BorderLayout());
		
		JPanel btnPannel = new JPanel();
		btnPannel.setLayout(new FlowLayout());
		btnPannel.add(btn_update);
		btnPannel.add(btn_grade);
		btnPannel.add(btn_logout);
		
		add(btnPannel);
		
		setVisible(true);
		setSize(400, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 회원정보수정
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoWindow(loginID);
			}
		});
		
		// 성적관리
		btn_grade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GradeWindow(loginID);
			}
		});
		
		// 로그아웃
		btn_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CommonPopup(4);
				dispose();
				new LoginWindow();
				
			}
		});
		
	}
}
