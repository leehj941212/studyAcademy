class ArrayOne
{
	public static void main(String[] args) 
	{
		int a , b , c , d , e ;
		int []f = new int[5]; // 좌항 대괄호는 변수명 좌측,우측 어디에 있어도 상관없다 []f == f[]

		f[0] = 123;
		f[1] = 456;
		f[2] = 789;

		System.out.println(f[0] + f[1] );

		int i;
		for (i = 0 ; i <= 4 ; i++ ){ //i가 0부터 4까지 1씩 증가하며 총 5번 실행한다
		System.out.println(f[i]);
		}

		//사이즈가 5인 double형 배열 선언
	    //임의의 값을 지정하여 배열 값 출력
		double []num = new double[5];
		num[0] = 1.1;
		num[1] = 2.2;
		num[2] = 3.3;
		num[3] = 4.4;
		num[4] = 5.5;

		for (int n = 0; n < 5 ; n++ ){ //n이 0부터 4까지 1씩 증가하며 총 5번 실행한다
			System.out.println(num[n]);
		}

		//사이즈가 5인 String형 배열 선언
		//임의의 값을 지정하여 배열 값 출력
		String []txt = new String[5];
		txt[0] = "에이";			
		txt[1] = "비씨";
		txt[2] = "디이";
		txt[3] = "에프";
		txt[4] = "에이치";

		for ( int n = 0; n < 5 ; n++ ){ //n이 0부터 4까지 1씩 증가하며 총 5번 실행한다
			System.out.println(txt[n]);
		}
	}
}
