class SupExam{
	private int a;
	SupExam() {
		System.out.println("부모 생성자");
		a = 50;
	}

	int getA() {
		return a;
	}
}

class SubExam extends SupExam {
	SubExam(){
		System.out.println("자식 생성자");
	}
}

public class DefaultConstructor {
	public static void main(String[] args) {
		SubExam x = new SubExam();
		//부모클래스의 생성자 먼저 실행하고 자식클래스의 생성자 실행
		System.out.println("x.getA() = " + x.getA());
	}
}
