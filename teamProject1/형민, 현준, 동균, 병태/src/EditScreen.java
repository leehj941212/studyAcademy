import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class EditScreen implements ActionListener {
	JFrame jf=new JFrame("ȸ�� ���� ����â");
	JFrame jf2=new JFrame("ȸ��Ż�� Ȯ��â");
	JTextField pwtext=new JTextField();
	JTextField nicktext=new JTextField();
	JTextField pnumtext=new JTextField();
	JTextField pnumtext2=new JTextField();
	JTextField pnumtext3=new JTextField();

	Color c=new Color(255,255,204);
	Color c1=new Color(255,255,255);

	JLabel id =new JLabel("ID:");
	JLabel ioid =new JLabel("IO���� ������ ID");
	JLabel pw =new JLabel("P.W:");
	JLabel iopw =new JLabel("IO���� ������ P.W");
	JLabel name =new JLabel("�̸�:");
	JLabel ioname =new JLabel("IO���� ������ �̸�");
	JLabel nick =new JLabel("�г���:");
	JLabel ionick =new JLabel("IO���� ������ �г���");
	JLabel pnum =new JLabel("��ȭ��ȣ:");
	JLabel iopnum =new JLabel("IO���� ������ ��ȭ��ȣ");
	JLabel iopnum2 =new JLabel("IO���� ������ ��ȭ��ȣ2");
	JLabel iopnum3 =new JLabel("IO���� ������ ��ȭ��ȣ3");
	JLabel mail =new JLabel("E-mail:");
	JLabel iomail =new JLabel("IO���� ������ E-mail");
	JLabel g =new JLabel("@");
	JLabel iomail1 =new JLabel("IO���� ������ E-mail1");
	JLabel day =new JLabel("�������:");
	JLabel ioday =new JLabel("IO���� ������ �������");
	JLabel ioday1 =new JLabel("IO���� ������ �������1");
	JLabel ioday2 =new JLabel("IO���� ������ �������2");
	JLabel sung =new JLabel("����:");
	JLabel iosung =new JLabel("IO���� ������ ����");
	JLabel exitlb =new JLabel("���� ȸ��Ż�� �Ͻǰǰ���?");

	JButton pwed=new JButton("����");
	JButton nicked=new JButton("����");
	JButton pnumed=new JButton("����");
	JButton out=new JButton("ȸ��Ż��");
	JButton cl=new JButton("�ݱ�");
	JButton yes=new JButton("YES");
	JButton no=new JButton("NO");

	JFrame lgFrame;
	JFrame mFrame;

	String i; // �α��ν� �Է¹��� ���̵�

	EditScreen(JFrame lgFrame, JFrame mFrame, String userId){
		i = userId;
		this.lgFrame = lgFrame;
		this.mFrame = mFrame;
		jf.setLayout(null);
		jf.add(id);
		jf.add(ioid);
		jf.add(pw);
		jf.add(pwtext, iopw);
		jf.add(name);
		jf.add(ioname);
		jf.add(nick);
		jf.add(nicktext, ionick);
		jf.add(pnum);
		jf.add(pnumtext, iopnum);
		jf.add(pnumtext2, iopnum2);
		jf.add(pnumtext3, iopnum3);
		jf.add(mail);
		jf.add(iomail);
		jf.add(g);
		jf.add(iomail1);
		jf.add(day);
		jf.add(ioday);
		jf.add(ioday1);
		jf.add(ioday2);
		jf.add(sung);
		jf.add(iosung);

		jf.add(pwed);
		jf.add(nicked);
		jf.add(pnumed);
		jf.add(out);
		jf.add(cl);

		id.setBounds(65, 20, 100, 50);
		pw.setBounds(52, 50, 100, 50);
		name.setBounds(50, 80, 100, 50);
		nick.setBounds(38, 115, 100, 50);
		pnum.setBounds(23, 150, 100, 50);
		mail.setBounds(40, 180, 100, 50);
		day.setBounds(23, 210, 100, 50);
		sung.setBounds(50, 240, 100, 50);

		ioid.setBounds(100, 20, 200, 50);
		pwtext.setBounds(100, 65, 150, 25);
		ioname.setBounds(100, 80, 200, 50);
		nicktext.setBounds(100, 130, 150, 25);
		pnumtext.setBounds(100, 165, 50, 25);
		pnumtext2.setBounds(160, 165, 70, 25);
		pnumtext3.setBounds(240, 165, 70, 25);
		iomail.setBounds(100, 180, 200, 50);
		g.setBounds(200, 180, 200, 50);
		iomail1.setBounds(230, 180, 200, 50);
		ioday.setBounds(100, 210, 200, 50);
		ioday1.setBounds(150, 210, 200, 50);
		ioday2.setBounds(180, 210, 200, 50);
		iosung.setBounds(100, 240, 200, 50);

		pwed.setBounds(250, 67, 100, 20);
		nicked.setBounds(250, 133, 100, 20);
		pnumed.setBounds(350, 167, 100, 20);
		out.setBounds(260, 420, 100, 25);
		cl.setBounds(370, 420, 90, 25);

		jf.setVisible(true);
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

		pwed.addActionListener(this);
		nicked.addActionListener(this);
		pnumed.addActionListener(this);
		out.addActionListener(this);
		cl.addActionListener(this);

		jf.getContentPane().setBackground(c);
		pwed.setBackground(c1);
		nicked.setBackground(c1);
		pnumed.setBackground(c1);
		out.setBackground(c1);
		cl.setBackground(c1);
		yes.setBackground(c1);
		no.setBackground(c1);
		this.fileinput();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==pwed){
			if(pwtext.getText().equals("")){
				JOptionPane.showMessageDialog(null,"������ ��й�ȣ�� �ٽ� �Է��ϼ���");
			}
			else{
				JOptionPane.showMessageDialog(null,"����Ǿ����ϴ�");
			}

			FileOutputStream f= null;

			try{
				f=new FileOutputStream("UserData\\"+i+"\\pw.txt");
				String data=pwtext.getText();
				byte b [] =data.getBytes();
				f.write(b);
			}catch (Exception w){
				//System.out.println(w+" => ���Ͼ��� ����");
			}finally{
				try{
					f.close();
				}catch (Exception k){
					//System.out.println(k+" => close ����");
				}
			}
		}
		if(e.getSource()==nicked){
			if(nicktext.getText().equals("")){
				JOptionPane.showMessageDialog(null,"������ �г����� �ٽ� �Է��ϼ���");
			}
			else{
				JOptionPane.showMessageDialog(null,"����Ǿ����ϴ�");
			}
			FileOutputStream f= null;

			try{
				f=new FileOutputStream("UserData\\"+i+"\\nick.txt");
				String data=nicktext.getText();
				byte b [] =data.getBytes();
				f.write(b);
			}catch (Exception w){
				//System.out.println(w+" => ���Ͼ��� ����");
			}finally{
				try{
					f.close();
				}catch (Exception k){
					//System.out.println(k+" => close ����");
				}
			}
		}
		if(e.getSource()==pnumed){
			String pw1="(\\d{3})";
			Matcher matcher1 = Pattern.compile(pw1).matcher(pnumtext.getText());
			String pw2="(\\d{4})";
			Matcher matcher2 = Pattern.compile(pw2).matcher(pnumtext2.getText());
			String pw3="(\\d{4})";
			Matcher matcher3 = Pattern.compile(pw3).matcher(pnumtext3.getText());

			if(!matcher1.matches() || !matcher2.matches() || !matcher3.matches())
			{
				JOptionPane.showMessageDialog(null,"������ ��ȭ��ȣ�� �ٽ� �Է��ϼ���");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"����Ǿ����ϴ�");

				FileOutputStream f=null;

				try{
					f=new FileOutputStream("UserData\\"+i+"\\pnum.txt");
					String numdata=pnumtext.getText();
					byte b [] =numdata.getBytes();
					f.write(b);
					f=new FileOutputStream("UserData\\"+i+"\\pnum2.txt");
					String num2data=pnumtext2.getText();
					byte b1 [] =num2data.getBytes();
					f.write(b1);
					f=new FileOutputStream("UserData\\"+i+"\\pnum3.txt");
					String num3data=pnumtext3.getText();
					byte b2 [] =num3data.getBytes();
					f.write(b2);
				}catch (Exception w){
					//System.out.println(w+" => ���Ͼ��� ����");
				}finally{
					try{
						f.close();
					}catch (Exception k){
						//System.out.println(k+" => close ����");
					}
				}
			}
			/*
			if(pnumtext.getText().equals("")){
				JOptionPane.showMessageDialog(null,"������ ��ȭ��ȣ�� �ٽ� �Է��ϼ���");
			}
			else if(pnumtext1.getText().equals("") || pnumtext2.getText().equals("")){

			}
			else if((pnumtext1.getText().length()!=4) || (pnumtext2.getText().length()!=4))
			{
				JOptionPane.showMessageDialog(null,"������ ��ȭ��ȣ�� 4�ڸ����� �ٽ� Ȯ���ϼ���");
			}
			else{

			}
			 */
		}
		if(e.getSource()==out){
			jf2.setLayout(null);

			jf2.add(exitlb);

			jf2.add(yes);
			jf2.add(no);

			exitlb.setBounds(30, 25, 300, 25);
			yes.setBounds(20, 170, 80, 25);
			no.setBounds(135, 170, 80, 25);

			jf2.setVisible(true);
			jf2.setSize(250, 250);

			jf2.getContentPane().setBackground(c);

			yes.addActionListener(this);
			no.addActionListener(this);
		}
		if(e.getSource()==cl){
			if(pwtext.getText().equals("")){
				JOptionPane.showMessageDialog(null,"��й�ȣ�� �ٽ� Ȯ�� �� ������ �����ּ���");
			}
			else if(nicktext.getText().equals("")){
				JOptionPane.showMessageDialog(null,"�г����� �ٽ� Ȯ�� �� ������ �����ּ���");
			}
			else if(pnumtext.getText().equals("")){
				JOptionPane.showMessageDialog(null,"��ȭ��ȣ�� �ٽ� Ȯ�� �� ������ �����ּ���");
			}
			else if(pnumtext2.getText().equals("") || pnumtext3.getText().equals("")){
				JOptionPane.showMessageDialog(null,"��ȭ��ȣ�� �ٽ� Ȯ�� �� ������ �����ּ���");
			}
			else{
				mFrame.setVisible(true);
				jf.dispose();
			}
		}
		if(e.getSource()==yes){
			String path = "UserData\\"+i;
			File folder = new File(path);
			try{
				while(folder.exists()){
					File[] folder_list = folder.listFiles();

					for (int j = 0; j < folder_list.length; j++){
						folder_list[j].delete(); // ���� ����
					}

					if(folder_list.length == 0 && folder.isDirectory()){
						folder.delete(); // ���� ����
					}
				}
			} catch (Exception w){
				//System.out.println(w);
			}
			JOptionPane.showMessageDialog(null,"Ż�� �Ϸ��߽��ϴ�.");

			lgFrame.setVisible(true);
			mFrame.dispose();
			jf.dispose();
			jf2.dispose();
		}
		if(e.getSource()==no){
			jf2.dispose();
		}
	}

	public void fileinput(){
		FileInputStream f1=null;

		try{
			f1=new FileInputStream("UserData\\"+i+"\\day.txt");
			byte b1 [] =new byte [f1.available()];
			while(f1.read(b1)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\day1.txt");
			byte b11 [] =new byte [f1.available()];
			while(f1.read(b11)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\day2.txt");
			byte b111 [] =new byte [f1.available()];
			while(f1.read(b111)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\mail.txt");
			byte b2 [] =new byte [f1.available()];
			while(f1.read(b2)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\mail1.txt");
			byte b22 [] =new byte [f1.available()];
			while(f1.read(b22)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\name.txt");
			byte b3 [] =new byte [f1.available()];
			while(f1.read(b3)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\nick.txt");
			byte b4 [] =new byte [f1.available()];
			while(f1.read(b4)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\pnum.txt");
			byte b5 [] =new byte [f1.available()];
			while(f1.read(b5)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\pnum2.txt");
			byte b6 [] =new byte [f1.available()];
			while(f1.read(b6)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\pnum3.txt");
			byte b7 [] =new byte [f1.available()];
			while(f1.read(b7)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\pw.txt");
			byte b8 [] =new byte [f1.available()];
			while(f1.read(b8)!=-1){}
			f1=new FileInputStream("UserData\\"+i+"\\sung.txt");
			byte b9 [] =new byte [f1.available()];
			while(f1.read(b9)!=-1){}

			String daydata=new String(b1);
			String day1data=new String(b11);
			String day2data=new String(b111);
			String maildata=new String(b2);
			String mail1data=new String(b22);
			String namedata=new String(b3);
			String nickdata=new String(b4);
			String pnumdata=new String(b5);
			String pnum2data=new String(b6);
			String pnum3data=new String(b7);
			String pwdata=new String(b8);
			String sungdata=new String(b9);

			ioid.setText(i);
			ioday.setText(daydata+"��");
			ioday1.setText(day1data);
			ioday2.setText(day2data+"��");
			iomail.setText(maildata);
			iomail1.setText(mail1data);
			ioname.setText(namedata);
			nicktext.setText(nickdata);
			pnumtext.setText(pnumdata);
			pnumtext2.setText(pnum2data);
			pnumtext3.setText(pnum3data);
			pwtext.setText(pwdata);
			iosung.setText(sungdata);

		}catch (FileNotFoundException e){
			//System.out.println(e+" => ���ϻ��� ����");
		}catch (IOException e){
			//System.out.println(e+" => �����б� ����");
		}finally{
			try{
				f1.close();
			}catch (Exception e){
				//System.out.println(e+" => �ݱ� ����");
			}
		}
	}
}