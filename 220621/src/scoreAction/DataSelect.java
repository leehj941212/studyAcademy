package scoreAction;

import scoreDAO.StudentDAO;

public class DataSelect implements ScoreInterface {

	@Override
	public void executeMysql() {
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.selectConnect();
		
	}

}
