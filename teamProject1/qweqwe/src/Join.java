//package Team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;

public class Join extends JFrame implements ActionListener , KeyListener{
	JLabel ln = new JLabel("ȸ������");
	JLabel lid = new JLabel("ID");
	JLabel lpw = new JLabel("p.w");
	JLabel lpww = new JLabel("p.w Ȯ��");
	JLabel lname = new JLabel("�̸�");
	JLabel lnick = new JLabel("�г���");
	JLabel ph = new JLabel("��ȭ��ȣ");
	JLabel em = new JLabel("E-mail");
	JLabel bir = new JLabel("�������");
	JLabel gen = new JLabel("����");
	JLabel ph1 = new JLabel("��");
	JLabel ph2 = new JLabel("��");
	JLabel em1 = new JLabel("@");
	JLabel br = new JLabel("��");
	JLabel br1 = new JLabel("��");
	JLabel pwa = new JLabel("4~12�ڸ����� �Է����ּ���");
	JLabel pwa2 = new JLabel("");
	JLabel pid = new JLabel("id���Է��ϼ���");
	JLabel pname = new JLabel("�̸��� �Է��ϼ���");
	JLabel pnick = new JLabel("�г����� �Է��ϼ���");




	JTextField idd = new JTextField();
	JTextField iname = new JTextField();
	JTextField inick = new JTextField();
	JTextField iph = new JTextField();
	JTextField iph2 = new JTextField();
	JTextField iem = new JTextField();
	JTextField ibir = new JTextField();
	JTextField ibir2 = new JTextField();
	JPasswordField pw = new JPasswordField();
	JPasswordField pw1= new JPasswordField();
	JButton jid = new JButton("�ߺ�Ȯ��");
	JButton ok = new JButton("����");
	JButton cc = new JButton("���");


	String[] phone = {"010" , "011" , "016" , "017" ,"018" ,"019"};
	String[] em2 = {"naver.com " , "hanmail.net" , "nate.com" ,"gmail.com"};	
	String[] month = {"1��", "2��", "3��", "4��", "5��","6��", "7��", "8��","9��","10��","11��","12��"};
	String[] gen1 = {"��" , "��" , "���þ���"};

	JComboBox<String> phCombo= new JComboBox(phone);
	JComboBox<String> emCombo= new JComboBox(em2);
	JComboBox<String> mtCombo= new JComboBox(month);
	JComboBox<String> genCombo= new JComboBox(gen1);

	Color c = new Color(255,255,204); //���
	Color c1 = new Color(255,255,255); //��

	String id = idd.getText();
	String folderpath = "UserData\\"+"id";

	File f = new File(folderpath);
	boolean z = false;
	//    JoinDTO Jdto = new JoinDTO();

