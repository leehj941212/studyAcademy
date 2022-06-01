        //사이즈 5인 배열 선언
		//배열요소 값 지정 (1~10사이의 랜덤값)
		//사용자 숫자 입력(Scanner)
		//배열요소와 일치하는 값이 있으면 몇번째에 일치하는지 출력
		//없으면 일치하는 값이 없다고 출력

import java.util.Scanner;

class Q25 {
	public static void main(String[] args) {
		int []txt = new int[5];
		int su = 0;

		for ( int n = 0 ; n < txt.length ; n++ ){
			txt[n] = (int)(Math.random()*10+1);
		}
		
		System.out.print("txt 배열의 값 : ");

		for ( int n = 0 ; n < txt.length ; n++ ){
			System.out.print(txt[n] + " ");
		}

		System.out.println();

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for ( int n = 0 ; n < txt.length ; n++ ){
			if ( num == txt[n]){
				System.out.println( (n+1) + "번째 와 일치 합니다" );
				su = 1;
			} 
		}

		if (su == 0){
			System.out.println("일치하는 값이 없습니다");
		}
	}
}
