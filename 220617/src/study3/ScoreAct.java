package study3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ScoreAct {
	Scanner sc = new Scanner(System.in);
	ScoreDTO student = new ScoreDTO();
	Connection connection = null;
	Statement statement = null;

	void connectMysql() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/study3", "root", "1234");
			statement = connection.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	String menuSelect() {
		System.out.println("�޴� �� �����ϼ���");
		System.out.println("1. �����Է�");
		System.out.println("2. ��������");
		System.out.println("3. ��������");
		System.out.println("4. ���α׷� ����");
		String menuNum = sc.nextLine();
		return menuNum;
	}

	boolean lookUp() {
		boolean isName = false;

		System.out.println("�л��� �̸��� �Է��ϼ���");
		student.setName(sc.nextLine());
		String sql = "select*from score where name = '"+ student.getName() +"'";		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				isName = true;
			} else {
				isName = false;
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return isName;
	}

	void create() {
		boolean isName = lookUp();

		if (!isName) {
			try {
				System.out.println("��ȣ�� �Է��ϼ���");
				student.setNum(sc.nextInt());
				System.out.println("���� ������ �Է��ϼ���");
				student.setMath(sc.nextInt());
				System.out.println("���� ������ �Է��ϼ���");
				student.setScience(sc.nextInt());
				sc.nextLine();

				//sql�� �Է��� ��ɹ�
				String sql = "insert into score values('"
						+student.getName() +"' , " 
						+ student.getNum() + " , " 
						+ student.getMath()+ " , " 
						+ student.getScience() +")";

				//()���� ������ �����Ѵ�
				statement.executeUpdate(sql);
				System.out.println("�Է��� �Ϸ�Ǿ����ϴ�");

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("�̹� ��ϵ� �̸� �Դϴ� �ʱ� ȭ������ ���ư��ϴ�");
		}	
	}


	void update() {
		boolean isName = lookUp();

		if (!isName) {
			System.out.println("�ش��ϴ� ������ �����ϴ� �ʱ� ȭ������ ���ư��ϴ�");
		} else {
			try {
				System.out.println("��ȣ�� �Է��ϼ���");
				student.setNum(sc.nextInt());
				System.out.println("���� ������ �Է��ϼ���");
				student.setMath(sc.nextInt());
				System.out.println("���� ������ �Է��ϼ���");
				student.setScience(sc.nextInt());
				sc.nextLine();

				//sql�� �Է��� ��ɹ�
				String sql = "update score set name = '"
						+student.getName()+"' , num = "
						+ student.getNum()+ " , math = " 
						+ student.getMath()+ " , science = " 
						+ student.getScience()+ " where name = '"+student.getName()+"'";

				//()���� ������ �����Ѵ�
				statement.executeUpdate(sql);

				System.out.println("������ �Ϸ�Ǿ����ϴ�");
			} catch (Exception e) {
				System.out.println(e);
			}

		}		

	}

	void delete() {
		boolean isName = lookUp();

		if (!isName) {		
			System.out.println("�ش��ϴ� ������ �����ϴ� �ʱ�ȭ������ ���ư��ϴ�");
		} else {
			try {
				//sql�� �Է��� ��ɹ�
				String sql = "delete from score where name = '"+student.getName()+"'";
				//()���� ������ �����Ѵ�
				statement.executeUpdate(sql);				
				System.out.println("������ �Ϸ�Ǿ����ϴ�");		
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}


}