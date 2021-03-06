import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseExamTwo extends JFrame {
	//객체화
	JLabel label = new JLabel("드래그");
	JTextField text = new JTextField();
	
	public MouseExamTwo() {
		//frame 이름 설정
		super("마우스 이벤트");
		//layout 설정
		setLayout(new BorderLayout());
		//객체 frame에 추가
		add(label , "North");
		add(text , "South");
		//
		setBackground(Color.pink);
		//frame 사이즈 설정
		setSize(500 , 400);
		//frame 출력
		setVisible(true);
		//종료 버튼 생성
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//event 설정
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
		
//		text.setText("마우스 있다");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseExited(e);
//		text.setText("마우스 없다");
	}
	
}
