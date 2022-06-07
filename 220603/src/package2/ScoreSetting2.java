package package2;
// ���� �Է�
// ArrayList �� ������ �߰� �Ѵ�

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreSetting2 {
	ArrayList<ScoreData2> list = new ArrayList<ScoreData2>();

	void scoreInput() {
		Scanner sc = new Scanner (System.in);	
		ScoreData2 data = new ScoreData2();

		System.out.println("�л� �̸��� �Է��ϼ���");
		data.setName(sc.nextLine());
		System.out.println("�ش� �л��� java ������ �Է��ϼ���");
		data.setJava(sc.nextInt());
		System.out.println("�ش� �л��� web ������ �Է��ϼ���");
		data.setWeb(sc.nextInt());
		System.out.println("�ش� �л��� jsp ������ �Է��ϼ���");
		data.setJsp(sc.nextInt());
		
		list.add(data);

	}

	void scoreOutput() {
		Scanner sc = new Scanner (System.in);
		System.out.println("������ ����� �л��� �̸��� �Է��ϼ���");
		String name = sc.nextLine();

		if (list.contains(name)) {
			ScoreData2 value = list.get(list.indexOf(name));

			System.out.println("java ���� : " + value.getJava() + " ");
			System.out.println("web ���� : " + value.getWeb() + " ");
			System.out.println("jsp ���� : " + value.getJsp() + " ");
		} else {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}

	}

	void scoreOutputAll() {
		
		for (int i = 0; i < list.size(); i++) {
			ScoreData2 value = list.get(list.indexOf(i));
			
			System.out.println("�̸� : " + value.getName() + " ");
			System.out.println("java ���� : " + value.getJava() + " ");
			System.out.println("web ���� : " + value.getWeb() + " ");
			System.out.println("jsp ���� : " + value.getJsp() + " ");
			System.out.println();
		}		

	}
	
	void scoreDelete() {	
		Scanner sc = new Scanner (System.in);
		System.out.println("�����͸� ������ �л��� �̸��� �Է��ϼ���");
		String name3 = sc.nextLine();

		if (list.contains(name3)) {
			list.remove(list.indexOf(name3));
		} else {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}

	}
	
	void scoreProgramOff() {
		System.out.println("���α׷��� �����մϴ�.");
	}

}
