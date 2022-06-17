package study2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBCreateScanner {
	Scanner sc = new Scanner(System.in);
	public DBCreateScanner() {
		try {
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql에 입력할 명령문
			
			System.out.println("입력할 필드명을 입력하세요 (id , password)");
			 String fieldName = sc.nextLine();
			 System.out.println("입력할 필드값을 입력하세요 (varchar 타입일시 '' 도 입력)");
			 String fieldValue = sc.nextLine();
			 
			 String sql = "insert into signup1("+fieldName+") values("+fieldValue+")";
			 
			 //명령문 수행할수 있게 Statement 타입으로 create
				Statement st = conn.createStatement();
				//()안의 내용을 실행한다
				st.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBCreateScanner();

	}

}
