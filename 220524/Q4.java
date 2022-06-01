import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q4 {
	public static void main(String[] args) {

		//숫자를 입력받아 입력한 숫자중의 짝수들의 합 (do~while 사용)

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num ;
		int sum = 0; //합계 초기값 설정

		do{
			num = sc.nextInt(); 
			// 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류) , 여러번 입력하기 위해 do 안에 입력
			System.out.println("현재 입력값 : " + num);
			

			if (num % 2 == 0 && num > 0){ // 입력값이 짝수 일때
				sum = sum + num;
			} else{ // 입력값이 짝수가 아닐때
				sum = sum;
			}

				System.out.println("입력받은 숫자중의 짝수들의 합 : " + sum);
		}
		while (num >= 0 ); //조건에는 없지만 마이너스 값을 넣으면 종료한다
	}
}
