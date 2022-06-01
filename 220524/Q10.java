class Q10 {
	public static void main(String[] args) {

		//1~100까지 출력하고 난 다음에 다시 거꾸로
		//100에서부터 1까지 출력을 하는 프로그램을 작성한다 =>while문 한번만 사용

		int num = 1 , su = 1; // 초기값 설정

		while ( num <= 100){ //1부터 100까지 총 100번 실행
			if (num <= 50){ //1부터 50까지는 아래 내용을 출력한다
				System.out.println((num-1)*2 + 1);
				System.out.println((num-1)*2 + 2);

				num++;
			} else { //51부터 100까지는 아래 내용을 출력한다
				System.out.println((num-su)*2);
				System.out.println((num-su)*2 - 1);

                su +=2;
				num ++;				
			}
		}		
	}
}