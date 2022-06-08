import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseExam extends JFrame implements MouseListener , MouseMotionListener {
	//��üȭ
	JLabel label = new JLabel("�巡��");
	JTextField text = new JTextField();
	
	public MouseExam() {
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
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		text.setText("x = " + e.getX() + " ,y = " + e.getY());
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		text.setText("���콺 �ִ�");
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		text.setText("���콺 ����");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MouseExam();

	}


}
