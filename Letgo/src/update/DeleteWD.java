package update;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class DeleteWD extends JFrame implements ActionListener{
	JLabel jlReal, jlBlink1, jlBlink2, jlBlink3;
	JButton yes, no;
	JPasswordField jpf;
	String z;
	DeleteWD(String x){
		this.z=x;
		set();
		setPanel();
		setDisplay();
	}
	
	void set() {
		jlReal = new JLabel("정말 탈퇴하시겠습니까?");
		yes = new JButton("예");
		no = new JButton("아니오");
		jlBlink1 = new JLabel("");
		jlBlink2 = new JLabel("");
		jlBlink3 = new JLabel("");
//		jpf = new JPasswordField();
		Font font = new Font("궁서 보통", Font.BOLD, 20); //글씨체 안바뀜.. 크기만 바뀜
		jlReal.setFont(font);
		jlReal.setForeground(Color.red); //색깔 변경 ok
		
		yes.addActionListener(this);
		no.addActionListener(this);
	}
	
	void setPanel() {
		JPanel jp1 = new JPanel();
		jp1.add(jlReal);
		
		JPanel jp2 = new JPanel(new GridLayout(1,0,10,10));
		jp2.add(yes);
		jp2.add(no);
		
		JPanel jp3 = new JPanel();
		jp3.add(jlBlink1);
		
		JPanel jp4 = new JPanel();
		jp4.add(jlBlink2);
		
		JPanel jp5 = new JPanel();
		jp5.add(jlBlink3);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		add(jp4, BorderLayout.WEST);
		add(jp5, BorderLayout.EAST);		
	}
	
	void setDisplay() {
		setTitle("회원탈퇴");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//SourceDTO sourceDTO = new SourceDTO();
		try {
		if (e.getSource()==yes) {	//예 누르면 정보 삭제
			File file = new File("."+File.separator+"member"+File.separator+this.z);
			if (file.exists()) {						// 폴더 찾기
				File[] files = file.listFiles();		// 폴더 안 파일 찾아서 리스트에 넣어놓고
				for (int i=0; i<files.length; i++) {		// 한번에 폴더를 삭제할순 없고, 폴더안에 파일부터 삭제하고 폴더 삭제해야됨
					if(files[i].exists()) {				// 파일들 삭제문
						files[i].delete();
						System.out.println(files[i].getName()+" 파일 삭제성공");
    				}else{
    					System.out.println(files[i].getName()+" 삭제실패");
    				}
				}
			}
			if (file.exists()) {				// 폴더 삭제
				file.delete();
				System.out.println(file.getName()+" 폴더 삭제성공");
			}
			new LoginWD();
			setVisible(false);
		}else if(e.getSource()==no) {
			new MenuWD(z);			//아니오 누르면 메뉴창으로
			setVisible(false);
		}
		}catch (Exception o) {
			System.out.println(o +" => 파일삭제 실패");
		}
	}

}