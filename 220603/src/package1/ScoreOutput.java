package package1;
//성적 출력
// scoreOutput() 메소드는 입력받은 name ArrayList 의 값과 같은 순서에 위치하는 다른  ArrayList 값들을 출력 한다
//scoreOutputAll() 메소드는 전체 ArrayList 값들을 출력 한다

import java.util.Scanner;

public class ScoreOutput {

	void scoreOutput() {
		Scanner sc = new Scanner (System.in);

		System.out.println("성적을 출력할 학생의 이름을 입력하세요");
		String name1 = sc.nextLine();
		ScoreData.name.add(name1);


		if (ScoreData.name.contains(name1)) {
			int a = ScoreData.name.indexOf(name1);
			System.out.print("java 점수 : " + ScoreData.java.get(a) + " ");
			System.out.print("web 점수 : " + ScoreData.web.get(a) + " ");
			System.out.print("jsp 점수 : " + ScoreData.jsp.get(a) + " ");
			System.out.println();
		} else {
			System.out.println("해당하는 정보가 없습니다");
		}
	}

	void scoreOutputAll() {

		for (int i = 0; i < ScoreData.name.size(); i++) {
			System.out.print("이름 : " + ScoreData.name.get(i) + " ");
			System.out.print("java 점수 : " + ScoreData.java.get(i) + " ");
			System.out.print("web 점수 : " + ScoreData.web.get(i) + " ");
			System.out.print("jsp 점수 : " + ScoreData.jsp.get(i) + " ");
			System.out.println();
		}

	}
}
