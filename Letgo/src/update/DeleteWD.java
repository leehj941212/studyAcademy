package update;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class DeleteWD extends JFrame implements ActionListener{
	JLabel jlReal, jlBlink1, jlBlink2, jlBlink3;
	JButton yes, no;
	JPasswordField jpf;
	String z;
	DeleteWD(String x){
		this.z=x;
		set();
		setPanel();
		setDisplay();
	}
	
	void set() {
		jlReal = new JLabel("���� Ż���Ͻðڽ��ϱ�?");
		yes = new JButton("��");
		no = new JButton("�ƴϿ�");
		jlBlink1 = new JLabel("");
		jlBlink2 = new JLabel("");
		jlBlink3 = new JLabel("");
//		jpf = new JPasswordField();
		Font font = new Font("�ü� ����", Font.BOLD, 20); //�۾�ü �ȹٲ�.. ũ�⸸ �ٲ�
		jlReal.setFont(font);
		jlReal.setForeground(Color.red); //���� ���� ok
		
		yes.addActionListener(this);
		no.addActionListener(this);
	}
	
	void setPanel() {
		JPanel jp1 = new JPanel();
		jp1.add(jlReal);
		
		JPanel jp2 = new JPanel(new GridLayout(1,0,10,10));
		jp2.add(yes);
		jp2.add(no);
		
		JPanel jp3 = new JPanel();
		jp3.add(jlBlink1);
		
		JPanel jp4 = new JPanel();
		jp4.add(jlBlink2);
		
		JPanel jp5 = new JPanel();
		jp5.add(jlBlink3);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		add(jp4, BorderLayout.WEST);
		add(jp5, BorderLayout.EAST);		
	}
	
	void setDisplay() {
		setTitle("ȸ��Ż��");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//SourceDTO sourceDTO = new SourceDTO();
		try {
		if (e.getSource()==yes) {	//�� ������ ���� ����
			File file = new File("."+File.separator+"member"+File.separator+this.z);
			if (file.exists()) {						// ���� ã��
				File[] files = file.listFiles();		// ���� �� ���� ã�Ƽ� ����Ʈ�� �־����
				for (int i=0; i<files.length; i++) {		// �ѹ��� ������ �����Ҽ� ����, �����ȿ� ���Ϻ��� �����ϰ� ���� �����ؾߵ�
					if(files[i].exists()) {				// ���ϵ� ������
						files[i].delete();
						System.out.println(files[i].getName()+" ���� ��������");
    				}else{
    					System.out.println(files[i].getName()+" ��������");
    				}
				}
			}
			if (file.exists()) {				// ���� ����
				file.delete();
				System.out.println(file.getName()+" ���� ��������");
			}
			new LoginWD();
			setVisible(false);
		}else if(e.getSource()==no) {
			new MenuWD(z);			//�ƴϿ� ������ �޴�â����
			setVisible(false);
		}
		}catch (Exception o) {
			System.out.println(o +" => ���ϻ��� ����");
		}
	}

}