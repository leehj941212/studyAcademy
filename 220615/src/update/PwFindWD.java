package update;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PwFindWD extends JFrame implements ActionListener { 

	JLabel label,label1,label2,label3,label4,label5,label6,label7;
	JTextField text1,text2;
	JButton jb1, jb2, jb3;

	
	
	
	PwFindWD(){
		super("PW_Find");

		setSName();
		setSText();
		setSDisplay();
		
	}

	void setSName() {
		label=new JLabel(""); // ����


		label1=new JLabel("��й�ȣ ã��");
		label2=new JLabel("���� : ");
		label3=new JLabel("�� :");
		label4=new JLabel("PW : ");
		label5=new JLabel("��й�ȣ ��� ����");
		label6=new JLabel("�̸� : ");
		label7=new JLabel("���� ���� 1ȣ��~!?!?");
		
		text1=new JTextField(10);
		text2=new JTextField(5);


		jb1=new JButton("��� �� �α���ȭ��");
		jb2=new JButton("Ȯ��");


	}

	void setSText(){

		JPanel jp = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp2.add(label);
		jp2.add(label6);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(label4);
		

		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(label7);
		jp3.add(text2);
		jp3.add(label5);
		
		
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp4.add(jb2);
		jp4.add(jb1);

		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);
		
		
		
		
	}

	void setSDisplay() {

		setVisible(true);  // ȭ�� ����ϴ� �ڵ�!!!
		setSize(325, 300); // (width, heigth) ũŰ, �ʺ� �־��ָ� ��!
		setDefaultCloseOperation(EXIT_ON_CLOSE); // â�ݱ�
		setLocationRelativeTo(null); // â ����� ����ִ� ��
	//	pack(); // â�� �ִ� ũ�⸦ �Ȱ��� �����.

		jb1.addActionListener(this);
		jb2.addActionListener(this);
	//	jb3.addActionListener(this);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1)
		{   new LoginWD();
		setVisible(false);
		}else if (e.getSource()==jb2)
		{  
			
			
			File dir = new File("member");		// ����
			File [] filenames = dir.listFiles();
			
			for(int i=0; i<filenames.length;i++) {
				String namePath = "member/"+filenames[i].getName()+"/name.txt"; // �̸��� ���� ��� 
				String answerPath = "member/"+filenames[i].getName()+"/questions.txt";  // �亯�� �ؽ�Ʈ ���
				String pwPath = "member/"+filenames[i].getName()+"/password.txt";  // �� �ؽ�Ʈ ���
			
				
				FileInputStream f = null; // ������ǲ������ ����
				FileInputStream d = null; 
				FileInputStream w = null; 

				File na=new File(namePath);
				File t=new File(answerPath);

				File pw=new File(pwPath);

				if(na.exists()) {
//			
			try {  // f : �̸�, d: ��, w : id���
				f=new FileInputStream(na);
				d=new FileInputStream(t);
				w=new FileInputStream(pw);
				byte [] b = new byte [ f.available()]; // �迭 �� ��ŭ�� ���� available
				byte [] c = new byte [ d.available()];
				byte [] o = new byte [ w.available()];
				System.out.print(new String(c));
				
				while(f.read(b)!=-1) { // ���� ���ٴ� ��. ���������� ���ƶ�� ��.
				}
				while(d.read(c)!=-1) {
				}
				while(w.read(o)!=-1) {

				}
				
				//if(new String(b).equals(String.valueOf(jpf1.getPassword()))) { 
				
				if(new String(b).equals(String.valueOf(text1.getText())) && new String(c).equals(text2.getText()) ) {  // equals�� String���� ������.
					
					// ��й�ȣ ���� �� Ȯ��
					FileInputStream f2 = new FileInputStream(pw);
					label5.setText(new String(o));
					
					
				}else if ( String.valueOf(text2.getText()).equals("") || text2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "���� �Է��ؾ� �ǿ�...!!");
					break;
				}else {
					JOptionPane.showMessageDialog(null, "�� ������.... �����...");
					break;
				}
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}catch(Exception z) {
				System.out.println(z); // try�� catch�� ��Ʈ ( else )
			}
			}
			}		
		}else if  (e.getSource()==jb3)
		{   new LoginWD();
		setVisible(false);
		}
	}



}
