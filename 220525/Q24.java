		//5명의 학생의 성적처리
		//5명의 학생의 점수를 입력
		//합계,평균,최고점,최저점 출력

import java.util.Scanner;

class Q24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int []score = new int[5]; 
		int sum = 0 , ave , num = 0 ; //합계 , 평균 , 자리바꾸기용 변수 선언

		for ( int n = 0; n < score.length ; n++ ){ // score 변수 값 지정
			score[n] = sc.nextInt();
		}

		for ( int n = 0; n < score.length ; n++ ){ 
			for ( int j = n+1 ; j < score.length ; j++ ){
				if (score[n] < score[j]){
					num = score[n];
					score[n] = score[j];
					score[j] = num;
				}
			}
		}

		for ( int n = 0 ; n < score.length ; n++ ){
			sum = sum + score[n];
		}

		ave = sum/(score.length);

		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + ave);
		System.out.println("최고점 : " + score[0]);
		System.out.println("최저점 : " + score[score.length - 1]);
	}
}
