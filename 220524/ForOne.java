class ForOne 
{
	public static void main(String[] args) 
	{
		int index;
		for(index = 1 ; index < 11 ; index += 1 )
		{
			System.out.println("��� : " + index);
		}

		char ch;
		for(ch = 'A' ; ch <= 'Z' ; ch++)
		{
			System.out.println("���� " + ch);
		}
		System.out.println("���� " + ch);

		int number;
		int sum = 0;
		for( number = 1; number <= 100 ; number++ )
			{
				sum = sum + number ;
			}
		System.out.println("�հ� " + sum);

		int x, y ;
		for(x = 1 ; x <= 5 ; x++)
		{
			System.out.println("x �ݺ�");
			for( y=1 ; y <=3 ; y++)
			{
				System.out.println("y �ݺ�");
			}
		}
	}
}
