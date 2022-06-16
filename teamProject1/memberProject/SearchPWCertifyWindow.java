package memberProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SearchPWCertifyWindow {
    int randomNum;
    String StrRandomNum;
    JFrame jf1;
    JLabel jl_CertifViaPhone, jl_CertifViaMail, jl_nameViaPhone, jl_phone, jl_nameViaMail, jl_mail;
    JTextField tf_nameViaPhone, tf_phone, tf_nameViaMail, tf_mail, tf_InsertNum;
    JButton jb_receiveNum, jb_next;

    public SearchPWCertifyWindow(String id) {
        jf1 = new JFrame(); // 프레임 만들고
        jf1.setLayout(null);
        jf1.setTitle("그린대학교 학사정보시스템");
        jf1.setResizable(false);
// 인증번호 받기, 인증번호 입력하기, 다음 버튼이 올라가는 패널
        /** 라벨 */
        jl_CertifViaPhone = new JLabel(" 휴대전화로 인증 ");
        //jl_CertifViaMail = new JLabel(" 이메일로 인증 ");

        jl_nameViaPhone = new JLabel(" 이름 : ");
        jl_phone = new JLabel(" 휴대전화 : ");
        jl_nameViaMail = new JLabel(" 이름 : ");
        jl_mail = new JLabel(" 이메일 : ");
        /** 텍스트필드*/
        tf_nameViaPhone = new JTextField();
        tf_phone = new JTextField();
        tf_nameViaMail = new JTextField();
        tf_mail = new JTextField();
        /** 버튼 */
        jb_receiveNum = new JButton("인증번호받기");
        tf_InsertNum = new JTextField(10); // 인증번호 입력패널
        // tf_InsertNum.setText("인증번호를 입력하세요");
        jb_next = new JButton("다음");


        /** 프레임, 패널 레이아웃 */
        jf1.add(jl_CertifViaPhone);   jl_CertifViaPhone.setBounds(30,50, 100, 50);
        //jf1.add(jl_CertifViaMail);     jl_CertifViaMail.setBounds(30,150, 100, 50);

        jf1.add(jl_nameViaPhone);     jl_nameViaPhone.setBounds(130,30, 100, 50);
        jf1.add(jl_phone);                   jl_phone.setBounds(130,80, 100, 50);
        //jf1.add(jl_nameViaMail);       jl_nameViaMail.setBounds(130,130, 100, 50);
        //jf1.add(jl_mail);                     jl_mail.setBounds(130,180, 100, 50);

        jf1.add(tf_nameViaPhone);     tf_nameViaPhone.setBounds(200,30, 100, 50);
        jf1.add(tf_phone);                   tf_phone.setBounds(200,80, 100, 50);
        //jf1.add(tf_nameViaMail);       tf_nameViaMail.setBounds(200,130, 100, 50);
        //jf1.add(tf_mail);                     tf_mail.setBounds(200,180, 100, 50);

        jf1.add(jb_receiveNum);         jb_receiveNum.setBounds(350,80, 100, 50);
        jf1.add(tf_InsertNum);           tf_InsertNum.setBounds(330,130, 140, 50);
        jf1.add(jb_next);                     jb_next.setBounds(350,180, 100, 50);


        jf1.setVisible(true);
        jf1.setSize(500, 300);
        jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);

        jb_receiveNum.addActionListener(new ActionListener() {      // 인증번호받기 버튼 누르면 난수생성하기
            @Override
            public void actionPerformed(ActionEvent e) {
            	HashMap<String, MemberDTO> members = MemberDAO.getMember();
                MemberDTO member = new MemberDTO();

                String findName = tf_nameViaPhone.getText();
                String findPhone = tf_phone.getText();
                String findName2 = tf_nameViaMail.getText();
                String findEmail = tf_mail.getText();
                String certifyNum = tf_InsertNum.getText();

                randomNum = (int) (Math.random() * 999999 + 1);  // 6자리의 난수 생성
                StrRandomNum = Integer.toString(randomNum);
                if (findName.equals("") || findPhone.equals(""))
                {
                	new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
                }
                else
                {
                	if (members.containsKey(findName)) {  //휴대전화로 인증 란 에 이름텍스트필드에 입력한 값이 키로 가지고 있는 것과 일치하면,
                        member = members.get(findName);
                        if ( (findName.equals(member.getMemberName() ) && findPhone.equals( member.getPhoneNum() ) )) {
                        	System.out.println(StrRandomNum);
                        } else {
                            new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
                        }
                    } else {
                        new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
                    }
                }
            }
        });

        jb_next.addActionListener(new ActionListener() {      // 인증번호받기 버튼 누르면 난수생성하기
            @Override
            public void actionPerformed(ActionEvent e) {

            	HashMap<String, MemberDTO> members = MemberDAO.getMember();
                MemberDTO member = new MemberDTO();

                String findName = tf_nameViaPhone.getText();
                String findPhone = tf_phone.getText();
                String findName2 = tf_nameViaMail.getText();
                String findEmail = tf_mail.getText();
                String certifyNum = tf_InsertNum.getText();
                
                if (certifyNum.equals(""))
                {
                	new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
                }
                else
                {
                	if ( certifyNum.equals(StrRandomNum) ) {// 인증번호 랜덤 생성한 번호를 입력해서 이것도 일치를 해야 아이디 전송
                    	new putNewPassword(id);
                    } else {
                    	new CommonPopup(14);	// "인증번호가 일치하지 않습니다."
                    }
                }
                //new LoginWindow();
            }
        });
    }
}
