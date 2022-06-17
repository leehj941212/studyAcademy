package study1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DBRead {

	public DBRead() {
		try {
			//����� Ŭ������ �����ϰ� ���ش�
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql�� �Է��� ��ɹ�
			String sql = "select*from signup2 where password !='fhfghfgh'";
			//��ɹ� �����Ҽ� �ְ� create
			Statement st = conn.createStatement();
			//��ɹ� �����Ҽ� �ְ� Statement Ÿ������ create
			ResultSet rs = st.executeQuery(sql);

			//ResultSet ���� ������ �ݺ�
			while (rs.next()) {
				//Column�� ������ŭ �ݺ� , index�� 1���� �����Ѵ�
				for (int i = 1; i < (rs.getMetaData().getColumnCount()+1); i++) {
					if (rs.getMetaData().getColumnTypeName(i).equals("VARCHAR")) {
						//1��° �ʵ��� �� ���
						String s = rs.getString(i);
						System.out.print(s +"  ");
					} else if (rs.getMetaData().getColumnTypeName(i).equals("INT")) {
						int s = rs.getInt(i);
						System.out.print(s +"  ");
					} else {
						Date s = rs.getDate(i);
						System.out.print(s +"  ");
					}

				}
				System.out.println();
			}			


		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public static void main(String[] args) {
		new DBRead();

	}

}
