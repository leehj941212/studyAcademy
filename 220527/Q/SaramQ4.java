class  Saram2{
	String irum;
	int age;
	void title(){
		System.out.println("<< 자바의 객체 생성(배열 이용) >>");
		System.out.println("*** 정보 출력 ***");
		System.out.println("--------");
	}
}

class  SaramQ4{
	public static void main(String[] args) {
		Saram2[] saram = new Saram2[3];
		Saram2 saram2 = new Saram2();

		for (int n=0;n < saram.length;n++){
			saram[n] = new Saram2();
		}

		saram[0].irum = "철수";
		saram[0].age = 18;

		saram[1].irum = "영희";
		saram[1].age = 81;

		saram[2].irum = "바둑이";
		saram[2].age = 3;

		for (int n=0 ;n < saram.length;n++){
			saram2.title();
		System.out.println("이름 : " + saram[n].irum);
		System.out.println("나이 : " + saram[n].age);
		System.out.println();
		}	
	}
}
