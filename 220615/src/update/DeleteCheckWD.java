package update;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteCheckWD extends JFrame implements ActionListener{
	JLabel jl, jlalert;
		//JPasswordField jpf;
	JButton jbyes, jbno;
	String z;
	DeleteCheckWD(String x) {
		this.z=x;
		checkset();
		checkPanel();
		checksetDisplay();
	}
	void checkset() {
		jl = new JLabel("���� Ż���Ͻðڽ��ϱ�?");
		//		jpf = new JPasswordField(20);
		jbyes = new JButton("Ȯ��");
		jbno = new JButton("���");
		jlalert = new JLabel("");
	}

	void checkPanel() {
		JPanel jp1 = new JPanel();
		jp1.add(jl);

		//		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		//		jp2.add(jpf);
		//		jp2.add(jlalert);

		JPanel jp3 = new JPanel();
		jp3.add(jbyes);
		jp3.add(jbno);

		add(jp1, BorderLayout.NORTH);
		//		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
	}

	void checksetDisplay() {
		setTitle("Ż�� Ȯ��");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);		
		//setSize(300, 100);
		pack();
		jbno.addActionListener(this);
		jbyes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbno) {
			new DeleteWD(z);
			setVisible(false);

		}else if(e.getSource() == jbyes) {	//Ȯ�ι�ư ������
			
			File folder = new File("member"+File.separator+this.z);	// ��� ��üȭ
			DeleteWD dl = new DeleteWD(z);
			new LoginWD();
			dl.setVisible(false);
			setVisible(false);
			try {
				while(folder.exists()) {		//�����ص� ��ο� ������ ������
					File [] files = folder.listFiles();	// ������ �о ������ �迭�� ��Ƶΰ�
					// �����ȿ� ������ ������ ������ �ȵǼ� ���Ϻ��� ����� ������ �����ؾߵ�
					for(int i = 0; i < files.length; i++) {
						files[i].delete();				// ������迭�� �ݺ������� ���� ���� �����ŭ ����
					}
					if (files.length == 0 && folder.isDirectory()) {  // ������迭�� ũ�Ⱑ 0�̰� ������ �ִٸ�
						folder.delete();								// ���� ����
						JOptionPane.showMessageDialog(null, "Ż���ϼ̽��ϴ�");
					}
				}	

			}catch (Exception o) {
				System.out.println(o + " ���� ����");
			}
		}
	}
}