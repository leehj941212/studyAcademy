package study1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBUpdate {
	
	public DBUpdate() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql�� �Է��� ��ɹ�
			String sql = "update signup1 set id = 'zxczxc' where id = '111'";
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
			Statement st = conn.createStatement();
			//()���� ������ �����Ѵ�
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBUpdate();

	}

}
