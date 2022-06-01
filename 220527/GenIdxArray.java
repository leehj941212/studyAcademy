import java.util.Scanner;

class GenIdxArray {

	int[] idxArray(int n){ //배열도 리턴값이 될 수 있다 , 배열인것을 []로 표시해야함
		int[] a = new int[n];
		for ( int i = 0 ; i < n ; i++)
		a[i] = i;
		return a; //[]는 안쓰고 변수명만 쓴다
	}

	public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
		GenIdxArray ob = new GenIdxArray();

		System.out.print("요소 수는 : ");
		int n = stdln.nextInt();
		int[] x = ob.idxArray(n);

		for ( int i = 0 ; i < n ; i++ ){
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
