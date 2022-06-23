package programAction;

import programDAO.TotalDAO;
import programDTO.SourceDTO;

public class StudentSignUp implements TotalActInterface {

	@Override
	public void executeMysql() {
		SourceDTO sourceDTO = new SourceDTO();
		TotalDAO totalDAO = TotalDAO.connectMysql();
		totalDAO.signUpConnect(sourceDTO);
		
	}

}
