package study2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBCreateScanner {
	Scanner sc = new Scanner(System.in);
	public DBCreateScanner() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql�� �Է��� ��ɹ�
			
			System.out.println("�Է��� �ʵ���� �Է��ϼ��� (id , password)");
			 String fieldName = sc.nextLine();
			 System.out.println("�Է��� �ʵ尪�� �Է��ϼ��� (varchar Ÿ���Ͻ� '' �� �Է�)");
			 String fieldValue = sc.nextLine();
			 
			 String sql = "insert into signup1("+fieldName+") values("+fieldValue+")";
			 
			 //��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
				Statement st = conn.createStatement();
				//()���� ������ �����Ѵ�
				st.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBCreateScanner();

	}

}
