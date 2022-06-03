package package1;
//정보 삭제
//입력받은 name ArrayList 의 값과 같은 순서에 위치하는 다른  ArrayList 값들을 삭제 한다

import java.util.Scanner;

public class ScoreDelete {

	void scoreDelete() {
		Scanner sc = new Scanner (System.in);

		System.out.println("데이터를 삭제할 학생의 이름을 입력하세요");
		String name1 = sc.nextLine();

		if (ScoreData.name.contains(name1)) {
			int a = ScoreData.name.indexOf(name1);
			ScoreData.name.remove(a);
			ScoreData.java.remove(a);
			ScoreData.web.remove(a);
			ScoreData.jsp.remove(a);
		} else {
			System.out.println("해당하는 정보가 없습니다");
		}
	}
}