package study2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBReadScanner {
	Scanner sc = new Scanner(System.in);
	public DBReadScanner() {
		try {
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			System.out.println("id를 입력하면 해당하는 password 가 나옵니다");
			String fieldName = sc.nextLine();
			//sql에 입력할 명령문
			String sql = "select*from signup1 where id = '"+ fieldName +"'";
			//명령문 수행할수 있게 create
			Statement st = conn.createStatement();
			//명령문 수행할수 있게 Statement 타입으로 create
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String fieldVaule = rs.getString(2);
				System.out.print(fieldVaule +"  ");
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new DBReadScanner();

	}

}
