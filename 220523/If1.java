class If1
{
	public static void main(String[] args) 
	{
		int su;
		su = (int)(Math.random()*100); //0~99 범위의 난수
		//System.out.println(" su " + su );

		if(su % 2 == 0){
			System.out.println( su + "는 짝수입니다");
		}
		else{
		//if(su % 2 != 0){
			System.out.println( su + "는 홀수입니다");
		}
		System.out.println("프로그램 종료");
	}
}
