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
	JFrame frame = new JFrame("ȸ������");

	SignUpWD() {
		panels();
		arrangement();
		frame();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		//ȸ������ ��ư�� ��������
		if (e.getSource() == buttons.get("ȸ������") ) {
			if (!new File("member").exists()) {
				try {
					new File("."+File.separator+ "member").mkdir();
				} catch (Exception memberE) {
					System.out.println(memberE + " => ���Ͼ��� ����");
				}
			} 




			if (!labels.get("���̵�üũ").getText().equals("")
					||!labels.get("��й�ȣüũ").getText().equals("")
					||!labels.get("�̸�üũ").getText().equals("")
					||!labels.get("����üũ").getText().equals("")
					||!labels.get("�޴�����ȣüũ").getText().equals("")
					||!labels.get("�������üũ").getText().equals("")
					||!labels.get("�й�üũ").getText().equals("")
					||!labels.get("����üũ").getText().equals("")) {
				JOptionPane.showMessageDialog(null, "������ Ȯ���ϼ���");
			} else {
				if (textFields.get("���̵�").getText().equals("")
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
				} else {

					//������ġ
					String folderPath = "member"+File.separator+textFields.get("���̵�").getText();
					//id.txt ��ġ
					String idPath = folderPath + File.separator + "id.txt";
					//password.txt ��ġ
					String passwordPath = folderPath + File.separator + "password.txt";
					//name.txt ��ġ
					String namePath = folderPath + File.separator + "name.txt";
					//gender.txt ��ġ
					String genderPath = folderPath + File.separator + "gender.txt";
					//callNum.txt ��ġ
					String callNumPath = folderPath + File.separator + "callNum.txt";
					//birth.txt ��ġ
					String birthPath = folderPath + File.separator + "birth.txt";
					//hakbun.txt ��ġ
					String hakbunPath = folderPath + File.separator + "hakbun.txt";
					//questions.txt ��ġ
					String questionsPath = folderPath + File.separator + "questions.txt";
					//java.txt ��ġ
					String javaPath = folderPath + File.separator + "java.txt";
					//web.txt ��ġ
					String webPath = folderPath + File.separator + "web.txt";
					//jsp.txt ��ġ
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

						//folderPath �� ���� ��ġ mkdir �� ���丮�� make
						new File(folderPath).mkdir();

						id = new FileOutputStream(idPath);
						byte a[] = textFields.get("���̵�").getText().getBytes();
						id.write(a);	

						password = new FileOutputStream(passwordPath);
						byte b[] = String.valueOf(passwordFields.get("��й�ȣ").getPassword()).getBytes();
						password.write(b);	

						name = new FileOutputStream(namePath);
						byte c[] = textFields.get("�̸�").getText().getBytes();
						name.write(c);	

						gender = new FileOutputStream(genderPath);
						byte d[] = comboBoxs.get("����").getSelectedItem().toString().getBytes();
						gender.write(d);	

						callNum = new FileOutputStream(callNumPath);
						byte l[] = textFields.get("�޴�����ȣ").getText().getBytes();
						callNum.write(l);	

						birth = new FileOutputStream(birthPath);
						String birthAll = textFields.get("����").getText() + comboBoxs.get("����").getSelectedItem().toString() + (textFields.get("����").getText());
						byte f[] = birthAll.getBytes();
						birth.write(f);	

						hakbun = new FileOutputStream(hakbunPath);
						byte g[] = textFields.get("�й�").getText().getBytes();
						hakbun.write(g);	

						questions = new FileOutputStream(questionsPath);
						byte h[] = textFields.get("����").getText().getBytes();
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

						//�α���ȭ��
						JOptionPane.showMessageDialog(null, "ȸ�����ԵǾ����ϴ�");
						new LoginWD();
						frame.setVisible(false);

					} catch (Exception e2) {
						System.out.println(e2 + " => ���Ͼ��� ����");
					} finally {
						try {
							//id.close();
						} catch (Exception e3) {
							System.out.println(e3 + " => close ����");
						}
					}
				}

			}
		}
		
		//��ҹ�ư ��������
		if (e.getSource() == buttons.get("���") ) {
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
		//���̵� üũ ����
		if (textFields.get("���̵�").getText().equals("")) {
			if (!new String(passwordFields.get("��й�ȣ").getPassword()).equals(null)) {
				labels.get("���̵�üũ").setText("���̵� �Է��ϼ���");
			} else {		
				labels.get("���̵�üũ").setText("");
			}
		}else  {
			byte[] idCheck  =textFields.get("���̵�").getText().getBytes();
			if (textFields.get("���̵�").getText().length() <2 || textFields.get("���̵�").getText().length() > 20) {
				labels.get("���̵�üũ").setText("���̵� ���ڼ��� Ȯ�����ּ���");
			} else {
				for (int i = 0; i < idCheck.length; i++) {
					if (!Character.isLowerCase(idCheck[i]) && !Character.isDigit(idCheck[i])) {
						labels.get("���̵�üũ").setText("���̵�� ���� �ҹ���, ���ڸ� ��밡���մϴ�");
					} else {
						if ((new File("."+File.separator+ "member"+File.separator+textFields.get("���̵�").getText())).exists()) {
							labels.get("���̵�üũ").setText("�ߺ��� ���̵� �Դϴ�");
						} else {
							labels.get("���̵�üũ").setText("");

						}
					}
				}
			}
		}
		//���̵� üũ ��

		//��й�ȣ üũ ��ü ����
		//��й�ȣ üũ ����
		String passwordA = new String(passwordFields.get("��й�ȣ").getPassword());
		String passwordB = new String(passwordFields.get("��й�ȣȮ��").getPassword());
		byte[] passwordCheck  =passwordA.getBytes();
		if (passwordA.equals("")) {
			if (!passwordB.equals("")) {
				labels.get("��й�ȣüũ").setText("��й�ȣ�� �Է��ϼ���");
			} else {
				labels.get("��й�ȣüũ").setText("");
			}
		}else {
			if (passwordA.length() <2 
					|| passwordA.length() > 16) {
				labels.get("��й�ȣüũ").setText("��й�ȣ ���ڼ��� Ȯ�����ּ���");
			} else {
				for (int i = 0; i < passwordCheck.length; i++) {
					if (!Character.isLowerCase(passwordCheck[i]) 
							&& !Character.isDigit(passwordCheck[i]) 
							&& !Character.isUpperCase(passwordCheck[i])) {
						labels.get("��й�ȣüũ").setText("��й�ȣ�� ���� �� �ҹ���, ���ڸ� ��밡���մϴ�");
					} else {
						labels.get("��й�ȣüũ").setText("");

						//��й�ȣ üũ ��

						//��й�ȣ Ȯ�� üũ ����
						if (passwordFields.get("��й�ȣȮ��").getPassword().equals(null)) {
							labels.get("��й�ȣüũ").setText("");
						} else  {

							if (!passwordB.equals(passwordA)) {
								labels.get("��й�ȣüũ").setText("��й�ȣ�� �ٸ��ϴ�");
							} else {
								labels.get("��й�ȣüũ").setText("");
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
				labels.get("�޴�����ȣüũ").setText("�޴��� ��ȣ�� �Է��ϼ���");
			} else {
				labels.get("�޴�����ȣüũ").setText("");							
			}
		}  else {
			byte[] callNumCheckA  =textFields.get("�޴�����ȣ").getText().getBytes();
			for (int i = 0; i < callNumCheckA.length; i++) {
				if (callNumCheckA.length != 11 
						||!Character.isDigit(callNumCheckA[i])) {
					labels.get("�޴�����ȣüũ").setText("�޴��� ��ȣ�� Ȯ���ϼ���");
				} else {
					labels.get("�޴�����ȣüũ").setText("");
				}
			}
		}
		//�޴�����ȣ üũ ��

		//���� üũ ����
		if (new String(textFields.get("����").getText()).equals("")) {
			if (!comboBoxs.get("����").getSelectedItem().toString().equals("��")) {
				labels.get("�������üũ").setText("�¾ �⵵�� �Է��ϼ���");
			} else {
				labels.get("�������üũ").setText("");
			} 
		} else {
			byte[] yearCheckA =textFields.get("����").getText().getBytes();
			for (int i = 0; i < yearCheckA.length; i++) {
				if (yearCheckA.length != 4 
						|| !Character.isDigit(yearCheckA[i])) {
					labels.get("�������üũ").setText("�¾ �⵵�� 4�ڸ� ���ڷ� �Է��ϼ���");
				} else {
					labels.get("�������üũ").setText("");
					//���� üũ ��

						//���� üũ ����
						if (textFields.get("����").getText().equals("")) {
							if ((comboBoxs.get("����").getSelectedItem()).toString().equals("��")) {
								labels.get("�������üũ").setText("");
							} else {
								labels.get("�������üũ").setText("�¾ ���� �Է��ϼ���");
							}
						} else {
							byte[] dayCheckA =textFields.get("����").getText().getBytes();
							for (int j = 0; j < dayCheckA.length; j++) {
								if (!Character.isDigit(dayCheckA[j])) {
									labels.get("�������üũ").setText("�¾ ���� ���ڷ� �Է��ϼ���");
								} else {
									switch ((comboBoxs.get("����").getSelectedItem()).toString()) {
									case "01": case "03" : case "05" : case "07" : case "08" : case "10" : case "12" :
										if (Integer.parseInt(textFields.get("����").getText()) < 0 
												||Integer.parseInt(textFields.get("����").getText()) > 31  ) {
											labels.get("�������üũ").setText("�¾ ���� Ȯ�����ּ���");
										} else {
											labels.get("�������üũ").setText("");
										}
										break;
									case "04" : case "06" : case "09" : case "11" : 
										if (Integer.parseInt(textFields.get("����").getText()) < 0 
												||Integer.parseInt(textFields.get("����").getText()) > 30  ) {
											labels.get("�������üũ").setText("�¾ ���� Ȯ�����ּ���");
										}else {
											labels.get("�������üũ").setText("");
										}
										break;
									case "02" :
										if (Integer.parseInt(textFields.get("����").getText()) < 0 
												||Integer.parseInt(textFields.get("����").getText()) > 29  ) {
											labels.get("�������üũ").setText("�¾ ���� Ȯ�����ּ���");
										}else {
											labels.get("�������üũ").setText("");
										}
										break;
									case "��" :{
											labels.get("�������üũ").setText("");
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
//		}
		//���� ��ü üũ ��

		//�й� üũ ����
		if (textFields.get("�й�").getText().equals("")) {
			if (!textFields.get("����").getText().equals("")) {
				labels.get("�й�üũ").setText("�й��� �Է��ϼ���");
			} else {
				labels.get("�й�üũ").setText("");							
			}
		}  else {
			byte[] hakbunCheckA  =textFields.get("�й�").getText().getBytes();
			for (int k = 0; k < hakbunCheckA.length; k++) {
				if (hakbunCheckA.length != 6 
						||!Character.isDigit(hakbunCheckA[k])) {
					labels.get("�й�üũ").setText("�й��� Ȯ���ϼ���");
				} else {
					labels.get("�й�üũ").setText("");
				}
			}
		}
		//�й� üũ ��

		//		//���� üũ ����
		//		if (textFields.get("����").getText().equals("")) {
		//			if (!textFields.get("�й�").getText().equals("")
		//					&&labels.get("�̸�").getText().equals("")
		//					&&labels.get("����üũ").getText().equals("")
		//					&&labels.get("�޴�����ȣüũ").getText().equals("")
		//					&&labels.get("�������üũ").getText().equals("")
		//					&&labels.get("�й�üũ").getText().equals("")) {
		//				labels.get("����üũ").setText("������ ���� �Է��ϼ���");
		//			} else {
		//				labels.get("����üũ").setText("");							
		//			}
		//		}
	}
	//���� üũ ��



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

		setLabels("���̵�üũ", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("��й�ȣ", "��й�ȣ �Է�", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("��й�ȣȮ��", "��й�ȣ ���Է�", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);

		setPasswordFields("��й�ȣ", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setPasswordFields("��й�ȣȮ��", standardX+220, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("��й�ȣ����", "*2~16�� ���� �� �ҹ���, ���ڸ� ��밡���մϴ�", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("��й�ȣüũ", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("����", "", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("ȸ�������ۼ�", "ȸ������ �ۼ�", standardX, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("�̸�", "�̸�", standardX, standardY + (HeightY + interval)*n++, 220, HeightY);
		setTextFields("�̸�", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("�̸�üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("����", "����", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		String[] gender = {"����","����","����","�����"};
		setComboBoxs("����", gender, standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("����üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("�޴�����ȣ", "�޴��� ��ȣ (11�ڸ� ���ڸ� �Է��ϼ���)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("�޴�����ȣ", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		setLabels("�޴�����ȣüũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("�������", "�������", standardX, standardY + (HeightY + interval)*n, 400, HeightY);
		setLabels("�������üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);
		setTextFields("����", standardX, standardY + (HeightY + interval)*n, 150, HeightY);
		String[] month = {"��","01","02","03","04","05","06","07","08","09","10","11","12"};
		setComboBoxs("����", month, standardX+150, standardY + (HeightY + interval)*n, 150, HeightY);
		setTextFields("����", standardX+300, standardY + (HeightY + interval)*n++, 150, HeightY);

		setLabels("�й�", "�й�(6�ڸ� ���ڸ� �Է��ϼ���)", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("�й�", standardX, standardY + (HeightY + interval)*n++, 150, HeightY);
		setLabels("�й�üũ", "", standardX + 150, standardY + (HeightY + interval)*n++, 400, HeightY);

		setLabels("����", "���� ���� 1ȣ��", standardX, standardY + (HeightY + interval)*n++, 300, HeightY);
		setTextFields("����", standardX, standardY + (HeightY + interval)*n++, 250, HeightY);

		setLabels("����üũ", "", standardX, 850, 400, 40);

		setButtons("���", "���", 230, 900, 100, 40);
		setButtons("ȸ������", "ȸ������", 350, 900, 100, 40);
	}


}
