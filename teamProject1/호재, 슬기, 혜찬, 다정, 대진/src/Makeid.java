import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
//아이디 패스워드 이메일 이름 성별 생년월일
public class Makeid implements ActionListener,KeyListener{
	String[] month= {"01","02","03","04","05","06","07","08","09","10","11","12"};
	String id;
	JFrame jf = new JFrame();
	JLabel jltitle=new JLabel("회원가입");
	JLabel jl1=new JLabel("아이디    ");
	JLabel jl2=new JLabel("패스워드");
	JLabel jl3=new JLabel("이름       ");
	JLabel jl4=new JLabel("이메일 ");
	JLabel jl5=new JLabel("성별     ");
	JLabel jl6=new JLabel("생년월일");
	Font titlefont = new Font("궁서", Font.BOLD, 25);
	JTextField jt1 = new JTextField(10);
	JTextField jt2 = new JTextField(10);
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
	void idmake() {
		String id;
		jltitle.setFont(titlefont);
		jltitle.setHorizontalAlignment(JLabel.LEFT);
		jf.setTitle("회원가입");
		jf.setLayout(new GridLayout(8,1));
		jf.setSize(500, 500);
		JPanel jp1=new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
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
		jp1.add(jl1); jp1.add(jt1);
		jp2.add(jl2); jp2.add(jt2);
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
		jf.add(jltitle);
		jf.add(jp1); jf.add(jp2); jf.add(jp3); jf.add(jp4); jf.add(jp5); jf.add(jp6); jf.add(jp7);
		
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		
	}
	
	@Override
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
		Login login =new Login();
		if(e.getSource()==jb1) {
			String id=jt1.getText(),pwd=jt2.getText(),name=jt3.getText(),email,sex="",birth;
			id=jt1.getText();
			email=jt4_1.getText()+"@"+jt4_2.getText();
			if(jrb[0].isSelected()) {
				sex=jrb[0].getText();
			}else {
				sex=jrb[1].getText();
			}
			
			birth=jt6_1.getText()+jcb.getSelectedItem().toString()+jt6_2.getText();
			if(!id.equals("")) {if(!pwd.equals("")){
			try {File f = new File(id+".txt");
			if(!f.exists()) {
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(pwd);
				bw.write("\r\n");
				bw.write(name);
				bw.write("\r\n");
				bw.write(email);
				bw.write("\r\n");
				bw.write(sex);
				bw.write("\r\n");
				bw.write(birth);
				bw.close();
				jf.dispose();
				login.lgin();
			}
				else{
					JOptionPane.showMessageDialog(null,"이미 가입된 사용자입니다","회원가입 오류",JOptionPane.ERROR_MESSAGE);
				}
			
			} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"잘못입력하셧습니다","회원가입 오류",JOptionPane.ERROR_MESSAGE);
				}
		
			}else {JOptionPane.showMessageDialog(null,"패스워드를 입력하시오","회원가입 오류",JOptionPane.ERROR_MESSAGE);}
			}else {
				JOptionPane.showMessageDialog(null,"아이디를 입력하시오","회원가입 오류",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==jb2) {
			jf.dispose();;
			
			login.lgin();
		}
		
	}
	void fileMake(String id,String pwd,String name,String email,String sex,String birth) {
		
			
	}
	
}
