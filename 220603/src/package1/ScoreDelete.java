package package1;
//���� ����
//�Է¹��� name ArrayList �� ���� ���� ������ ��ġ�ϴ� �ٸ�  ArrayList ������ ���� �Ѵ�

import java.util.Scanner;

public class ScoreDelete {

	void scoreDelete() {
		Scanner sc = new Scanner (System.in);

		System.out.println("�����͸� ������ �л��� �̸��� �Է��ϼ���");
		String name1 = sc.nextLine();

		if (ScoreData.name.contains(name1)) {
			int a = ScoreData.name.indexOf(name1);
			ScoreData.name.remove(a);
			ScoreData.java.remove(a);
			ScoreData.web.remove(a);
			ScoreData.jsp.remove(a);
		} else {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}
	}
}