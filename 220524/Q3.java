class Q3 {
	public static void main(String[] args) {

		// 1~10까지를 곱해서 그 결과를 출력하는 프로그램작성

		int multi = 1 ; // 곱한 결과의 초기값 설정

		for ( int num = 1; num < 11 ; num++){ // num이 1부터 시작하여 10이 될때까지 1씩증가하여 총 10번 실행한다
			multi = multi * num ;
		}

		System.out.println("1부터 10까지의 곱은 " + multi + "입니다");
	}
}
