import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingExam {

	JFrame frame = new JFrame();

	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button10 = new JButton("+");
	JButton button11 = new JButton("-");
	JButton button12 = new JButton("*");
	JButton button13 = new JButton("/");
	JButton button14 = new JButton("=");
	JButton button15 = new JButton("0.0");

	JPanel panel = new JPanel(); 

	void addUI() {
		
		frame.setLayout(new BorderLayout());
		frame.add(button15 , "North");
		button15.setHorizontalAlignment(JButton.LEFT);
		
		panel.setLayout(new GridLayout(3,5));
		panel.add(button10);
		panel.add(button11);
		panel.add(button12);
		panel.add(button13);
		panel.add(button14);
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		
		frame.add(panel , "Center");
		//화면에 출력된다
		frame.setVisible(true);
		//Frame 사이즈 설정
		frame.setSize(500, 300);
		//종료버튼을 만든다
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingExam exam = new SwingExam();
		exam.addUI();

	}

}
