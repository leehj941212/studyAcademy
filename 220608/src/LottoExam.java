import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//���ڻ����� ������ 1~45 �� �ߺ����� ���� 6���� ���ڸ�
//���� ������ textField �� ��� ( ex. [1] [2] [3] [4] [5] [6] )
//��� 2 * 3 ��ư�� ���ڰ� ��µ� ���ڷ� ����ȴ�

public class LottoExam implements MouseListener {
	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	ArrayList<JButton> buttons = new ArrayList<JButton>();

	void button() {

		panel2.setLayout(new BorderLayout());
		buttons.add(new JButton("���ڻ���"));
		panel2.add(buttons.get(0) ,"East");
		panel2.add(textField , "Center");
		
		panel.setLayout(new GridLayout(2 , 3));
		for (int i = 1; i < 7; i++) {
			String j = "[" + i + "]";
			buttons.add(new JButton(j));
			panel.add(buttons.get(i));
		}

	}

	void frame() {
		frame.setLayout(new BorderLayout());
		frame.add(panel2 , "South");
		frame.add(panel , "Center");

		//ȭ�鿡 ��µȴ�
		frame.setVisible(true);
		//Frame ������ ����
		frame.setSize(500, 300);
		//�����ư�� �����
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		frame.addMouseListener(this);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//if (e.getSource() == buttons.get(0)) {
			textField.setText("asdf");
		//}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		textField.setText("asdf");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		textField.setText("asdf");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		textField.setText("asdf");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		LottoExam lottoExam = new LottoExam();
		lottoExam.button();
		lottoExam.frame();
	}

}
