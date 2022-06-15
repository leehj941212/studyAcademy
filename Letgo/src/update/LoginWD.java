package update;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class LoginWD extends JFrame implements ActionListener{
	private static final boolean FileNotFoundException = false;
	JLabel label1,label2,label3,label4;
	JTextField text1;
	JButton jb1, jb2, jb3,jb4;
	JPasswordField jpf1;
	//	SourceDTO sDTO;
	InputStream id;

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

		jpf1=new JPasswordField();

		jb1=new JButton("�α���");
		jb2=new JButton("ȸ������");
		jb3=new JButton("���̵� ã��");
		jb4=new JButton("��й�ȣ ã��");

	}

	void setFText() {
		// ����
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

		jp3.add(jpf1);
		jp3.add(jb1);

		//	jp.setBorder(new TitledBorder(""));

		// ����
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10)); // ��, ��, �翷 ����, ���Ʒ� ����
		jp4.add(jb3);
		jp4.add(jb4);
		//	jp.setBorder(new TitledBorder(""));

		// ����
		//	add(jp,BorderLayout.NORTH);
		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);



		/*	try {

			f = new FileInputStream("asd");
			System.out.println("availabe = "+f.available()); // ���� �� �ִ� byte�� ��(�ѱ��� 2���� �����1)
			byte b[] = new byte [ f.available()]; // ���� java�� 4���ڴϱ� 4���� ������ ����ٴ� ��.

			while(f.read(b)!=-1) {
			}
			String data = new String(b);
			System.out.println(b);
			System.out.println(data);

		}catch(FileNotFoundException e) {  // ���� �Ʒ��� catch�� �Ƚᵵ ����.��ȣ�ȿ� �� ����� Exception e���ᵵ ��.
			System.out.println(e+" => ���ϻ��� ����");
		}catch(IOException e) {
			System.out.println(e+" =>���� �б� ����");
		}finally {
			try {
			f.close();
		}catch(Exception e) {
			System.out.println(e+" => �ݱ� ����");
			}

		}
		 */	
	}

	void Process() {




	}

	void setFDisplay() {

		setTitle("login"); // �����ڿ��� super("login")�ϸ� �Ȱ��� ��.

		setVisible(true);  // ȭ�� ����ϴ� �ڵ�!!!
		setSize(600, 400); // (width, heigth) ũŰ, �ʺ� �־��ָ� ��!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();

	}

	void addres() {

	}

	public void actionPerformed(ActionEvent e) {
		String idPath = "member/"+text1.getText();
		String pwPath = "member/"+text1.getText()+"/password.txt";
		File id=new File(idPath);

		FileInputStream f = null; // ������ǲ������ ����

		/*
		 try {
			FileInputStream fis = new  FileInputStream(idPath);
			System.out.println(fis.available());
		} catch (java.io.FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 */
		if(e.getSource()==jb1) {
			if(false==id.exists()) {
				JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.");
			}else {
				try {
					f=new FileInputStream(pwPath);

					byte [] b = new byte [ f.available()]; // �迭 �� ��ŭ�� ���� available
					// System.out.print(new String(c));
					while(f.read(b)!=-1) { // ���� ���ٴ� ��. ���������� ���ƶ�� ��.
					}

					if(new String(b).equals(String.valueOf(jpf1.getPassword()))) {  // equals�� String���� ������.
						String asd = text1.getText();
						new MenuWD(asd);							// ��й�ȣ ���� �� Ȯ��
						setVisible(false); 
					}
					else {
						JOptionPane.showMessageDialog(null, "���̵� �� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					}

				}catch(Exception i) {
					System.out.println(i); // try�� catch�� ��Ʈ ( else )
				}
			}
		}else if (e.getSource()==jb2)
		{   new SignUpWD();
		setVisible(false);
		}else if (e.getSource()==jb3)
		{   new IdFindWD();
		setVisible(false);
		}else if (e.getSource()==jb4)
		{   new PwFindWD();
		setVisible(false);
		}
	} 

	private void JOptionPane() {

	}

	public static void main(String[]args) {
		new LoginWD();

	}
}
