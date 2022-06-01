		//사이즈가 10인 배열 선언
		//배열요소 값 지정(1~100사이의 랜덤값)
		//모든 배열 값 출력

class Q21 
{
	public static void main(String[] args) 
	{
		int []txt = new int [10]; //txt 배열의 10개의 값을 가진다
		for ( int n = 0; n < txt.length ; n++ ){ //n이 0부터 9까지 10번 반복한다
			txt[n] = (int)(Math.random()*100+1);
				System.out.println("txt[" + n + "]의 값 : " + txt[n]);
		}
	}
}
