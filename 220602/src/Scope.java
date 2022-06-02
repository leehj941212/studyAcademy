
public class Scope {
	//전역변수 선언
	int k = 100;
	final int w = 100; //final 값을 바꿀 수 없다
	static int x = 700; // static 변수 <-- 클래스 변수
	
	static void printX() {
		System.out.println("x = " + x);
	}

	public static void main(String[] args) {
		Scope s = new Scope();
		System.out.println(s.w);
		System.out.println("x = " + x);
		int x = 800; //지역변수
		System.out.println("x = " + x);
		System.out.println("k = " + s.k);
//		static는 클래스명.변수 형태로 사용한다
		System.out.println("Scope.x = " + Scope.x);
//		Scope.printX();
		printX();
	}

}
