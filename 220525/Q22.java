		//원하는 배열 사이즈를 입력
		//배열요소 값 지정 (1~100사이의 랜덤값)
		//모든 배열 값 출력

import java.util.Scanner;

class Q22 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int []txt = new int[num];

		for ( int n = 0 ; n < txt.length ; n++ ){
			txt[n]=(int)(Math.random()*100+1);
			System.out.println("txt[" + n + "]의 값 : " + txt[n]);
		}
	}
}
