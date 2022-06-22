package scoreAction;

import java.util.Scanner;

import scoreDAO.StudentDAO;
import scoreDTO.StudentDTO;

public class DataInsert implements ScoreInterface {

	@Override
	public void executeMysql() {
		StudentDTO studentDTO = new StudentDTO();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("name(varchar(20)) , num(int) , math(int) , science(int) 의 값을 입력하세요");
		studentDTO.setName(scanner.nextLine());
		studentDTO.setNum(scanner.nextInt());
		studentDTO.setMath(scanner.nextInt());
		studentDTO.setScience(scanner.nextInt());
		scanner.nextLine();
//		StudentDAO studentDAO = new StudentDAO();
		StudentDAO studentDAO = StudentDAO.connectMysql();
		studentDAO.insertConnect(studentDTO);
		scanner.close();
	}

}
