package scoreAction;

import scoreDAO.StudentDAO;

public class DataUpdate implements ScoreInterface {

	@Override
	public void executeMysql() {
		//mysql�� ������ �� �ִ� ������ ȣ��
//		StudentDAO studentDAO = new StudentDAO();
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.updateConnect();

	}


}
