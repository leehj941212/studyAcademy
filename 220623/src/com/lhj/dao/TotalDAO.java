package com.lhj.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lhj.dto.SourceDTO;

public class TotalDAO {
	SourceDTO sourceDTO;
	SqlSessionFactory factory;
	static TotalDAO totalDAO;

	//mysql ����
	public TotalDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("programconnectmysql.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//������ 1���� �ϱ� ���� �޼ҵ�
	public static TotalDAO connectMysql() {
		if (totalDAO==null) {
			synchronized (TotalDAO.class) {
				totalDAO = new TotalDAO();
			}
		}
		return totalDAO;
	}

	//ȸ������
	public void signUp(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("signup", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	//���̵�� �ߺ� ��ȸ
	public List<SourceDTO> lookUpById(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		List<SourceDTO> list = sqlSession.selectList("lookUpById", sourceDTO);
		sqlSession.close();

		return list;
	}

	//���̵� , ��й�ȣ�� �ߺ� ��ȸ
	public List<SourceDTO> lookUpByIdPassword(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		List<SourceDTO> list = sqlSession.selectList("lookUpByIdPassword", sourceDTO);
		sqlSession.close();

		return list;
	}

	//�̸� , �������� �ߺ� ��ȸ
	public List<SourceDTO> lookUpByNameQuestions(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		List<SourceDTO> list = sqlSession.selectList("lookUpByNameQuestions", sourceDTO);
		sqlSession.close();

		return list;
	}

	//��й�ȣ ����
	public void updatePassword(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("updatePassword", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	//java , web , jsp ����
	public void updateJavaWebJsp(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("updateJavaWebJsp", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	//ȸ��Ż��
	public void delete(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.delete("delete", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}
}
