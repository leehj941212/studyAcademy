class SwitchTwo 
{
	public static void main(String[] args) 
	{
		int month = (int)(Math.random()*12)+1;
		System.out.print(month + "���� ");

		switch(month){
			case 2 : System.out.println("28�� ����"); break;
			case 4 : case 6 : case 9 : case 11 : System.out.println("30�� ����"); break;
			//if(month == 4 || month == 6 || month == 9 || month == 11)
			default : System.out.println("31�� ����");
		}
	}
}
