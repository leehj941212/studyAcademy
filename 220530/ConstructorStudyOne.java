class ConstructorStudyTwo{
	int a;
	ConstructorStudyTwo(int b){ 
		// 생성자 , 클래스명과 동일 , 매개변수를 가질 수 있다 ,returnType 이 없다
		System.out.println("클래스 메소드");
	}
	String m(){
		System.out.println("메소드");
		return "java";
	}
}

public class  ConstructorStudyOne{
	public static void main(String[] args) {
		ConstructorStudyTwo  constructorStudyTwo = new ConstructorStudyTwo(789);
		// 객체 생성시 자동 호출
		// constructorStudyTwo.ConstructorStudyTwo(); 식으로 임의 호출은 불가
		constructorStudyTwo.a = 123;
		String str = constructorStudyTwo.m();
	}
}
