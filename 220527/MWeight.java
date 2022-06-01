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

		System.out.print("인원 수는? : ");
		int person = stdln.nextInt();

		int[] height = new int[person];
		int[] weight = new int[person];
		System.out.println(person + "명의 신장과 체중을 입력하시오");

		for (int i = 0 ; i < person ; i++ ){
			System.out.print((i + 1) + "번의 신장 : ");
			height[i] = stdln.nextInt();
			System.out.print((i + 1) + "번의 체중 : ");
			weight[i] = stdln.nextInt();
		}
		System.out.println("가장 키가 큰 사람의 신장 : " + ob.maxOf(height) + "cm");
		System.out.println("가장 뚱뚱한 사람의 신장 : " + ob.maxOf(weight) + "kg");
	}
}
