import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseExamTwo extends JFrame {
	//��üȭ
	JLabel label = new JLabel("�巡��");
	JTextField text = new JTextField();
	
	public MouseExamTwo() {
		//frame �̸� ����
		super("���콺 �̺�Ʈ");
		//layout ����
		setLayout(new BorderLayout());
		//��ü frame�� �߰�
		add(label , "North");
		add(text , "South");
		//
		setBackground(Color.pink);
		//frame ������ ����
		setSize(500 , 400);
		//frame ���
		setVisible(true);
		//���� ��ư ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//event ����
		//addMouseListener(new MEvent);
		//addMouseMotionListener(new MEvent);
	}

	public static void main(String[] args) {
		new MouseExamTwo();

	}


}

class MEvent extends MouseAdapter {

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseEntered(e);
		
//		text.setText("���콺 �ִ�");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseExited(e);
//		text.setText("���콺 ����");
	}
	
}
