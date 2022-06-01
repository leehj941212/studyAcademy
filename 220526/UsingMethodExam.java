     /*class UsingMethodExam{
     Method이름 :  methodExam03_01
     ReturnType : 정수
     Parameter : 정수 1개
	(구현부에서)하는 일 : 	methodExam03_01이 호출되었습니다. 출력
	                                인수로 받은 정수 출력 
	                               정수*2 리턴. 
	 
	 Method이름 :  methodExam03_02
     ReturnType : String
     Parameter : String 1개, 정수 1개
	 (구현부에서)하는 일 : 		methodExam03_02가 호출되었습니다. 출력
		                                인수로 받은 String 에 바보를 붙여서 출력
		                                 인수로 받은 String 에 바보를 붙여서 리턴
	
	 Method이름 :  methodExam03_03
     ReturnType : 리턴안함
     Parameter : 정수 1개와 String 1개
     (구현부에서)하는 일 : 		methodExam03_03이 호출되었습니다. 출력	

     
     Method이름 :  methodExam03_04
     ReturnType : 실수(부동소수형)
     Parameter : 첫번째 인수(정수),두번째 인수(실수), 세번째인수(정수)
	(구현부에서)하는 일 : 		methodExam03_04가 호출되었습니다. 출력
	                                   실수값 리턴

    } 
    */

class UsingMethodExam {

	int methodExam03_01(int num01){
		//Method이름 :  methodExam03_01
        //ReturnType : 정수
        //Parameter : 정수 1개
		System.out.println("methodExam03_01이 호출되었습니다"); //methodExam03_01이 호출되었습니다. 출력
		System.out.println(num01); //인수로 받은 정수 출력
		int num02 = num01*2;
		return num02; //정수*2 리턴.
	}

	String methodExam03_02(String txt01 , int num01){
		//Method이름 :  methodExam03_02
        //ReturnType : String
        //Parameter : String 1개, 정수 1개
		System.out.println("methodExam03_02이 호출되었습니다"); //methodExam03_02가 호출되었습니다. 출력
		String txt02 = txt01 + "바보"; 
		System.out.println(txt02); //인수로 받은 String 에 바보를 붙여서 출력
		return txt02; //인수로 받은 String 에 바보를 붙여서 리턴
	}

	void methodExam03_03(int num01 , String txt01){
		//Method이름 :  methodExam03_03
        //ReturnType : 리턴안함
        //Parameter : 정수 1개와 String 1개
		System.out.println("methodExam03_03이 호출되었습니다"); //methodExam03_03이 호출되었습니다. 출력
	}

	double methodExam03_04(int num01 , double num02 , int num03){
		//Method이름 :  methodExam03_04
        //ReturnType : 실수(부동소수형)
        //Parameter : 첫번째 인수(정수),두번째 인수(실수), 세번째인수(정수)
		System.out.println("methodExam03_04이 호출되었습니다"); //methodExam03_04가 호출되었습니다. 출력
		return num02; //실수값 리턴
	}

	public static void main(String[] args) {
		UsingMethodExam exam = new UsingMethodExam(); 
		//UsingMethodExam 클래스를 변수 exam에 선언
		int x = exam.methodExam03_01(10); 
		// methodExam03_01 메서드에 10 이라는 인자를 넣어 호출하고 리턴값을 x에 부여
		String y = exam.methodExam03_02("홍길동" , 15); 
		//exam.methodExam03_02 메서드에 "홍길동" , 15 이라는 인자를 넣어 호출하고 리턴값을 y에 부여
		exam.methodExam03_03(11 , "바나나");
		//methodExam03_03 메서드에 11 , "바나나" 이라는 인자를 넣어 호출
		double z = exam.methodExam03_04(11 , 1.5 , 4);
		//exam.methodExam03_04 메서드에 11 , 1.5 , 4 이라는 인자를 넣어 호출하고 리턴값을 z에 부여
	}
}
