package teamProjectDB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class IdFindWD  implements ActionListener { 
	SourceDTO student = new SourceDTO();
	MemberAct act = new MemberAct();

	JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
	JTextField text1,text2;
	JButton jb1, jb2, jb3, jb4;
	JFrame frame = new JFrame("ID_Find");

	IdFindWD(){
		act.connectMysql();
		setSName();
		setSText();
		setSDisplay();
	}

	void setSName() {
		label=new JLabel("");
		label1=new JLabel("���̵� ã��");
		label2=new JLabel("���� ");
		label3=new JLabel("�� : ");
		label4=new JLabel("ID : ");
		label5=new JLabel("���̵� ��� ����");	

		label6=new JLabel("");	// ���� ����


		label7=new JLabel("�̸�"); 
		label8=new JLabel("�̸� �Է�");
		label9=new JLabel("���� ���� 1ȣ��~!?!?");

		text1=new JTextField(10);
		text2=new JTextField(5);


		jb1=new JButton("��� �� �α���ȭ��");
		jb2=new JButton("Ȯ��");


	}

	void setSText() {
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp2.add(label);
		jp2.add(label8);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(label4);


		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(label9);
		jp3.add(text2);
		jp3.add(label5);

		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp4.add(jb2);
		jp4.add(jb1);

		frame.add(jp2,BorderLayout.WEST);  // �ڸ�����
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

	}

	void setSDisplay() {

		frame.setVisible(true);  // ȭ�� ����ϴ� �ڵ�!!!
		frame.setSize(325, 300); // (width, heigth) ũŰ, �ʺ� �־��ָ� ��!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�ݱ�
		frame.setLocationRelativeTo(null); // â ����� ����ִ� ��
		//	pack(); // â�� �ִ� ũ�⸦ �Ȱ��� �����.

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		//��� �� �α���ȭ�� ��ư ��������
		if(e.getSource()==jb1) {
			new LoginWD();
			frame.setVisible(false);
			//Ȯ�� ��ư ��������
		} else if (e.getSource()==jb2){
			//���� �Է¾�������
			if (text1.getText().equals("")
					||text2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���� �Է��ؾ� �ſ�...!!");
			}else {
				student.setName(text1.getText()); 
				student.setQuestions(text2.getText());
				student.setId(act.findIdByNameQuestions(student.getName() , student.getQuestions()));
				//��ȸ �ȵɶ�
				if (student.getId().equals("")) {
					JOptionPane.showMessageDialog(null, "�� ������...�߸� �Է��޾��..."); // try�� catch�� ��Ʈ ( else )
					//��ȸ �����϶�
				} else {
					label5.setText(student.getId());
				}
			}
		}

	}
}