package scoreDAO;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDAO {
	SqlSessionFactory factory;
	//xml¿¡ ¿¬°á
	public StudentDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mysqlconnectconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insertConnect() {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("asd");
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void updateConnect() {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("qwe");
		sqlSession.commit();
		sqlSession.close();
	}
}
