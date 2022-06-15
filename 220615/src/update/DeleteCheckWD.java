package update;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteCheckWD extends JFrame implements ActionListener{
	JLabel jl, jlalert;
		//JPasswordField jpf;
	JButton jbyes, jbno;
	String z;
	DeleteCheckWD(String x) {
		this.z=x;
		checkset();
		checkPanel();
		checksetDisplay();
	}
	void checkset() {
		jl = new JLabel("정말 탈퇴하시겠습니까?");
		//		jpf = new JPasswordField(20);
		jbyes = new JButton("확인");
		jbno = new JButton("취소");
		jlalert = new JLabel("");
	}

	void checkPanel() {
		JPanel jp1 = new JPanel();
		jp1.add(jl);

		//		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		//		jp2.add(jpf);
		//		jp2.add(jlalert);

		JPanel jp3 = new JPanel();
		jp3.add(jbyes);
		jp3.add(jbno);

		add(jp1, BorderLayout.NORTH);
		//		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
	}

	void checksetDisplay() {
		setTitle("탈퇴 확인");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);		
		//setSize(300, 100);
		pack();
		jbno.addActionListener(this);
		jbyes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbno) {
			new DeleteWD(z);
			setVisible(false);

		}else if(e.getSource() == jbyes) {	//확인버튼 누를때
			
			File folder = new File("member"+File.separator+this.z);	// 경로 객체화
			DeleteWD dl = new DeleteWD(z);
			new LoginWD();
			dl.setVisible(false);
			setVisible(false);
			try {
				while(folder.exists()) {		//지정해둔 경로에 폴더가 있으면
					File [] files = folder.listFiles();	// 폴더를 읽어서 파일즈 배열에 담아두고
					// 폴더안에 파일이 있으면 삭제가 안되서 파일부터 지우고 폴더를 삭제해야됨
					for(int i = 0; i < files.length; i++) {
						files[i].delete();				// 파일즈배열을 반복문으로 묶어 파일 사이즈만큼 삭제
					}
					if (files.length == 0 && folder.isDirectory()) {  // 파일즈배열의 크기가 0이고 폴더가 있다면
						folder.delete();								// 폴더 삭제
						JOptionPane.showMessageDialog(null, "탈퇴하셨습니다");
					}
				}	

			}catch (Exception o) {
				System.out.println(o + " 삭제 실패");
			}
		}
	}
}