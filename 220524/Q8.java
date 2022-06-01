import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q8 {
	public static void main(String[] args) {

		//두개의 숫자를 입력받다. 예를들어 3,5를 입력받게 되면 3부터 5까지의 합계를 구해 출력
		//단, 음수를 입력하거나 또는 5,3 입력이 되거나
		//1~9 숫자 범위를 넘어가는 경우 숫자를 다시 입력받아 처리

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num1 = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)
		int num2 = sc.nextInt(); // 2번째 입력값도 받는다
		int sum = 0; // 합계 초기값 설정

		for (num1 = num1 ;
		num1 < 0 || num2 < 0 || num2 - num1 <0 || num1 > 9 || num2 >9 ; 
		num1 = sc.nextInt() , num2 = sc.nextInt() ){
			//입력값1,입력값2가 0보다 작거나 9보다 크거나 입력값1이 입력값2보다 크면 다시 입력받는다
			System.out.println("다시 입력하세요");
		}

		for (num1 = num1 ; num1 <= num2 ; num1++){ //입력값1이 1씩 증가하여 입력값2와 동일해질때까지 실행한다
			sum = sum + num1;
		}

		System.out.println(sum);
	}
}
