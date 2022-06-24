package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;


class SignUp implements ActionListener , KeyListener {
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JLabel>checkLabels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JComboBox<String>> comboBoxs = new Hashtable<String,JComboBox<String>>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JPanel> panels = new Hashtable<String,JPanel>();
	JFrame frame = new JFrame("회원가입");
	ImageIcon bonobono = new ImageIcon("src/com/lhj/image/bonobono.jpg");
	Image img = bonobono.getImage();
	

	SignUp() {
		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();
		panels();
		arrangement();
		frame();	
	}

	//ActionListener 시작
	@Override
	public void actionPerformed(ActionEvent e) {	

		//회원가입 버튼 눌렀을때 시작
		if (e.getSource() == buttons.get("회원가입") ) {

			//오류체크에 아무것도 뜨지 않았을때
			if (isAllErrorCheck()) {
				JOptionPane.showMessageDialog(null, "오류를 확인하세요", "입력값 오류", JOptionPane.ERROR_MESSAGE);

				//입력안한 칸이 없을때
			} else if(isAllBlankCheck()) {
				JOptionPane.showMessageDialog(null, "빈칸을 입력하세요" ,"빈칸 오류", JOptionPane.ERROR_MESSAGE);

				//오류가 없고 빈칸이 없을때
				//회원가입 시작
			} else {
				sourceDTO.setName(textFields.get("이름").getText());
				sourceDTO.setCallNum(textFields.get("휴대폰번호").getText());
				sourceDTO.setId(textFields.get("아이디").getText());
				sourceDTO.setPassword(String.valueOf(passwordFields.get("비밀번호").getPassword()));
				sourceDTO.setQuestions(textFields.get("보물").getText());
				sourceDTO.setGender(comboBoxs.get("성별").getSelectedItem().toString());
				sourceDTO.setBirth(Integer.parseInt(textFields.get("생년").getText() + comboBoxs.get("생월").getSelectedItem().toString() + (textFields.get("생일").getText())));
				sourceDTO.setHakbun(Integer.parseInt(textFields.get("학번").getText()));
				sourceDTO.setJava(0);
				sourceDTO.setWeb(0);
				sourceDTO.setJsp(0);

				totalDAO.signUp(sourceDTO);
				//로그인화면
				JOptionPane.showMessageDialog(null, "회원가입되었습니다", "회원가입 완료" , JOptionPane.PLAIN_MESSAGE);
				new Login();
				frame.setVisible(false);
			}

		}
		//회원가입 버튼 눌렀을때 끝


		//취소 버튼 눌렀을때 시작
		if (e.getSource() == buttons.get("취소") ) {
			new Login();
			frame.setVisible(false);
		}
		//취소 버튼 눌렀을때 끝
	}
	//ActionListener 끝

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}



	@Override
	public void keyReleased(KeyEvent e) {

		//아이디 체크 시작
		//아이디를 입력안했을때 체크 시작
		if (textFields.get("아이디").getText().equals("")) {
			//아이디를 입력안하고 비밀번호를 입력했을때
			if (!new String(passwordFields.get("비밀번호").getPassword()).equals(null)) {
				checkLabels.get("아이디체크").setText("아이디를 입력하세요");
				//아이디를 입력안했을때(초기화면)
			}else {
				checkLabels.get("아이디체크").setText("");
			}
		} 
		//아이디를 입력안했을때 체크 끝
		//아이디를 입력했을때 체크 시작
		else {
			//이이디 글자수 제한에 맞지 않을때
			if (textFields.get("아이디").getText().length() <2 || textFields.get("아이디").getText().length() > 20) {
				checkLabels.get("아이디체크").setText("아이디 글자수를 확인해주세요");
			}else {
				byte[] idCheck  =textFields.get("아이디").getText().getBytes();
				for (int i = 0; i < idCheck.length; i++) {
					//아이디가 소문자,숫자가 아닐때
					if (!Character.isLowerCase(idCheck[i]) && !Character.isDigit(idCheck[i])) {
						checkLabels.get("아이디체크").setText("아이디는 영문 소문자, 숫자만 사용가능합니다");
						break;
					} else {
						sourceDTO.setId(textFields.get("아이디").getText()); 
						List<SourceDTO> list = totalDAO.lookUpById(sourceDTO);
						//아이디가 중복되었을때
						if (list.size() != 0) {
							checkLabels.get("아이디체크").setText("중복된 아이디 입니다");
							//문제없을때
						} else {
							checkLabels.get("아이디체크").setText("");
						}
					}
				}
			}
		}
		//아이디를 입력했을때 체크 끝
		//아이디체크 끝

		//비밀번호 체크 전체 시작
		//비밀번호 체크 시작
		String passwordA = new String(passwordFields.get("비밀번호").getPassword());
		String passwordB = new String(passwordFields.get("비밀번호확인").getPassword());
		byte[] passwordCheck  =passwordA.getBytes();
		if (passwordA.equals("")) {
			if (!passwordB.equals("")) {
				checkLabels.get("비밀번호체크").setText("비밀번호를 입력하세요");
			} else {
				checkLabels.get("비밀번호체크").setText("");
			}
		}else {
			if (passwordA.length() <2 
					|| passwordA.length() > 16) {
				checkLabels.get("비밀번호체크").setText("비밀번호 글자수를 확인해주세요");
			} else {
				for (int i = 0; i < passwordCheck.length; i++) {
					if (!Character.isLowerCase(passwordCheck[i]) 
							&& !Character.isDigit(passwordCheck[i]) 
							&& !Character.isUpperCase(passwordCheck[i])) {
						checkLabels.get("비밀번호체크").setText("비밀번호는 영문 대 소문자, 숫자만 사용가능합니다");
					} else {
						checkLabels.get("비밀번호체크").setText("");

						//비밀번호 체크 끝

						//비밀번호 확인 체크 시작
						if (String.valueOf(passwordFields.get("비밀번호확인").getPassword()).equals("")) {
							checkLabels.get("비밀번호체크").setText("");
						} else  {

							if (!passwordB.equals(passwordA)) {
								checkLabels.get("비밀번호체크").setText("비밀번호가 다릅니다");
							} else {
								checkLabels.get("비밀번호체크").setText("");
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
				checkLabels.get("휴대폰번호체크").setText("휴대폰 번호를 입력하세요");
			} else {
				checkLabels.get("휴대폰번호체크").setText("");							
			}
		}  else {
			byte[] callNumCheckA  =textFields.get("휴대폰번호").getText().getBytes();
			for (int i = 0; i < callNumCheckA.length; i++) {
				if (callNumCheckA.length != 11 
						||!Character.isDigit(callNumCheckA[i])) {
					checkLabels.get("휴대폰번호체크").setText("휴대폰 번호를 확인하세요");
				} else {
					checkLabels.get("휴대폰번호체크").setText("");
				}
			}
		}
		//휴대폰번호 체크 끝

		//생년 체크 시작
		if (new String(textFields.get("생년").getText()).equals("")) {
			if (!comboBoxs.get("생월").getSelectedItem().toString().equals("월")) {
				checkLabels.get("생년월일체크").setText("태어난 년도를 입력하세요");
			} else {
				checkLabels.get("생년월일체크").setText("");
			} 
		} else {
			byte[] yearCheckA =textFields.get("생년").getText().getBytes();
			for (int i = 0; i < yearCheckA.length; i++) {
				if (yearCheckA.length != 4 
						|| !Character.isDigit(yearCheckA[i])) {
					checkLabels.get("생년월일체크").setText("태어난 년도는 4자리 숫자로 입력하세요");
				} else {
					checkLabels.get("생년월일체크").setText("");
					//생년 체크 끝

					//생일 체크 시작
					if (textFields.get("생일").getText().equals("")) {
						if ((comboBoxs.get("생월").getSelectedItem()).toString().equals("월")) {
							checkLabels.get("생년월일체크").setText("");
						} else {
							checkLabels.get("생년월일체크").setText("태어난 일을 입력하세요");
						}
					} else {
						byte[] dayCheckA =textFields.get("생일").getText().getBytes();
						for (int j = 0; j < dayCheckA.length; j++) {
							if (!Character.isDigit(dayCheckA[j])) {
								checkLabels.get("생년월일체크").setText("태어난 일은 숫자로 입력하세요");
							} else {
								switch ((comboBoxs.get("생월").getSelectedItem()).toString()) {
								case "01": case "03" : case "05" : case "07" : case "08" : case "10" : case "12" :
									if (Integer.parseInt(textFields.get("생일").getText()) < 0 
											||Integer.parseInt(textFields.get("생일").getText()) > 31  ) {
										checkLabels.get("생년월일체크").setText("태어난 일을 확인해주세요");
									} else {
										checkLabels.get("생년월일체크").setText("");
									}
									break;
								case "04" : case "06" : case "09" : case "11" : 
									if (Integer.parseInt(textFields.get("생일").getText()) < 0 
											||Integer.parseInt(textFields.get("생일").getText()) > 30  ) {
										checkLabels.get("생년월일체크").setText("태어난 일을 확인해주세요");
									}else {
										checkLabels.get("생년월일체크").setText("");
									}
									break;
								case "02" :
									if (Integer.parseInt(textFields.get("생일").getText()) < 0 
											||Integer.parseInt(textFields.get("생일").getText()) > 29  ) {
										checkLabels.get("생년월일체크").setText("태어난 일을 확인해주세요");
									}else {
										checkLabels.get("생년월일체크").setText("");
									}
									break;
								case "월" :{
									checkLabels.get("생년월일체크").setText("");
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
		//
		//생일 전체 체크 끝

		//학번 체크 시작
		if (textFields.get("학번").getText().equals("")) {
			if (!textFields.get("보물").getText().equals("")) {
				checkLabels.get("학번체크").setText("학번을 입력하세요");
			} else {
				checkLabels.get("학번체크").setText("");							
			}
		}  else {
			byte[] hakbunCheckA  =textFields.get("학번").getText().getBytes();
			for (int k = 0; k < hakbunCheckA.length; k++) {
				if (hakbunCheckA.length != 6 
						||!Character.isDigit(hakbunCheckA[k])) {
					checkLabels.get("학번체크").setText("학번을 확인하세요");
				} else {
					checkLabels.get("학번체크").setText("");
				}
			}
		}
		//학번 체크 끝
	}



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

	void setcheckLabels(String K , String V , int x , int y , int width, int height) {
		checkLabels.put(K,new JLabel(V));
		panels.get("전체").add(checkLabels.get(K));
		checkLabels.get(K).setBounds(x, y, width, height);
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
		
		panels.put("전체",new JPanel(){
	           /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	            protected void paintComponent(Graphics g){
	               super.paintComponent(g);
	               g.drawImage(img, 350, 50, 100, 100, this);
	            }
	        });
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

		setcheckLabels("아이디체크", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("비밀번호", "비밀번호 입력", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("비밀번호확인", "비밀번호 재입력", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);

		setPasswordFields("비밀번호", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setPasswordFields("비밀번호확인", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("비밀번호설명", "*2~16자 영문 대 소문자, 숫자만 사용가능합니다", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setcheckLabels("비밀번호체크", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("여백", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("회원정보작성", "회원정보 작성", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("이름", "이름", standardX, standardY + (HeightY + interval)*n++, 220, HeightY);
		setTextFields("이름", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setcheckLabels("이름체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("성별", "성별", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		String[] gender = {"성별","man","woman","private"};
		setComboBoxs("성별", gender, standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setcheckLabels("성별체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("휴대폰번호", "휴대폰 번호 (11자리 숫자만 입력하세요)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("휴대폰번호", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setcheckLabels("휴대폰번호체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("생년월일", "생년월일", standardX, standardY + (HeightY + interval)*n, 400, HeightY);
		setcheckLabels("생년월일체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);
		setTextFields("생년", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		String[] month = {"월","01","02","03","04","05","06","07","08","09","10","11","12"};
		setComboBoxs("생월", month, standardX+150, standardY + (HeightY + interval)*n, 150, HeightY);
		setTextFields("생일", standardX+300, standardY + (HeightY + interval)*n++, 150, HeightY);

		setLabels("학번", "학번(6자리 숫자만 입력하세요)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("학번", standardX, standardY + (HeightY + interval)*n++, 150, HeightY);
		setcheckLabels("학번체크", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("보물", "나의 보물 1호는", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("보물", standardX, standardY + (HeightY + interval)*n++, 250, HeightY);

		setcheckLabels("보물체크", "", standardX, 850, 400, 40);

		setButtons("취소", "취소", 230, 900, 100, 40);
		setButtons("회원가입", "회원가입", 350, 900, 100, 40);
	}

	boolean isAllErrorCheck() {
		boolean errorCheck = false;
		for (String key : checkLabels.keySet()) {
			if (!checkLabels.get(key).getText().equals("")) {
				errorCheck = true;
				break;
			}
		}
		return errorCheck;
	}

	boolean isAllBlankCheck() {
		boolean blankCheck = false;
		for (String key : textFields.keySet()) {
			if (textFields.get(key).getText().equals("")) {
				blankCheck = true;
				break;
			}
		}

		if (comboBoxs.get("성별").getSelectedItem().toString().equals("성별")) {
			blankCheck = true;
		}

		if (comboBoxs.get("생월").getSelectedItem().toString().equals("월")) {
			blankCheck = true;
		}

		return blankCheck;
	}


}
