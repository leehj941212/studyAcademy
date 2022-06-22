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

	//xml�� ����
	//mysql�� ������ ��ü �۾����� 1���� �̷����� �ȴ�
	public StudentDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mysqlconnectconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//��ü�� 1���� ����� ���� ���� �޼ҵ�
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
