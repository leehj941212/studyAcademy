package study1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDelete {
	
	public DBDelete() {
		try {
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql에 입력할 명령문
			String sql = "delete from signup1 where id = 'zxczxc'";
			//명령문 수행할수 있게 Statement 타입으로 create
			Statement st = conn.createStatement();
			//()안의 내용을 실행한다
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBDelete();

	}

}
