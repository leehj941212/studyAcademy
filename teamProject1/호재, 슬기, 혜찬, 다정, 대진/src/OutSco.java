import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

class OutSco implements ActionListener{
	String id="";
	int sco1,sco2,sco3;
	JFrame jf=new JFrame();
	JButton jb1 = new JButton("확인");
	JButton jb2 = new JButton("돌아가기");
	JLabel jl1=new JLabel("이름");
	JLabel jl2=new JLabel("");
	JLabel jl3=new JLabel("국어");
	JLabel jl4=new JLabel("");
	JLabel jl5=new JLabel("수학");
	JLabel jl6=new JLabel("");
	JLabel jl7=new JLabel("영어");
	JLabel jl8=new JLabel("");
	JLabel jl9=new JLabel("평균");
	JLabel jla=new JLabel("");
	void OutScore(String id) {
		this.id=id;
		jf.setTitle("성적 확인");
		jf.setLayout(new GridLayout(11,1));
		jf.setSize(400,300);
		JPanel jp1= new JPanel();
		jp1.setLayout(new GridLayout(1, 2));
		jp1.add(jb1);
		jp1.add(jb2);
		jf.add(jl1);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		jf.add(jl5);
		jf.add(jl6);
		jf.add(jl7);
		jf.add(jl8);
		jf.add(jl9);
		jf.add(jla);
		jf.add(jp1);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			readFile(id);
		}
		if(e.getSource()==jb2) {
			jf.dispose();
			MainBu mainmenu = new MainBu();
			mainmenu.callbu(id);
		}
		
	}
	void readFile(String id) {
		File f = new File(id+".txt");
		ArrayList<String>info=new ArrayList<String>();
		String str;
		try {
			
			BufferedReader rf = new BufferedReader(new FileReader(f));
			while((str= rf.readLine())!=null) {
				info.add(str);				
			}
		}catch (Exception e){}
		try {
		jl2.setText(info.get(1));
		jl4.setText(info.get(5));
		jl6.setText(info.get(6));
		jl8.setText(info.get(7));
		double arg=(Double.parseDouble(info.get(5))+Double.parseDouble(info.get(6))+Double.parseDouble(info.get(7)))/3;
		jla.setText(Double.toString(arg));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"성적입력 먼저 하세요","성적확인 오류",JOptionPane.ERROR_MESSAGE);
		}
		}
		
	

}
