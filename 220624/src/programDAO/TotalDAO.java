package programDAO;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import programDTO.SourceDTO;

public class TotalDAO {
	SqlSessionFactory factory;
	static TotalDAO totalDAO;
	
	public TotalDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mysqlconnectconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//��ü�� 1���� ����� ���� ���� �޼ҵ�
		public static TotalDAO connectMysql() {
			if (totalDAO==null) {
				synchronized (TotalDAO.class) {
					totalDAO = new TotalDAO();
				}
			}
			return totalDAO;
		}
		
		//�α���
		public void signUpConnect(SourceDTO sourceDTO) {
			SqlSession sqlSession =factory.openSession();
			sqlSession.insert("asd", sourceDTO);
			sqlSession.commit();
			sqlSession.close();
		}

}
