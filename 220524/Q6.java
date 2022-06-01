import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q6{
	public static void main(String[] args) {

		//2개의 정수값을 입력받아 후자가 전자의 약수이면
		//"약수"라고 표시하고 아니면 "약수아님"이라고 표시한다

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num1 = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)
		int num2 = sc.nextInt(); // 2번째 입력값을 받는다

		System.out.print(num2 + "은 " + num1 + "의 ");


		if (num1%num2 ==0){ //num2가 num1의 약수 일때
		
			System.out.println("약수");
		} else { //num2가 num1의 약수가 아닐때
			System.out.println("약수아님");
		}
	}
}
