package package1;
import java.util.Scanner;

public class ScoreProMain {

	public static void main(String[] args) {
		
		//�Է°��� �ޱ����� Scanner ��üȭ
		Scanner sc = new Scanner (System.in);
		
		//�� Ŭ������ ��üȭ
		ScoreInput input = new ScoreInput();
		ScoreOutput output = new ScoreOutput();
		ScoreDelete delete = new ScoreDelete();
		ScoreProgramOff off = new ScoreProgramOff();



		//i = 1 �϶����� �ݺ�
		for (int i = 0; i != 1;) {

			System.out.println("1~5 �� �Է��ϼ���");

			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ���� ���");
			System.out.println("3. �л� ���� ��ü ���");
			System.out.println("4. �л� ���� ���� ����");
			System.out.println("5. ���α׷� ����");
			
			//�޴� 1~5���� �Է��� �޴´�
			int a = sc.nextInt();
			
				switch (a) {
				case 1: input.scoreInput();
				break;

				case 2: output.scoreOutput();
				break;

				case 3: output.scoreOutputAll();
				break;

				case 4: delete.scoreDelete();
				break;

				case 5: off.scoreProgramOff();
				i = 1;
				break;
				
				default: System.out.println("�ٽ� �Է��ϼ���"); 
				break;
				}
		}



	}

}
