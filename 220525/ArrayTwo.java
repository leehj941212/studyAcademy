class ArrayTwo 
{
	public static void main(String[] args) 
	{
		//System.out.println(args[0]);
		//System.out.println(args[1]);
		int []i = new int[5];
		int []j = {7,8,4,3,5}; //배열 크기, 값을 입력

		//int x = 10;
		int x = (int)(Math.random()*10);
		int []k = new int[x]; //[]안에 변수를 넣어도 가능
		int idx;
		for ( idx = 0 ; idx < k.length  ; idx++ )
		{
			System.out.println(k[idx]);
		} 
	}
}
