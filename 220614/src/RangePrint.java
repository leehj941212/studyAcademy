import java.util.Scanner;

public class RangePrint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력 : ");
		int a = sc.nextInt();
		System.out.print("숫자입력 : ");
		int b = sc.nextInt();
		System.out.print("결과     : ");
		if (a > b) {
			for (int i = b; i <= a; i++) {
				System.out.print(i);
				if (i < a) {
					System.out.print(" , ");
				}
			}
		} else {
			for (int i = a; i <= b; i++) {
				System.out.print(i);
				if (i < b) {
					System.out.print(" , ");
				}
			}

		}
		sc.close();
	}
}
