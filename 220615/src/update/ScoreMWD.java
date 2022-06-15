package update;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreMWD extends JFrame implements ActionListener{

	JFrame frame = new JFrame ();

	JLabel id, idBlank,Java, Web, Jsp, alram1, alram2, alram3, alram4;
	JTextField javaJumsu, WebJumsu, JspJumsu;
	JButton save, exit, reset, average; 





	JPanel panel1, panel2, panel3 ; 

	JFrame messageFrame = new JFrame();
	JButton message;

	SourceDTO sourceDTO = new SourceDTO();
	String z;

	public ScoreMWD(String x) {
		this.z=x;

		id = new JLabel("���̵�");
		Java = new JLabel("Java ���� ����");
		Web = new JLabel("Web ���� ����");
		Jsp = new JLabel("Jsp ���� ����");

		alram1 = new JLabel("* ������ �Է����ּ��� * ");
		alram2 = new JLabel("���� �ܿ��� ���� �Ұ��մϴ�"); 
		alram3 = new JLabel(""); 
		alram4 = new JLabel(""); 

		idBlank = new JLabel("");
		javaJumsu = new JTextField("");
		WebJumsu = new JTextField("");
		JspJumsu = new JTextField("");

		save= new JButton("����");
		average= new JButton("��� ����");
		reset= new JButton("�Է°� �ʱ�ȭ");
		exit= new JButton("���");

		message= new JButton("Ȯ��");

		Font letter = new Font("���� ���",Font.BOLD, 14); 
		Font letter2 = new Font("���� ���",Font.BOLD, 12); 

		id.setFont(letter);
		Java.setFont(letter);
		Web.setFont(letter);
		Jsp.setFont(letter);
		alram1.setFont(letter);
		alram2.setFont(letter2);
		alram3.setFont(letter2);
		alram4.setFont(letter2);
		idBlank.setFont(letter);
		javaJumsu.setFont(letter);
		WebJumsu.setFont(letter);
		JspJumsu.setFont(letter);
		save.setFont(letter);
		exit.setFont(letter);
		message.setFont(letter);
		reset.setFont(letter);
		average.setFont(letter);

		alram3.setForeground(Color.BLUE);
		alram4.setForeground(Color.BLUE);

		setTitle("My ���� ����");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setSize(450,300);

		JPanel left = new JPanel (); 
		left.setLayout(new GridLayout(6,1));

		left.add(alram1);
		left.add(id);
		left.add(Java);
		left.add(Web);
		left.add(Jsp);
		left.add(alram3);

		alram1.setHorizontalAlignment(JLabel.CENTER);
		id.setHorizontalAlignment(JLabel.CENTER);
		Java.setHorizontalAlignment(JLabel.CENTER);
		Web.setHorizontalAlignment(JLabel.CENTER);
		Jsp.setHorizontalAlignment(JLabel.CENTER);
		alram3.setHorizontalAlignment(JLabel.CENTER);

		JPanel right = new JPanel (); 
		right.setLayout(new GridLayout(6,1));

		right.add(alram2);
		right.add(idBlank);
		right.add(javaJumsu);
		right.add(WebJumsu);
		right.add(JspJumsu);
		right.add(alram4);

		JPanel layout = new JPanel ();
		layout.setLayout(new GridLayout(1,2));

		layout.add(left);
		layout.add(right);

		JPanel bottons = new JPanel ();
		bottons.setLayout(new FlowLayout());

		bottons.add(save);
		//	bottons.add(average);
		bottons.add(reset);
		bottons.add(exit);

		add(layout,"Center");
		add(bottons,"South");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		save.addActionListener(this);
		exit.addActionListener(this);
		reset.addActionListener(this);
		average.addActionListener(this);

		idBlank.setText(this.z);

		try {
			FileInputStream fi = new FileInputStream("."+File.separator+ "member"+File.separator+this.z+File.separator + "id.txt");
			byte i[] = new byte [fi.available()];

			while(fi.read(i) != -1 ){
				String data4 = new String(i);
				idBlank.setText(data4);
			}	
			alram4.setText("");
		} catch(Exception e){  
			System.out.println(e+"id �� �ҷ����� ����");
		}

		try {
			FileInputStream fa =  new FileInputStream("."+File.separator+ "member"+File.separator+this.z+File.separator + "java.txt");
			byte c[] = new byte [fa.available()];

			while(fa.read(c) != -1 ){
				String data1 = new String(c);
				javaJumsu.setText(data1);	
			}
		} catch(Exception e){
			System.out.println(e+"java �� �ҷ����� ����");

		}

		try {
			FileInputStream fb =  new FileInputStream("."+File.separator+ "member"+File.separator+this.z+File.separator + "web.txt");
			byte d[] = new byte [fb.available()];

			while(fb.read(d) != -1 ){
				String data2 = new String(d);
				WebJumsu.setText(data2);	
			}
		} catch(Exception e){
			System.out.println(e+"web �� �ҷ����� ����");
		}

		try {
			FileInputStream fc =  new FileInputStream("."+File.separator+ "member"+File.separator+this.z+File.separator + "jsp.txt");
			byte g[] = new byte [fc.available()];

			while(fc.read(g) != -1 ){
				String data3 = new String(g);
				JspJumsu.setText(data3);	
			}
		} catch(Exception e){
			System.out.println(e+"jsp �� �ҷ����� ����");

		}	


	}

	void addOutput(){

		sourceDTO.setId(idBlank.getText());

		String folderPath = "."+File.separator+ "member"+File.separator+this.z;
		String idPath = folderPath + File.separator + "id.txt";
		String javaPath = folderPath + File.separator + "java.txt";
		String WebPath = folderPath + File.separator + "web.txt";
		String JspPath = folderPath + File.separator + "jsp.txt";

		try  {
			sourceDTO.setJava(Integer.parseInt(javaJumsu.getText()));

			FileOutputStream javaOutput = null ; 

			javaOutput = new FileOutputStream(javaPath);
			byte b[] = Integer.toString(sourceDTO.getJava()).getBytes();

			javaOutput.write(b); //������ �����+ n.write �� try�� �ɾ���

		}
		catch(Exception e) {
			System.out.println("java ���� ���� ����");
			alram3.setText("���� ��� ����");


		} 
		try  {

			sourceDTO.setWeb(Integer.parseInt(WebJumsu.getText()));

			FileOutputStream webOutput = null ; 

			webOutput = new FileOutputStream(WebPath);
			byte b[] = Integer.toString(sourceDTO.getWeb()).getBytes();

			webOutput.write(b);
		}catch(Exception e) {
			System.out.println("web ���� ���� ����");
			alram3.setText("�����ϴ� ������ �ƴմϴ�.");
		}
		try  {

			sourceDTO.setJsp(Integer.parseInt(JspJumsu.getText()));

			FileOutputStream jspOutput = null ; 

			jspOutput = new FileOutputStream(JspPath);
			byte b[] = Integer.toString(sourceDTO.getJsp()).getBytes();

			jspOutput.write(b);
		}catch(Exception e) {
			System.out.println("jsp ���� ���� ����");
			alram3.setText("�����ϴ� ������ �ƴմϴ�.");

		}

	}

	void savePopup1(){


		JLabel pm_item1 = new JLabel("���� �Ǿ����ϴ�");

		messageFrame.setLayout(null);
		pm_item1.setBounds(100,30,150,30);
		message.setBounds(40,80,200,50);

		messageFrame.setTitle("�ȳ��޼���");
		messageFrame.add(pm_item1);
		messageFrame.add(message);
		messageFrame.setSize(300,200);
		messageFrame.setVisible(true);

		messageFrame.setDefaultCloseOperation(messageFrame.EXIT_ON_CLOSE);
		messageFrame.setLocationRelativeTo(null);
		message.addActionListener(this);

	}

	void rankingMeod(){

		try {

			int [] subject = new int [3];

			subject[0] = Integer.parseInt(WebJumsu.getText());
			subject[1] = Integer.parseInt(JspJumsu.getText());
			subject[2] = Integer.parseInt(javaJumsu.getText());

			int sum = 0; 

			for (int n= 0; n<subject.length ; n++) { 
				sum = sum + subject[n];
			}
			int sumit = sum/ subject.length ;

			alram3.setText("��� ������ "+sumit+"�� �Դϴ�.");
		}

		catch (Exception e) { 
			System.out.println(e);
		}
	}


	public void actionPerformed(ActionEvent e) {

		byte [] javacheck = javaJumsu.getText().getBytes();
		byte [] webcheck = WebJumsu.getText().getBytes();
		byte [] jspcheck = JspJumsu.getText().getBytes();


		if(e.getSource()==save){

			if(javaJumsu.getText().equals("")||WebJumsu.getText().equals("")||JspJumsu.getText().equals("")) {
				alram3.setText("���� �Է����ּ���.");
			} else {
				int a = 0;
				for(int i = 0; i < javacheck.length; i++) {
					if(!Character.isDigit(javacheck[i])) {
						alram3.setText("���ڸ� �Է� �����մϴ�.");
						a = 1;
						break;
					} else {
						alram3.setText("");
					}
				}

				for(int i = 0; i < webcheck.length; i++) {
					if(!Character.isDigit(webcheck[i])) {
						alram3.setText("���ڸ� �Է� �����մϴ�.");
						a = 1;
						break;
					} else {
						alram3.setText("");
					}
				}

				for(int i = 0; i < jspcheck.length; i++) {
					if(!Character.isDigit(jspcheck[i])) {
						alram3.setText("���ڸ� �Է� �����մϴ�.");
						a = 1;
						break;
					} else {
						alram3.setText("");
					}
				}

				if (a==1) {
					alram3.setText("������ Ȯ���ϼ���");
				} else {
					addOutput();
					savePopup1();

					alram3.setText("");
					alram4.setText("");
				}

			}

		}else if(e.getSource()==message){
			messageFrame.setVisible(false);
		}else if(e.getSource()==exit) {
			new MenuWD(z);
			setVisible(false);
		}else if(e.getSource()==reset) {
			javaJumsu.setText("");
			WebJumsu.setText("");
			JspJumsu.setText("");
		}else if(e.getSource()==average) {

			if(javaJumsu.getText().equals("")||WebJumsu.getText().equals("")||JspJumsu.getText().equals("")) {
				alram3.setText("������ �ٽ� �Է����ּ���");
			}
			else {
				rankingMeod();
			}

		}

	}

}