package study1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBCreate {
	
	public DBCreate() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql�� �Է��� ��ɹ�
			String sql = "insert into signup2(id , password , nickName , email , name "
					+ ", address , birthday , gender, callNum , score1 , score2 , score3) "
					+ "values('bnm' , 'asd' ,'zxc','qwe','asd'"
					+ ",'sdf','34523','1234','asd',123,234,345)";
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
			Statement st = conn.createStatement();
			//()���� ������ �����Ѵ�
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DBCreate();

	}

}
