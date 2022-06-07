package package2;
// 성적 입력
// ArrayList 의 값들을 추가 한다

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreSetting2 {
	ArrayList<ScoreData2> list = new ArrayList<ScoreData2>();

	void scoreInput() {
		Scanner sc = new Scanner (System.in);	
		ScoreData2 data = new ScoreData2();

		System.out.println("학생 이름을 입력하세요");
		data.setName(sc.nextLine());
		System.out.println("해당 학생의 java 점수를 입력하세요");
		data.setJava(sc.nextInt());
		System.out.println("해당 학생의 web 점수를 입력하세요");
		data.setWeb(sc.nextInt());
		System.out.println("해당 학생의 jsp 점수를 입력하세요");
		data.setJsp(sc.nextInt());
		
		list.add(data);

	}

	void scoreOutput() {
		Scanner sc = new Scanner (System.in);
		System.out.println("성적을 출력할 학생의 이름을 입력하세요");
		String name = sc.nextLine();

		if (list.contains(name)) {
			ScoreData2 value = list.get(list.indexOf(name));

			System.out.println("java 점수 : " + value.getJava() + " ");
			System.out.println("web 점수 : " + value.getWeb() + " ");
			System.out.println("jsp 점수 : " + value.getJsp() + " ");
		} else {
			System.out.println("해당하는 정보가 없습니다");
		}

	}

	void scoreOutputAll() {
		
		for (int i = 0; i < list.size(); i++) {
			ScoreData2 value = list.get(list.indexOf(i));
			
			System.out.println("이름 : " + value.getName() + " ");
			System.out.println("java 점수 : " + value.getJava() + " ");
			System.out.println("web 점수 : " + value.getWeb() + " ");
			System.out.println("jsp 점수 : " + value.getJsp() + " ");
			System.out.println();
		}		

	}
	
	void scoreDelete() {	
		Scanner sc = new Scanner (System.in);
		System.out.println("데이터를 삭제할 학생의 이름을 입력하세요");
		String name3 = sc.nextLine();

		if (list.contains(name3)) {
			list.remove(list.indexOf(name3));
		} else {
			System.out.println("해당하는 정보가 없습니다");
		}

	}
	
	void scoreProgramOff() {
		System.out.println("프로그램을 종료합니다.");
	}

}
