package update;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class SignUpWD implements ActionListener , KeyListener {
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JComboBox<String>> comboBoxs = new Hashtable<String,JComboBox<String>>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JPanel> panels = new Hashtable<String,JPanel>();
	JFrame frame = new JFrame("회원가입");

	SignUpWD() {
		panels();
		arrangement();
		frame();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		//회원가입 버튼을 눌렀을때
		if (e.getSource() == buttons.get("회원가입") ) {
			if (!new File("member").exists()) {
				try {
					new File("."+File.separator+ "member").mkdir();
				} catch (Exception memberE) {
					System.out.println(memberE + " => 파일쓰기 실패");
				}
			} 




			if (!labels.get("아이디체크").getText().equals("")
					||!labels.get("비밀번호체크").getText().equals("")
					||!labels.get("이름체크").getText().equals("")
					||!labels.get("성별체크").getText().equals("")
					||!labels.get("휴대폰번호체크").getText().equals("")
					||!labels.get("생년월일체크").getText().equals("")
					||!labels.get("학번체크").getText().equals("")
					||!labels.get("보물체크").getText().equals("")) {
				JOptionPane.showMessageDialog(null, "오류를 확인하세요");
			} else {
				if (textFields.get("아이디").getText().equals("")
						||String.valueOf(passwordFields.get("비밀번호").getPassword()).equals("")
						||textFields.get("이름").getText().equals("")
						||comboBoxs.get("성별").getSelectedItem().toString().equals("성별")
						||textFields.get("휴대폰번호").getText().equals("")
						||textFields.get("생년").getText().equals("")
						||comboBoxs.get("생월").getSelectedItem().toString().equals("월")
						||textFields.get("생일").getText().equals("")
						||textFields.get("학번").getText().equals("")
						||textFields.get("보물").getText().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 입력하세요");
				} else {

					//폴더위치
					String folderPath = "member"+File.separator+textFields.get("아이디").getText();
					//id.txt 위치
					String idPath = folderPath + File.separator + "id.txt";
					//password.txt 위치
					String passwordPath = folderPath + File.separator + "password.txt";
					//name.txt 위치
					String namePath = folderPath + File.separator + "name.txt";
					//gender.txt 위치
					String genderPath = folderPath + File.separator + "gender.txt";
					//callNum.txt 위치
					String callNumPath = folderPath + File.separator + "callNum.txt";
					//birth.txt 위치
					String birthPath = folderPath + File.separator + "birth.txt";
					//hakbun.txt 위치
					String hakbunPath = folderPath + File.separator + "hakbun.txt";
					//questions.txt 위치
					String questionsPath = folderPath + File.separator + "questions.txt";
					//java.txt 위치
					String javaPath = folderPath + File.separator + "java.txt";
					//web.txt 위치
					String webPath = folderPath + File.separator + "web.txt";
					//jsp.txt 위치
					String jspPath = folderPath + File.separator + "jsp.txt";

					FileOutputStream id = null;
					FileOutputStream password = null;
					FileOutputStream name = null;
					FileOutputStream gender = null;
					FileOutputStream callNum = null;
					FileOutputStream birth = null;
					FileOutputStream hakbun = null;
					FileOutputStream questions = null;
					FileOutputStream java = null;
					FileOutputStream web = null;
					FileOutputStream jsp = null;

					try {

						//folderPath 는 폴더 위치 mkdir 는 디렉토리를 make
						new File(folderPath).mkdir();

						id = new FileOutputStream(idPath);
						byte a[] = textFields.get("아이디").getText().getBytes();
						id.write(a);	

						password = new FileOutputStream(passwordPath);
						byte b[] = String.valueOf(passwordFields.get("비밀번호").getPassword()).getBytes();
						password.write(b);	

						name = new FileOutputStream(namePath);
						byte c[] = textFields.get("이름").getText().getBytes();
						name.write(c);	

						gender = new FileOutputStream(genderPath);
						byte d[] = comboBoxs.get("성별").getSelectedItem().toString().getBytes();
						gender.write(d);	

						callNum = new FileOutputStream(callNumPath);
						byte l[] = textFields.get("휴대폰번호").getText().getBytes();
						callNum.write(l);	

						birth = new FileOutputStream(birthPath);
						String birthAll = textFields.get("생년").getText() + comboBoxs.get("생월").getSelectedItem().toString() + (textFields.get("생일").getText());
						byte f[] = birthAll.getBytes();
						birth.write(f);	

						hakbun = new FileOutputStream(hakbunPath);
						byte g[] = textFields.get("학번").getText().getBytes();
						hakbun.write(g);	

						questions = new FileOutputStream(questionsPath);
						byte h[] = textFields.get("보물").getText().getBytes();
						questions.write(h);	

						java = new FileOutputStream(javaPath);
						byte i[] = ("0").getBytes();
						java.write(i);	

						web = new FileOutputStream(webPath);
						byte j[] = ("0").getBytes();
						web.write(j);	

						jsp = new FileOutputStream(jspPath);
						byte k[] = ("0").getBytes();
						jsp.write(k);	

						//로그인화면
						JOptionPane.showMessageDialog(null, "회원가입되었습니다");
						new LoginWD();
						frame.setVisible(false);

					} catch (Exception e2) {
						System.out.println(e2 + " => 파일쓰기 실패");
					} finally {
						try {
							//id.close();
						} catch (Exception e3) {
							System.out.println(e3 + " => close 실패");
						}
					}
				}

			}
		}
		
		//취소버튼 눌렀을때
		if (e.getSource() == buttons.get("취소") ) {
			new LoginWD();
			frame.setVisible(false);
		}
			
	}




	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}



	@Override
	public void keyReleased(KeyEvent e) {
		//아이디 체크 시작
		if (textFields.get("아이디").getText().equals("")) {
			if (!new String(passwordFields.get("비밀번호").getPassword()).equals(null)) {
				labels.get("아이디체크").setText("아이디를 입력하세요");
			} else {		
				labels.get("아이디체크").setText("");
			}
		}else  {
			byte[] idCheck  =textFields.get("아이디").getText().getBytes();
			if (textFields.get("아이디").getText().length() <2 || textFields.get("아이디").getText().length() > 20) {
				labels.get("아이디체크").setText("아이디 글자수를 확인해주세요");
			} else {
				for (int i = 0; i < idCheck.length; i++) {
					if (!Character.isLowerCase(idCheck[i]) && !Character.isDigit(idCheck[i])) {
						labels.get("아이디체크").setText("아이디는 영문 소문자, 숫자만 사용가능합니다");
					} else {
						if ((new File("."+File.separator+ "member"+File.separator+textFields.get("아이디").getText())).exists()) {
							labels.get("아이디체크").setText("중복된 아이디 입니다");
						} else {
							labels.get("아이디체크").setText("");

						}
					}
				}
			}
		}
		//아이디 체크 끝

		//비밀번호 체크 전체 시작
		//비밀번호 체크 시작
		String passwordA = new String(passwordFields.get("비밀번호").getPassword());
		String passwordB = new String(passwordFields.get("비밀번호확인").getPassword());
		byte[] passwordCheck  =passwordA.getBytes();
		if (passwordA.equals("")) {
			if (!passwordB.equals("")) {
				labels.get("비밀번호체크").setText("비밀번호를 입력하세요");
			} else {
				labels.get("비밀번호체크").setText("");
			}
		}else {
			if (passwordA.length() <2 
					|| passwordA.length() > 16) {
				labels.get("비밀번호체크").setText("비밀번호 글자수를 확인해주세요");
			} else {
				for (int i = 0; i < passwordCheck.length; i++) {
					if (!Character.isLowerCase(passwordCheck[i]) 
							&& !Character.isDigit(passwordCheck[i]) 
							&& !Character.isUpperCase(passwordCheck[i])) {
						labels.get("비밀번호체크").setText("비밀번호는 영문 대 소문자, 숫자만 사용가능합니다");
					} else {
						labels.get("비밀번호체크").setText("");

						//비밀번호 체크 끝

						//비밀번호 확인 체크 시작
						if (passwordFields.get("비밀번호확인").getPassword().equals(null)) {
							labels.get("비밀번호체크").setText("");
						} else  {

							if (!passwordB.equals(passwordA)) {
								labels.get("비밀번호체크").setText("비밀번호가 다릅니다");
							} else {
								labels.get("비밀번호체크").setText("");
							}	
						}
					}
					//비밀번호 확인 체크 끝
				}
			}
		}
		//비밀번호 체크 전체 끝

		//휴대폰번호 체크 시작
		if (textFields.get("휴대폰번호").getText().equals("")) {
			if (!new String(textFields.get("생년").getText()).equals("")) {
				labels.get("휴대폰번호체크").setText("휴대폰 번호를 입력하세요");
			} else {
				labels.get("휴대폰번호체크").setText("");							
			}
		}  else {
			byte[] callNumCheckA  =textFields.get("휴대폰번호").getText().getBytes();
			for (int i = 0; i < callNumCheckA.length; i++) {
				if (callNumCheckA.length != 11 
						||!Character.isDigit(callNumCheckA[i])) {
					labels.get("휴대폰번호체크").setText("휴대폰 번호를 확인하세요");
				} else {
					labels.get("휴대폰번호체크").setText("");
				}
			}
		}
		//휴대폰번호 체크 끝

		//생년 체크 시작
		if (new String(textFields.get("생년").getText()).equals("")) {
			if (!comboBoxs.get("생월").getSelectedItem().toString().equals("월")) {
				labels.get("생년월일체크").setText("태어난 년도를 입력하세요");
			} else {
				labels.get("생년월일체크").setText("");
			} 
		} else {
			byte[] yearCheckA =textFields.get("생년").getText().getBytes();
			for (int i = 0; i < yearCheckA.length; i++) {
				if (yearCheckA.length != 4 
						|| !Character.isDigit(yearCheckA[i])) {
					labels.get("생년월일체크").setText("태어난 년도는 4자리 숫자로 입력하세요");
				} else {
					labels.get("생년월일체크").setText("");
					//생년 체크 끝

						//생일 체크 시작
						if (textFields.get("생일").getText().equals("")) {
							if ((comboBoxs.get("생월").getSelectedItem()).toString().equals("월")) {
								labels.get("생년월일체크").setText("");
							} else {
								labels.get("생년월일체크").setText("태어난 월을 입력하세요");
							}
						} else {
							byte[] dayCheckA =textFields.get("생일").getText().getBytes();
							for (int j = 0; j < dayCheckA.length; j++) {
								if (!Character.isDigit(dayCheckA[j])) {
									labels.get("생년월일체크").setText("태어난 일은 숫자로 입력하세요");
								} else {
									switch ((comboBoxs.get("생월").getSelectedItem()).toString()) {
									case "01": case "03" : case "05" : case "07" : case "08" : case "10" : case "12" :
										if (Integer.parseInt(textFields.get("생일").getText()) < 0 
												||Integer.parseInt(textFields.get("생일").getText()) > 31  ) {
											labels.get("생년월일체크").setText("태어난 일을 확인해주세요");
										} else {
											labels.get("생년월일체크").setText("");
										}
										break;
									case "04" : case "06" : case "09" : case "11" : 
										if (Integer.parseInt(textFields.get("생일").getText()) < 0 
												||Integer.parseInt(textFields.get("생일").getText()) > 30  ) {
											labels.get("생년월일체크").setText("태어난 일을 확인해주세요");
										}else {
											labels.get("생년월일체크").setText("");
										}
										break;
									case "02" :
										if (Integer.parseInt(textFields.get("생일").getText()) < 0 
												||Integer.parseInt(textFields.get("생일").getText()) > 29  ) {
											labels.get("생년월일체크").setText("태어난 일을 확인해주세요");
										}else {
											labels.get("생년월일체크").setText("");
										}
										break;
									case "월" :{
											labels.get("생년월일체크").setText("");
									}
										break;
									}
								}
							}
						}
						//생일 체크 끝
					}

				}
			}
//		}
		//생일 전체 체크 끝

		//학번 체크 시작
		if (textFields.get("학번").getText().equals("")) {
			if (!textFields.get("보물").getText().equals("")) {
				labels.get("학번체크").setText("학번을 입력하세요");
			} else {
				labels.get("학번체크").setText("");							
			}
		}  else {
			byte[] hakbunCheckA  =textFields.get("학번").getText().getBytes();
			for (int k = 0; k < hakbunCheckA.length; k++) {
				if (hakbunCheckA.length != 6 
						||!Character.isDigit(hakbunCheckA[k])) {
					labels.get("학번체크").setText("학번을 확인하세요");
				} else {
					labels.get("학번체크").setText("");
				}
			}
		}
		//학번 체크 끝

		//		//보물 체크 시작
		//		if (textFields.get("보물").getText().equals("")) {
		//			if (!textFields.get("학번").getText().equals("")
		//					&&labels.get("이름").getText().equals("")
		//					&&labels.get("성별체크").getText().equals("")
		//					&&labels.get("휴대폰번호체크").getText().equals("")
		//					&&labels.get("생년월일체크").getText().equals("")
		//					&&labels.get("학번체크").getText().equals("")) {
		//				labels.get("보물체크").setText("질문의 답을 입력하세요");
		//			} else {
		//				labels.get("보물체크").setText("");							
		//			}
		//		}
	}
	//보물 체크 끝



	void setButtons(String K , String V , int x , int y , int width, int height) {
		buttons.put(K,new JButton(V));
		panels.get("전체").add(buttons.get(K));
		buttons.get(K).setBounds(x, y, width, height);
		buttons.get(K).addActionListener(this);
	}

	void setLabels(String K , String V , int x , int y , int width, int height) {
		labels.put(K,new JLabel(V));
		panels.get("전체").add(labels.get(K));
		labels.get(K).setBounds(x, y, width, height);
	}


	void setTextFields(String K , int x , int y , int width, int height) {
		textFields.put(K,new JTextField());
		panels.get("전체").add(textFields.get(K));
		textFields.get(K).setBounds(x, y, width, height);
		textFields.get(K).addKeyListener(this);
	}

	void setComboBoxs(String K , String[] V ,int x , int y , int width, int height) {
		comboBoxs.put(K,new JComboBox<>(V));
		panels.get("전체").add(comboBoxs.get(K));
		comboBoxs.get(K).setBounds(x, y, width, height);
		comboBoxs.get(K).addActionListener(this);
	}

	void setPasswordFields(String K ,int x , int y , int width, int height) {
		passwordFields.put(K,new JPasswordField());
		panels.get("전체").add(passwordFields.get(K));
		passwordFields.get(K).setBounds(x, y, width, height);
		passwordFields.get(K).addKeyListener(this);
	}

	void panels() {
		panels.put("전체",new JPanel());
		panels.get("전체").setLayout(null);
	}

	void frame() {
		frame.setLayout(new BorderLayout());
		frame.add(panels.get("전체"), "Center");

		//화면에 출력된다
		frame.setVisible(true);
		//Frame 사이즈 설정
		frame.setSize(500, 1000);
		//종료버튼을 만든다
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

	}

	void arrangement(){

		setLabels("아이디", "아이디 입력", 20, 20, 150, 30);

		int standardX = labels.get("아이디").getX();
		int standardY = labels.get("아이디").getY();
		int HeightY = labels.get("아이디").getHeight();
		int interval = 5;
		int n = 1;

		setTextFields("아이디", standardX, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("아이디설명", "*2~20자의 영문 소문자, 숫자만 사용가능합니다", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("아이디체크", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("비밀번호", "비밀번호 입력", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("비밀번호확인", "비밀번호 재입력", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);

		setPasswordFields("비밀번호", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setPasswordFields("비밀번호확인", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("비밀번호설명", "*2~16자 영문 대 소문자, 숫자만 사용가능합니다", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("비밀번호체크", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("여백", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("회원정보작성", "회원정보 작성", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("이름", "이름", standardX, standardY + (HeightY + interval)*n++, 220, HeightY);
		setTextFields("이름", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("이름체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("성별", "성별", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		String[] gender = {"성별","남자","여자","비공개"};
		setComboBoxs("성별", gender, standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("성별체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("휴대폰번호", "휴대폰 번호 (11자리 숫자만 입력하세요)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("휴대폰번호", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("휴대폰번호체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("생년월일", "생년월일", standardX, standardY + (HeightY + interval)*n, 400, HeightY);
		setLabels("생년월일체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);
		setTextFields("생년", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		String[] month = {"월","01","02","03","04","05","06","07","08","09","10","11","12"};
		setComboBoxs("생월", month, standardX+150, standardY + (HeightY + interval)*n, 150, HeightY);
		setTextFields("생일", standardX+300, standardY + (HeightY + interval)*n++, 150, HeightY);

		setLabels("학번", "학번(6자리 숫자만 입력하세요)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("학번", standardX, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("학번체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("보물", "나의 보물 1호는", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("보물", standardX, standardY + (HeightY + interval)*n++, 250, HeightY);

		setLabels("보물체크", "", standardX, 850, 400, 40);

		setButtons("취소", "취소", 230, 900, 100, 40);
		setButtons("회원가입", "회원가입", 350, 900, 100, 40);
	}


}
