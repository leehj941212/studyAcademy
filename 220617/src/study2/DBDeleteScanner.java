package study2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBDeleteScanner {
	Scanner sc = new Scanner(System.in);
	public DBDeleteScanner() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			System.out.println("delete �� id �� �Է��ϼ��� (varchar Ÿ���̸� ''�� �Է�)");
			String fieldValue = sc.nextLine();
			//sql�� �Է��� ��ɹ�
			String sql = "delete from signup1 where id = "+fieldValue;
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
			Statement st = conn.createStatement();
			//()���� ������ �����Ѵ�
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBDeleteScanner();

	}

}
