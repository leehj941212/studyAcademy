import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login implements ActionListener{
   JFrame jf = new JFrame("LOGIN PAGE");
   JButton btn1 = new JButton("로그인");
   JButton btn2 = new JButton("회원가입");
   JButton btn3 = new JButton("ID·P.W 찾기");
   Panel p1 = new  Panel();
   Panel p2 = new Panel();
   JLabel jl1 = new JLabel("ID : ");
   JLabel jl2 = new JLabel("P.W :");
   TextField tf1 = new TextField();
   JPasswordField tf2 = new JPasswordField();
   Color c = new Color(255,255,204);
   Color c1 = new Color(255,255,254);
   File f = new File("UserData");
   Login(){
      jf.setLayout(new BorderLayout());
      p1.setLayout(null);
      p1.setBackground(c);
      p2.setBackground(c);
      p1.add(jl1);
      p1.add(jl2);
      p1.add(tf1);
      p1.add(tf2);
      jl1.setBounds(60, 60, 20, 20);
      jl2.setBounds(60,140,30,20);
      tf1.setBounds(100, 60, 150, 20);
      tf2.setBounds(100,140,150,20);
      jf.add(p1,"Center");
      p2.setLayout(new FlowLayout());
      btn1.setBackground(c1);
      btn2.setBackground(c1);
      btn3.setBackground(c1);
      p2.add(btn2);
      p2.add(btn3);
      p2.add(btn1);
      jf.add(p2,"South");   

      btn1.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);
      jf.setSize(380, 300);
      jf.setVisible(true);
      jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

   }
   public static void main(String[]args) {
      new Login();
   }
   /*void text() {
      String idPath = "UserData/"+tf1.getText();
      String pwPath = idPath+"/"+tf2.getText()+".txt"; 
      File id = new File(idPath);
      File pw = new File(pwPath);
   }*/
   @Override
   public void actionPerformed(ActionEvent e) {
      switch(e.getActionCommand()) {
      case "로그인":
         LoginProcess();
         break;


      case "회원가입": 
         new CheckList();
         jf.setVisible(false);    
         break;

      case "ID·P.W 찾기":
         new Find();
         jf.setVisible(false);
         break;

      }      
   }


   void LoginProcess()
   {

      String idName = tf1.getText();
      String idPath = "UserData\\"+idName;
      String pwPath = idPath+"\\"+"pw.txt"; 
      File id = new File(idPath);
      File pw = new File(pwPath);
      FileInputStream fi1 = null;                  
      if(tf1.getText().length()==0||tf2.getPassword().length==0) {
         JOptionPane.showMessageDialog(null, "입력하신 정보가 없습니다.");
      }
      else {
         if(false == id.exists())
         {
            JOptionPane.showMessageDialog(null, "존재하지않는 아이디입니다");
         }

         try {
            fi1 = new FileInputStream(pw);

            byte[ ] readBuffer = new byte[ fi1.available( ) ];

            while(fi1.read(readBuffer) != -1)
            {

            }

            if(new String(readBuffer).equals(String.valueOf(tf2.getPassword()))) {
               new Menu(jf, idName);
               jf.setVisible(false);             
            }
            else
               JOptionPane.showMessageDialog(null, "올바르지 않는 비밀번호입니다");

         }
         catch(Exception e){
         }

      }
   }
}