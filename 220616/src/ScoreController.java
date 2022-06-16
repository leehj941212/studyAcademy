import java.util.Scanner;

public class ScoreController {
	Scanner sc = new Scanner(System.in);
	ScoreAct scoreAct = new ScoreAct();
	
	boolean isWork = true;
	void manuSelect() {
		while (isWork) {
			System.out.println("메뉴 중 선택하세요");
			System.out.println("1. 성적입력");
			System.out.println("2. 성적수정");
			System.out.println("3. 성적삭제");
			System.out.println("4. 프로그램 종료");
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
				System.out.println("프로그램이 종료되었습니다");
				isWork = false;
				break;
			default:
				System.out.println("잘못된 값입니다. 다시 선택하세요");
				break;
			}

		}
		
	}
}