	public Join() {
		setLayout(null);
		add(ln);
		add(bir);
		add(cc);
		add(em);
		add(em1);
		add(gen);
		add(idd);
		add(iname);
		add(inick);
		add(iph);
		add(iph2);
		add(iem);
		add(ibir);
		add(ibir2);
		add(jid);
		add(lid);
		add(lname);
		add(lnick);
		add(lpw);
		add(lpww);
		add(ok);
		add(ph);
		add(ph1);
		add(ph2);
		add(pw);
		add(pw1);
		add(br);
		add(br1);
		add(jid);
		add(ok);
		add(cc);
		add(pwa);
		add(pwa2);
		add(pid);
		add(pname);
		add(pnick);

		jid.setBackground(c1);
		ok.setBackground(c1);
		cc.setBackground(c1);
		getContentPane().setBackground(c);
		ln.setBounds(160 , 0 , 100 , 100);
		lid.setBounds(20 , 50 , 100 , 100);
		pid.setBounds(100, 110, 200, 20);
		idd.setBounds(100, 90, 100, 20);
		jid.setBounds(220, 90, 100, 20);
		lpw.setBounds(20 , 120 , 100 ,100);
		pw.setBounds(100, 160, 100, 20);
		lpww.setBounds(20 , 190 , 100 , 100);
		pw1.setBounds(100,230,100,20);
		pwa.setBounds(100, 250 , 200, 20);
		pwa2.setBounds(100 ,180 , 200 , 20);
		lname.setBounds(20 , 260 , 100 , 100);
		iname.setBounds(100, 300 , 100, 20);
		pname.setBounds(100, 320, 200, 20);
		lnick.setBounds(20 , 330 , 100 , 100);
		inick.setBounds(100,370,100,20);
		pnick.setBounds(100, 390, 200, 20);
		ph.setBounds(20 , 400 , 100 , 100);
		add(phCombo);
		phCombo.setBounds(100, 440, 50, 20);
		ph1.setBounds(160,440,20, 20);
		iph.setBounds(180, 440, 60, 20);
		ph2.setBounds(250, 440,20,20);;
		iph2.setBounds(270, 440, 60, 20);
		em.setBounds(20 , 470 , 100 , 100);
		add(emCombo);
		iem.setBounds(100, 510, 50, 20);
		em1.setBounds(155, 510,20, 20);
		emCombo.setBounds(172, 510,120, 20);
		bir.setBounds(20 , 540 , 100 , 100);
		ibir.setBounds(100, 580, 60, 20);
		br.setBounds(170, 580, 20, 20);
		mtCombo.setBounds(190, 580, 60, 20);
		add(mtCombo);
		br1.setBounds(320, 580, 20, 20);
		ibir2.setBounds(260, 580, 50, 20);
		gen.setBounds(20 , 610 , 100 , 100);
		add(genCombo);
		genCombo.setBounds(100, 650, 50, 20);

		ok.setBounds(180, 700, 80, 50);
		cc.setBounds(280, 700, 80, 50);


		setVisible(true); //�������°� ����
		setSize(400, 800); //������� ���� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jid.addActionListener(this);
		ok.addActionListener(this);
		cc.addActionListener(this);
		pw.addKeyListener(this);
		pw1.addKeyListener(this);
		iph.addKeyListener(this);
		iph2.addKeyListener(this);
		ibir.addKeyListener(this);
		ibir2.addKeyListener(this);
		idd.addKeyListener(this);
		iname.addKeyListener(this);
		inick.addKeyListener(this);

	}



	@Override
	public void keyPressed(KeyEvent e) {

	}


