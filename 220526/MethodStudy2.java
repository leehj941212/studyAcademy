class MethodStudy2 {

	public void sub1(){
		System.out.println("Welcome to JAVA");
	}

	void sub2(int a , int b){ //매개변수 int a , int b 를 가지고 있다
		int c;
		c = a + b;
		System.out.println(a + "+" + b + "=" + c);
	}

	double sub3(int m , int n){ //매개변수 int m , int n를 가지고 있고 double 형태의 리턴값을 가진다
		double k;
		k = m + n;
		return k;
	}

	public static void main(String[] args) {
		MethodStudy2 ken = new MethodStudy2(); // 변수 ken 에 MethodStudy2 클래스 할당
		System.out.println("*** method result ***");
		ken.sub1(); // sub1 메서드 호출
		ken.sub2(123,456); //sub2 메서드에 매개변수 123,456 을 넣어 호출
		double w = ken.sub3(78,90); 
		// sub3 메서드에 매개변수 78,90을 넣고 sub3 메서드 호출하여 리턴값을 변수 w에 할당
		System.out.println("sub3(x,y)=" + w);
	}
}
