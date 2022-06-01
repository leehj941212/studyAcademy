//메인 메서드 정보만 있을때 다른 요소 입력

class OverloadedMethod {

	void setOverload(int x){
		System.out.println(x * 2);
	}

	String setOverload(){
		String x = "(int)(Math.random()*10)";
		System.out.println(x);
		return x;
	}

	void setOverload(String x , String y){
		System.out.println(x + y);
	}

	void overload(){
		System.out.println("작동중...");
	}

	char getOverload(String x){
		System.out.println(x);
		char y = '1';
		return y;
	}

	void getOverload(String x , String y){
		System.out.println(x + y);
	}

	void getOverload(double x){
		System.out.println(x);
	}

	public static void main(String[] args) {
		OverloadedMethod om = new OverloadedMethod(); 
		//클래스 OverloadedMethod를 om에 대입한다
		om.setOverload(5); 
		//setOverload 메서드에 5라는 매개변수를 넣고 호출한다
		String re = om.setOverload(); 
		//setOverload 메서드를 호출하고 리턴값을 re 변수에 넣는다
		om.setOverload("A" , "Java"); 
		// setOverload 메서드에 "A" , "Java" 라는 매개변수를 넣고 호출한다
		om.overload(); 
		//overload 메서드를 호출한다
		char ch = om.getOverload("hello"); 
		//getOverload 메서드에 hello 라는 매개변수를 넣고 호출하고 리턴값을 ch 변수에 넣는다
		om.getOverload("aa" , "BB"); 
		//getOverload 메서드에 "aa" , "BB" 라는 매개변수를 넣고 호출한다
		om.getOverload(5.2); 
		//getOverload 메서드에 5.2 라는 매개변수를 넣고 호출한다
	}
}
