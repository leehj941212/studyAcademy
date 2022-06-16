package memberProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendId {
    public SendId(String id) {
        JFrame jf1 = new JFrame();
        jf1.setTitle("그린대학교 학사정보시스템");
      
        /** 라벨 */
        JLabel jl1_idSent = new JLabel(" 선택하신 인증 수단으로 아이디가 전송되었습니다 ");
        JLabel jl2_idSent = new JLabel(" 해당 아이디 : ");
        JLabel jl3_idSent = new JLabel();
        
        /** 버튼*/
        JButton jb1_toLoginWindow = new JButton("로그인 하기");
        JButton jb2_toSearchPW= new JButton("비밀번호 찾기");
        
        /** 프레임, 패널 레이아웃 */
        jf1.setLayout(null);
        jf1.setTitle("그린대학교 학사정보시스템 - 아이디 찾기");
        jf1.setResizable(false);
        
        jf1.add(jl1_idSent);      jl1_idSent.setBounds(50, 20, 300, 50);
        jf1.add(jl2_idSent);      jl2_idSent.setBounds(50, 80, 150, 50);
        jf1.add(jl3_idSent);      jl3_idSent.setBounds(120, 80, 100, 50);
        
        jf1.add(jb1_toLoginWindow);   jb1_toLoginWindow.setBounds(70, 150, 120, 50);
        jf1.add(jb2_toSearchPW);   jb2_toSearchPW.setBounds(210,150, 130, 50);
        
        jl3_idSent.setText(id);
        
        jf1.setVisible(true);
        jf1.setSize(430,270);
        jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);

        jb1_toLoginWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginWindow();
                jf1.setVisible(false);
            }
        });

        jb2_toSearchPW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindPasswordWindow();
            }
        });

    }
}

