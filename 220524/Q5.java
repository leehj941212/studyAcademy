import java.util.Scanner; // Scanner를 사용하기 위하여 import 한다

class Q5 {
	public static void main(String[] args) {

		// 입력한 정수값의 모든 약수와 그 개수를 표시하는 프로그램

		Scanner sc = new Scanner(System.in); // 키로드로 입력값을 입력 할 수 있다
		int num = sc.nextInt(); // 입력값이 num 에 할당 된다 , 숫자만 인식(문자는 오류)
		int yakSu = 0 , geSu = 0 ;

		System.out.print("입력값 : " + num + "의 약수 : ");
		if ( num > 0){ // 입력값의 약수가 존재할때(자연수일때)

				for (yakSu = num; yakSu >= 1; yakSu-- ){ //yakSu가 입력값부터 1까지 1씩 줄어들며 실행한다
					if (num % yakSu == 0){ // 입력값을 yakSu로 나눴을때 나머지가 0이면 약수
						geSu++;
						System.out.print(yakSu +" ");
					}
				}
        System.out.print(" (" + geSu + " 개)");
		} else { // 입력값의 약수가 존재하지 않을때(자연수가 아닐때)
			System.out.println("없습니다");
		}
	}
}