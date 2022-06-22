package scoreAction;

import scoreDAO.StudentDAO;

public class DataRead implements ScoreInterface {

	@Override
	public void executeMysql() {
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.readConnect();
		
	}

}
