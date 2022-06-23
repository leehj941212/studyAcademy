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
			System.out.println("�޴��� �����ϼ���");
			System.out.println("1 . �Է�");
			System.out.println("2 . ��ȸ");
			System.out.println("3 . ����");
			System.out.println("4 . ����");
			System.out.println("5 . ����");
			menuNum = scanner.nextLine();

			switch (menuNum) {
			//DataCreate.executeMysql() -> studentDAO.insertConnect() 
			//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml �� insert("") ����
			case "1": case "�Է�":
				scoreInterface = new DataInsert();
				scoreInterface.executeMysql();
				break;
				//DataSelect.executeMysql() -> studentDAO.insertConnect() 
				//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml �� select("") ����
				//-> List ���·� ���� �޾� return -> �ٽ� studentDAO.insertConnect() ���� ���
			case "2": case "��ȸ":
				scoreInterface = new DataSelect();
				scoreInterface.executeMysql();
				break;
				//DataUpdate.executeMysql() -> studentDAO.deleteConnect() 
				//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml �� delete("") ����
			case "3": case "����":
				scoreInterface = new DataUpdate();
				scoreInterface.executeMysql();
				break;
				//DataDelete.executeMysql() -> studentDAO.insertConnect() 
				//-> mysqlconnectconfig.xml -> mysqlinsertconfig.xml �� insert("") ����
			case "4": case "����":
				scoreInterface = new DataDelete();
				scoreInterface.executeMysql();
				break;
			case "5": case "����":
				System.out.println("���α׷��� ����Ǿ����ϴ�");
				isRun = false;
				break;

				//�߸� �Է�������
			default:
				System.out.println("�߸� �Է��߽��ϴ� �ٽ� �Է��ϼ���");
				break;
			}

		}
		scanner.close();
	}

}
