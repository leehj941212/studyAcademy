import java.awt.event.*;
import java.io.*;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
public class MainBu implements ActionListener{
	String id;
	JFrame jf = new JFrame();
	JLabel jlname = new JLabel();
	JLabel jlemail = new JLabel();
	JButton jbu1=new JButton("���� �Է�"); 
	JButton jbu2=new JButton("���� Ȯ��"); 
	JButton jbu3=new JButton("");
	JButton jbu4=new JButton("��������"); 
	JButton jbu5=new JButton("�α׾ƿ�"); 
	JPanel jpinfo=new JPanel();
	JPanel jpbu=new JPanel();
	
	void callbu(String id) {
		ArrayList<String> info = new ArrayList<String>();
		this.id=id;
		try {
			File f = new File(id+".txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String str;
			while((str= br.readLine())!=null) {
				info.add(str);	
			}
			jlname.setText(info.get(1)+" ��");
			jlemail.setText("����: "+info.get(2));
		} catch (Exception e) {}
		jf.setLayout(new GridLayout(2,1));
		jf.setSize(400,200);
		jpinfo.setLayout(new GridLayout(2,1));
		
		jpinfo.add(jlname);
		jpinfo.add(jlemail);
		jpbu.setLayout(new FlowLayout());
		jbu1.addActionListener(this);
		jbu2.addActionListener(this);
		jbu4.addActionListener(this);
		jbu5.addActionListener(this);
		jpbu.add(jbu1);
		jpbu.add(jbu2);
		jpbu.add(jbu4);
		jpbu.add(jbu5);
		jf.add(jpinfo);
		jf.add(jpbu);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbu1) {//�����Է�
			SetSco ssco=new SetSco();
			jf.dispose();
			ssco.setscore(id);
		}
		if(e.getSource()==jbu2) {//����Ȯ��
			OutSco osco=new OutSco();
			jf.dispose();
			osco.OutScore(id);
		}
		if(e.getSource()==jbu4) {//��������
			Idremake remake=new Idremake();
			remake.reidmake(id);
		}
		if(e.getSource()==jbu5) {//�α׾ƿ�
			Login logout = new Login();
			jf.dispose();
			logout.lgin();
		}
		
	}
	
}
