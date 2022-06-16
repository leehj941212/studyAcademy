package memberProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GradeWindow extends JFrame{
	
	static int memberRank = 0;	// 회원 등수
	
	public GradeWindow(String loginID) {
		JLabel id = new JLabel(loginID, 10);
		JLabel name = new JLabel("", 10);
		JLabel korGrade = new JLabel("", 10);
		JLabel engGrade = new JLabel("", 10);
		JLabel mathGrade = new JLabel("", 10);
		JLabel average = new JLabel("", 10);
		JLabel rank = new JLabel("", 10);
		
		setLayout(new BorderLayout());
		
		/* NORTH에 들어갈 패널 */
		JPanel memberPanel = new JPanel();
		memberPanel.setLayout(new GridLayout(2,1));
		// title
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("성적관리"));
		// 기본정보
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(new JLabel("아이디 : "));
		infoPanel.add(id);
		infoPanel.add(new JLabel("이름 : "));
		infoPanel.add(name);
		
		memberPanel.add(titlePanel);
		memberPanel.add(infoPanel);
		
		/* CENTER에 들어갈 패널 */
		JPanel gradePanel = new JPanel();
		gradePanel.setLayout(new GridLayout(5,1));
		// 국어성적
		JPanel korPanel = new JPanel();
		korPanel.setLayout(new FlowLayout());
		korPanel.add(new JLabel("국어성적 : "));
		korPanel.add(korGrade);
		// 영어성적
		JPanel engPanel = new JPanel();
		engPanel.setLayout(new FlowLayout());
		engPanel.add(new JLabel("영어성적 : "));
		engPanel.add(engGrade);
		// 수학성적
		JPanel mathPanel = new JPanel();
		mathPanel.setLayout(new FlowLayout());
		mathPanel.add(new JLabel("수학성적 : "));
		mathPanel.add(mathGrade);
		// 평균
		JPanel avgPanel = new JPanel();
		avgPanel.setLayout(new FlowLayout());
		avgPanel.add(new JLabel("평균 : "));
		avgPanel.add(average);
		// 등수
		JPanel rankPanel = new JPanel();
		rankPanel.setLayout(new FlowLayout());
		rankPanel.add(new JLabel("등수 : "));
		rankPanel.add(rank);
		
		gradePanel.add(korPanel);
		gradePanel.add(engPanel);
		gradePanel.add(mathPanel);
		gradePanel.add(avgPanel);
		gradePanel.add(rankPanel);
		
		add(memberPanel, BorderLayout.NORTH);
		add(gradePanel, BorderLayout.CENTER);
		
		/* 로그인한 ID로 회원의 정보 가져오기 */
		MemberDTO loginMember = getLoginMember(loginID);
		name.setText(loginMember.getMemberName());
		korGrade.setText(loginMember.getKorGrade());
		engGrade.setText(loginMember.getEngGrade());
		mathGrade.setText(loginMember.getMathGrade());
		average.setText(loginMember.getAverage());
		rank.setText(Integer.toString(memberRank));
		
		setVisible(true);
		setSize(300, 250);
	}
	
	/* 로그인한 ID로 회원의 정보 가져오기 위한 메소드*/
	public static MemberDTO getLoginMember(String loginID) {
		HashMap<String, MemberDTO> members = MemberDAO.getAllMemeber();
		
		// 로그인한 ID의 회원정보
		MemberDTO member = new MemberDTO();
		if(members.containsKey(loginID))
		{
			member = members.get(loginID);
		}
		
		// 회원 전체를 ArrayList로 저장
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		for(String key : members.keySet())
		{
			memberList.add(members.get(key));
		}
		// MemberDTO에 Comparable 구현했기때문에 가능함. 
		Collections.sort(memberList, Collections.reverseOrder());
		// 로그인한 ID의 등수 계산
		for(int i=0; i<memberList.size(); i++)
			if((memberList.get(i).getMemberId()).equals(loginID))
				memberRank = i+1;
		
		return member;
	}
	
	
}