	@Override
	public void keyReleased(KeyEvent e) {
		if (idd.getText().length() <= 0) {
			pid.setText("id�� �Է��ϼ���.");
		}else {
			pid.setText("");
		}
		if (iname.getText().equals("")) {
			pname.setText("������ �Է��ϼ���.");
		}else {
			pname.setText("");
		}
		if (inick.getText().equals("")) {
			pnick.setText("�г����� �Է��ϼ���.");
		}else {
			pnick.setText("");
		}

		if (String.valueOf(pw.getPassword()).equals(String.valueOf(pw1.getPassword()))) {
			pwa.setText("��й�ȣ�� ��ġ�մϴ�");		
		}
		else{
			pwa.setText("��й�ȣ�� ��ġ�����ʽ��ϴ�");
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {

		if (inick.getText() == "") {
			inick.setText("�г����� �Է��ϼ���.");
		}
		if (pw.getPassword().length <= 0) {
			pwa2.setText("��й�ȣ�� �Է��ϼ���");
		}else {
			pwa2.setText("");
		}
		if (pw1.getPassword().length <= 0) {
			pwa.setText("��й�ȣ�� ���Է��ϼ���");
		}else{
			pwa.setText("");
		}
		if(iph.getText() == "") {
			iph.setText("���ڸ� �Է��ϼ���");
		}
		if(iph2.getText()== "") {
			iph2.setText("���ڸ� �Է��ϼ���");
		}
		if(iem.getText()== "") {
			iem.setText("�̸��ϰ����� �Է��ϼ���");
		}
		if(ibir.getText()== "") {
			ibir.setText("�ùٸ� �⵵�� �Է��ϼ���");
		}
		if(ibir2.getText() == "") {
			ibir.setText("�ùٸ� �ϼ��� �Է��ϼ���");
		}
		if(e.getSource() == pw) {
			if(pw.getPassword().length>=12) e.consume();
		}

		if(e.getSource() == pw1) {
			if(pw1.getPassword().length>=12) e.consume();
		}
		if (String.valueOf(pw.getPassword()).equals(String.valueOf(pw1.getPassword()))) {
			pwa.setText("��й�ȣ�� ��ġ�մϴ�");		
		}
		else{
			pwa.setText("��й�ȣ�� ��ġ�����ʽ��ϴ�");
		}
		if(e.getSource() == iph) {
			if(iph.getText().length()==4) e.consume();
		}
		if(e.getSource() == iph2) {
			if(iph2.getText().length()>=4) e.consume();
		}
		if(e.getSource() == ibir) {
			if(ibir.getText().length()>=4) e.consume();
		}
		if(e.getSource() == ibir2) {
			if(ibir2.getText().length()>=2) e.consume();
		}


	}



	@Override
	public void actionPerformed(ActionEvent e) {
		f = new File("UserData/"+ this.idd.getText());

		FileOutputStream tx = null;
		if (e.getSource() == jid) {
			if(f.exists()) {
				JOptionPane.showMessageDialog(null, "���̵� �ߺ��Դϴ�");
				z= false;
			}else {
				JOptionPane.showMessageDialog(null, "���̵� ��밡���մϴ�.");
				idd.setEditable(false);
				jid.setEnabled(false);

				z = true;
			}
		}
		if(e.getSource() == ok) {
			boolean x = false;
			String y = "";
			if (idd.getText().equals("")) {
				x = true;
				y = "id�� �Էµ��� �ʾҽ��ϴ�";
			}
			if( iname.getText().equals("")) {
				x = true;
				y = "�̸��� �Էµ��� �ʾҽ��ϴ�";
			}
			if(inick.getText().equals("")) {
				x = true;
				y = "�г����� �Էµ��� �ʾҽ��ϴ�";
			}
			try {
				Integer.parseInt(iph.getText());
			}catch (Exception e1) {
				x = true;
				y = "��ȭ��ȣ �ι�°ĭ�� ���ڸ��Է��ּ���.";
			}
			try {
				Integer.parseInt(iph2.getText());
			}catch (Exception e1) {
				x = true;
				y = "��ȭ��ȣ ����°ĭ�� ���ڸ��Է��ּ���.";
			}
			try {
				Integer.parseInt(ibir.getText());
			}catch (Exception e1) {
				x = true;
				y = "�⵵�� ���ڸ��Է��ּ���.";
			}
			try {
				Integer.parseInt(ibir2.getText());
			}catch (Exception e1) {
				x = true;
				y = "��¥�� ���ڸ��Է��ּ���.";
			}
			if(iph.getText().equals("")) {
				x = true;
				y = "�ڵ�����ȣ�� �Էµ��� �ʾҽ��ϴ�";
			}
			if(iph.getText().length() <4) {
				x = true;
				y = "�ڵ��� �߰��ڸ� 4�ڸ����� �Է����ּ���.";
			}

			if(iph2.getText().equals("")) {
				x = true;
				y = "�ڵ�����ȣ�� �Էµ��� �ʾҽ��ϴ�";
			}
			if(iph2.getText().length() <4) {
				x = true;
				y = "�ڵ��� ���ڸ� 4�ڸ����� �Է����ּ���.";
			}
			if(iem.getText().equals("")) {
				x = true;
				y = "�̸����� �Էµ��� �ʾҽ��ϴ�";
			}
			if(ibir.getText().equals("")) {
				x = true;
				y = "������ �Էµ��� �ʾҽ��ϴ�";
			}
			if(ibir2.getText().equals("")) {
				x = true;
				y = "������ �Էµ��� �ʾҽ��ϴ�";
			}
			if(String.valueOf(pw.getPassword()).equals("")) {
				x = true;
				y = "�н����尡 �Էµ��� �ʾҽ��ϴ�";
			}
			if(String.valueOf(pw1.getPassword()).equals("")) {
				x = true;
				y = "�н����尡 �Էµ��� �ʾҽ��ϴ�";
			}
			if(!String.valueOf(pw.getPassword()).equals(String.valueOf(pw1.getPassword()))) {
				x = true;
				y = "�н����尡 ��ġ�����ʽ��ϴ�";
			}
			if(pw.getPassword().length<4) {
				x = true;
				y = "��й�ȣ�� 4�ڸ��� �̻� �Է����ּ���";
			}
			if(ibir.getText().length() <4) {
				x = true;
				y = "�⵵ 4�ڸ����� �Է����ּ���.";
			}



			switch (mtCombo.getSelectedIndex()+1) {
			case 1 : case  3 : case 5 : case 7 : case 8 : case 10 : case 12 :
				try {
					if (Integer.parseInt(ibir2.getText()) > 31) {
						y = "31�ϱ��� �Է����ּ���.";
						x = true;
					}				
				} catch (Exception e2) {
					y = "��Ȯ�� �ϼ��� �Է����ּ���.";
					x = true;
				}

				break;
			case 2 : 
				try {
					if (Integer.parseInt(ibir2.getText()) > 29) {
						y = "29�� ���� �Է����ּ���.";
						x = true;
					}				
				} catch (Exception e2) {
					y = "��Ȯ�� �ϼ��� �Է����ּ���.";
					x = true;
				}

				break;
			default:
				try {
					if (Integer.parseInt(ibir2.getText()) > 30) {
						y = "30�ϱ��� �Է����ּ���.";
						x = true;
					}				
				} catch (Exception e2) {
					y = "��Ȯ�� �ϼ��� �Է����ּ���.";
					x = true;
				}

				break;
			}
			if (!z) {
				y += "���̵� �ߺ�üũ�� �������ּ���.\n";			
			}
			if (!z || x) {
				JOptionPane.showMessageDialog(null, y);
				return;			
			}
			if (!f.exists()) {
				try {
					f.mkdir();
					try {

						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\pw.txt");
						String pwpw = String.valueOf(pw.getPassword());
						byte iidd [] = pwpw.getBytes();
						tx.write(iidd);
						
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\name.txt");
						iidd =iname.getText().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\nick.txt");
						iidd =inick.getText().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\pnum.txt");
						iidd = phCombo.getSelectedItem().toString().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\pnum2.txt");
						iidd = iph.getText().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\pnum3.txt");
						iidd = iph2.getText().getBytes();
						tx.write(iidd);

						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\mail.txt");
						iidd = iem.getText().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\mail1.txt");
						iidd = emCombo.getSelectedItem().toString().getBytes();
						tx.write(iidd);


						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\day.txt");
						iidd = ibir.getText().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\day1.txt");
						iidd =  mtCombo.getSelectedItem().toString().getBytes();
						tx.write(iidd);
						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\day2.txt");
						iidd = ibir2.getText().getBytes();
						tx.write(iidd);

						tx = new FileOutputStream("UserData\\"+idd.getText()+"\\sung.txt");
						iidd = genCombo.getSelectedItem().toString().getBytes();
						tx.write(iidd);
						tx.close();
						JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�.");



						//�α��� Ŭ���� ȣ�� �� â ����
						new Login();
						this.dispose();

					}catch (Exception e1) {

						JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�");
					}finally {

					}
				}catch (Exception e1) {

				}

			}

		}else {

		}

		if(e.getSource() == cc) {
			new Login();
			this.dispose();
		}		
	}

}
