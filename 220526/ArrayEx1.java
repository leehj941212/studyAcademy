//학급 수 <- 입력
//반의 학생수 <- 입력
//학생 점수 <- 입력
//각 반의 점수 합계, 평균 출력

import java.util.Scanner;

class  ArrayEx1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("학급 수를 입력하세요");
		int banNum = sc.nextInt(); //학급 수 입력

		int [][]scoreNum = new int[banNum][]; //1차원은 학급 , 2차원은 학생 으로 설정
		int []sum = new int[banNum]; // 합계 배열 선언
		int []ave = new int[banNum]; // 평균 배열 선언
		int num; // 입력값을 받아둘 변수 선언

		for ( int n = 0 ; n < banNum ; n++ ){ // 학급 수 만큼 반복
			System.out.println( (n+1) + "반의 학생수를 입력하세요");
			num = sc.nextInt(); // 입력값을 num에 부여한다
			scoreNum[n] = new int [num]; // 입력값을 2차원의 길이로 정한다
			
		}

		for ( int n = 0 ; n < banNum ; n++ ){ //학급 수 만큼 반복
			for ( int j = 0 ; j < scoreNum[n].length ; j++ ){ //학생 수 만큼 반복
				System.out.println( (n+1) + "반의 " + (j+1) + "번 학생의 점수를 입력하세요");
				scoreNum[n][j] = sc.nextInt(); //입력받은 값을 점수로 부여한다
			}
		}

		for ( int n = 0 ; n < banNum ; n++ ){ //학급 수 만큼 반복
			for ( int j = 0 ; j < scoreNum[n].length ; j++ ){ //학생 수 만큼 반복
				sum[n] = sum[n] + scoreNum[n][j]; // 학급별 점수 합계
		}
		ave[n] = sum[n] / scoreNum[n].length; // 학급별 점수 평균
		}

		for ( int n = 0 ; n < banNum ; n++ ){
			System.out.println((n+1) + "반의 점수 합계 : " + sum[n]);
			System.out.println((n+1) + "반의 점수 평균 : " + ave[n]);
		}
	}
}
