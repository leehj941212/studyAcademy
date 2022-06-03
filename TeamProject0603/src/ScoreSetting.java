//정보 삭제
//입력받은 name ArrayList 의 값과 같은 순서에 위치하는 다른  ArrayList 값들을 삭제 한다

import java.util.ArrayList;
import java.util.Scanner;

 class ScoreSetting {
	static ArrayList<String> name = new ArrayList<String>();
	static ArrayList<Integer> java = new ArrayList<Integer>();
	static ArrayList<Integer> web = new ArrayList<Integer>();
	static ArrayList<Integer> jsp = new ArrayList<Integer>(); // Array list 생성
	
	Scanner sc = new Scanner (System.in);

	void scoreInput() {
		
		System.out.println("학생 이름을 입력하세요");
		ScoreSetting.name.add(sc.nextLine());
		System.out.println("해당 학생의 java 점수를 입력하세요");
		ScoreSetting.java.add(sc.nextInt());
		System.out.println("해당 학생의 web 점수를 입력하세요");
		ScoreSetting.web.add(sc.nextInt());
		System.out.println("해당 학생의 jsp 점수를 입력하세요");
		ScoreSetting.jsp.add(sc.nextInt());

	}
	
	void scoreOutput() {

		System.out.println("성적을 출력할 학생의 이름을 입력하세요");
		String name1 = sc.nextLine();
		ScoreSetting.name.add(name1);


		if (ScoreSetting.name.contains(name1)) {
			int a = ScoreSetting.name.indexOf(name1);
			System.out.print("java 점수 : " + ScoreSetting.java.get(a) + " ");
			System.out.print("web 점수 : " + ScoreSetting.web.get(a) + " ");
			System.out.print("jsp 점수 : " + ScoreSetting.jsp.get(a) + " ");
			System.out.println();
		} else {
			System.out.println("해당하는 정보가 없습니다");
		}
	}

	void scoreOutputAll() {

		for (int i = 0; i < ScoreSetting.name.size(); i++) {
			System.out.print("이름 : " + ScoreSetting.name.get(i) + " ");
			System.out.print("java 점수 : " + ScoreSetting.java.get(i) + " ");
			System.out.print("web 점수 : " + ScoreSetting.web.get(i) + " ");
			System.out.print("jsp 점수 : " + ScoreSetting.jsp.get(i) + " ");
			System.out.println();
		}

	}

	void scoreDelete() {

		System.out.println("데이터를 삭제할 학생의 이름을 입력하세요");
		String name1 = sc.nextLine();

		if (ScoreSetting.name.contains(name1)) {
			int a = ScoreSetting.name.indexOf(name1);
			ScoreSetting.name.remove(a);
			ScoreSetting.java.remove(a);
			ScoreSetting.web.remove(a);
			ScoreSetting.jsp.remove(a);
		} else {
			System.out.println("해당하는 정보가 없습니다");
		}
	}
	
	void scoreProgramOff() {
		System.out.println("프로그램을 종료합니다.");
	}
	
}