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

		System.out.println("�̸��� �Է��ϼ���");
		student.setName(str);
		System.out.println("��ȣ�� �Է��ϼ���");
		student.setNum(i);
		System.out.println("���� ������ �Է��ϼ���");
		student.setMath(i);
		System.out.println("���� ������ �Է��ϼ���");
		student.setScience(i);

		list.add(student);
	}

	void change() {

	}

	void delete() {

	}
}