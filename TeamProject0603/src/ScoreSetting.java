//���� ����
//�Է¹��� name ArrayList �� ���� ���� ������ ��ġ�ϴ� �ٸ�  ArrayList ������ ���� �Ѵ�

import java.util.ArrayList;
import java.util.Scanner;

 class ScoreSetting {
	static ArrayList<String> name = new ArrayList<String>();
	static ArrayList<Integer> java = new ArrayList<Integer>();
	static ArrayList<Integer> web = new ArrayList<Integer>();
	static ArrayList<Integer> jsp = new ArrayList<Integer>(); // Array list ����
	
	Scanner sc = new Scanner (System.in);

	void scoreInput() {
		
		System.out.println("�л� �̸��� �Է��ϼ���");
		ScoreSetting.name.add(sc.nextLine());
		System.out.println("�ش� �л��� java ������ �Է��ϼ���");
		ScoreSetting.java.add(sc.nextInt());
		System.out.println("�ش� �л��� web ������ �Է��ϼ���");
		ScoreSetting.web.add(sc.nextInt());
		System.out.println("�ش� �л��� jsp ������ �Է��ϼ���");
		ScoreSetting.jsp.add(sc.nextInt());

	}
	
	void scoreOutput() {

		System.out.println("������ ����� �л��� �̸��� �Է��ϼ���");
		String name1 = sc.nextLine();
		ScoreSetting.name.add(name1);


		if (ScoreSetting.name.contains(name1)) {
			int a = ScoreSetting.name.indexOf(name1);
			System.out.print("java ���� : " + ScoreSetting.java.get(a) + " ");
			System.out.print("web ���� : " + ScoreSetting.web.get(a) + " ");
			System.out.print("jsp ���� : " + ScoreSetting.jsp.get(a) + " ");
			System.out.println();
		} else {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}
	}

	void scoreOutputAll() {

		for (int i = 0; i < ScoreSetting.name.size(); i++) {
			System.out.print("�̸� : " + ScoreSetting.name.get(i) + " ");
			System.out.print("java ���� : " + ScoreSetting.java.get(i) + " ");
			System.out.print("web ���� : " + ScoreSetting.web.get(i) + " ");
			System.out.print("jsp ���� : " + ScoreSetting.jsp.get(i) + " ");
			System.out.println();
		}

	}

	void scoreDelete() {

		System.out.println("�����͸� ������ �л��� �̸��� �Է��ϼ���");
		String name1 = sc.nextLine();

		if (ScoreSetting.name.contains(name1)) {
			int a = ScoreSetting.name.indexOf(name1);
			ScoreSetting.name.remove(a);
			ScoreSetting.java.remove(a);
			ScoreSetting.web.remove(a);
			ScoreSetting.jsp.remove(a);
		} else {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}
	}
	
	void scoreProgramOff() {
		System.out.println("���α׷��� �����մϴ�.");
	}
	
}