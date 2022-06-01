class Base{
	int x; //���� ����
	Base(){ //�Ű������� ���� ������
		this.x = 0; 
		// Base.x = 0;
		// ���� Ŭ������ x �� ����
	}
	Base(int x){ //(int x)�Ű������� ������ ������
		this.x = x; 
		// ���� Ŭ������ x �� ����
	}
	void print(){ //x�� ���
		System.out.println("Base.x = " + x);
	}
}

class Derived extends Base{ //Base Ŭ������ ��ӹ޴´�
	int x;
	Derived(int x1, int x2){ //(int x1, int x2)�Ű������� ������ ������
		//super(); �� �����Ǿ��ִ�
		super.x = x1; //�θ� Ŭ������ x�� ����
		this.x = x2; //���� Ŭ������ x�� ����
	}
	void derivedPrint(){ //x�� ���
		System.out.println("Derived.x = " + x);
	}
}

public class SuperTester{
	public static void main(String[] args) {
		Base a = new Base(10); 
		// Base Ŭ������ (int x)�Ű������� ������ �����ڸ� �����ϰ� ���� ����
		// Base.x = 10;
		System.out.println("-- a --");
		a.print(); 
		// Base.print() �޼��� ����

		Derived b = new Derived(20, 30);
		//Base Ŭ������ �Ű������� ���� �����ڸ� �����ϰ�
		//Derived Ŭ������ (int x1, int x2)�Ű������� ������ ������ �����ϸ� ���� ����
		// Base.x = 20; Derived.x = 30;
		System.out.println("-- b --");
		b.print(); // Base.print() �޼��� ����(��ӹ޾ұ� ������)
	}
}
