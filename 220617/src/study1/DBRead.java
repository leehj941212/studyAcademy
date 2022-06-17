package study1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DBRead {

	public DBRead() {
		try {
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/study1", "root", "1234");
			//sql에 입력할 명령문
			String sql = "select*from signup2 where password !='fhfghfgh'";
			//명령문 수행할수 있게 create
			Statement st = conn.createStatement();
			//명령문 수행할수 있게 Statement 타입으로 create
			ResultSet rs = st.executeQuery(sql);

			//ResultSet 값이 있을때 반복
			while (rs.next()) {
				//Column의 개수만큼 반복 , index는 1부터 시작한다
				for (int i = 1; i < (rs.getMetaData().getColumnCount()+1); i++) {
					if (rs.getMetaData().getColumnTypeName(i).equals("VARCHAR")) {
						//1번째 필드의 값 출력
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
