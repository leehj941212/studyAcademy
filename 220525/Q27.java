        //6명의 두 과목(java,web)
		//배열의 요소값은 입력(Scanner)
		//학생별 평균 , 과목별 평균

import java.util.Scanner;

class Q27 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		int [][]score = new int[2][6];  //배열의 첫번째 차원은 과목(java,web) , 두번째 차원은 학생 으로 선언
		int []stuAve = new int[6];  //학생 당 평균 점수를 배열로 선언
		int javaAve = 0; //java평균의 초기값 설정
		int webAve = 0; //web평균의 초기값 설정

		for (int n = 0 ; n < score.length ; n++ ){ //과목별로 반복 실행
			for (int j = 0 ; j < score[n].length ; j++ ){ //학생별로 반복 실행
				if (n == 0){ //자바점수
					System.out.println((j+1) + "번째 학생의 java 점수를 입력하세요");
					score[n][j] = sc.nextInt();
					javaAve = javaAve + score[n][j]; // java 점수의 합계만 계산 
				} if (n == 1){ //웹점수
					System.out.println((j+1) + "번째 학생의 web 점수를 입력하세요");
					score[n][j] = sc.nextInt();
					webAve = webAve + score[n][j]; //web 점수의 합계만 계산
				}
			}
		}

		javaAve = javaAve / stuAve.length; //java 평균
		webAve = webAve / stuAve.length; //web 평균
		
		for (int n = 0 ; n < stuAve.length ; n++ ){
			stuAve[n] = (score[0][n] + score[1][n])/score.length;
		}

			System.out.print("학생별 평균 점수 :");
			for (int n = 0 ; n < stuAve.length ; n++ ){
				System.out.print(stuAve[n] + " ");
			}
			System.out.println();
			System.out.println("java의 평균 점수 : " + javaAve);
			System.out.println("web의 평균 점수 : " + webAve);
	}
}
