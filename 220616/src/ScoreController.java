import java.util.Scanner;

public class ScoreController {
	Scanner sc = new Scanner(System.in);
	ScoreAct scoreAct = new ScoreAct();
	
	boolean onWork = true;
	void manuSelect() {
		while (onWork) {
			System.out.println("�޴� �� �����ϼ���");
			System.out.println("1. �����Է�");
			System.out.println("2. ��������");
			System.out.println("3. ��������");
			System.out.println("4. ���α׷� ����");
			int manuNum = sc.nextInt();

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
				System.out.println("���α׷� ���� â");
				onWork = false;
				break;
			default:
				System.out.println("�߸��� ���Դϴ�. �ٽ� �����ϼ���");
				break;
			}

		}
		
	}
}
