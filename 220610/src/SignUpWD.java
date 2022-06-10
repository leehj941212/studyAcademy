import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpWD implements ActionListener {
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JLabel>labels = new ArrayList<JLabel>();
	ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	ArrayList<JPanel> panels = new ArrayList<JPanel>();
	JFrame frame = new JFrame();
	
	void addButtons() {
		buttons.add(new JButton("����"));
	}
	
	void addLabels() {
		labels.add(new JLabel("���̵� ������"));
		labels.add(new JLabel());
	}

	void addTextFields() {
		textFields.add(new JTextField());
	}
	
	void addPanels() {
		
	}


	void frame() {
		frame.setLayout(new BorderLayout());
		frame.add(textFields.get(0) , "South");
		frame.add(labels.get(0) , "Center");
		frame.add(labels.get(1) , "North");
		frame.add(buttons.get(0) , "East");

		//ȭ�鿡 ��µȴ�
		frame.setVisible(true);
		//Frame ������ ����
		frame.setSize(500, 300);
		//�����ư�� �����
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		buttons.get(0).addActionListener(this);
	}

	void addOutput() {
		SourceDTO sourceDTO = new SourceDTO();
		sourceDTO.setId(textFields.get(0).getText());

		String folderPath = "."+File.separator+ "member"+File.separator+sourceDTO.getId();
		String idPath = folderPath + File.separator + "id.txt";
		
		if (new File(folderPath).exists()) {
			labels.get(1).setText("���� ���̵� �ֽ��ϴ�");
		} else {
			FileOutputStream id = null;
			try {	
				new File(folderPath).mkdir();
				id = new FileOutputStream(idPath);
				byte b[] = sourceDTO.getId().getBytes();
				id.write(b);		
			} catch (Exception e) {
				System.out.println(e + " => ���Ͼ��� ����");
			} finally {
				try {
					id.close();
				} catch (Exception e) {
					System.out.println(e + " => close ����");
				}
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.get(0)) {
			addOutput();
		}
	}

	public static void main(String[] args) {
		SignUpWD signUpWD = new SignUpWD();
		
		signUpWD.addButtons();
		signUpWD.addLabels();
		signUpWD.addTextFields();		
		signUpWD.frame();
	}


}
