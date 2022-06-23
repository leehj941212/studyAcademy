package scoreAction;

import java.util.List;

import scoreDAO.StudentDAO;
import scoreDTO.StudentDTO;

public class DataSelect implements ScoreInterface {

	@Override
	public void executeMysql() {
		StudentDAO studentDAO = StudentDAO.connectMysql();
		List<StudentDTO> list = studentDAO.selectConnect();
		
		System.out.print("name");
		System.out.print("      ");
		System.out.print("num");
		System.out.print("      ");
		System.out.print("math");
		System.out.print("      ");
		System.out.print("science");
		System.out.print("      ");
		System.out.println();
		
		for (StudentDTO studentDTO : list) {
			System.out.print(studentDTO.getName());
			System.out.print("      ");
			System.out.print(studentDTO.getNum());
			System.out.print("      ");
			System.out.print(studentDTO.getMath());
			System.out.print("      ");
			System.out.print(studentDTO.getScience());
			System.out.print("      ");
			System.out.println();
		}
		
	}

}
