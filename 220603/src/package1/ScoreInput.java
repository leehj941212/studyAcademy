package package1;
// 성적 입력
// ArrayList 의 값들을 추가 한다

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreInput  {

	void scoreInput() {

		Scanner sc = new Scanner (System.in);
		//ScoreData data = new ScoreInput();

		System.out.println("학생 이름을 입력하세요");
		ScoreData.name.add(sc.nextLine());
		System.out.println("해당 학생의 java 점수를 입력하세요");
		ScoreData.java.add(sc.nextInt());
		System.out.println("해당 학생의 web 점수를 입력하세요");
		ScoreData.web.add(sc.nextInt());
		System.out.println("해당 학생의 jsp 점수를 입력하세요");
		ScoreData.jsp.add(sc.nextInt());

	}

}
