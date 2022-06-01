import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q1 {
	public static void main(String[] args) {

		//숫자를 입력받아 절댓값을 구하는 프로그램을 작성

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)

		if (num >= 0){ //입력값이 0 보다 크거나 같으면 입력값을 그대로 출력한다
			System.out.println("입력받은 값 " + num + "의 절댓값 : " + num);
		} else{ //입력값이 0 보다 작으면 입력값에 (-1)을 곱하여 출력한다
			System.out.println("입력받은 값 " + num + "의 절댓값 : " + -num);
		}
	}
}
