class SungJukA{
	String stdName;
	String stdNo;
	int stdJumsu;

	void stdPrint(){
		System.out.println(" " + stdName +" ����");
		System.out.println(" �̸� : " + stdName);
		System.out.println(" �й� : " + stdNo);
		System.out.println(" ���� : " + stdJumsu);
	}
}

public class  SungJuk{
	public static void main(String[] args) {
		/*
		String stdName = "ö��";
		String stdNo = "1234567";
		int stdJumsu = 100;

		String stdName2 = "����";
		String stdNo2 = "789456";
		int stdJumsu2 = 100;

		System.out.println(" ö�� ����");
		System.out.println(" �̸� : " + stdName);
		System.out.println(" �й� : " + stdNo);
		System.out.println(" ���� : " + stdJumsu);

		System.out.println(" ���� ����");
		System.out.println(" �̸� : " + stdName2);
		System.out.println(" �й� : " + stdNo2);
		System.out.println(" ���� : " + stdJumsu2);
		*/

		SungJukA sungJukA = new SungJukA();
		sungJukA.stdName = "ö��";
		sungJukA.stdNo = "1234567";
		sungJukA.stdJumsu = 100;
		sungJukA.stdPrint();

		SungJukA sungJukA2 = new SungJukA();
		sungJukA2.stdName = "����";
		sungJukA2.stdNo = "789456";
		sungJukA2.stdJumsu = 100;
		sungJukA2.stdPrint();		

		/*
		System.out.println(" ö�� ����");
		System.out.println(" �̸� : " + sungJukA.stdName);
		System.out.println(" �й� : " + sungJukA.stdNo);
		System.out.println(" ���� : " + sungJukA.stdJumsu);

		System.out.println(" ���� ����");
		System.out.println(" �̸� : " + sungJukA2.stdName);
		System.out.println(" �й� : " + sungJukA2.stdNo);
		System.out.println(" ���� : " + sungJukA2.stdJumsu);
		*/
	}
}
