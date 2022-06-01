class  Saram{
	String irum;
	int age;
	void title(){
		System.out.println("<< 자바의 객체 생성 >>");
		System.out.println("*** 정보 출력 ***");
		System.out.println("--------");
	}
}

	public class SaramQ3{
	public static void main(String[] args) {
		Saram saram = new Saram();
		saram.irum = "철수";
		saram.age = 18;
		saram.title();
		System.out.println("이름 : " + saram.irum);
		System.out.println("나이 : " + saram.age);
		System.out.println();

		Saram saram2 = new Saram();
		saram2.irum = "영희";
		saram2.age = 81;
		saram2.title();
		System.out.println("이름 : " + saram2.irum);
		System.out.println("나이 : " + saram2.age);
		System.out.println();

		Saram saram3 = new Saram();
		saram3.irum = "바둑이";
		saram3.age = 3;
		saram3.title();
		System.out.println("이름 : " + saram3.irum);
		System.out.println("나이 : " + saram3.age);
		System.out.println();
	}
}
