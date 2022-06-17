package study2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBUpdateScanner {
	Scanner sc = new Scanner(System.in);
	public DBUpdateScanner() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			System.out.println("update �� Field���� �����ϼ��� (id , password)");
			String fieldName = sc.nextLine();
			System.out.println("update �� �ʵ尪�� �Է��ϼ��� (varchar Ÿ���Ͻ� '' �� �Է�)");
			String fieldValueBefore = sc.nextLine();
			System.out.println("update �� �ʵ尪�� �Է��ϼ��� (varchar Ÿ���Ͻ� '' �� �Է�)");
			String fieldValueAfter = sc.nextLine();
			
			//sql�� �Է��� ��ɹ�
			String sql = "update signup1 set "+fieldName+" = "+fieldValueAfter+" where "+fieldName+" = "+fieldValueBefore;
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
			Statement st = conn.createStatement();
			//()���� ������ �����Ѵ�
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBUpdateScanner();

	}

}
