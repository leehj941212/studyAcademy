package package2;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreSetting2 {
	//ScoreData2 �� ��üȭ
	ArrayList<ScoreData2> list = new ArrayList<ScoreData2>();
	Scanner sc = new Scanner(System.in);
	
	//���� �Է�
	void scoreInput() {

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
	
	//���� ���
	void scoreOutput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("������ ����� �л��� �̸��� �Է��ϼ���");
		String name = sc.nextLine();
		int su = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				System.out.println("java ���� : " + list.get(i).getJava() + " ");
				System.out.println("web ���� : " + list.get(i).getWeb() + " ");
				System.out.println("jsp ���� : " + list.get(i).getJsp() + " ");
				su = i;
				break;
			}

		}

		if (su == -1) {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}

	}
	
	//���� ��ü ���
	void scoreOutputAll() {

		for (int i = 0; i < list.size(); i++) {

			System.out.println("�̸� : " + list.get(i).getName() + " ");
			System.out.println("java ���� : " + list.get(i).getJava() + " ");
			System.out.println("web ���� : " + list.get(i).getWeb() + " ");
			System.out.println("jsp ���� : " + list.get(i).getJsp() + " ");
			System.out.println();
		}		

	}
	
	//���� ����
	void scoreDelete() {	
		Scanner sc = new Scanner(System.in);

		System.out.println("�����͸� ������ �л��� �̸��� �Է��ϼ���");
		String name = sc.nextLine();
		int su = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				su = i;
				break;
			}

		}

		if (su == -1) {
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		}

	}
	
	//���α׷� ����
	void scoreProgramOff() {
		System.out.println("���α׷��� �����մϴ�.");
	}

}
