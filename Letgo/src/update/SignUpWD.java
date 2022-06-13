package update;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpWD implements ActionListener {
	List<JButton> buttons = new ArrayList<JButton>();
	List<JLabel>labels = new ArrayList<JLabel>();
	List<JTextField> textFields = new ArrayList<JTextField>();
	List<JPanel> panels = new ArrayList<JPanel>();
	JFrame frame = new JFrame();
	
	SignUpWD(){

		addButtons();
		addLabels();
		addTextFields();	
		addPanels();
		frame();
	}

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
		JPanel panel = new JPanel();
		panels.add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(textFields.get(0) , "South");
		panel.add(labels.get(0) , "Center");
		panel.add(labels.get(1) , "North");
		panel.add(buttons.get(0) , "East");
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
		File file = new File(folderPath); 

		if (file.exists()) {
			labels.get(1).setText("���� ���̵� �ֽ��ϴ�");
		} else {
			FileOutputStream id = null;
			try {
				//folderPath �� ���� ��ġ mkdir�� ���丮�� make
				file.mkdir();
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
		new SignUpWD();
	}


}
