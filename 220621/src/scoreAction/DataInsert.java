package scoreAction;

import java.util.Scanner;

import scoreDAO.StudentDAO;
import scoreDTO.StudentDTO;

public class DataInsert implements ScoreInterface {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void executeMysql() {
		StudentDTO studentDTO = new StudentDTO();
		
		
		System.out.println("name(varchar(20)) �� ���� �Է��ϼ���");
		studentDTO.setName(scanner.nextLine());
		System.out.println("num(int) �� ���� �Է��ϼ���");
		studentDTO.setNum(scanner.nextInt());
		System.out.println("math(int) �� ���� �Է��ϼ���");
		studentDTO.setMath(scanner.nextInt());
		System.out.println("science(int) �� ���� �Է��ϼ���");
		studentDTO.setScience(scanner.nextInt());
//		StudentDAO studentDAO = new StudentDAO();
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.insertConnect(studentDTO);
	}

}
