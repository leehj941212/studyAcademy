import java.util.Scanner; //Scanner 를 쓰려면 import를 해야 한다

class IfOne 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); // 키보드로 입력 할 수 있게 한다
		int num;
		num = sc.nextInt(); // 입력값이 num 에 할당 된다
		//System.out.println(" num : " + num);

		if(num >= 90) {
			System.out.println("A");
		} 
		else if (num >= 80){
			System.out.println("B");
		} 
		else if (num >= 70){
			System.out.println("C");
		} 
		else {
			System.out.println("D");
		}
	}
}