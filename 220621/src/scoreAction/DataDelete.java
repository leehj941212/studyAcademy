package scoreAction;

import java.util.Scanner;

import scoreDAO.StudentDAO;
import scoreDTO.StudentDTO;

public class DataDelete implements ScoreInterface {
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void executeMysql() {
		StudentDTO studentDTO = new StudentDTO();
		
		System.out.println("삭제할 학생의 name을 입력하세요");
		studentDTO.setName(scanner.nextLine());
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.deleteConnect(studentDTO);
		
	}

}
