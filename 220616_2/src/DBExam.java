import java.sql.DriverManager;

public class DBExam {
	
	public DBExam() {
		try {//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql �� DB ����
			DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBExam();
	}

}
