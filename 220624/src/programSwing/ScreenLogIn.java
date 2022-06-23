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
		labels.put("�α���Ÿ��Ʋ", new JLabel("�α����ϼ���"));
		labels.put("���̵��Է�", new JLabel("���̵� �Է�"));	
		labels.put("��й�ȣ�Է�", new JLabel("��й�ȣ �Է�"));
		
		textFields.put("���̵�", new JTextField(20));
		passwordFields.put("��й�ȣ", new JPasswordField());
		
		buttons.put("ȸ������", new JButton("ȸ������"));
		buttons.put("�α���", new JButton("�α���"));
		buttons.put("���̵�ã��", new JButton("���̵� ã��"));
		buttons.put("��й�ȣã��", new JButton("��й�ȣ ã��"));
		
		panels.put("login", new JPanel());
		for (String key : labels.keySet()) {
			panels.get("login").add(labels.get(key));
		}
		
		panels.get("login").add(textFields.get("���̵�"));
		panels.get("login").add(passwordFields.get("��й�ȣ"));
		
		for (String key : buttons.keySet()) {
			panels.get("login").add(buttons.get(key));
		}
	}
	


	//��ġ ��ġ
	void setFText() {
		// ��
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		jp2.add(label4);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(jb2);

		// �߾�
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10));
		jp3.add(label1);
		jp3.add(idText);

		jp3.add(passwordText);
		jp3.add(jb1);


		// ����
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10));
		jp4.add(jb3);
		jp4.add(jb4);

		// ����
		frame.add(jp2,BorderLayout.WEST);
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);
	}

	//frame ����
	void setFDisplay() {
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();

	}



}
