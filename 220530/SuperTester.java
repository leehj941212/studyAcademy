class Base{
	int x; //변수 선언
	Base(){ //매개변수가 없는 생성자
		this.x = 0; 
		// Base.x = 0;
		// 현재 클래스의 x 값 지정
	}
	Base(int x){ //(int x)매개변수를 가지는 생성자
		this.x = x; 
		// 현재 클래스의 x 값 지정
	}
	void print(){ //x값 출력
		System.out.println("Base.x = " + x);
	}
}

class Derived extends Base{ //Base 클래스를 상속받는다
	int x;
	Derived(int x1, int x2){ //(int x1, int x2)매개변수를 가지는 생성자
		//super(); 가 생략되어있다
		super.x = x1; //부모 클래스의 x값 지정
		this.x = x2; //현재 클래스의 x값 지정
	}
	void derivedPrint(){ //x값 출력
		System.out.println("Derived.x = " + x);
	}
}

public class SuperTester{
	public static void main(String[] args) {
		Base a = new Base(10); 
		// Base 클래스의 (int x)매개변수를 가지는 생성자를 실행하고 변수 선언
		// Base.x = 10;
		System.out.println("-- a --");
		a.print(); 
		// Base.print() 메서드 실행

		Derived b = new Derived(20, 30);
		//Base 클래스의 매개변수가 없는 생성자를 실행하고
		//Derived 클래스의 (int x1, int x2)매개변수를 가지는 생성자 실행하며 변수 선언
		// Base.x = 20; Derived.x = 30;
		System.out.println("-- b --");
		b.print(); // Base.print() 메서드 실행(상속받았기 때문에)
	}
}
