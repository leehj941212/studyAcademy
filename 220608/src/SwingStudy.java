import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingStudy {
	JFrame jf = new JFrame();
	JButton jb = new JButton("버튼1");
	JButton jb2 = new JButton("버튼2");
	JButton jb3 = new JButton("버튼3");
	JButton jb4 = new JButton("버튼4");
	JButton jb5 = new JButton("버튼5");
	JButton jb6 = new JButton("버튼6");

	void addUI() {

		//FlowLayout 형식 사용 (옆으로 주르륵 나열됨)
		//		jf.setLayout(new FlowLayout());

		//Frame 에 Button 추가
		//		jf.add(jb);
		//		jf.add(jb2);
		//		jf.add(jb3);
		//		jf.add(jb4);

		//BorderLayout 형식 사용 (동서남북중앙 위치 선택해서 나열)
		//		jf.setLayout(new BorderLayout());

		//Frame 에 Button 추가
		//		jf.add(jb , BorderLayout.NORTH);
		//		jf.add(jb2 , BorderLayout.NORTH);
		//		jf.add(jb3 , BorderLayout.SOUTH);
		//		jf.add(jb4 , BorderLayout.EAST);

		//		//GridLayout 형식 사용 (행,열 사이즈를 정해서 나열)
		//		jf.setLayout(new GridLayout(1,3));
		//
		//		//Frame 에 Button 추가
		//		jf.add(jb);
		//		jf.add(jb2);
		//		jf.add(jb3);
		//		jf.add(jb4);

		jf.setLayout(new BorderLayout());
		jf.add(jb,"North");
		jf.add(jb2,"South");
		jf.add(jb3,"West");
		jf.add(jb4,"East");
		//패널도 Component 이다
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(jb5 , "West");
		jp.add(jb6 , "East");
		jf.add(jp , "Center");
		

		//화면에 출력된다
		jf.setVisible(true);
		//Frame 사이즈 설정
		jf.setSize(500, 300);
		//종료버튼을 만든다
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		SwingStudy study = new SwingStudy();
		study.addUI();

	}

}
