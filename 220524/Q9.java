import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q9 {
	public static void main(String[] args) {

		//정숫값을 연속해서 입력을 받아
		//합계와 평균을 구하는 프로그램을 작성하시오
		//0 입력시 프로그램 종료

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)

		int sum = 0 , ave = 0 , time = 1; //합계,평균,입력횟수의 초기값 설정

		System.out.println("현재 입력값 : " + num);

		for (num = num ; num != 0 ; num = sc.nextInt() , time++ ){ 
			// 입력값이 0이 아니면 다시 입력값을 받고 time를 1증가 시킨다
			sum = sum + num; 
			ave = sum / time;

			System.out.println("현재 합계 : " + sum);
			System.out.println("현재 평균 : " + ave);
		}
	}
}
