package memberProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class MemberInfoWindow implements ActionListener{
	
	JFrame f; 
	JButton save;
	JTextArea ta;
	JLabel id, inputId, pw1, pw2, name, inputName, birth, inputBirth, gender, inputGender, email, inputEmail, phoneNum, inputPhoneNum;
	JPasswordField inputPw1, inputPw2;
	
	MemberDTO member = new MemberDTO();

	//객체 생성
	public MemberInfoWindow(String logID){
		f = new JFrame();
		id = new JLabel("ID :");
		inputId = new JLabel(logID);
		pw1 = new JLabel("비밀번호 : ");
		inputPw1 = new JPasswordField("");
		pw2 = new JLabel("비밀번호 재확인 : ");
		inputPw2 = new JPasswordField("");
		email = new JLabel("이메일 : ");
		inputEmail = new JLabel("");
		name = new JLabel("이름 : ");
		inputName = new JLabel("    ");
		birth = new JLabel("생년월일 : ");
		inputBirth = new JLabel("    ");
		phoneNum = new JLabel("연락처 : ");
		inputPhoneNum = new JLabel("");
		gender = new JLabel("성별 : ");
		inputGender = new JLabel(" ");
		save = new JButton("저장하기");
		
		addLayout();
		
		HashMap<String, MemberDTO> members = getMember();
		
		if(members.containsKey(logID)){ //입력된 id와 같은 값
			member = members.get(logID);
		}		
		inputEmail.setText(member.getMailAdress());
		inputName.setText(member.getMemberName());
		inputBirth.setText(member.getBirthDate());
		inputPhoneNum.setText(member.getPhoneNum());
		inputGender.setText(member.getGender());	

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(members.containsKey(logID)){ //입력된 id와 같은 값
					members.remove(logID);
					String spw = new String(inputPw1.getPassword());
					member.setPassword(spw);
					members.put(logID, member);
				}	
				
				String inPw1 = new String(inputPw1.getPassword());
				String inPw2 = new String(inputPw2.getPassword());
				
				String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
				Matcher matcher1 = Pattern.compile(pwPattern).matcher(inPw1);
				
				if(!(inPw1.equals(inPw2))) {
					JOptionPane.showMessageDialog(f, "비밀번호가 일치하지 않습니다.");
					inputPw2.setText("");
				}else if(!matcher1.matches()) {
					new CommonPopup(6);		// "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요."
					inputPw1.setText("");
					inputPw2.setText("");
				}else if(inPw1.equals("") || inPw2.equals("")) {
					new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
				}else {
					FileOutputStream fos = null;
					try {
						fos = new FileOutputStream("MemberDTO.txt");		
						String data = "";
						for(String s : members.keySet())
						{
							data += members.get(s) + "\r\n";
						}
						
						System.out.println(data);
						byte b[] = data.getBytes();
						fos.write(b);
					} catch (Exception e1) {
						System.out.println("...");
					} finally {
						try {
							fos.close();
						} catch (Exception e1) {
							System.out.println("...");
						}
					}
					
					new CommonPopup(10);	// "회원정보가 수정되었습니다."
					f.dispose();
					new LoginAfterWindow(logID);
				}
			}
		});
	
	}

	public HashMap<String, MemberDTO> getMember() {
		File info = new File("MemberDTO.txt");		 	 	
		FileInputStream fis = null;
		String data = null;
	     try{
	         fis = new FileInputStream(info);
	         byte[] b = new byte[fis.available()];
	         while(fis.read(b) != -1) {}
	         data = new String(b);
	     } catch (IOException e) { 
	    	 System.out.println("...");
	     } finally {
	    	 try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     
	     HashMap<String, MemberDTO> memberHash = new HashMap<String, MemberDTO>();
         String[] splitRN = data.split("\r\n");
         for(int i=0; i<splitRN.length; i++)
         {
        	 MemberDTO member = new MemberDTO();
        	 String[] splitSlash = splitRN[i].split("/");
        	 for(int j=0; j<splitSlash.length; j++)
        	 {
        		 if(j==0) member.setMemberId(splitSlash[j]);
        		 if(j==1) member.setPassword(splitSlash[j]);
        		 if(j==2) member.setMailAdress(splitSlash[j]);
        		 if(j==3) member.setMemberName(splitSlash[j]);
        		 if(j==4) member.setBirthDate(splitSlash[j]);
        		 if(j==5) member.setPhoneNum(splitSlash[j]);
        		 if(j==6) member.setGender(splitSlash[j]);
        		 if(j==7) member.setKorGrade(splitSlash[j]);
        		 if(j==8) member.setEngGrade(splitSlash[j]);
        		 if(j==9) member.setMathGrade(splitSlash[j]);
        		 if(j==10) member.setAverage(splitSlash[j]);
        	 }
        	 memberHash.put(member.getMemberId(), member);
         }      
         
         return memberHash;

	}

	//레이아웃
	void addLayout() {
		f.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jp1.add(save,"Center");
		f.add(jp1,BorderLayout.SOUTH);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(8,2));
		jp2.add(new JLabel("ID : "));
		jp2.add(inputId);
		jp2.add(new JLabel("비밀번호 : "));
		jp2.add(inputPw1);
		jp2.add(new JLabel("비밀번호 재확인 : "));
		jp2.add(inputPw2);
		jp2.add(new JLabel("이메일 : "));
		jp2.add(inputEmail);
		jp2.add(new JLabel("이름 : "));
		jp2.add(inputName);
		jp2.add(new JLabel("생년월일 : "));
		jp2.add(inputBirth); 
		jp2.add(new JLabel("연락처 : "));
		jp2.add(inputPhoneNum);
		jp2.add(new JLabel("성별 : "));
		jp2.add(inputGender);
		
		f.add(jp2,BorderLayout.WEST);
		f.setSize(300,500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}