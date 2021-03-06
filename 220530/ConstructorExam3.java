class SuperE{
	public SuperE(){ //매개변수가 없는 생성자
		System.out.println(1);
	}
	public SuperE(int i){ //(int i 매개변수)를 가지는 생성자
		System.out.println(2);
	}
	public SuperE(boolean b){ //(boolean b 매개변수)를 가지는 생성자
		System.out.println(3);
	}
}

class SubE extends SuperE{ // SuperE 클래스를 상속받는다
	public SubE(){ //매개변수가 없는 생성자
		super(3); 
		// SuperE(3); 과 같은 의미
		// 부모 클래스 생성자에 (3)이라는 매개변수를 넣고 실행한다
		// 안쓰면 super(); 가 자동으로 써진다
		System.out.println(4); 
	}
	public SubE(int a){ //(int a 매개변수)를 가지는 생성자
		this("A"); 
		//SubE("A"); 와 같은 의미
		//현재 클래스 생성자에 ("A")이라는 매개변수를 넣고 실행한다
		//SubE("A"); 가 실행될때 SuperE 생성자가 실행되므로 super();가 자동 생성 되지 않는다
		System.out.println(5);
	}
	public SubE(String s){ //(String s 매개변수)를 가지는 생성자
		super(true); 
		// SuperE(true); 과 같은 의미
		//부모 클래스 생성자에 (true)이라는 매개변수를 넣고 실행한다
		// 안쓰면 super(); 가 자동으로 써진다
		System.out.println(6);
	}
}

public class ConstructorExam3{
	public static void main(String[] args) {
		//SubE a = new SubE();  // 2 , 4 출력
		//SubE a = new SubE(3); // 3, 6, 5 출력
		//SubE a = new SubE("Java"); // 3, 6 출력
		//SubE a = new SubE(true); // 실행되지 않는다
	}
}
