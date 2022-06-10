package update;
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
		panels.add(new JPanel());
		panels.get(0).setLayout(new BorderLayout());
		panels.get(0).add(textFields.get(0) , "South");
		panels.get(0).add(labels.get(0) , "Center");
		panels.get(0).add(labels.get(1) , "North");
		panels.get(0).add(buttons.get(0) , "East");
	}

	void frame() {
		frame.setLayout(new BorderLayout());
		frame.add(panels.get(0), "Center");


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

		//������ġ
		String folderPath = "."+File.separator+ "member"+File.separator+sourceDTO.getId();
		//id.txt ��ġ
		String idPath = folderPath + File.separator + "id.txt";

		if (new File(folderPath).exists()) {
			labels.get(1).setText("���� ���̵� �ֽ��ϴ�");
		} else {
			FileOutputStream id = null;
			try {
				//folderPath �� ���� ��ġ mkdir�� ���丮�� make
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

	SignUpWD(){

		addButtons();
		addLabels();
		addTextFields();	
		addPanels();
		frame();
	}

	public static void main(String[] args) {
		new SignUpWD();
	}


}
