class SwitchOne 
{
	public static void main(String[] args) 
	{
		int su = (int)(Math.random()*10)+1;
		System.out.print(su + " = ");

		switch(su){
			case 1 : System.out.print("일") ; break ;
			case 2 : System.out.print("월") ; break ;
			case 3 : System.out.print("화") ; break ;
			case 4 : System.out.print("수") ; break ;
			case 5 : System.out.print("목") ; break ;
			case 6 : System.out.print("금") ; break ;
			default : System.out.print("토") ;
		}
		System.out.println(" 요일 ");
	}
}
