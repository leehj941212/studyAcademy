package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;

public class DeleteCheckWD implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	JLabel jl, jlalert;
	JButton jbyes, jbno;
	JFrame frame = new JFrame("Ż�� Ȯ��");

	DeleteCheckWD(SourceDTO sourceDTO) {
		this.sourceDTO = sourceDTO;
		//DB���� �ȵǾ� ������ ����
		totalDAO = TotalDAO.connectMysql();
		checkset();
		checkPanel();
		checksetDisplay();
	}
	void checkset() {
		jl = new JLabel("���� Ż���Ͻðڽ��ϱ�?");
		jbyes = new JButton("Ȯ��");
		jbno = new JButton("���");
		jlalert = new JLabel("");
	}

	void checkPanel() {
		JPanel jp1 = new JPanel();
		jp1.add(jl);

		JPanel jp3 = new JPanel();
		jp3.add(jbyes);
		jp3.add(jbno);

		frame.add(jp1, BorderLayout.NORTH);
		//		add(jp2, BorderLayout.CENTER);
		frame.add(jp3, BorderLayout.SOUTH);
	}

	void checksetDisplay() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//setSize(300, 100);
		frame.pack();
		jbno.addActionListener(this);
		jbyes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbno) {
			new DeleteWD(sourceDTO);
			frame.setVisible(false);
		}else if(e.getSource() == jbyes) {	//Ȯ�ι�ư ������
			totalDAO.delete(sourceDTO);

			DeleteWD dl = new DeleteWD(sourceDTO);
			new LoginWD();
			dl.frame.setVisible(false);
			frame.setVisible(false);

			JOptionPane.showMessageDialog(null, "Ż���ϼ̽��ϴ�");


		}
	}
}