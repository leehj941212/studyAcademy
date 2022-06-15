import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = (int)(Math.random()*100+1);

		for (int i = 0; i < 5; i++) {
			System.out.print("숫자입력 : ");
			int x = sc.nextInt();

			if (x > a) {
				System.out.println("Up");
			} else if (x < a) {
				System.out.println("Down");
			} else if (x == a) {
				System.out.println("Clear");
				i = 5;
			}
		}
		sc.close();
	}

}
