import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingStudy {
	JFrame jf = new JFrame();
	JButton jb = new JButton("��ư1");
	JButton jb2 = new JButton("��ư2");
	JButton jb3 = new JButton("��ư3");
	JButton jb4 = new JButton("��ư4");
	JButton jb5 = new JButton("��ư5");
	JButton jb6 = new JButton("��ư6");

	void addUI() {

		//FlowLayout ���� ��� (������ �ָ��� ������)
		//		jf.setLayout(new FlowLayout());

		//Frame �� Button �߰�
		//		jf.add(jb);
		//		jf.add(jb2);
		//		jf.add(jb3);
		//		jf.add(jb4);

		//BorderLayout ���� ��� (���������߾� ��ġ �����ؼ� ����)
		//		jf.setLayout(new BorderLayout());

		//Frame �� Button �߰�
		//		jf.add(jb , BorderLayout.NORTH);
		//		jf.add(jb2 , BorderLayout.NORTH);
		//		jf.add(jb3 , BorderLayout.SOUTH);
		//		jf.add(jb4 , BorderLayout.EAST);

		//		//GridLayout ���� ��� (��,�� ����� ���ؼ� ����)
		//		jf.setLayout(new GridLayout(1,3));
		//
		//		//Frame �� Button �߰�
		//		jf.add(jb);
		//		jf.add(jb2);
		//		jf.add(jb3);
		//		jf.add(jb4);

		jf.setLayout(new BorderLayout());
		jf.add(jb,"North");
		jf.add(jb2,"South");
		jf.add(jb3,"West");
		jf.add(jb4,"East");
		//�гε� Component �̴�
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(jb5 , "West");
		jp.add(jb6 , "East");
		jf.add(jp , "Center");
		

		//ȭ�鿡 ��µȴ�
		jf.setVisible(true);
		//Frame ������ ����
		jf.setSize(500, 300);
		//�����ư�� �����
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		SwingStudy study = new SwingStudy();
		study.addUI();

	}

}
