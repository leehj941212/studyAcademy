package study1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDelete {
	
	public DBDelete() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql�� �Է��� ��ɹ�
			String sql = "delete from signup1 where id = 'zxczxc'";
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
			Statement st = conn.createStatement();
			//()���� ������ �����Ѵ�
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBDelete();

	}

}
