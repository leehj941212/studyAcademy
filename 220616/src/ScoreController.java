import java.util.Scanner;

public class ScoreController {
	Scanner sc = new Scanner(System.in);
	ScoreAct scoreAct = new ScoreAct();
	
	boolean isWork = true;
	void manuSelect() {
		while (isWork) {
			System.out.println("�޴� �� �����ϼ���");
			System.out.println("1. �����Է�");
			System.out.println("2. ��������");
			System.out.println("3. ��������");
			System.out.println("4. ���α׷� ����");
			int manuNum = sc.nextInt();
			sc.nextLine();

			switch (manuNum) {
			case 1:
				scoreAct.input();
				break;
			case 2:
				scoreAct.change();
				break;
			case 3:
				scoreAct.delete();
				break;
			case 4:
				System.out.println("���α׷��� ����Ǿ����ϴ�");
				isWork = false;
				break;
			default:
				System.out.println("�߸��� ���Դϴ�. �ٽ� �����ϼ���");
				break;
			}

		}
		
	}
}
