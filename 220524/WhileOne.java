class WhileOne 
{
	public static void main(String[] args) 
	{
		int x = 10 ;

		while( x <=10 )
		{
			System.out.println("¹Ýº¹");
			x = x + 2;
		}

		int z = (int)(Math.random()*10);

		while( z < 5 )
		{
			z = (int)(Math.random()*10);
			System.out.println(" z : " + z);
		}

		int a = 1 ;
		while ( a <= 10)
		{
			System.out.println("a = " + a );
			a++;
			if ( a == 5)
			{
				break;
			}
		}

		int b = 1;
		do
		{
			System.out.println(" °ª " + b);
			b++;
		}while (b >= 10);
	}
}
