package package1;
// ���� �Է�
// ArrayList �� ������ �߰� �Ѵ�

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreInput  {

	void scoreInput() {

		Scanner sc = new Scanner (System.in);
		//ScoreData data = new ScoreInput();

		System.out.println("�л� �̸��� �Է��ϼ���");
		ScoreData.name.add(sc.nextLine());
		System.out.println("�ش� �л��� java ������ �Է��ϼ���");
		ScoreData.java.add(sc.nextInt());
		System.out.println("�ش� �л��� web ������ �Է��ϼ���");
		ScoreData.web.add(sc.nextInt());
		System.out.println("�ش� �л��� jsp ������ �Է��ϼ���");
		ScoreData.jsp.add(sc.nextInt());

	}

}
