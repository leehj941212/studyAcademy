class SupExam{
	private int a;
	SupExam() {
		System.out.println("�θ� ������");
		a = 50;
	}

	int getA() {
		return a;
	}
}

class SubExam extends SupExam {
	SubExam(){
		System.out.println("�ڽ� ������");
	}
}

public class DefaultConstructor {
	public static void main(String[] args) {
		SubExam x = new SubExam();
		//�θ�Ŭ������ ������ ���� �����ϰ� �ڽ�Ŭ������ ������ ����
		System.out.println("x.getA() = " + x.getA());
	}
}
