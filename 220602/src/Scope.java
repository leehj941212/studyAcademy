
public class Scope {
	//�������� ����
	int k = 100;
	final int w = 100; //final ���� �ٲ� �� ����
	static int x = 700; // static ���� <-- Ŭ���� ����
	
	static void printX() {
		System.out.println("x = " + x);
	}

	public static void main(String[] args) {
		Scope s = new Scope();
		System.out.println(s.w);
		System.out.println("x = " + x);
		int x = 800; //��������
		System.out.println("x = " + x);
		System.out.println("k = " + s.k);
//		static�� Ŭ������.���� ���·� ����Ѵ�
		System.out.println("Scope.x = " + Scope.x);
//		Scope.printX();
		printX();
	}

}
