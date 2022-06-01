class Super01{
	void display() {
		System.out.println("== Super01 클래스의 Display() 메소드 ==");
	}
}

class Override01 extends Super01{ //Super01 클래스를 상속받는다
	void display(){ //overriding
		System.out.println("== Override01 클래스의 Display() 메소드 ==");
	}
}

class NoOverride extends Super01{ //Super01 클래스를 상속받는다
	void display(String name){ //super 클래스와 같은 이름의 메소드지만 매개변수가 달라 overloading
		System.out.println("== NoOverride 클래스의 Display() 메소드 ==" + "매개변수: " + name);
	}
}

class JavaExam {
	public static void main(String[] args) {
		System.out.println("*** 메소드의 재정의(overriding) ***");

		Override01 obj1 = new Override01();
		//Override01 클래스를 객체선언 (super클래스와 sub클래스 생성자에 내용은 따로 없다)
		NoOverride obj2 = new NoOverride();
		//NoOverride 클래스를 객체선언 (super클래스와 sub클래스 생성자에 내용은 따로 없다)

		obj1.display();
		//overriding 되었기 때문에 super 클래스의 display()는 실행되지 않는다
		obj2.display("kkk");
		//NoOverride.display("kkk"); 실행
		obj2.display();
		//Super01.display(); 실행
	}
}
