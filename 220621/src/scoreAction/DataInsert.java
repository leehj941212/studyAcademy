package scoreAction;

import java.util.Scanner;

import scoreDAO.StudentDAO;
import scoreDTO.StudentDTO;

public class DataInsert implements ScoreInterface {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void executeMysql() {
		StudentDTO studentDTO = new StudentDTO();
		
		
		System.out.println("name(varchar(20)) 의 값을 입력하세요");
		studentDTO.setName(scanner.nextLine());
		System.out.println("num(int) 의 값을 입력하세요");
		studentDTO.setNum(scanner.nextInt());
		System.out.println("math(int) 의 값을 입력하세요");
		studentDTO.setMath(scanner.nextInt());
		System.out.println("science(int) 의 값을 입력하세요");
		studentDTO.setScience(scanner.nextInt());
//		StudentDAO studentDAO = new StudentDAO();
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.insertConnect(studentDTO);
	}

}
