//메인 메서드 정보만 있을때 다른 부분 작성

class MethodExam02 {

	int methodEx01(int num1){
		int num2 = num1 + 10;
		return num2;
	}

	String methodEx02(String txt1 ){
		String txt2 = txt1 + "조아";
		return txt2;
	}

	void methodEx03(int num1 , char txt1 ){
		System.out.println(num1);
		System.out.println(txt1);
	}

	int methodEx04(int num1 , double num2 , int num3 ){
		int num4 = num1 + (int)num2 + num3;
		return num4;
	}

	public static void main(String[] args) {
		MethodExam02 mme = new MethodExam02(); 
		// 클래스 MethodExam02 를 변수 mme에 할당한다
		int k = mme.methodEx01(33); 
		//매서드 methodEx01 에 33 이라는 매개변수를 넣어 호출하고 리턴값을 변수 k에 할당한다
		System.out.println(k);
		String s = mme.methodEx02("java"); 
		//매서드 methodEx02 에 java 라는 매개변수를 넣어 호출하고 리턴값을 변수 s에 할당한다
		System.out.println(s);
		mme.methodEx03(42,'a'); 
		//매서드 methodEx03 에 42,'a' 라는 매개변수를 넣어 호출한다
		int d = mme.methodEx04(7 , 5.5 , 8);
		//매서드 methodEx04 에 7 , 5.5 , 8 라는 매개변수를 넣어 호출하고 리턴값을 변수 d에 할당한다
		System.out.println(d);
	}
}
