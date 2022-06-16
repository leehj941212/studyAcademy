import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Idremake implements ActionListener,KeyListener{
	String[] month= {"01","02","03","04","05","06","07","08","09","10","11","12"};
	String id;
	JFrame jf = new JFrame();
	JLabel jl3=new JLabel("이름       ");
	JLabel jl4=new JLabel("이메일 ");
	JLabel jl5=new JLabel("성별     ");
	JLabel jl6=new JLabel("생년월일");
	JTextField jt3 = new JTextField(10);
	JTextField jt4_1 = new JTextField(10);
	JTextField jt4_2 = new JTextField(10);
	JTextField jt6_1 = new JTextField(10);
	JTextField jt6_2 = new JTextField(10);
	JCheckBox jc1 =new JCheckBox("남");
	JCheckBox jc2 =new JCheckBox("여");
	JButton jb1=new JButton("확인"); JButton jb2=new JButton("돌아가기");
	JComboBox<String> jcb=new JComboBox<String>(month);
	String[] sss = {"남","여"};
	JRadioButton jrb[] = new JRadioButton[2];
	void reidmake(String id) {
		this.id=id;
		jf.setLayout(new GridLayout(7,1));
		jf.setSize(500, 500);
		
		JPanel jp3=new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jp4=new JPanel();
		jp4.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jp5=new JPanel();
		jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jp6=new JPanel();
		jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jp7=new JPanel();
		jp7.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jp3.add(jl3); jp3.add(jt3);
		jp4.add(jl4); jp4.add(jt4_1); jp4.add(new JLabel("@")); jp4.add(jt4_2);
		jp5.add(jl5); 
		ButtonGroup g= new ButtonGroup();
		for(int i=0;i<jrb.length;i++){
			jrb[i]=new JRadioButton(sss[i]);
			g.add(jrb[i]);
			jp5.add(jrb[i]);
			jrb[i].addActionListener(this);
		}jrb[0].setSelected(true);
        jrb[1].setSelected(false);
        jt6_2.addKeyListener(this);
		jp6.add(jl6); jp6.add(jt6_1); jp6.add(new JLabel("년")); jp6.add(jcb); jp6.add(new JLabel("월")); jp6.add(jt6_2); jp6.add(new JLabel("일"));
		jp7.add(jb1); jp7.add(jb2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jf.add(jp3); jf.add(jp4); jf.add(jp5); jf.add(jp6); jf.add(jp7);
		
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		
	}
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			jb1.doClick();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MainBu mainhome = new MainBu();
		if(e.getSource()==jb1) {
			String name=jt3.getText(),email,sex="",birth;
			
			email=jt4_1.getText()+"@"+jt4_2.getText();
			if(email.equals(""))email="id@email";
			if(jrb[0].isSelected()) {
				sex=jrb[0].getText();
			}else {
				sex=jrb[1].getText();
			}
			if(sex.equals(""))sex="남";
			birth=jt6_1.getText()+jcb.getSelectedItem().toString()+jt6_2.getText();
			if(birth.equals(""))birth="000100";
			String line,du="",du2="";
			try {	
			File f = new File(id+".txt");
			BufferedReader br=new BufferedReader(new FileReader(f));
			
			for(int i=0; i<1; i++) {
				line = br.readLine();
				du+=line+"\r\n";
			}
			for(int i=0; i<4; i++) {
				String del = br.readLine();
			}
			for(int i =0;i<3;i++){
				line = br.readLine();
				du2+=line+"\r\n";
			}
			
			FileWriter fw = new FileWriter(f);
			if(name.equals(""))name="name";
						
			fw.write(du);
			fw.write(name);
			fw.write("\r\n");
			fw.write(email);
			fw.write("\r\n");
			fw.write(sex);
			fw.write("\r\n");
			fw.write(birth);
			fw.write("\r\n");
			fw.write(du2);
			fw.close();
			
			
			
			}catch(Exception e2){
				
			}
			jf.dispose();
			
			mainhome.callbu(id);
		
		}
		if(e.getSource()==jb2) {
			jf.dispose();
			mainhome.callbu(id);
		}
		
	}
	
}
