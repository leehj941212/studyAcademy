package package2;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreSetting2 {
	//ScoreData2 를 객체화
	ArrayList<ScoreData2> list = new ArrayList<ScoreData2>();
	Scanner sc = new Scanner(System.in);
	
	//성적 입력
	void scoreInput() {

		ScoreData2 data = new ScoreData2();
		

		System.out.println("학생 이름을 입력하세요");
		data.setName(sc.nextLine());
		System.out.println("해당 학생의 java 점수를 입력하세요");
		data.setJava(sc.nextInt());
		System.out.println("해당 학생의 web 점수를 입력하세요");
		data.setWeb(sc.nextInt());
		System.out.println("해당 학생의 jsp 점수를 입력하세요");
		data.setJsp(sc.nextInt());

		list.add(data);
	}
	
	//성적 출력
	void scoreOutput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("성적을 출력할 학생의 이름을 입력하세요");
		String name = sc.nextLine();
		int su = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				System.out.println("java 점수 : " + list.get(i).getJava() + " ");
				System.out.println("web 점수 : " + list.get(i).getWeb() + " ");
				System.out.println("jsp 점수 : " + list.get(i).getJsp() + " ");
				su = i;
				break;
			}

		}

		if (su == -1) {
			System.out.println("해당하는 정보가 없습니다");
		}

	}
	
	//성적 전체 출력
	void scoreOutputAll() {

		for (int i = 0; i < list.size(); i++) {

			System.out.println("이름 : " + list.get(i).getName() + " ");
			System.out.println("java 점수 : " + list.get(i).getJava() + " ");
			System.out.println("web 점수 : " + list.get(i).getWeb() + " ");
			System.out.println("jsp 점수 : " + list.get(i).getJsp() + " ");
			System.out.println();
		}		

	}
	
	//성적 삭제
	void scoreDelete() {	
		Scanner sc = new Scanner(System.in);

		System.out.println("데이터를 삭제할 학생의 이름을 입력하세요");
		String name = sc.nextLine();
		int su = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				su = i;
				break;
			}

		}

		if (su == -1) {
			System.out.println("해당하는 정보가 없습니다");
		}

	}
	
	//프로그램 종료
	void scoreProgramOff() {
		System.out.println("프로그램을 종료합니다.");
	}

}
