package scoreAction;

import scoreDAO.StudentDAO;

public class DataCreate implements ScoreInterface {

	@Override
	public void executeMysql() {
		//mysql에 연결할 수 있는 생성자 호출
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.insertConnect();
		
	}

}
