import java.util.Scanner;

class MWeight {

	int maxOf(int[] a){
		int max = a[0];
		for ( int i = 1 ; i < a.length ; i++ )
		if ( a[i] > max )
			max = a[i];
		System.out.println("123123");
		System.out.println("234234");
		return max;
	}

	public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
		MWeight ob = new MWeight();

		System.out.print("�ο� ����? : ");
		int person = stdln.nextInt();

		int[] height = new int[person];
		int[] weight = new int[person];
		System.out.println(person + "���� ����� ü���� �Է��Ͻÿ�");

		for (int i = 0 ; i < person ; i++ ){
			System.out.print((i + 1) + "���� ���� : ");
			height[i] = stdln.nextInt();
			System.out.print((i + 1) + "���� ü�� : ");
			weight[i] = stdln.nextInt();
		}
		System.out.println("���� Ű�� ū ����� ���� : " + ob.maxOf(height) + "cm");
		System.out.println("���� �׶��� ����� ���� : " + ob.maxOf(weight) + "kg");
	}
}
