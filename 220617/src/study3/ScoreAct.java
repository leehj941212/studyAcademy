package study3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ScoreAct {
	Scanner sc = new Scanner(System.in);
	ScoreDTO student = new ScoreDTO();
	Class classA = null;
	Connection connection = null;
	Statement statement = null;
	
	
	boolean read() {
		boolean isName = false;

		try {
			//사용할 클래스에 접근하게 해준다
			classA = Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/study3", "root", "1234");	
			
			
			System.out.println("학생의 이름을 입력하세요");
			student.setName(sc.nextLine());

			String sql = "select*from score where name = '"+ student.getName() +"'";
			//명령문 수행할수 있게 Statement 타입으로 create
			
			statement = connection.createStatement();
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
		boolean isName = read();
		System.out.println(student.getName());
		System.out.println(student.getName());
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
				
				System.out.println(student.getName());

				//()안의 내용을 실행한다
				statement.executeUpdate(sql);

				System.out.println("입력이 완료되었습니다");

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("등록 할 수 없습니다");
		}	
	}

	
	void update() {
		boolean isName = read();
		if (!isName) {
			System.out.println("해당하는 정보가 없습니다");
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
		boolean isName = read();
		if (!isName) {		
			System.out.println("해당하는 정보가 없습니다");
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