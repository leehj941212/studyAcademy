class CExam{
	String hak;
	String name;
	int jum;
	//���� ������Ÿ�� ����

	public CExam(){ //������,�Ű����� ������
		hak = "213";
		name = "java";
		jum = 90;
	}
	public CExam(String con_hak){ //������, (String �Ű�����)�� ������
		hak = con_hak;
		name = "babo";
		jum = 80;
	}
	public CExam(String con_hak , String con_name){ //������, (Stirng , String �Ű�����)�� ������
		hak = con_hak;
		name = con_name;
		jum = 95;
	}
	void title(){
		System.out.println("�ڹ��� ������");
	}
	void show(){
		System.out.println(hak + " " + name +" " + jum);
	}
}

class ConExam {
	public static void main(String[] args) {
		CExam c1 = new CExam(); 
		//�Ű����� ���� ������ ȣ��
		//hak = "213"; name = "java"; jum = 90;
		CExam c2 = new CExam("1234567"); 
		//(String �Ű�����) ������ ȣ��
        //hak = "1234567"; name = "babo"; jum = 80;
		CExam c3 = new CExam("987654" , "goo"); 
		//(Stirng , String �Ű�����) ������ ȣ��
		//hak = "987654"; name = "goo"; jum = 95;
		CExam c4 = new CExam("1357" , "hoo"); 
		//(Stirng , String �Ű�����) ������ ȣ��
		//hak = "1357"; name = "hoo"; jum = 95;
		c1.title();
		c1.show();
		c2.show();
		c3.show();
		c4.show();
	}
}
