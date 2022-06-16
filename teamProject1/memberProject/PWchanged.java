package memberProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PWchanged {

     PWchanged(){
          JFrame jf1 = new JFrame();
          /** 라벨 */
          JLabel jl1_done = new JLabel("비밀번호가 변경되었습니다.");
          /** 버튼 */
          JButton jb1_next = new JButton("다음");
          /** 프레임, 패널 레이아웃 */
          jf1.setLayout(new FlowLayout());
          jf1.add(jl1_done);
          jf1.add(jb1_next);

          jf1.setVisible(true);
          jf1.setSize(500,200);
          jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);

          jb1_next.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new LoginWindow();
                    jf1.dispose();
               }
          });
     }
}

