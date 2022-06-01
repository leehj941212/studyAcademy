class ForOne 
{
	public static void main(String[] args) 
	{
		int index;
		for(index = 1 ; index < 11 ; index += 1 )
		{
			System.out.println("출력 : " + index);
		}

		char ch;
		for(ch = 'A' ; ch <= 'Z' ; ch++)
		{
			System.out.println("글자 " + ch);
		}
		System.out.println("글자 " + ch);

		int number;
		int sum = 0;
		for( number = 1; number <= 100 ; number++ )
			{
				sum = sum + number ;
			}
		System.out.println("합계 " + sum);

		int x, y ;
		for(x = 1 ; x <= 5 ; x++)
		{
			System.out.println("x 반복");
			for( y=1 ; y <=3 ; y++)
			{
				System.out.println("y 반복");
			}
		}
	}
}
