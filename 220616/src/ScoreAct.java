import java.util.ArrayList;
import java.util.Scanner;

public class ScoreAct {
	Scanner sc = new Scanner(System.in);
	ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

	void input() {
		ScoreDTO student = new ScoreDTO();

		String str = null;
		str = sc.nextLine();
		int i = sc.nextInt();

		System.out.println("이름을 입력하세요");
		student.setName(str);
		System.out.println("번호를 입력하세요");
		student.setNum(i);
		System.out.println("수학 점수를 입력하세요");
		student.setMath(i);
		System.out.println("과학 점수를 입력하세요");
		student.setScience(i);

		list.add(student);
	}

	void change() {

	}

	void delete() {

	}
}