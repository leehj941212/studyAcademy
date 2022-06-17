package study2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBUpdateScanner {
	Scanner sc = new Scanner(System.in);
	public DBUpdateScanner() {
		try {
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			System.out.println("update 할 Field명을 선택하세요 (id , password)");
			String fieldName = sc.nextLine();
			System.out.println("update 전 필드값을 입력하세요 (varchar 타입일시 '' 도 입력)");
			String fieldValueBefore = sc.nextLine();
			System.out.println("update 후 필드값을 입력하세요 (varchar 타입일시 '' 도 입력)");
			String fieldValueAfter = sc.nextLine();
			
			//sql에 입력할 명령문
			String sql = "update signup1 set "+fieldName+" = "+fieldValueAfter+" where "+fieldName+" = "+fieldValueBefore;
			//명령문 수행할수 있게 Statement 타입으로 create
			Statement st = conn.createStatement();
			//()안의 내용을 실행한다
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBUpdateScanner();

	}

}
