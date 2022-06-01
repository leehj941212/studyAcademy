import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q2 {
	public static void main(String[] args) {

		//숫자를 입력받아 1부터 입력받은 숫자 까지의 합계

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)
        int sum = 0; // 합계 초기값

		System.out.print("1부터 " + num + "까지의 합은 ");

		if(num >= 1){ //입력값이 1보다 크거나 같을때
			for (num = num ; num >= 1 ; num-- ) {
				sum = sum + num ;
			}
		} else{ //입력값이 1보다 작을때
			for (num = num ; num <= 1 ; num++ ) {
				sum = sum + num ;
			}
		} 

		System.out.println(sum + " 입니다");
	}
}
