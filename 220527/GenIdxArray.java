import java.util.Scanner;

class GenIdxArray {

	int[] idxArray(int n){ //�迭�� ���ϰ��� �� �� �ִ� , �迭�ΰ��� []�� ǥ���ؾ���
		int[] a = new int[n];
		for ( int i = 0 ; i < n ; i++)
		a[i] = i;
		return a; //[]�� �Ⱦ��� ������ ����
	}

	public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
		GenIdxArray ob = new GenIdxArray();

		System.out.print("��� ���� : ");
		int n = stdln.nextInt();
		int[] x = ob.idxArray(n);

		for ( int i = 0 ; i < n ; i++ ){
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
