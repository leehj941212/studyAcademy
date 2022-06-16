import java.util.ArrayList;
import java.util.Scanner;

public class ScoreAct {
	Scanner sc = new Scanner(System.in);
	ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

	void input() {
		ScoreDTO student = new ScoreDTO();

		System.out.println("이름을 입력하세요");
		
		student.setName(sc.nextLine());
		System.out.println("번호를 입력하세요");
		student.setNum(sc.nextInt());
		System.out.println("수학 점수를 입력하세요");
		student.setMath(sc.nextInt());
		System.out.println("과학 점수를 입력하세요");
		student.setScience(sc.nextInt());
		sc.nextLine();
		System.out.println("입력이 완료되었습니다");
		
		

		list.add(student);
	}

	void change() {
		int index = lookUp();
		if (index == -1) {	
			System.out.println("해당하는 정보가 없습니다");
		} else {
			System.out.println("이름을 입력하세요");
			
			list.get(index).setName(sc.nextLine());
			System.out.println("번호를 입력하세요");
			list.get(index).setNum(sc.nextInt());
			System.out.println("수학 점수를 입력하세요");
			list.get(index).setMath(sc.nextInt());
			System.out.println("과학 점수를 입력하세요");
			list.get(index).setScience(sc.nextInt());
			sc.nextLine();
			System.out.println("수정이 완료되었습니다");
			
			

		}

	}

	void delete() {
		int index = lookUp();
		if (index == -1) {		
			System.out.println("해당하는 정보가 없습니다");
		} else {
			list.remove(index);
			System.out.println("삭제가 완료되었습니다");
		}

	}

	int lookUp() {

		int index = -1;
		System.out.println("해당 학생의 번호를 입력하세요");
		int intSc = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (intSc == list.get(i).getNum()) {
				index = i;
				break;
			} 
		}
		return index;

	}
}