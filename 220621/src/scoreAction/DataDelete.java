package scoreAction;

import java.util.Scanner;

import scoreDAO.StudentDAO;
import scoreDTO.StudentDTO;

public class DataDelete implements ScoreInterface {
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void executeMysql() {
		StudentDTO studentDTO = new StudentDTO();
		
		System.out.println("������ �л��� name�� �Է��ϼ���");
		studentDTO.setName(scanner.nextLine());
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.deleteConnect(studentDTO);
		
	}

}
