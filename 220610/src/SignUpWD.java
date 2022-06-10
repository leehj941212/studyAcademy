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
		buttons.add(new JButton("가입"));
	}
	
	void addLabels() {
		labels.add(new JLabel("아이디를 쓰세요"));
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

		//화면에 출력된다
		frame.setVisible(true);
		//Frame 사이즈 설정
		frame.setSize(500, 300);
		//종료버튼을 만든다
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		buttons.get(0).addActionListener(this);
	}

	void addOutput() {
		SourceDTO sourceDTO = new SourceDTO();
		sourceDTO.setId(textFields.get(0).getText());

		String folderPath = "."+File.separator+ "member"+File.separator+sourceDTO.getId();
		String idPath = folderPath + File.separator + "id.txt";
		
		if (new File(folderPath).exists()) {
			labels.get(1).setText("같은 아이디가 있습니다");
		} else {
			FileOutputStream id = null;
			try {	
				new File(folderPath).mkdir();
				id = new FileOutputStream(idPath);
				byte b[] = sourceDTO.getId().getBytes();
				id.write(b);		
			} catch (Exception e) {
				System.out.println(e + " => 파일쓰기 실패");
			} finally {
				try {
					id.close();
				} catch (Exception e) {
					System.out.println(e + " => close 실패");
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
