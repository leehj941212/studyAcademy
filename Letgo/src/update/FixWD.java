package update;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FixWD extends JFrame{			// �� ������ ����
	JLabel lbname, lbbirth, lbhakbun, lbphone, lbpw, lbpwcheck;
	JTextField tfname, tfbirth, tfhakbun, tfphone, tfpw, tfpwcheck;
	JButton jbout, jbcancle, jbsave;
	
	FixWD(){			// ������
		setUnit();
		setFrame();
		setDisplay();
	}
	
	void setUnit() {					// ��, �ؽ�Ʈ�ʵ�, ��ư �ȿ� ���� �� ũ��	
		lbname = new JLabel("�̸�");
		lbbirth = new JLabel("�������");
		lbhakbun = new JLabel("�й�");
		lbphone = new JLabel("����ó");
		lbpw = new JLabel("��й�ȣ");
		lbpwcheck = new JLabel("��й�ȣ Ȯ��");
		tfname = new JTextField(10);	
		tfbirth = new JTextField(10);
		tfhakbun = new JTextField(10);
		tfphone = new JTextField(10);
		tfpw = new JTextField(10);
		tfpwcheck = new JTextField(10);
		jbout = new JButton("�α׾ƿ�");
		jbcancle = new JButton("���");
		jbsave = new JButton("Ȯ��");
	}
	void setFrame() {										// �г� ���. 
		JPanel jp1 = new JPanel(new GridLayout(0,1,10,20));
		jp1.add(lbname);
		jp1.add(lbbirth);
		jp1.add(lbhakbun);
		jp1.add(lbphone);
		jp1.add(lbpw);
		jp1.add(lbpwcheck);
		//jp1.setBorder(new TitledBorder(""));
		
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));
		jp2.add(tfname);
		jp2.add(tfbirth);
		jp2.add(tfhakbun);
		jp2.add(tfphone);
		jp2.add(tfpw);
		jp2.add(tfpwcheck);
		//jp2.setBorder(new TitledBorder(""));
		
		JPanel jp3 = new JPanel();
		jp3.add(jbout);
		//jp3.setBorder(new TitledBorder(""));
		
		JPanel jp4 = new JPanel();
		jp4.add(jbsave);
		jp4.add(jbcancle);
		//jp4.setBorder(new TitledBorder(""));
		
		add(jp1, BorderLayout.WEST);			// ��� ��ġ
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.EAST);
		add(jp4, BorderLayout.SOUTH);
	}
	void setDisplay() {
		setTitle("ȸ������ ����");					// â�̸� 
		setVisible(true);						// ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);//
		setLocationRelativeTo(null);
		//setResizable(false);
		//setSize(200, 400);
		pack();
	}
	void setInput() {
		
	}
	public static void main(String[] args) {
		new FixWD();
	}
}
