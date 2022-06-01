class High{
	int x = 1000; // 변수 선언
	void display(){ //메소드
		System.out.println("== High 클래스의 display() 메소드 ==");
		System.out.println("  High 클래스의 x 값: " + x); //x = 1000
	}
}

class Lower extends High{ //High클래스를 상속 받는다
	int x = 2000;
	void display() { //overriding
		System.out.println("== Lower 클래스의 display() 메소드 ==");
		System.out.println("  Lower 클래스의 x 값: " + x); //x = 2000
	}
	void write(){
		this.display(); //Lower.display(); 실행
		super.display(); //High.display(); 실행
	}
}

class Jv {
	public static void main(String[] args) {
		System.out.println("*** this 및 super 예약어 ***");

		Lower obj = new Lower();
		//Lower클래스를 객체선언
		obj.write() ;
		//Lower.display(); High.display(); 실행
	}
}
