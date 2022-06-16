package memberProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinWindow extends JFrame{
	//중복검사 click 건수
	static int doubleCheckCnt = 0;
			
	public JoinWindow() {
		//전체 JTextField
		JTextField id_fd = new JTextField();
		JPasswordField pw_fd = new JPasswordField();
		JPasswordField repw_fd = new JPasswordField();
		JTextField mailAdr_fd = new JTextField();
		JTextField memName_fd = new JTextField();
		JTextField phoneNum_fd = new JTextField();
		//title
		JLabel title_la = new JLabel("회 원 가 입");
		//전체 button
		JButton doubleCheckId_bt = new JButton("중복확인");
		JButton save_bt = new JButton("완료");
		//email combobox
		String[] mailAdr_comList = {"@naver.com", "@gmail.com", "@nate.com", "@daum.net"};
		JComboBox mailAdr_com = new JComboBox(mailAdr_comList);
		//생년월일 combobox
		//년
		String[] birthDateYear_comList = new String[113];
		for(int i = 0; i<birthDateYear_comList.length; i++) {
			birthDateYear_comList[i] = Integer.toString(1910+i)+"년";
		}
		JComboBox birthDateYear_com= new JComboBox(birthDateYear_comList);
		//월
		String[] birthDateMonth_comList = new String[12];
		for(int j = 0; j<birthDateMonth_comList.length; j++) {
			birthDateMonth_comList[j] = Integer.toString(1+j)+"월";
		}
		JComboBox birthDateMonth_com= new JComboBox(birthDateMonth_comList);
		//일
		String[] birthDateDay_comList = new String[31];
		for(int k = 0; k<birthDateDay_comList.length; k++) {
			birthDateDay_comList[k] = Integer.toString(1+k)+"일";
		}
		JComboBox birthDateDay_com= new JComboBox(birthDateDay_comList);
		//gender combobox
		String[] gender_comList = {"남", "여"};
		JComboBox gender_com = new JComboBox(gender_comList);
		
		//전체 Layout
		setLayout(new BorderLayout());
		//north Layout
		setTitle("그린대학교 회원가입");
		JPanel title_pn = new JPanel();
		title_pn.setLayout(new FlowLayout(FlowLayout.CENTER));
		title_la.setOpaque(true);
		//title_la.setBackground(Color.darkGray);
		title_la.setForeground(Color.DARK_GRAY);
		title_la.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		title_pn.add(title_la);
		add(title_pn, BorderLayout.NORTH);
		
		//center Layout
		JPanel allInfo_pn = new JPanel();
		allInfo_pn.setLayout(new GridLayout(1,3));
		
		JPanel line1 = new JPanel();
		line1.setLayout(new GridLayout(8,1));
		line1.add(new JLabel("   I D   :   "));
		line1.add(new JLabel("   P . W .   :   "));
		line1.add(new JLabel("   P . W .  재 입 력   :   "));
		line1.add(new JLabel("   E - m a i l  주  소   :   "));
		line1.add(new JLabel("   이 름   :   "));
		line1.add(new JLabel("   생 년 월 일   :   "));
		line1.add(new JLabel("   핸 드 폰  번 호   :   "));
		line1.add(new JLabel("   성 별   :   "));
		add(line1, BorderLayout.WEST);
		
		JPanel line2 = new JPanel();
		line2.setLayout(new GridLayout(8,1));
		line2.add(id_fd);
		line2.add(pw_fd);
		line2.add(repw_fd);
		line2.add(mailAdr_fd);
		line2.add(memName_fd);
		JPanel birthDateYMD_com = new JPanel();
		birthDateYMD_com.setLayout(new GridLayout(1,3));
		birthDateYMD_com.add(birthDateYear_com);birthDateYMD_com.add(birthDateMonth_com);birthDateYMD_com.add(birthDateDay_com);
		line2.add(birthDateYMD_com);
		line2.add(phoneNum_fd);
		line2.add(gender_com);
		add(line2, BorderLayout.CENTER);
		
		JPanel line3 = new JPanel();
		line3.setLayout(new GridLayout(8,1));
		line3.add(doubleCheckId_bt);
		line3.add(new JLabel("   8자리 이상, 대소문자·특수문자 포함"));
		line3.add(new JLabel(""));
		line3.add(mailAdr_com);
		line3.add(new JLabel(""));
		line3.add(new JLabel(""));
		line3.add(new JLabel("   11자리수 입력"));
		line3.add(new JLabel(""));
		add(line3, BorderLayout.EAST);
		
		allInfo_pn.add(line1);
		allInfo_pn.add(line2);
		allInfo_pn.add(line3);
		add(allInfo_pn, BorderLayout.CENTER);
		
		
//		JPanel allInfo_pn = new JPanel();
//		allInfo_pn.setLayout(new GridLayout(8,1));
//		
//		//id panel
//		JPanel id_pn = new JPanel();
//		id_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		id_pn.add(new JLabel("ID : "));
//		id_pn.add(id_fd);
//		id_pn.add(doubleCheckId_bt);
//		//pw panel
//		JPanel pw_pn = new JPanel();
//		pw_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		pw_pn.add(new JLabel("P.W. : "));
//		pw_pn.add(pw_fd);
//		pw_pn.add(new JLabel("8자리 이상, 대소문자와 특수문자를 포함한 비밀번호"));
//		//repw panel
//		JPanel repw_pn = new JPanel();
//		repw_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		repw_pn.add(new JLabel("P.W.재입력 : "));
//		repw_pn.add(repw_fd);
//		//mailAdr panel
//		JPanel mailAdr_pn = new JPanel();
//		mailAdr_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		mailAdr_pn.add(new JLabel("E-mail 주소 : "));
//		mailAdr_pn.add(mailAdr_fd);
//		mailAdr_pn.add(mailAdr_com);
//		//name panel
//		JPanel memName_pn = new JPanel();
//		memName_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		memName_pn.add(new JLabel("이름 : "));
//		memName_pn.add(memName_fd);
//		//birthDate panel
//		JPanel birthDate_pn = new JPanel();
//		birthDate_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		birthDate_pn.add(new JLabel("생년월일 : "));
//		birthDate_pn.add(birthDateYear_com);
//		birthDate_pn.add(birthDateMonth_com);
//		birthDate_pn.add(birthDateDay_com);
//		//name panel
//		JPanel phoneNum_pn = new JPanel();
//		phoneNum_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		phoneNum_pn.add(new JLabel("핸드폰 번호 : "));
//		phoneNum_pn.add(phoneNum_fd);
//		//gender panel
//		JPanel gender_pn = new JPanel();
//		gender_pn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		gender_pn.add(new JLabel("성별 : "));
//		gender_pn.add(gender_com);
//		
//		allInfo_pn.add(id_pn);
//		allInfo_pn.add(pw_pn);
//		allInfo_pn.add(repw_pn);
//		allInfo_pn.add(mailAdr_pn);
//		allInfo_pn.add(memName_pn);
//		allInfo_pn.add(birthDate_pn);
//		allInfo_pn.add(phoneNum_pn);
//		allInfo_pn.add(gender_pn);
//		
//		add(allInfo_pn, BorderLayout.CENTER);
		
		//south Layout
		JPanel save_pn = new JPanel();
		save_pn.setLayout(new FlowLayout());
		save_pn.add(save_bt);
		
		add(save_pn, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(700,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//save 버튼 동작
		save_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//member DTO
				String save_id = id_fd.getText();
				String save_pw = new String(pw_fd.getPassword());
				String save_repw = new String(repw_fd.getPassword());
				String save_mailAdr = mailAdr_fd.getText() + mailAdr_com.getSelectedItem();
				String save_memName = memName_fd.getText();
				String save_birthDate = (String) birthDateYear_com.getSelectedItem() + 
												 birthDateMonth_com.getSelectedItem() + birthDateDay_com.getSelectedItem();
				String save_phoneNum = phoneNum_fd.getText();
				String save_gender = (String) gender_com.getSelectedItem();
				/*int MIN = 8;
			  	int MAX = 20;
			  	String pwCondition =  "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{" + MIN + "," + MAX + "})$";*/
				//grade DTO
				int korGrade = (int)(Math.random()*100+1);
				int engGrade = (int)(Math.random()*100+1);
				int mathGrade = (int)(Math.random()*100+1);
				double avg = (korGrade + engGrade + mathGrade)/3;
				String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
				Matcher matcher = Pattern.compile(pwPattern).matcher(save_pw);
			
				String saveAll = save_id + "/" + save_pw + "/" + save_mailAdr + "/" + save_memName + "/" + 
								 save_birthDate + "/" + save_phoneNum  + "/" + save_gender + "/" +
								 korGrade + "/" + engGrade + "/" + mathGrade +  "/" + avg + "\r\n";
				System.out.println(saveAll);
				if((id_fd.getText()).equals("") || save_pw.equals("") || save_repw.equals("") || (mailAdr_fd.getText()).equals("") || 
					(memName_fd.getText()).equals("") || (phoneNum_fd.getText()).equals("")) {
					new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
				}else if(doubleCheckCnt == 0) {
					new CommonPopup(5);		// "중복검사 버튼을 클릭하세요."
				}else if(!(save_pw.equals(save_repw))) {
					new CommonPopup(8);		// "비밀번호가 일치하지 않습니다."
					repw_fd.setText("");
				}else if(!matcher.matches()) {
					new CommonPopup(6);		// "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요."
					repw_fd.setText("");
				}else if((phoneNum_fd.getText()).length() != 11){
					new CommonPopup(18);	// "핸드폰 번호를 11자리수로 입력하세요."
				}
				else {
					//saveAll 정보들을 memberDTO.txt 로 output
					FileOutputStream fo = null;
					try {
						fo = new FileOutputStream("memberDTO.txt", true); //true 값을 줘야 다음 정보를 넣었을 때 그 전의 정보가 삭제되지 않는다.
						byte saveByte[] = saveAll.getBytes();
						fo.write(saveByte);
						new CommonPopup(9);	// "회원가입 되었습니다."
						dispose();
						new LoginWindow();
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//double check 중복확인 버튼 동작
		doubleCheckId_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String doubleCheck_id = id_fd.getText();
				
				File file = new File("memberDTO.txt");
				
				// 1. check if the file exists or not
				if(file.exists()) {
					FileInputStream fi = null;
					String data = null;
					try {
						
						fi = new FileInputStream("memberDTO.txt");
						
						byte dcByte[] = new byte[fi.available()];
						
						while (fi.read(dcByte) != -1) {}
						data = new String(dcByte);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					//split 관련, id 중복검사
					HashMap<String, MemberDTO> memberHash = new HashMap<>();
					String[] splitRN = data.split("\r\n");
					for(int i = 0; i <splitRN.length; i++) {
						MemberDTO member = new MemberDTO();
						String[] splitSlash = splitRN[i].split("/");
						for(int j = 0; j<splitSlash.length; j++) {
							if(j==0) {
								member.setMemberId(splitSlash[0]);
							}
						}
						memberHash.put(member.getMemberId(), member);
					}
					
					//System.out.println(memberHash.toString());
					if(memberHash.containsKey(doubleCheck_id))
					{
						new CommonPopup(2);	// "이미 존재하는 아이디입니다."
						id_fd.setText("");
					}
					else if ((id_fd.getText()).equals(""))
					{
						new CommonPopup(1);	// "빈값은 입력할 수 없습니다."
					}
					else 
					{
						doubleCheckCnt++;
						new CommonPopup(3); // "사용할 수 있는 아이디입니다."
					}
				}
				else if ((id_fd.getText()).equals(""))
				{
					new CommonPopup(1);	// "빈값은 입력할 수 없습니다."
				}
				else
				{
					doubleCheckCnt++;
					new CommonPopup(3); // "사용할 수 있는 아이디입니다."
				}
				
				/*
				// ArrayList 사용한 예제
				ArrayList<String> idList = new ArrayList<String>(); //배열로 만들어도 되는데 사람의 개수가 정해지지 않아서 ArrayList 로 함. 그리고 contains 를 쓰기 위해 ArrayList 를 씀.
				String[] splitRN = data.split("\r\n");
				for(int i=0; i<splitRN.length; i++) {
					String[] splitSlash = splitRN[i].split("/");
					for(int j=0; j<splitSlash.length; j++) {
						if(j==0) idList.add(splitSlash[0]);
					}
				}
				if(idList.contains(id_fd.getText())) {
					new CommonPopup(2);
					id_fd.setText("");
				}
				else {
					doubleCheckCnt++;
					new CommonPopup(3);
				}
				*/
			}
		});
	}	
}

