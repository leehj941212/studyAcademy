package teamProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class MemberAct {
	SourceDTO student = new SourceDTO();

	Connection connection = null;
	Statement statement = null;

	void connectMysql() {
		try {
			//사용할 클래스에 접근하게 해준다
			Class.forName("com.mysql.jdbc.Driver");
			//mysql DB 연결	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/study3", "root", "1234");
			statement = connection.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void executeMysql(String sql) {
		try {
			if (statement == null) {
				connectMysql();
			}
			//()안의 내용을 실행한다
			statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	boolean idPasswordLookUp(String id , String password) {
		boolean isIdPassword = false;
		String sql = "select*from teamproject where id = '"+ id +"' && password = '" + password + "'";		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				isIdPassword = true;
			} else {
				isIdPassword = false;
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return isIdPassword;
	}

	String findIdByNameQuestions(String name , String questions) {
		String value = null;
		String sql = "select*from teamproject where name = '"+ name +"' && questions = '" + questions + "'";		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getString(3);
				System.out.println(value);
			} 	else {
				value = "";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}


	String findPasswordByNameQuestions(String name , String questions) {
		String value = null;
		String sql = "select*from teamproject where name = '"+ name +"' && questions = '" + questions + "'";		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getString(4);
				System.out.println(value);
			} 	else {
				value = "";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

	boolean idLookUp(String id) {
		boolean isId = false;
		String sql = "select*from teamproject where id = '"+ id +"'";		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				isId = true;
			} else {
				isId = false;
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return isId;
	}

	String nameValue(String id) {
		String value = null;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

	int birthValue(String id) {
		int value = 0;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getInt(7);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	int hakbunValue(String id) {
		int value = 0;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getInt(8);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	String callNumValue(String id) {
		String value = null;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getString(2);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	int javaValue(String id) {
		int value = 0;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getInt(9);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	int webValue(String id) {
		int value = 0;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getInt(10);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	int jspValue(String id) {
		int value = 0;
		String sql = "select*from teamproject where id = '"+ id +"'";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				value = resultSet.getInt(11);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}









}
