class Puppy3{
	public Puppy3(){
		System.out.println("매개변수 없음");
	}
	public Puppy3(String x){
		System.out.println("매개변수 String x " + x);
	}
	public Puppy3(String x , String y){
		System.out.println("매개변수 String x , String y " + x + y);
	}
	public Puppy3(char x){
		System.out.println("매개변수 char x " + x);
	}
	public Puppy3(boolean x){
		System.out.println("매개변수 boolean x " + x);
	}
}

class ConstructorExam2 {
	public static void main(String[] args) {
		Puppy3 p1 = new Puppy3(); //매개변수 없는 생성자 호출
		System.out.println("====1번 완료====");
		Puppy3 p2 = new Puppy3("A"); //(String x 매개변수)를 가지는 생성자 호출
		System.out.println("====2번 완료====");
		Puppy3 p3 = new Puppy3("Java" , "Hi"); //(String x , String y 매개변수)를 가지는 생성자 호출
		System.out.println("====3번 완료====");
		Puppy3 p4 = new Puppy3('F'); //(char x 매개변수)를 가지는 생성자 호출
		System.out.println("====4번 완료====");
		Puppy3 p5 = new Puppy3(true); //(boolean x 매개변수)를 가지는 생성자 호출
	}
}
