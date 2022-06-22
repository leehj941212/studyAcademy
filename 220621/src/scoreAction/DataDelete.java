package scoreAction;

import scoreDAO.StudentDAO;

public class DataDelete implements ScoreInterface {

	@Override
	public void executeMysql() {
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.deleteConnect();
		
	}

}

