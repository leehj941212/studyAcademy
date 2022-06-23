package programSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ScreenLogIn {
	JFrame frame = new JFrame("login");
	Map<String, JPanel> panels = new Hashtable<String, JPanel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JLabel>checkLabels = new Hashtable<String,JLabel>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	Map<String,JComboBox<String>> comboBoxs = new Hashtable<String,JComboBox<String>>();
	
	
	
	
	
	
	JLabel label1,label2,label3,label4;
	JTextField idText;
	JButton jb1, jb2, jb3,jb4;
	JPasswordField passwordText;
	InputStream id;
	
	
	
	
	
	void setPanel(){		
		labels.put("로그인타이틀", new JLabel("로그인하세요"));
		labels.put("아이디입력", new JLabel("아이디 입력"));	
		labels.put("비밀번호입력", new JLabel("비밀번호 입력"));
		
		textFields.put("아이디", new JTextField(20));
		passwordFields.put("비밀번호", new JPasswordField());
		
		buttons.put("회원가입", new JButton("회원가입"));
		buttons.put("로그인", new JButton("로그인"));
		buttons.put("아이디찾기", new JButton("아이디 찾기"));
		buttons.put("비밀번호찾기", new JButton("비밀번호 찾기"));
		
		panels.put("login", new JPanel());
		for (String key : labels.keySet()) {
			panels.get("login").add(labels.get(key));
		}
		
		panels.get("login").add(textFields.get("아이디"));
		panels.get("login").add(passwordFields.get("비밀번호"));
		
		for (String key : buttons.keySet()) {
			panels.get("login").add(buttons.get(key));
		}
	}
	


	//위치 배치
	void setFText() {
		// 서
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		jp2.add(label4);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(jb2);

		// 중앙
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10));
		jp3.add(label1);
		jp3.add(idText);

		jp3.add(passwordText);
		jp3.add(jb1);


		// 남쪽
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10));
		jp4.add(jb3);
		jp4.add(jb4);

		// 방향
		frame.add(jp2,BorderLayout.WEST);
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);
	}

	//frame 설정
	void setFDisplay() {
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();

	}



}
