package study3;

public class ScoreController {
	ScoreAct scoreAct = new ScoreAct();
	boolean isWork = true;
	
	public ScoreController() {	
		scoreAct.connectMysql();
		while (isWork){	
			String menuNum = scoreAct.menuSelect();
			switch (menuNum) {
			case "1":
				scoreAct.create();
				break;
			case "2":
				scoreAct.update();
				break;
			case "3":
				scoreAct.delete();
				break;
			case "4":
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
