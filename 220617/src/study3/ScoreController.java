package study3;

public class ScoreController {
	ScoreAct scoreAct = new ScoreAct();	
	
	public ScoreController() {	
		scoreAct.connectMysql();
		boolean isWork = true;
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
