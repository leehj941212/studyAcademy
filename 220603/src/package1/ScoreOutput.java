package package1;
//���� ���
// scoreOutput() �޼ҵ�� �Է¹��� name ArrayList �� ���� ���� ������ ��ġ�ϴ� �ٸ�  ArrayList ������ ��� �Ѵ�
//scoreOutputAll() �޼ҵ�� ��ü ArrayList ������ ��� �Ѵ�

import java.util.Scanner;

public class ScoreOutput {

	void scoreOutput() {
		Scanner sc = new Scanner (System.in);

		System.out.println("������ ����� �л��� �̸��� �Է��ϼ���");
		String name1 = sc.nextLine();
		ScoreData.name.add(name1);


		if (ScoreData.name.contains(name1)) {
			int a = ScoreData.name.indexOf(name1);
			System.out.print("java ���� : " + ScoreData.java.get(a) + " ");
			System.out.print("web ���� : " + ScoreData.web.get(a) + " ");
			System.out.print("jsp ���� : " + ScoreData.jsp.get(a) + " ");
			System.out.println();
		} else {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}
	}

	void scoreOutputAll() {

		for (int i = 0; i < ScoreData.name.size(); i++) {
			System.out.print("�̸� : " + ScoreData.name.get(i) + " ");
			System.out.print("java ���� : " + ScoreData.java.get(i) + " ");
			System.out.print("web ���� : " + ScoreData.web.get(i) + " ");
			System.out.print("jsp ���� : " + ScoreData.jsp.get(i) + " ");
			System.out.println();
		}

	}
}
