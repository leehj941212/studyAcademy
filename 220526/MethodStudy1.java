class MethodStudy1 {
	void method(){ //void 메소드명() { java문장; }
		System.out.println("method1");
	}
	void method2(int b){ //()안에 메인메서드에서 받는 변수명과 다른것 사용 , b -> 매개변수,인자,인수 라 부른다
		System.out.println("method two");
		System.out.println(" value = " + b);
	}
	int method3(){
		int value = 200; //메인메서드와 변수명은 같지만 다른 변수
		System.out.println("method3");
		System.out.println(" value = " + value);
		return value;
	}
	public static void main(String[] args) {
		int value = 100;
		MethodStudy1 txt = new MethodStudy1(); // MethodStudy1 클래스를 txt 변수에 할당한다
		System.out.println("main method");
		System.out.println(" value = " + value);
		txt.method(); // method 메서드 호출
		txt.method2(value); // ()안에 전달하고자 하는 내용 기입
		value = txt.method3(); // method3을 호출하고 리턴값을 value에 대입
		System.out.println(" value = " + value);
	}
}
