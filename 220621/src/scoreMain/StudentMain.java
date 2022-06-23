package scoreMain;

import java.util.Scanner;

import scoreAction.*;


public class StudentMain {

	public static void main(String[] args) {
		ScoreInterface scoreInterface;
		Scanner scanner = new Scanner(System.in);
		String menuNum;
		boolean isRun = true;
		while (isRun) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1 . 입력");
			System.out.println("2 . 조회");
			System.out.println("3 . 수정");
			System.out.println("4 . 삭제");
			System.out.println("5 . 종료");
			menuNum = scanner.nextLine();

			switch (menuNum) {
			//DataCreate.executeMysql() -> studentDAO.insertConnect() 
			//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml 의 insert("") 실행
			case "1": case "입력":
				scoreInterface = new DataInsert();
				scoreInterface.executeMysql();
				break;
				//DataSelect.executeMysql() -> studentDAO.insertConnect() 
				//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml 의 select("") 실행
				//-> List 형태로 값을 받아 return -> 다시 studentDAO.insertConnect() 에서 출력
			case "2": case "조회":
				scoreInterface = new DataSelect();
				scoreInterface.executeMysql();
				break;
				//DataUpdate.executeMysql() -> studentDAO.deleteConnect() 
				//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml 의 delete("") 실행
			case "3": case "수정":
				scoreInterface = new DataUpdate();
				scoreInterface.executeMysql();
				break;
				//DataDelete.executeMysql() -> studentDAO.insertConnect() 
				//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml 의 insert("") 실행
			case "4": case "삭제":
				scoreInterface = new DataDelete();
				scoreInterface.executeMysql();
				break;
			case "5": case "종료":
				System.out.println("프로그램이 종료되었습니다");
				isRun = false;
				break;

				//잘못 입력했을때
			default:
				System.out.println("잘못 입력했습니다 다시 입력하세요");
				break;
			}

		}
		scanner.close();
	}

}
