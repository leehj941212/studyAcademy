class SuperClassExam{
	int intNum;
	String memStr = "String in SuperClass";
	//변수 선언

	SuperClassExam(){ //생성자
		System.out.println("생성자 SuperClassExam() 호출");
	}
	public void methodZero(){  //매개변수가 없는 메서드
		System.out.println("SuperClassExam methodZero() 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		//int intNum , String memStr 값 변화 없음
	}
	int methodTwo(int i){ //int 형 리턴값을 가지고 (int i)매개변수를 가지는 메서드
		intNum = i;
		System.out.println("SuperClassExam methodTwo(int i) 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		return intNum;
		//intNum = i 으로 변경 , String memStr 값 변화 없음
		//return 값 : i
	}
	protected String methodThree(int i){ //String 형 리턴값을 가지고 (int i)매개변수를 가지는 메서드
		intNum = i;
		System.out.println("SuperClassExam methodThree(int i) 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		return i+memStr;
		//intNum = i 으로 변경 , String memStr 값 변화 없음
		//return 값 : i + "String in SuperClass"
	}
}

class SubClassExam extends SuperClassExam{ //SuperClassExam 클래스를 상속 받는다
	SubClassExam(){ //생성자
		//super(); 생략
		memStr = "SubClass의 생성자가 입력한 String";
		System.out.println("생성자 SubClassExam() 호출");
	}
	public void methodZero(){ //overriding
		System.out.println("SubClassExam methodZero() 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		//int intNum , String memStr 값 변화 없음
	}
	public void methodOwn(){ //리턴값,매개변수가 없는 메서드
		System.out.println("SubClassExam methodOwn() 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		//int intNum , String memStr 값 변화 없음
	}
	String methodThree(String s , int k){ 
		//아래 메서드와 overloading 관계 / super 클래스와 매개변수가 달라 overriding은 아님
		intNum = k;
		memStr = s;
		System.out.println("SubClassExam methodThree(String s , int k) 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		return memStr;
		//intNum = k , memStr = s 으로 변경
		//return 값 : s
	}
	protected String methodThree(int k, String str){ 
		//위 메서드와 overloading 관계 / super 클래스와 매개변수가 달라 overriding은 아님
		intNum = k;
		memStr = str;
		System.out.println("SubClassExam methodThree(int k, String str) 메서드 호출");
		System.out.println("intNum=" + intNum + "\t" + "memStr=" + memStr);
		return memStr;
		//intNum = k , memStr = str 으로 변경
		//return 값 : str
	}
}

public class MethodOverridingExam {
	public static void main(String[] args) {
		SuperClassExam sp = new SuperClassExam();
		// SuperClassExam() 생성자 호출 , 객체 선언
		sp.methodZero();
		// SuperClassExam.methodZero(); 실행
		int rs = sp.methodTwo(1);
		//sp.methodOwn(); << sub클래스의 메서드는 호출 할 수 없다
		System.out.println("********");
		SubClassExam sb = new SubClassExam();
		// SuperClassExam() 생성자 호출 , SubClassExam() 생성자 호출 , 객체 선언
		sb.methodZero();
		// SubClassExam.methodZero(); 실행 << Overriding 한 메서드
		int rx = sb.methodTwo(2);
		//SuperClassExam.methodTwo(2); 실행 <<super 클래스의 메서드는 사용가능
		String str1 = sb.methodThree(3 , "aaa");
		String str2 = sb.methodThree("bbb" , 4);
		System.out.println("********");
	}
}
