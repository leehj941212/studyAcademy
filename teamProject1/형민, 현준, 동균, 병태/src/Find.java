import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Find implements ActionListener{
   Color c = new Color(255,255,204);
   JFrame jf = new JFrame("FIND PAGE");
   Panel p = new Panel();
   JButton btn1 = new JButton("ID 찾기");
   JButton btn2 = new JButton("P.W 찾기");
   JButton btn3 = new JButton("닫기"   );
   JFrame loginFrame;
   Find(){

      jf.setLayout(new BorderLayout());      
      p.setLayout(null);
      p.setBackground(c);
      p.add(btn1);
      p.add(btn2);
      btn1.setBounds(70,110,100,40);
      btn2.setBounds(200, 110, 100, 40);
      jf.add(p, "Center");
      jf.add(btn3, "South");
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);
      btn1.setBackground( new Color(255,255,254));
      btn2.setBackground( new Color(255,255,254));
      btn3.setBackground( new Color(255,255,254));

      jf.setSize(380, 300);
      jf.setVisible(true);
      jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      switch(e.getActionCommand()) {
      case "ID 찾기" :
         new FindId();

         break;

      case "P.W 찾기" :
         new FindPw();

         break;
      case "닫기" : 
         new Login();
         jf.setVisible(false);
         break;
      }

   }

}
class FindId implements ActionListener{
   Color c = new Color(255,255,204);
   JFrame jf1 = new JFrame("FIND PAGE");
   TextField jt1 = new TextField();
   TextField jt2 = new TextField();
   JLabel jl = new JLabel("이름을 입력하세요");
   JLabel jl2 = new JLabel("닉네임을 입력하세요 ");
   Panel p = new Panel();
   Panel p2 = new Panel();
   JButton btn1 = new JButton("ID찾기");
   JButton btn2 = new JButton("취소");
   public FindId() {                           
      jf1.setLayout(new BorderLayout());
      p.add(jl);
      p.add(jl2);
      p.add(jt1);
      p.add(jt2);
      p.setLayout(null);
      p.setBackground(c);
      p2.setBackground(c);
      jl.setBounds(30, 60, 150, 20);
      jl2.setBounds(30, 140,150, 20);
      jt1.setBounds(180,60,130,20);
      jt2.setBounds(180,140,130,20);
      p2.add(btn1);
      p2.add(btn2);
      btn1.setBackground( new Color(255,255,254));
      btn2.setBackground( new Color(255,255,254));
      jf1.add(p2,"South");
      btn1.addActionListener(this);   
      btn2.addActionListener(this);
      jf1.add(p,"Center");
      jf1.setSize(380, 300);
      jf1.setVisible(true);
      jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
   }
   void readID() throws Exception {

      File findID = new File("UserData");      

      boolean check = false;
      String [] filenames = findID.list();
      if(jt1.getText().length()==0||jt2.getText().length()==0) {
         JOptionPane.showMessageDialog(null, "입력하신 정보가 없습니다.");
      }
      else {
         for(String filename : filenames) {
            FileInputStream fi2 = new FileInputStream(new File("UserData\\"+filename+"\\name.txt"));
            FileInputStream fi3 = new FileInputStream(new File("UserData\\"+filename+"\\nick.txt"));
            byte[ ] readBuffer = new byte[ fi2.available( ) ];
            byte[ ] readBuffer1 = new byte[ fi3.available( ) ];
            while(fi2.read(readBuffer)!=-1) {            
            }
            while(fi3.read(readBuffer1)!=-1) {
            }

            if(new String(readBuffer).equals(jt1.getText()) && new String(readBuffer1).equals(jt2.getText())) {
               JOptionPane.showMessageDialog(null, "당신의 ID는 "+filename);
               check = true;
            }

         }   
         if (!check){
            JOptionPane.showMessageDialog(null, "올바르지않은 정보입니다.");
         }     
      }

   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btn1) {
         try {
            readID();
            jf1.setVisible(false);
         } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }
      else if (e.getSource()==btn2) {
         new Find();
         jf1.setVisible(false);
      }



   }
}
class FindPw implements ActionListener{
   Color c = new Color(255,255,204);
   JFrame jf1 = new JFrame("FIND PAGE");
   TextField jt1 = new TextField();
   TextField jt2 = new TextField();
   JLabel jl = new JLabel("아이디를 입력하세요");
   JLabel jl2 = new JLabel("이름을 입력하세요 ");
   Panel p = new Panel();
   Panel p2 = new Panel();
   JButton btn1 = new JButton("PW찾기");
   JButton btn2 = new JButton("취소");
   public FindPw() {      

      jf1.setLayout(new BorderLayout());
      p.add(jl);
      p.add(jl2);
      p.add(jt1);
      p.add(jt2);
      p.setLayout(null);
      p.setBackground(c);
      jl.setBounds(30, 60, 150, 20);
      jl2.setBounds(30, 140,150, 20);
      jt1.setBounds(180,60,130,20);
      jt2.setBounds(180,140,130,20);
      p2.add(btn1);
      p2.add(btn2);
      btn1.setBackground( new Color(255,255,254));
      btn2.setBackground( new Color(255,255,254));
      p2.setBackground(c);
      jf1.add(p2,"South");   
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      jf1.add(p,"Center");
      jf1.setSize(380, 300);
      jf1.setVisible(true);
      jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);

   }
   void readPw() throws Exception{
      String idPath = "UserData\\"+jt1.getText();
      String pwPath = idPath+"\\pw.txt"; 
      File fi = new File(idPath);
      File fi2 = new File(pwPath);
      FileInputStream fip =null;
      FileInputStream fip2 =null;
      if(jt1.getText().length()==0||jt2.getText().length()==0) {
         JOptionPane.showMessageDialog(null, "입력하신 정보가 없습니다.");
      }
      else {

         if(false==fi.exists()) {
            JOptionPane.showMessageDialog(null, "존재하지않는 아이디입니다");
         }
         else {
            fip = new FileInputStream(idPath+"\\name.txt");
            fip2 = new FileInputStream(fi2);
            byte [] n = new byte[fip.available()];
            byte[] b = new byte[fip2.available()];      
            while(fip2.read(b)!=-1) {            
            }
            while(fip.read(n)!=-1) {

            }
            if(new String(n).equals(jt2.getText())&& fi.exists()) {
               JOptionPane.showMessageDialog(null, "당신의 비밀번호는 "+ new String(b));
            }   
            else {
               JOptionPane.showMessageDialog(null, "해당 정보가 없습니다");
            }

         }
      }
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btn1) {   
         try {
            readPw();
            jf1.setVisible(false);
         } catch (Exception e1) {     
         }
      }
      else if(e.getSource()==btn2) {
         new Find();
         jf1.setVisible(false);
      }

   }
}