package scoreAction;

import scoreDAO.StudentDAO;

public class DataCreate implements ScoreInterface {

	@Override
	public void executeMysql() {
		//mysql�� ������ �� �ִ� ������ ȣ��
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.insertConnect();
		
	}

}
