import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
//id 파일을 받아와서 점수 입력후 파일저장
class SetSco implements ActionListener,KeyListener{
		
		String id=" ";
		int sco1,sco2,sco3;
		JButton jb1 = new JButton("확인");
		JButton jb2 = new JButton("돌아가기");
		JTextField jt1=new JTextField("");
		JTextField jt2=new JTextField("");
		JTextField jt3=new JTextField("");
		JFrame jf = new JFrame();
		
		void setscore(String id){
			this.id=id;
			jf.setTitle("성적 입력");
			jf.setLayout(new GridLayout(9,1));
			jf.setSize(400,300);
			JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(1, 2));
			JLabel[] jl=new JLabel[4]; 
			JTextField[] jt=new JTextField[3];
			jf.add(jl[0]=new JLabel());
			jf.add(jt1);
			jf.add(jl[1]=new JLabel());
			jf.add(jt2);
			jf.add(jl[2]=new JLabel());
			jf.add(jt3);
			jf.add(jl[3]=new JLabel(" "));
			jl[0].setText("국어");
			jl[1].setText("수학");
			jl[2].setText("영어");
			jt3.addKeyListener(this);
			jp.add(jb1);
			jp.add(jb2);
			jf.add(jp);
			jf.setVisible(true);
			jf.setLocationRelativeTo(null);
			jf.setResizable(false);
			jb1.addActionListener(this);
			jb2.addActionListener(this);
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
			MainBu mainmenu = new MainBu();
			if(e.getSource()==jb1) {
					String str1 =jt1.getText();
					String str2 =jt2.getText();
					String str3 =jt3.getText();
					savesco(str1,str2,str3);
					jf.dispose();
					mainmenu.callbu(id);
			}
			if(e.getSource()==jb2) {
				jf.dispose();
				
				mainmenu.callbu(id);
			}
				
			}
		
				
			
		void savesco(String str1,String str2,String str3) {
			String line,du="";
	
			try {	
			File f = new File(id+".txt");
			if(!f.exists()) {
				f.createNewFile();
				
			}BufferedReader br=new BufferedReader(new FileReader(f));
			
			for(int i=0; i<5; i++) {
				line = br.readLine();
				du+=line+"\r\n";
				}
			for(int i =0;i<4;i++){
				String del = br.readLine();
			}
			FileWriter fw = new FileWriter(f);
			
			fw.write(du);
			fw.write(str1);
			fw.write("\r\n");
			fw.write(str2);
			fw.write("\r\n");
			fw.write(str3);
			fw.write("\r\n");
			fw.close();
			
			
			
			}catch(Exception e){
				
			}
		}
		

}
	

			