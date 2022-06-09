import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//숫자생성을 누르면 1~45 중 중복되지 않은 6개의 숫자를
//작은 순으로 textField 에 출력 ( ex. [1] [2] [3] [4] [5] [6] )
//상단 2 * 3 버튼의 숫자가 출력된 숫자로 변경된다

public class LottoExam implements ActionListener {
	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	ArrayList<JButton> buttons = new ArrayList<JButton>();

	void button() {

		panel2.setLayout(new BorderLayout());
		buttons.add(new JButton("숫자생성"));
		panel2.add(buttons.get(0) ,"East");
		panel2.add(textField , "Center");

		panel.setLayout(new GridLayout(2 , 3));
		for (int i = 1; i < 7; i++) {
			buttons.add(new JButton(Integer.toString(i)));	
			panel.add(buttons.get(i));
		}

	}

	void frame() {
		frame.setLayout(new BorderLayout());
		frame.add(panel2 , "South");
		frame.add(panel , "Center");

		//화면에 출력된다
		frame.setVisible(true);
		//Frame 사이즈 설정
		frame.setSize(500, 300);
		//종료버튼을 만든다
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		buttons.get(0).addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.get(0) ) {
			ArrayList<Integer> lottoNumAll = new ArrayList<Integer>();
			ArrayList<Integer> lottoNum = new ArrayList<Integer>();
			for (int i = 1; i < 46; i++) {
				lottoNumAll.add(i);
			}
			for (int i = 0; i < 6; i++) {
				int x = (int)(Math.random()*lottoNumAll.size());
				lottoNum.add(lottoNumAll.get(x));
				lottoNumAll.remove(x);
			}
			Collections.sort(lottoNum);
			
			textField.setText(
					"["+lottoNum.get(0)+"] "
							+"["+lottoNum.get(1)+"] "
							+"["+lottoNum.get(2)+"] "
							+"["+lottoNum.get(3)+"] "
							+"["+lottoNum.get(4)+"] "
							+"["+lottoNum.get(5)+"] ");

			for (int i = 1; i < 7; i++) {
				buttons.get(i).setText(lottoNum.get(i-1).toString());
			}
		}

	}

	public static void main(String[] args) {
		LottoExam lottoExam = new LottoExam();
		lottoExam.button();
		lottoExam.frame();
	}

}
