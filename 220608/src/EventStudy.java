import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventStudy implements ActionListener {

	JFrame frame = new JFrame();

	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");

	void addUI() {
		frame.setLayout(new GridLayout(3,2));
		frame.add(button0);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);

		//화면에 출력된다
		frame.setVisible(true);
		//Frame 사이즈 설정
		frame.setSize(500, 300);
		//종료버튼을 만든다
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		button0.addActionListener(this);
		button1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button0 ) {
			System.out.println("qwer123");
		} else {
			System.out.println("234asdf");
		}
		
	}

	public static void main(String[] args) {
		EventStudy study = new EventStudy();
		study.addUI();
	}
}
