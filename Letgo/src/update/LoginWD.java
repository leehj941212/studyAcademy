package update;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginWD extends JFrame{
	JLabel label1,label2,label3,label4;
	JTextField text1,text2;
	JButton jb1, jb2, jb3;

	LoginWD(){
	
		setFName();
		setFText();
		setFDisplay();
	}
	
	void setFName() {
		label1=new JLabel("�α����ϼ���.");
		label2=new JLabel("���̵� �Է�");
		label3=new JLabel("��й�ȣ �Է�");
		label4=new JLabel("");

		text1=new JTextField(20);
		text2=new JTextField(5);

		jb1=new JButton("�α���");
		jb2=new JButton("ȸ������");
		jb3=new JButton("���̵� �� ��й�ȣ ã��");
	}

	void setFText() {
		// ��
//		JPanel jp = new JPanel(new GridLayout(1,1,10,10)); // ��, ��, �翷 ����, ���Ʒ� ����
//		jp.add(label1);		
//		jp.setBorder(new TitledBorder("")); // �� ĭ�� �ĭ���� �����ִ� Ŭ����?

		// ��
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10)); // ��, ��, �翷 ����, ���Ʒ� ����
		jp2.add(label4);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(jb2);
	//	jp.setBorder(new TitledBorder(""));

		// �߾�
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10)); // ��, ��, �翷 ����, ���Ʒ� ����
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(text2);
		jp3.add(jb1);
	//	jp.setBorder(new TitledBorder(""));

		// ��
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10)); // ��, ��, �翷 ����, ���Ʒ� ����
		jp4.add(jb3);
	//	jp.setBorder(new TitledBorder(""));

		// ����
	//	add(jp,BorderLayout.NORTH);
		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);
		
	}

	void setFDisplay() {

		setTitle("login"); // �����ڿ��� super("login")�ϸ� �Ȱ��� ��.

		setVisible(true);  // ȭ�� ����ϴ� �ڵ�!!!
		setSize(600, 400); // (width, heigth) ũŰ, �ʺ� �־��ָ� ��!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
	}
	public static void main(String[]args) {
		new LoginWD();


	}

}
