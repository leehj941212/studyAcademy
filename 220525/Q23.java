		//사이즈가 5인 배열 선언
		//배열 값 입력
		//이 배열의 값을 역순으로 복사하는 다른 배열 선언

import java.util.Scanner;

class Q23{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int []txt = new int[5]; // 크기가 5인 txt배열 선언
		int []xtx = new int[txt.length]; // txt배열과 크기가 같은 xtx배열 선언

		for ( int n = 0; n < txt.length ; n++ ){ //txt배열의 값 지정
			txt[n] = sc.nextInt();
		}

			for ( int n = 0 ; n < txt.length ; n++ ){ //xtx배열의 값 지정
				xtx[n] = txt[txt.length -1 - n];
			}

			System.out.print("배열 txt의 값: ");

			for ( int n = 0 ; n < txt.length ; n++ ){
				System.out.print(txt[n] + " ");
			}
			System.out.println();

			System.out.println("=========");

			System.out.print("배열 xtx의 값: ");

			for ( int n = 0 ; n < txt.length ; n++ ){
				System.out.print(xtx[n] + " ");
			}

	}
}
