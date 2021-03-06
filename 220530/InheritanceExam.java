class Car{
	// private
	public String carname;
	public int cost;
	//변수 선언

	protected void printAttributes(){ 
		//protected : 자식 클래스에게는 public / 외부 클래스에게는 private
		System.out.println("carname = " + carname + "\t cost = " + cost);
	}
}

class Benz extends Car{ //Car클래스를 상속받는다
	public Benz(){ //생성자
		carname = "Benz";
		cost =10000;
	}
}

class Audi extends Car{ //Car클래스를 상속받는다
	public Audi(){ //생성자
		carname = "Audi";
		cost =7000;
	}
}

class Bmw extends Car{ //Car클래스를 상속받는다
	public Bmw(){ //생성자
		carname = "Bmw";
		cost =8000;
	}
}

public class  InheritanceExam{
	public static void main(String[] args) {
		Car c= new Car(); 
		//객체생성
		//public String carname;
	    //public int cost;
		Benz benz = new Benz();
		//객체생성
		//public String carname = "Benz, ";
	    //public int cost =10000;
		Audi audi = new Audi();
		//객체생성
		//public String carname = "Audi, ";
	    //public int cost =7000;
		Bmw bmw = new Bmw();
		//객체생성
		//public String carname = "Bmw, ";
	    //public int cost =8000;

		c.printAttributes();
		//Car 클래스를 객체화 하여 printAttributes() 메서드 실행
		benz.printAttributes();
		//Car클래스를 상속받는 Benz 클래스를 객체화 하여 printAttributes() 메서드 실행
		audi.printAttributes();
		//Car클래스를 상속받는 Audi 클래스를 객체화 하여 printAttributes() 메서드 실행
		bmw.printAttributes();
		//Car클래스를 상속받는 Bmw 클래스를 객체화 하여 printAttributes() 메서드 실행
	}
}
