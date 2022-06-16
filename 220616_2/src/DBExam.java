import java.sql.DriverManager;

public class DBExam {
	
	public DBExam() {
		try {//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql 의 DB 연결
			DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBExam();
	}

}
