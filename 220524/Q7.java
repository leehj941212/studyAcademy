import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q7 {
	public static void main(String[] args) {

		//달을 정수값으로 입력받아
		//달의 계절을 표시하는 프로그램을 작성
		//3,4,5 -> 봄
		//6,7,8 -> 여름
		//9,10,11 -> 가을
		//12,1,2 - > 겨울
		//만약 1~12 이외의 값이 입력된 경우에는 재입력 하도록 할것

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)
		
		for (num = num ; num < 1 || num > 12; num = sc.nextInt() ){ 
			//입력값이 1보다 작거나 12보다 크면 다시 입력받는다
			System.out.println("다시 입력하세요");
		}

		switch (num){
			
		case 3: case 4: case 5: System.out.println("봄"); break ; //입력값이 3,4,5 일때
		case 6: case 7: case 8: System.out.println("여름"); break ; //입력값이 6,7,8 일때
		case 9: case 10: case 11: System.out.println("가을"); break ; //입력값이 9,10,11 일때
		case 12: case 1: case 2: System.out.println("겨울"); break ; //입력값이 12,1,2 일때
		//1~12 외의 입력값은 for에서 확인했기때문에 default는 사용하지 않음
		}
	}
}
