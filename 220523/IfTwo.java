class IfTwo 
{
	public static void main(String[] args) 
	{
		int jumsu = (int)(Math.random()*100);

		//80 이상이 나오면 고급 , 60 이상이 나오면 중급 , 60 미만이 나오면 초급
		if(jumsu >= 80){
			System.out.println("고급");
		} 
			else if(jumsu >= 60){ //if(jumsu < 80 && jumsu >= 60)
			System.out.println("중급");
		}
		else {
			System.out.println("초급");
			}
	}
}