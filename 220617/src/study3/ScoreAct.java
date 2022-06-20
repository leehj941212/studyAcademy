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
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/study3", "root", "1234");
			statement = connection.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	String menuSelect() {
		System.out.println("메뉴 중 선택하세요");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적수정");
		System.out.println("3. 성적삭제");
		System.out.println("4. 프로그램 종료");
		String menuNum = sc.nextLine();
		return menuNum;
	}

	boolean lookUp() {
		boolean isName = false;

		System.out.println("학생의 이름을 입력하세요");
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
				System.out.println("번호를 입력하세요");
				student.setNum(sc.nextInt());
				System.out.println("수학 점수를 입력하세요");
				student.setMath(sc.nextInt());
				System.out.println("과학 점수를 입력하세요");
				student.setScience(sc.nextInt());
				sc.nextLine();

				//sql에 입력할 명령문
				String sql = "insert into score values('"
						+student.getName() +"' , " 
						+ student.getNum() + " , " 
						+ student.getMath()+ " , " 
						+ student.getScience() +")";

				//()안의 내용을 실행한다
				statement.executeUpdate(sql);
				System.out.println("입력이 완료되었습니다");

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("이미 등록된 이름 입니다 초기 화면으로 돌아갑니다");
		}	
	}


	void update() {
		boolean isName = lookUp();

		if (!isName) {
			System.out.println("해당하는 정보가 없습니다 초기 화면으로 돌아갑니다");
		} else {
			try {
				System.out.println("번호를 입력하세요");
				student.setNum(sc.nextInt());
				System.out.println("수학 점수를 입력하세요");
				student.setMath(sc.nextInt());
				System.out.println("과학 점수를 입력하세요");
				student.setScience(sc.nextInt());
				sc.nextLine();

				//sql에 입력할 명령문
				String sql = "update score set name = '"
						+student.getName()+"' , num = "
						+ student.getNum()+ " , math = " 
						+ student.getMath()+ " , science = " 
						+ student.getScience()+ " where name = '"+student.getName()+"'";

				//()안의 내용을 실행한다
				statement.executeUpdate(sql);

				System.out.println("수정이 완료되었습니다");
			} catch (Exception e) {
				System.out.println(e);
			}

		}		

	}

	void delete() {
		boolean isName = lookUp();

		if (!isName) {		
			System.out.println("해당하는 정보가 없습니다 초기화면으로 돌아갑니다");
		} else {
			try {
				//sql에 입력할 명령문
				String sql = "delete from score where name = '"+student.getName()+"'";
				//()안의 내용을 실행한다
				statement.executeUpdate(sql);				
				System.out.println("삭제가 완료되었습니다");		
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}


}