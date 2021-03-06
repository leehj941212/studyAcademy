class Super_x{
	void ken(int i){ //(int i)매개변수를 가지는 메소드
		System.out.println("상위클래스의 메소드 ken: " + i + " ");
	}
	void boo(float j){ //(float j)매개변수를 가지는 메소드
		System.out.println("상위클래스의 메소드 boo: " + j + " ");
	}
}

class Sub_x extends Super_x{ //Super_x 클래스를 상속 받는다
	void boo(int i , int j){ //(int i , int j)매개변수를 가지는 메소드 , overloading
		System.out.println("하위클래스의 메소드 boo: " + i + " , " + j);
	}
	void yoo(int i){ //(int i)매개변수를 가지는 메소드
		System.out.println("하위클래스의 메소드 yoo: " + i + " ");
	}
	void soo(){ //메소드
		System.out.println("하위클래스의 메소드 soo ");
	}
}

class Jv2{
	public static void main(String[] args) {
		System.out.println("*** 메소드의 상속 ***");
		Sub_x obj = new Sub_x();
		//Sub_x 클래스를 객체선언
		obj.ken(50);
		//Super_x.ken(50); 실행
		obj.boo(3.1415f);
		//Super_x.boo(3.1415f); 실행
		obj.boo(10,20);
		//Sub_x.boo(10,20); 실행
		obj.yoo(50);
		//Sub_x.yoo(50); 실행
		obj.soo();
		//Sub_x.soo(); 실행
	}
}
