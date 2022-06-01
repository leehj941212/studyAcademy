class CExam{
	String hak;
	String name;
	int jum;
	//변수 데이터타입 선언

	public CExam(){ //생성자,매개변수 없을때
		hak = "213";
		name = "java";
		jum = 90;
	}
	public CExam(String con_hak){ //생성자, (String 매개변수)를 받을때
		hak = con_hak;
		name = "babo";
		jum = 80;
	}
	public CExam(String con_hak , String con_name){ //생성자, (Stirng , String 매개변수)를 받을때
		hak = con_hak;
		name = con_name;
		jum = 95;
	}
	void title(){
		System.out.println("자바의 생성자");
	}
	void show(){
		System.out.println(hak + " " + name +" " + jum);
	}
}

class ConExam {
	public static void main(String[] args) {
		CExam c1 = new CExam(); 
		//매개변수 없는 생성자 호출
		//hak = "213"; name = "java"; jum = 90;
		CExam c2 = new CExam("1234567"); 
		//(String 매개변수) 생성자 호출
        //hak = "1234567"; name = "babo"; jum = 80;
		CExam c3 = new CExam("987654" , "goo"); 
		//(Stirng , String 매개변수) 생성자 호출
		//hak = "987654"; name = "goo"; jum = 95;
		CExam c4 = new CExam("1357" , "hoo"); 
		//(Stirng , String 매개변수) 생성자 호출
		//hak = "1357"; name = "hoo"; jum = 95;
		c1.title();
		c1.show();
		c2.show();
		c3.show();
		c4.show();
	}
}
