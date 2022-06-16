package memberProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class putNewPassword {
	
	MemberDTO member = new MemberDTO();
	
    public putNewPassword(String id){
        JFrame jf1 = new JFrame();
        /** 패널 */
        JPanel jp1_center = new JPanel();       //라벨이 올라갈 패널
        JPanel jp2_east_next = new JPanel();    //다음버튼이 올라갈 패널
        /** 라벨 */
        JLabel jl1_check = new JLabel("새로운 비밀번호 입력");
        JLabel jl2_douleCheck = new JLabel("새로운 비밀번호 확인");
        /** 텍스트필드 */
        JPasswordField tf1 = new JPasswordField(20);
        JPasswordField tf2 = new JPasswordField(20);
        /** 버튼 */
        JButton jb1_next = new JButton("다음");
        /** 프레임, 패널 레이아웃 */
        jf1.setLayout(new BorderLayout());     // 프레임 레이아웃 나누고
        jf1.add(jp1_center, "Center");        // 프레임에 1번 패널 올리고, 1번 패널의 위치는 센터
        jf1.add(jp2_east_next, "East");

        jp1_center.add(jl1_check);
        jp1_center.add(tf1);
        jp1_center.add(jl2_douleCheck);
        jp1_center.add(tf2);


        jp2_east_next.add(jb1_next);

        jf1.setVisible(true);
        jf1.setSize(500,200);
        jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
        
        HashMap<String, MemberDTO> members = getMember();

        jb1_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String inPw1 = new String(tf1.getPassword());
				String inPw2 = new String(tf2.getPassword());
				
            	if (inPw1.equals("") || inPw2.equals(""))
            	{
            		new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
            	}
            	else
            	{
            		if(members.containsKey(id)){ //입력된 id와 같은 값
                		member = members.get(id);
    					members.remove(id);
    					String spw = new String(tf1.getPassword());
    					member.setPassword(spw);
    					members.put(id, member);
    					System.out.println(members.toString());
    				}	
    				
    				String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    				Matcher matcher1 = Pattern.compile(pwPattern).matcher(inPw1);
    				
    				if(!(inPw1.equals(inPw2))) {
    					new CommonPopup(8);		// "비밀번호가 일치하지 않습니다."
    					tf1.setText("");
    				}else if(!matcher1.matches()) {
    					new CommonPopup(6);		// "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요."
    					tf1.setText("");
    					tf2.setText("");
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
    					new PWchanged();
    					jf1.dispose();
    				}
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

}

