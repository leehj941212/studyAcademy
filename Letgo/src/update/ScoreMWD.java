package update;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScoreMWD extends JFrame{

	String [] Elements = {"�̸�","�й�","Java ���� ����", "C ���� ����", "Python ���� ����" };

	JLabel [] label = new JLabel [Elements.length];
	JTextField [] textField = new JTextField [Elements.length];

	JButton save, reset;

	public ScoreMWD() {
		super("My ���� ����");

		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		JPanel panel1 = new JPanel ();
		panel1.setBackground(Color.LIGHT_GRAY);
		
		panel1.setLayout(new GridLayout(Elements.length,2,10,10));	 

		for(int i = 0; i<Elements.length; i++) {

			panel1.add(new JLabel(Elements[i]));
			panel1.add(new JTextField(""));	// �̸�~ ������� label�̶� textField
		}

		JPanel panel2 = new JPanel ();
		panel2.setLayout(new GridLayout(1,2));

		panel2.add(save= new JButton("����"));
		panel2.add(reset= new JButton("�ʱ�ȭ"));

		add(panel1,"Center");
		add(panel2,"South");

		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

}
