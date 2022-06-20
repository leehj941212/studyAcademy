package teamProjectDB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	SourceDTO student = new SourceDTO();
	MemberAct act = new MemberAct();

	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JLabel>checkLabels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JComboBox<String>> comboBoxs = new Hashtable<String,JComboBox<String>>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JPanel> panels = new Hashtable<String,JPanel>();
	JFrame frame = new JFrame("ȸ������");

	SignUpWD() {
		act.connectMysql();
		panels();
		arrangement();
		frame();	
	}

	//ActionListener ����
	@Override
	public void actionPerformed(ActionEvent e) {	

		//ȸ������ ��ư �������� ����
		if (e.getSource() == buttons.get("ȸ������") ) {

			//����üũ�� �ƹ��͵� ���� �ʾ�����
			if (!checkLabels.get("���̵�üũ").getText().equals("")
					||!checkLabels.get("��й�ȣüũ").getText().equals("")
					||!checkLabels.get("�̸�üũ").getText().equals("")
					||!checkLabels.get("����üũ").getText().equals("")
					||!checkLabels.get("�޴�����ȣüũ").getText().equals("")
					||!checkLabels.get("�������üũ").getText().equals("")
					||!checkLabels.get("�й�üũ").getText().equals("")
					||!checkLabels.get("����üũ").getText().equals("")) {
				JOptionPane.showMessageDialog(null, "������ Ȯ���ϼ���");

				//�Է¾��� ĭ�� ������
			} else if(textFields.get("���̵�").getText().equals("")
					||String.valueOf(passwordFields.get("��й�ȣ").getPassword()).equals("")
					||textFields.get("�̸�").getText().equals("")
					||comboBoxs.get("����").getSelectedItem().toString().equals("����")
					||textFields.get("�޴�����ȣ").getText().equals("")
					||textFields.get("����").getText().equals("")
					||comboBoxs.get("����").getSelectedItem().toString().equals("��")
					||textFields.get("����").getText().equals("")
					||textFields.get("�й�").getText().equals("")
					||textFields.get("����").getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��ĭ�� �Է��ϼ���");

				//������ ���� ��ĭ�� ������
				//ȸ������ ����
			} else {
				student.setName(textFields.get("�̸�").getText());
				student.setCallNum(textFields.get("�޴�����ȣ").getText());
				student.setId(textFields.get("���̵�").getText());
				student.setPassword(String.valueOf(passwordFields.get("��й�ȣ").getPassword()));
				student.setQuestions(textFields.get("����").getText());
				student.setGender(comboBoxs.get("����").getSelectedItem().toString());
				student.setBirth(Integer.parseInt(textFields.get("����").getText() + comboBoxs.get("����").getSelectedItem().toString() + (textFields.get("����").getText())));
				student.setHakbun(Integer.parseInt(textFields.get("�й�").getText()));
				student.setJava(0);
				student.setWeb(0);
				student.setJsp(0);

				String sql = "insert into teamproject values('"
						+student.getName()+"' , '" 
						+ student.getCallNum()+ "' , '" 
						+ student.getId()+ "' , '" 
						+ student.getPassword()+ "' , '" 
						+ student.getQuestions()+ "' , '" 
						+ student.getGender()+ "' , " 
						+ student.getBirth()+ " , " 
						+ student.getHakbun()+ " , " 
						+student.getJava()+ " , " 
						+student.getWeb()+ " , " 
						+student.getJsp()+")";

				act.executeMysql(sql);

				try {
					//�α���ȭ��
					JOptionPane.showMessageDialog(null, "ȸ�����ԵǾ����ϴ�");
					new LoginWD();
					frame.setVisible(false);

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		}
		//ȸ������ ��ư �������� ��


		//��� ��ư �������� ����
		if (e.getSource() == buttons.get("���") ) {
			new LoginWD();
			frame.setVisible(false);
		}
		//��� ��ư �������� ��
	}
	//ActionListener ��

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}



	@Override
	public void keyReleased(KeyEvent e) {

		if (textFields.get("���̵�").getText().equals("")) {
			if (!new String(passwordFields.get("��й�ȣ").getPassword()).equals(null)) {
				checkLabels.get("���̵�üũ").setText("���̵� �Է��ϼ���");
			} else {		
				checkLabels.get("���̵�üũ").setText("");
			}
		}else  {
			byte[] idCheck  =textFields.get("���̵�").getText().getBytes();
			if (textFields.get("���̵�").getText().length() <2 || textFields.get("���̵�").getText().length() > 20) {
				checkLabels.get("���̵�üũ").setText("���̵� ���ڼ��� Ȯ�����ּ���");
			} else {
				for (int i = 0; i < idCheck.length; i++) {
					if (!Character.isLowerCase(idCheck[i]) && !Character.isDigit(idCheck[i])) {
						checkLabels.get("���̵�üũ").setText("���̵�� ���� �ҹ���, ���ڸ� ��밡���մϴ�");
						break;			
					} else {
						if (act.idLookUp(textFields.get("���̵�").getText())) {
							checkLabels.get("���̵�üũ").setText("�ߺ��� ���̵� �Դϴ�");
						} else {
							checkLabels.get("���̵�üũ").setText("");

						}
					}
				}
			}
		}









		//���̵� üũ ����
		//���̵� �Է¾������� üũ ����
		if (textFields.get("���̵�").getText().equals("")) {
			//���̵� �Է¾��ϰ� ��й�ȣ�� �Է�������
			if (!new String(passwordFields.get("��й�ȣ").getPassword()).equals(null)) {
				checkLabels.get("���̵�üũ").setText("���̵� �Է��ϼ���");
				//���̵� �Է¾�������(�ʱ�ȭ��)
			}else {
				checkLabels.get("���̵�üũ").setText("");
			}
		} 
		//���̵� �Է¾������� üũ ��
		//���̵� �Է������� üũ ����
		else {
			//���̵� ���ڼ� ���ѿ� ���� ������
			if (textFields.get("���̵�").getText().length() <2 || textFields.get("���̵�").getText().length() > 20) {
				checkLabels.get("���̵�üũ").setText("���̵� ���ڼ��� Ȯ�����ּ���");
			}else {
				byte[] idCheck  =textFields.get("���̵�").getText().getBytes();
				for (int i = 0; i < idCheck.length; i++) {
					//���̵� �ҹ���,���ڰ� �ƴҶ�
					if (!Character.isLowerCase(idCheck[i]) && !Character.isDigit(idCheck[i])) {
						checkLabels.get("���̵�üũ").setText("���̵�� ���� �ҹ���, ���ڸ� ��밡���մϴ�");
						break;
						//���̵� �ߺ��Ǿ�����
					} else if (act.idLookUp(textFields.get("���̵�").getText())) {
						checkLabels.get("���̵�üũ").setText("�ߺ��� ���̵� �Դϴ�");
						//����������
					} else {
						checkLabels.get("���̵�üũ").setText("");
					}
				}
			}
		}
		//���̵� �Է������� üũ ��
		//���̵�üũ ��

		//��й�ȣ üũ ��ü ����
				//��й�ȣ üũ ����
				String passwordA = new String(passwordFields.get("��й�ȣ").getPassword());
				String passwordB = new String(passwordFields.get("��й�ȣȮ��").getPassword());
				byte[] passwordCheck  =passwordA.getBytes();
				if (passwordA.equals("")) {
					if (!passwordB.equals("")) {
						checkLabels.get("��й�ȣüũ").setText("��й�ȣ�� �Է��ϼ���");
					} else {
						checkLabels.get("��й�ȣüũ").setText("");
					}
				}else {
					if (passwordA.length() <2 
							|| passwordA.length() > 16) {
						checkLabels.get("��й�ȣüũ").setText("��й�ȣ ���ڼ��� Ȯ�����ּ���");
					} else {
						for (int i = 0; i < passwordCheck.length; i++) {
							if (!Character.isLowerCase(passwordCheck[i]) 
									&& !Character.isDigit(passwordCheck[i]) 
									&& !Character.isUpperCase(passwordCheck[i])) {
								checkLabels.get("��й�ȣüũ").setText("��й�ȣ�� ���� �� �ҹ���, ���ڸ� ��밡���մϴ�");
							} else {
								checkLabels.get("��й�ȣüũ").setText("");

								//��й�ȣ üũ ��

								//��й�ȣ Ȯ�� üũ ����
								if (passwordFields.get("��й�ȣȮ��").getPassword().equals(null)) {
									checkLabels.get("��й�ȣüũ").setText("");
								} else  {

									if (!passwordB.equals(passwordA)) {
										checkLabels.get("��й�ȣüũ").setText("��й�ȣ�� �ٸ��ϴ�");
									} else {
										checkLabels.get("��й�ȣüũ").setText("");
									}	
								}
							}
							//��й�ȣ Ȯ�� üũ ��
						}
					}
				}
				//��й�ȣ üũ ��ü ��

		//�޴�����ȣ üũ ����
		if (textFields.get("�޴�����ȣ").getText().equals("")) {
			if (!new String(textFields.get("����").getText()).equals("")) {
				checkLabels.get("�޴�����ȣüũ").setText("�޴��� ��ȣ�� �Է��ϼ���");
			} else {
				checkLabels.get("�޴�����ȣüũ").setText("");							
			}
		}  else {
			byte[] callNumCheckA  =textFields.get("�޴�����ȣ").getText().getBytes();
			for (int i = 0; i < callNumCheckA.length; i++) {
				if (callNumCheckA.length != 11 
						||!Character.isDigit(callNumCheckA[i])) {
					checkLabels.get("�޴�����ȣüũ").setText("�޴��� ��ȣ�� Ȯ���ϼ���");
				} else {
					checkLabels.get("�޴�����ȣüũ").setText("");
				}
			}
		}
		//�޴�����ȣ üũ ��

		//���� üũ ����
		if (new String(textFields.get("����").getText()).equals("")) {
			if (!comboBoxs.get("����").getSelectedItem().toString().equals("��")) {
				checkLabels.get("�������üũ").setText("�¾ �⵵�� �Է��ϼ���");
			} else {
				checkLabels.get("�������üũ").setText("");
			} 
		} else {
			byte[] yearCheckA =textFields.get("����").getText().getBytes();
			for (int i = 0; i < yearCheckA.length; i++) {
				if (yearCheckA.length != 4 
						|| !Character.isDigit(yearCheckA[i])) {
					checkLabels.get("�������üũ").setText("�¾ �⵵�� 4�ڸ� ���ڷ� �Է��ϼ���");
				} else {
					checkLabels.get("�������üũ").setText("");
					//���� üũ ��

					//���� üũ ����
					if (textFields.get("����").getText().equals("")) {
						if ((comboBoxs.get("����").getSelectedItem()).toString().equals("��")) {
							checkLabels.get("�������üũ").setText("");
						} else {
							checkLabels.get("�������üũ").setText("�¾ ���� �Է��ϼ���");
						}
					} else {
						byte[] dayCheckA =textFields.get("����").getText().getBytes();
						for (int j = 0; j < dayCheckA.length; j++) {
							if (!Character.isDigit(dayCheckA[j])) {
								checkLabels.get("�������üũ").setText("�¾ ���� ���ڷ� �Է��ϼ���");
							} else {
								switch ((comboBoxs.get("����").getSelectedItem()).toString()) {
								case "01": case "03" : case "05" : case "07" : case "08" : case "10" : case "12" :
									if (Integer.parseInt(textFields.get("����").getText()) < 0 
											||Integer.parseInt(textFields.get("����").getText()) > 31  ) {
										checkLabels.get("�������üũ").setText("�¾ ���� Ȯ�����ּ���");
									} else {
										checkLabels.get("�������üũ").setText("");
									}
									break;
								case "04" : case "06" : case "09" : case "11" : 
									if (Integer.parseInt(textFields.get("����").getText()) < 0 
											||Integer.parseInt(textFields.get("����").getText()) > 30  ) {
										checkLabels.get("�������üũ").setText("�¾ ���� Ȯ�����ּ���");
									}else {
										checkLabels.get("�������üũ").setText("");
									}
									break;
								case "02" :
									if (Integer.parseInt(textFields.get("����").getText()) < 0 
											||Integer.parseInt(textFields.get("����").getText()) > 29  ) {
										checkLabels.get("�������üũ").setText("�¾ ���� Ȯ�����ּ���");
									}else {
										checkLabels.get("�������üũ").setText("");
									}
									break;
								case "��" :{
									checkLabels.get("�������üũ").setText("");
								}
								break;
								}
							}
						}
					}
					//���� üũ ��
				}
			}
		}
		//
		//���� ��ü üũ ��

		//�й� üũ ����
		if (textFields.get("�й�").getText().equals("")) {
			if (!textFields.get("����").getText().equals("")) {
				checkLabels.get("�й�üũ").setText("�й��� �Է��ϼ���");
			} else {
				checkLabels.get("�й�üũ").setText("");							
			}
		}  else {
			byte[] hakbunCheckA  =textFields.get("�й�").getText().getBytes();
			for (int k = 0; k < hakbunCheckA.length; k++) {
				if (hakbunCheckA.length != 6 
						||!Character.isDigit(hakbunCheckA[k])) {
					checkLabels.get("�й�üũ").setText("�й��� Ȯ���ϼ���");
				} else {
					checkLabels.get("�й�üũ").setText("");
				}
			}
		}
		//�й� üũ ��
	}



	void setButtons(String K , String V , int x , int y , int width, int height) {
		buttons.put(K,new JButton(V));
		panels.get("��ü").add(buttons.get(K));
		buttons.get(K).setBounds(x, y, width, height);
		buttons.get(K).addActionListener(this);
	}

	void setLabels(String K , String V , int x , int y , int width, int height) {
		labels.put(K,new JLabel(V));
		panels.get("��ü").add(labels.get(K));
		labels.get(K).setBounds(x, y, width, height);
	}
	
	void setcheckLabels(String K , String V , int x , int y , int width, int height) {
		checkLabels.put(K,new JLabel(V));
		panels.get("��ü").add(checkLabels.get(K));
		checkLabels.get(K).setBounds(x, y, width, height);
	}


	void setTextFields(String K , int x , int y , int width, int height) {
		textFields.put(K,new JTextField());
		panels.get("��ü").add(textFields.get(K));
		textFields.get(K).setBounds(x, y, width, height);
		textFields.get(K).addKeyListener(this);
	}

	void setComboBoxs(String K , String[] V ,int x , int y , int width, int height) {
		comboBoxs.put(K,new JComboBox<>(V));
		panels.get("��ü").add(comboBoxs.get(K));
		comboBoxs.get(K).setBounds(x, y, width, height);
		comboBoxs.get(K).addActionListener(this);
	}

	void setPasswordFields(String K ,int x , int y , int width, int height) {
		passwordFields.put(K,new JPasswordField());
		panels.get("��ü").add(passwordFields.get(K));
		passwordFields.get(K).setBounds(x, y, width, height);
		passwordFields.get(K).addKeyListener(this);
	}

	void panels() {
		panels.put("��ü",new JPanel());
		panels.get("��ü").setLayout(null);
	}

	void frame() {
		frame.setLayout(new BorderLayout());
		frame.add(panels.get("��ü"), "Center");

		//ȭ�鿡 ��µȴ�
		frame.setVisible(true);
		//Frame ������ ����
		frame.setSize(500, 1000);
		//�����ư�� �����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

	}

	void arrangement(){

		setLabels("���̵�", "���̵� �Է�", 20, 20, 150, 30);

		int standardX = labels.get("���̵�").getX();
		int standardY = labels.get("���̵�").getY();
		int HeightY = labels.get("���̵�").getHeight();
		int interval = 5;
		int n = 1;

		setTextFields("���̵�", standardX, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("���̵𼳸�", "*2~20���� ���� �ҹ���, ���ڸ� ��밡���մϴ�", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setcheckLabels("���̵�üũ", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("��й�ȣ", "��й�ȣ �Է�", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("��й�ȣȮ��", "��й�ȣ ���Է�", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);

		setPasswordFields("��й�ȣ", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setPasswordFields("��й�ȣȮ��", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("��й�ȣ����", "*2~16�� ���� �� �ҹ���, ���ڸ� ��밡���մϴ�", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setcheckLabels("��й�ȣüũ", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("����", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("ȸ�������ۼ�", "ȸ������ �ۼ�", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("�̸�", "�̸�", standardX, standardY + (HeightY + interval)*n++, 220, HeightY);
		setTextFields("�̸�", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setcheckLabels("�̸�üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("����", "����", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		String[] gender = {"����","man","woman","private"};
		setComboBoxs("����", gender, standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setcheckLabels("����üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("�޴�����ȣ", "�޴��� ��ȣ (11�ڸ� ���ڸ� �Է��ϼ���)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("�޴�����ȣ", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setcheckLabels("�޴�����ȣüũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("�������", "�������", standardX, standardY + (HeightY + interval)*n, 400, HeightY);
		setcheckLabels("�������üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);
		setTextFields("����", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		String[] month = {"��","01","02","03","04","05","06","07","08","09","10","11","12"};
		setComboBoxs("����", month, standardX+150, standardY + (HeightY + interval)*n, 150, HeightY);
		setTextFields("����", standardX+300, standardY + (HeightY + interval)*n++, 150, HeightY);

		setLabels("�й�", "�й�(6�ڸ� ���ڸ� �Է��ϼ���)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("�й�", standardX, standardY + (HeightY + interval)*n++, 150, HeightY);
		setcheckLabels("�й�üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("����", "���� ���� 1ȣ��", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("����", standardX, standardY + (HeightY + interval)*n++, 250, HeightY);

		setcheckLabels("����üũ", "", standardX, 850, 400, 40);

		setButtons("���", "���", 230, 900, 100, 40);
		setButtons("ȸ������", "ȸ������", 350, 900, 100, 40);
	}


}
