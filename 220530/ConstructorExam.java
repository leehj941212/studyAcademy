class Puppy{
	String str;
	int i ;
	public Puppy(){ //생성자
		printPuppyName();
		System.out.println("생성자 Puppy() ");
		str = "메리";
		i = -98998;
	}
	public void printPuppyName(){
		System.out.println("public void printPuppyName() 호출");
		System.out.println(" 변수 str = " + str + ", i = " + i);
	}
}

class  ConstructorExam{
	public static void main(String[] args) {
		Puppy p = new Puppy(); 
		// 객체선언 , 생성자 호출
		// String str = "메리"; int i = -98998;
		p.printPuppyName(); //printPuppyName() 메서드 실행
	}
}
