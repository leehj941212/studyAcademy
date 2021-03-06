package teamProjectDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class DeleteWD implements ActionListener{
	SourceDTO student = new SourceDTO();
	MemberAct act = new MemberAct();
	
	JLabel jlReal, jlBlink1, jlBlink2, jlBlink3;
	JButton yes, no;
	JPasswordField jpf;
	JFrame frame = new JFrame("ȸ??Ż??");
	
	DeleteWD(String id){
		act.connectMysql();
		student.setId(id);
		set();
		setPanel();
		setDisplay();
	}
	
	void set() {
		jlReal = new JLabel("???? Ż???Ͻðڽ??ϱ??");
		yes = new JButton("??");
		no = new JButton("?ƴϿ?");
		jlBlink1 = new JLabel("");
		jlBlink2 = new JLabel("");
		jlBlink3 = new JLabel("");
		Font font = new Font("?ü? ????", Font.BOLD, 20); //?۾?ü ?ȹٲ?.. ũ?⸸ ?ٲ?
		jlReal.setFont(font);
		jlReal.setForeground(Color.red); //???? ???? ok
		
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
		
		frame.add(jp1, BorderLayout.NORTH);
		frame.add(jp2, BorderLayout.CENTER);
		frame.add(jp3, BorderLayout.SOUTH);
		frame.add(jp4, BorderLayout.WEST);
		frame.add(jp5, BorderLayout.EAST);		
	}
	
	void setDisplay() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

			if (e.getSource() == yes) {
				new DeleteCheckWD(student.getId());
				frame.setVisible(false);
			}else if (e.getSource() == no) {
				new MenuWD(student.getId());
				frame.setVisible(false);
			}

		
	}

}