class SwitchTwo 
{
	public static void main(String[] args) 
	{
		int month = (int)(Math.random()*12)+1;
		System.out.print(month + "월은 ");

		switch(month){
			case 2 : System.out.println("28일 까지"); break;
			case 4 : case 6 : case 9 : case 11 : System.out.println("30일 까지"); break;
			//if(month == 4 || month == 6 || month == 9 || month == 11)
			default : System.out.println("31일 까지");
		}
	}
}
