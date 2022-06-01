class SungJukA{
	String stdName;
	String stdNo;
	int stdJumsu;

	void stdPrint(){
		System.out.println(" " + stdName +" 정보");
		System.out.println(" 이름 : " + stdName);
		System.out.println(" 학번 : " + stdNo);
		System.out.println(" 점수 : " + stdJumsu);
	}
}

public class  SungJuk{
	public static void main(String[] args) {
		/*
		String stdName = "철수";
		String stdNo = "1234567";
		int stdJumsu = 100;

		String stdName2 = "영희";
		String stdNo2 = "789456";
		int stdJumsu2 = 100;

		System.out.println(" 철수 정보");
		System.out.println(" 이름 : " + stdName);
		System.out.println(" 학번 : " + stdNo);
		System.out.println(" 점수 : " + stdJumsu);

		System.out.println(" 영희 정보");
		System.out.println(" 이름 : " + stdName2);
		System.out.println(" 학번 : " + stdNo2);
		System.out.println(" 점수 : " + stdJumsu2);
		*/

		SungJukA sungJukA = new SungJukA();
		sungJukA.stdName = "철수";
		sungJukA.stdNo = "1234567";
		sungJukA.stdJumsu = 100;
		sungJukA.stdPrint();

		SungJukA sungJukA2 = new SungJukA();
		sungJukA2.stdName = "영희";
		sungJukA2.stdNo = "789456";
		sungJukA2.stdJumsu = 100;
		sungJukA2.stdPrint();		

		/*
		System.out.println(" 철수 정보");
		System.out.println(" 이름 : " + sungJukA.stdName);
		System.out.println(" 학번 : " + sungJukA.stdNo);
		System.out.println(" 점수 : " + sungJukA.stdJumsu);

		System.out.println(" 영희 정보");
		System.out.println(" 이름 : " + sungJukA2.stdName);
		System.out.println(" 학번 : " + sungJukA2.stdNo);
		System.out.println(" 점수 : " + sungJukA2.stdJumsu);
		*/
	}
}
