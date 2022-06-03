package package1;
import java.util.Scanner;

public class ScoreProMain {

	public static void main(String[] args) {
		
		//입력값을 받기위해 Scanner 객체화
		Scanner sc = new Scanner (System.in);
		
		//각 클래스를 객체화
		ScoreInput input = new ScoreInput();
		ScoreOutput output = new ScoreOutput();
		ScoreDelete delete = new ScoreDelete();
		ScoreProgramOff off = new ScoreProgramOff();



		//i = 1 일때까지 반복
		for (int i = 0; i != 1;) {

			System.out.println("1~5 중 입력하세요");

			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 성적 출력");
			System.out.println("3. 학생 성적 전체 출력");
			System.out.println("4. 학생 성적 정보 삭제");
			System.out.println("5. 프로그램 종료");
			
			//메뉴 1~5번중 입력을 받는다
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
				
				default: System.out.println("다시 입력하세요"); 
				break;
				}
		}



	}

}
