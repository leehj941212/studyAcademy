package memberProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class LoginWindow {
    JFrame jf1;
    JLabel jl_Id, jl_password;
    JTextField tf_id;
    JPasswordField tf_pass;
    JButton jb_log, jb_findId, jb_findPass, jb_join;

    public LoginWindow() {
        jf1 = new JFrame();
        jf1.setLayout(null);
        jf1.setTitle("그린대학교 학사정보시스템");   // 타이틀 표시
        /** 라벨 */
        jl_Id = new JLabel(" ID : ");
        jl_password = new JLabel(" Password : ");
        /** 텍스트필드 */
        tf_id = new JTextField(10);
        tf_pass = new JPasswordField(10);
        /** 버튼 */
        jb_log = new JButton("Log In");
        jb_findId = new JButton("아이디 찾기");
        jb_findPass = new JButton("비밀번호 찾기");
        jb_join = new JButton("회원 가입하기");
        /** 레이아웃 */
        jf1.add(jl_Id);                   jl_Id.setBounds( 100, 40, 100, 40);
        jf1.add(jl_password);       jl_password.setBounds( 100, 90, 100, 40);

        jf1.add(tf_id);                   tf_id.setBounds( 190, 40, 120, 40);
        jf1.add(tf_pass);               tf_pass.setBounds( 190, 90, 120, 40);

        jf1.add(jb_log);                  jb_log.setBounds( 320, 40, 120, 90);
        jf1.add(jb_findId);            jb_findId.setBounds( 70, 180, 110, 40);
        jf1.add(jb_findPass);        jb_findPass.setBounds( 190, 180, 120, 40);
        jf1.add(jb_join);                jb_join.setBounds( 320, 180, 120, 40);

        jf1.setVisible(true);
        jf1.setSize(500, 300);
        jf1.setResizable(false);
        jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);

        /** 액션 이벤트 */
        // 로그인 버튼
        jb_log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	File file = new File("memberDTO.txt");
            	if(file.exists()) {
	                HashMap<String, MemberDTO> members = MemberDAO.getMember();
                    // MemberDAO의 getMember()호출하고 리턴값을 받아오는 건데.
	                // 거기서 리턴되는 거는 텍스트파일을 읽고, MemberDTO에 member객체만들고 데이터들을 저장한 것들을 여기서 쓰려고 호출해서 받아오고
                    // members에 넣어놓고 그것의 타입인 HashMap<String, MemberDTO> 를 써준 것
	
	                MemberDTO member = new MemberDTO();  // 데이터를 통으로 가져온 거고.. 한줄 을 가져와야 돼. 그래야 member를 쓸 수 있는 거지.
                    String logID = tf_id.getText();     // 아이디 텍스트 필드에 타이핑 한 것을 logID에 저장
	                     //String logPW = tf_pass.getText();   // 비번 텍스트필드에 타이핑 한것을 logPW에 저장
	                String logPW = new String(tf_pass.getPassword());   // 패스워드필드 타입 char라서 new String ()으로 형변환
	                if (logID.equals("") || logPW.equals("")) {
                    	new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
                    }else if (!members.containsKey(logID)) {
                        new CommonPopup(11);            // '비밀번호가 일치하지 않거나 해당 아이디가 존재하지 않습니다.
                    }else {
		                if (members.containsKey(logID)) {      //멤버스가 키값으로 텍스트필드에 친 logID를 가지고 있다면,
		                    member = members.get(logID);       // 멤버스에서 텍스트필드에 kkk를 입력했으면 그것과 동일한 값을 가져와서 member변수에 저장해라.
			                    if (logID.equals(member.getMemberId()) && logPW.equals(member.getPassword())) {
			                    	jf1.dispose();
			                        new LoginAfterWindow(logID);
			                    } else {
			                        JOptionPane.showMessageDialog(null,"비밀번호가 일치하지 않습니다");
			                    }
		                }
	                }
            	} else {
            		new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
            	}
            }
        });

        // 아이디 찾기 버튼
        jb_findId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindIdWindow();
                jf1.setVisible(false);
            }
        });

        // 비밀번호 찾기 버튼
        jb_findPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindPasswordWindow();
                jf1.setVisible(false);
            }
        });

        //회원가입 버튼
        jb_join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JoinWindow();
                jf1.setVisible(false);
            }
        });
    }
    
    public static void main(String[] args) {
         new LoginWindow();
    }
}
