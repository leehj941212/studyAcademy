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
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			System.out.println("id�� �Է��ϸ� �ش��ϴ� password �� ���ɴϴ�");
			String fieldName = sc.nextLine();
			//sql�� �Է��� ��ɹ�
			String sql = "select*from signup1 where id = '"+ fieldName +"'";
			//��ɹ� �����Ҽ� �ְ� create
			Statement st = conn.createStatement();
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
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
