class Calculator{
	double areaCircle(double r){ // double 형의 리턴값을 가지고 (double r)매개변수를 가지는 메서드
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.14159 * r * r;
	}
}

class Computer extends Calculator{ // Calculator 클래스를 상속받는다
	double areaCircle(double r){ // Overriding
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}

public class ComputerExample{
	public static void main(String[] args) {
		int r = 10;
		Calculator calculator = new Calculator(); //객체생성
		System.out.println("원면적 : " + calculator.areaCircle(r));
		//calculator.areaCircle(10) = 3.14159 * 10 * 10;
		System.out.println();
		Computer computer = new Computer(); //객체생성
		System.out.println("원면적 : " + computer.areaCircle(r));
		//calculator.areaCircle(10) = Math.PI * 10 * 10;
	}
}
