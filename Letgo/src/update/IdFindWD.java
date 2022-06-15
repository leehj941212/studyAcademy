package update;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class IdFindWD extends JFrame  implements ActionListener { 
	
	JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
	JTextField text1,text2;
	JButton jb1, jb2, jb3, jb4;
	

	
	IdFindWD(){
		super("ID_Find");
		
		setSName();
		setSText();
		setSDisplay();
		
	}
	
	void setSName() {
		label=new JLabel("");
		label1=new JLabel("���̵� ã��");
		label2=new JLabel("���� ");
		label3=new JLabel("�� : ");
		label4=new JLabel("ID : ");
		label5=new JLabel("���̵� ��� ����");	
		
		label6=new JLabel("");	// ���� ����
		
		
		label7=new JLabel("�̸�"); 
		label8=new JLabel("�̸� �Է�");
		label9=new JLabel("���� ���� 1ȣ��~!?!?");
		
		text1=new JTextField(10);
		text2=new JTextField(5);
				
		
		jb1=new JButton("��� �� �α���ȭ��");
		jb2=new JButton("Ȯ��");
		
		
	}
	
	void setSText() {
		JPanel jp = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp2.add(label);
		jp2.add(label8);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(label4);
		
		
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(label9);
		jp3.add(text2);
		jp3.add(label5);
		
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp4.add(jb2);
		jp4.add(jb1);
		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
//		jb3.addActionListener(this);
		
	}
	
	void setSDisplay() {
		
		setVisible(true);  // ȭ�� ����ϴ� �ڵ�!!!
		setSize(325, 300); // (width, heigth) ũŰ, �ʺ� �־��ָ� ��!
		setDefaultCloseOperation(EXIT_ON_CLOSE); // â�ݱ�
		setLocationRelativeTo(null); // â ����� ����ִ� ��
	//	pack(); // â�� �ִ� ũ�⸦ �Ȱ��� �����.
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			new LoginWD();
		setVisible(false);
		} else if (e.getSource()==jb2){
		
			
//			String path = "C:/Users/Administrator/eclipse-workspace/Letgo/member"; // ��������� �ּ� �������� /�� �ٲ���.
//			File dir = new File(path);		// ����
//			String[] filenames = dir.list();	// id
//			
//			ArrayList<String> namePaths = new ArrayList<String>();	// ��� id�� name.txt������ ���
//			ArrayList<String> answerPaths = new ArrayList<String>();	// ��� id�� name.txt������ ���
//			ArrayList<String> idPaths = new ArrayList<String>();
//			
//			for(int i=0; i<filenames.length; i++)   // id��
//			{
//				String namePath = "member/"+filenames[i]+"/name.txt"; // �̸��� ���� ��� 
//				String answerPath = "member/"+filenames[i]+"/t.txt";  // �亯�� �ؽ�Ʈ ���
//				String idPath = "member/"+filenames[i]+"/id.txt";  // id�� �ؽ�Ʈ ���
//				namePaths.add(namePath);		// namePaths�ȿ� namePath�� �־��ָ鼭 ��� �̸����� �Ѿ
//				answerPaths.add(answerPath);	// answerPaths �ȿ� answerPath�� �־��ָ鼭 ��� �亯���� �Ѿ.
//				idPaths.add(idPath);
//				
//				
//				
//			}
//			
//			// ���⼭���� HashMap���� Ű�� ������ ��������.
//			HashMap<String, String> answerByName = new HashMap<String, String>();
//			for(int i=0; i<filenames.length; i++) // �����ִ� filenames�� �迭�� ���� ���� ( ȸ������ �� ���� ��� ���� ������ )
//			{
//				try {
//					// �̸�
//					FileInputStream fis = new FileInputStream(namePaths.get(i)); // fis ��ü�� �����ϸ鼭 namePaths�� ���Ϲ迭�� ���ư�����.
//					byte[] b = new byte[fis.available()]; // �� fis�� byte�迭 b�� �־���.
//					while(fis.read(b) != -1) {}		// != -1�� �ϸ鼭 ����ִ� �����͵��� ������ �� �ѹ��� �а� ����.
//					String s = new String(b); // �� ���� ��� s�� �־���.
//					
//					// �亯
//					FileInputStream fis2 = new FileInputStream(answerPaths.get(i)); // ���� ������ �����ϴ�.
//					byte[] b2 = new byte[fis2.available()];
//					while(fis2.read(b2) != -1) {}
//					String s2 = new String(b2);
//					
//					FileInputStream fis3 = new FileInputStream(idPaths.get(i)); // ���� ������ �����ϴ�.
//					byte[] b3 = new byte[fis3.available()];
//					while(fis2.read(b3) != -1) {}
//					label5.setText(new String(b3));
//					
//					
//					answerByName.put(s, s2); // Ű(s)��, ����(s2)�� ������
//					
////					if() {
////						label5.setText(s3);
////					}else {
////						JOptionPane.showMessageDialog(null, "������ ��� ��ġ���� �ʽ���~!! �ٽ� ���ݼ�!!");
////					}
//					
////					if(new String(b).equals(String.valueOf(text1.getText())) && new String(b2).equals(label5.getText()) ) {  // equals�� String���� ������.
////						// ��й�ȣ ���� �� Ȯ��
////						String st =new String(s);
////						label5.setText(st);
////
////					}
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
////					JOptionPane.showMessageDialog(null, "������ ��� ��ġ���� �ʽ���~!! �ٽ� ���ݼ�!!");
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//			}
//		//	JOptionPane.showMessageDialog(null, "���̵� �� ��й�ȣ�� Ʋ�Ƚ��ϴ�."); 
//			
//			
//			System.out.println(answerByName.toString()); // �̸��̶� ���� ���� ���.
////			
////			for(String s : answerByName.keySet()) 		// Ű(�̸�),����(��)�� ���ϳ� �����
////			{
////				System.out.println(s);
////				System.out.println(answerByName.get(s));
////			}
			
			String path = "C:/Users/Administrator/eclipse-workspace/Letgo/member"; // ��������� �ּ� �������� /�� �ٲ���.
			File dir = new File(path);		// ����
			String[] filenames = dir.list();
			
			for(String filename : filenames) {
				
				String namePath = "member/"+filename+"/name.txt"; // �̸��� ���� ��� 
				String answerPath = "member/"+filename+"/questions.txt";  // �亯�� �ؽ�Ʈ ���
				String idPath = "member/"+filename+"/id.txt";  // id�� �ؽ�Ʈ ���
			
				
				FileInputStream f = null; // ������ǲ������ ����
				FileInputStream d = null; 
				FileInputStream w = null; 

				File na=new File(namePath);
				File t=new File(answerPath);

				File id=new File(idPath);

				if(na.exists()) {
//			
			try {  // f : �̸�, d: ��, w : id���
				f=new FileInputStream(na);
				d=new FileInputStream(t);
				w=new FileInputStream(id);
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
					FileInputStream f2 = new FileInputStream(id);
					label5.setText(new String(o));
					
					//JOptionPane.showMessageDialog(null, "�� ������.... �����...");
				}
	
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}catch(Exception i) {
				System.out.println(i); // try�� catch�� ��Ʈ ( else )
			}
			}
				
		}
	}

	}

	
}
