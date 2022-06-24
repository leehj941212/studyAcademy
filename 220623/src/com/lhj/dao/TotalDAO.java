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

	//mysql 연결
	public TotalDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("programconnectmysql.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//연결을 1번만 하기 위한 메소드
	public static TotalDAO connectMysql() {
		if (totalDAO==null) {
			synchronized (TotalDAO.class) {
				totalDAO = new TotalDAO();
			}
		}
		return totalDAO;
	}

	//회원가입
	public void signUp(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("signup", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	//아이디로 중복 조회
	public List<SourceDTO> lookUpById(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		List<SourceDTO> list = sqlSession.selectList("lookUpById", sourceDTO);
		sqlSession.close();

		return list;
	}

	//아이디 , 비밀번호로 중복 조회
	public List<SourceDTO> lookUpByIdPassword(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		List<SourceDTO> list = sqlSession.selectList("lookUpByIdPassword", sourceDTO);
		sqlSession.close();

		return list;
	}

	//이름 , 질문으로 중복 조회
	public List<SourceDTO> lookUpByNameQuestions(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		List<SourceDTO> list = sqlSession.selectList("lookUpByNameQuestions", sourceDTO);
		sqlSession.close();

		return list;
	}

	//비밀번호 변경
	public void updatePassword(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("updatePassword", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	//java , web , jsp 변경
	public void updateJavaWebJsp(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("updateJavaWebJsp", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	//회원탈퇴
	public void delete(SourceDTO sourceDTO) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.delete("delete", sourceDTO);
		sqlSession.commit();
		sqlSession.close();
	}
}
