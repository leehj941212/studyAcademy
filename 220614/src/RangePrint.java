import java.util.Scanner;

public class RangePrint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
		int a = sc.nextInt();
		System.out.print("�����Է� : ");
		int b = sc.nextInt();
		System.out.print("���     : ");
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
