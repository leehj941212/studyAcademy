package scoreDAO;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import scoreDTO.StudentDTO;

public class StudentDAO {
	SqlSessionFactory factory;
	static StudentDAO studentDAO;

	//xml에 연결
	//mysql에 연결은 전체 작업에서 1번만 이뤄지만 된다
	public StudentDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mysqlconnectconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//객체를 1번만 만들기 위해 만든 메소드
	public static StudentDAO connectMysql() {
		if (studentDAO==null) {
			synchronized (StudentDAO.class) {
				studentDAO = new StudentDAO();
			}
		}
		return studentDAO;
	}

	public void insertConnect(StudentDTO studentDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("asd");
		sqlSession.commit();
		sqlSession.close();
	}

	public void readConnect() {

	}

	public void updateConnect() {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("qwe");
		sqlSession.commit();
		sqlSession.close();
	}

	public void deleteConnect() {

	}
}
