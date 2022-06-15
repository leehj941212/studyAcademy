package update;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemNotFoundException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.soap.Text;


public class FixWD extends JFrame implements ActionListener{			// �� ������ ����
	JLabel lbname, lbbirth, lbhakbun, lbphone, lbpw, lbpwcheck, lbalert, lbBlank1, lbBlank2;
	JTextField tfname, tfbirth, tfhakbun, tfphone;
	JPasswordField tfpw, tfpwcheck;
	JButton jbout, jbcancle, jbsave;
	String z;
	
	FixWD(String x){			// ������
		this.z=x;
		setUnit();
		setFrame();
		setDisplay();
		
	}
		
	void setUnit() {					//��, �ؽ�Ʈ�ʵ�, ��ư �ȿ� ���� �� ũ��	
		lbname = new JLabel("�̸�");
		lbbirth = new JLabel("�������");
		lbhakbun = new JLabel("�й�");
		lbphone = new JLabel("����ó");
		lbpw = new JLabel("��й�ȣ");
		lbpwcheck = new JLabel("��й�ȣ Ȯ��");
		lbalert = new JLabel("");
		lbBlank1 = new JLabel(""); 
		lbBlank2 = new JLabel(""); 
		tfname = new JTextField(15);	
		tfbirth = new JTextField(15);
		tfhakbun = new JTextField(15);
		tfphone = new JTextField(15);
		tfpw = new JPasswordField();
		tfpwcheck = new JPasswordField("");
		jbout = new JButton("�α׾ƿ�");
		jbcancle = new JButton("���");
		jbsave = new JButton("Ȯ��");
		
	}
	void setFrame() {										//�г� ���. 
		JPanel jp1 = new JPanel(new GridLayout(0,1,10,20));
		jp1.add(lbname);
		jp1.add(lbbirth);
		jp1.add(lbhakbun);
		jp1.add(lbphone);
		jp1.add(lbpw);
		jp1.add(lbpwcheck);
		jp1.add(lbBlank1);
		
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));
		jp2.add(tfname);
		jp2.add(tfbirth);
		jp2.add(tfhakbun);
		jp2.add(tfphone);
		jp2.add(tfpw);
		jp2.add(tfpwcheck);
		jp2.add(lbalert);
		FileInputStream f = null; // ������ǲ��Ʈ�� ����

		// �̸� ������� �й� ����ó �ҷ�����. �ѱ� �̸� ���� �����°�  => �̸� ����� �ϱ�� ��.
		try {
			if (new File("."+File.separator+"member/").exists()){
				String folderPath = "."+File.separator+"member"+File.separator;		
//				String abc = folderPath;											
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"name.txt"); //���
				byte b1[] = new byte [f.available()]; //b1�̶�� �迭�� �ؽ�Ʈ���� �׾Ƴ���
				while (f.read(b1) != -1) {}				// while���� �̿��� b1�� �׾Ƴ��� ������ ������� �о�Ͷ�
				String data1 = new String(b1);			// b1�� ���� ������ data1�� ����.
				tfname.setText(data1);					// �ؽ�Ʈ�ʵ忡 data1�� ������ ������ �־��.
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"birth.txt");
				byte b2[] = new byte [f.available()];
				while (f.read(b2) != -1) {}
				String data2 = new String(b2);
				tfbirth.setText(data2);
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"hakbun.txt");
				byte b3[] = new byte [f.available()];
				while (f.read(b3) != -1) {}
				String data3 = new String(b3);
				tfhakbun.setText(data3);
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"callNum.txt");
				byte b4[] = new byte [f.available()];
				while (f.read(b4) != -1) {}
				String data4 = new String(b4);
				tfphone.setText(data4);
			}
			
//			
			}catch (FileNotFoundException e) {
				System.out.println(e+ " => ���ϻ��� ����");
			}catch(IOException e) {
				System.out.println(e+ " => �����б� ����");
			}finally {
				try {
				f.close();
			}catch (Exception e) {
				System.out.println(e+ " => �ݱ� ����");
			}
		}
		JPanel jp3 = new JPanel();
		jp3.add(jbout);
		
		JPanel jp4 = new JPanel();
		jp4.add(jbsave);
		jp4.add(jbcancle);
		
		JPanel jp5 = new JPanel();
		jp5.add(lbBlank2);						//����־ ��¦ ������
		
		tfname.setEditable(false);				//���� �Ұ�
		tfbirth.setEditable(false);
		tfhakbun.setEditable(false);
		tfphone.setEditable(false);
		add(jp1, BorderLayout.WEST);			//�г� ��ġ
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.EAST);
		add(jp4, BorderLayout.SOUTH);
		add(jp5, BorderLayout.NORTH);
	}
	
	void setDisplay() {
		setTitle("ȸ������ ����");					//â�̸� 
		setVisible(true);						//�������� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);//�����ư ������ ����
		setLocationRelativeTo(null);			//â�㶧 �߾ӿ� �߱�
		setResizable(false);					//â ������ ����
		pack();									//���빰�� ���缭 â ũ�� ����
		
		jbout.addActionListener(this);			//�׼Ǹ����� �޼ҵ� ����
		jbsave.addActionListener(this);
		jbcancle.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		FileOutputStream f = null;		
		try {
		if (e.getSource() == jbout) {			//�α��� ȭ������
												//�α׾ƿ� ������ ���� ���� �������°� �����ؾߵ�.
			new LoginWD();
			setVisible(false);
		}else if (e.getSource() == jbcancle){	//�޴� ȭ������
			new MenuWD(this.z);
			setVisible(false);
		}else if (e.getSource() == jbsave) {	//��й�ȣ ����. ���� �� �α���ȭ������
			if (new String(tfpw.getPassword()).equals(new String(tfpwcheck.getPassword()))) {		// ��й�ȣ, ��й�ȣ Ȯ�� ���� ������
				if(tfpwcheck.getPassword().length==0) {
					tfpw.setText("");
					tfpwcheck.setText("");
					lbalert.setText("��й�ȣ�� Ȯ�����ּ���.");
				}else if(new String(tfpw.getPassword()).equals(new String(tfpwcheck.getPassword()))) {
				f = new FileOutputStream("member"+File.separator+this.z+File.separator+"password.txt");// �����ص� ��ο� �ؽ����� ����.
				byte b[] = String.valueOf(tfpw.getPassword()).getBytes();	// b[] �迭�� dto�� �����صа� �׾Ƴ���
				f.write(b);							// �����ص� ����� ���Ͽ� b�� ����
				f.close();							// ���� �ݱ�
				new LoginWD();			
				setVisible(false);
				}
				}else {
				lbalert.setText("��й�ȣ�� Ȯ�����ּ���.");
				tfpw.setText("");
				tfpwcheck.setText("");
			} 
			}
		}catch (Exception o) {
			System.out.println(o + " => ���Ͼ��� ����");
		}
		}
	
}