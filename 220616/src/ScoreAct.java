import java.util.ArrayList;
import java.util.Scanner;

public class ScoreAct {
	Scanner sc = new Scanner(System.in);
	ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

	void input() {
		ScoreDTO student = new ScoreDTO();

		System.out.println("�̸��� �Է��ϼ���");
		
		student.setName(sc.nextLine());
		System.out.println("��ȣ�� �Է��ϼ���");
		student.setNum(sc.nextInt());
		System.out.println("���� ������ �Է��ϼ���");
		student.setMath(sc.nextInt());
		System.out.println("���� ������ �Է��ϼ���");
		student.setScience(sc.nextInt());
		sc.nextLine();
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�");
		
		

		list.add(student);
	}

	void change() {
		int index = lookUp();
		if (index == -1) {	
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		} else {
			System.out.println("�̸��� �Է��ϼ���");
			
			list.get(index).setName(sc.nextLine());
			System.out.println("��ȣ�� �Է��ϼ���");
			list.get(index).setNum(sc.nextInt());
			System.out.println("���� ������ �Է��ϼ���");
			list.get(index).setMath(sc.nextInt());
			System.out.println("���� ������ �Է��ϼ���");
			list.get(index).setScience(sc.nextInt());
			sc.nextLine();
			System.out.println("������ �Ϸ�Ǿ����ϴ�");
			
			

		}

	}

	void delete() {
		int index = lookUp();
		if (index == -1) {		
			System.out.println("�ش��ϴ� ������ �����ϴ�");
		} else {
			list.remove(index);
			System.out.println("������ �Ϸ�Ǿ����ϴ�");
		}

	}

	int lookUp() {

		int index = -1;
		System.out.println("�ش� �л��� ��ȣ�� �Է��ϼ���");
		int intSc = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (intSc == list.get(i).getNum()) {
				index = i;
				break;
			} 
		}
		return index;

	}
}