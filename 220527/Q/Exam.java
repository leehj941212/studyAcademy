class Overloading1{

	public void disp(int i , String str){
		System.out.println("������ ���ڿ� ���: " + i + " " + str);
	}

	public void disp(String str){
		System.out.println("���ڿ� ���: " + str);
	}

	public void disp(int i , String str , double ken){
		System.out.println("������ ���ڿ�, �Ǽ� ���: " + i + " " + str + " " + ken);
	}
}

class Exam {
	public static void main(String[] args) {

		Overloading1 kkk = new Overloading1();
		kkk.disp(50 , "�ڹ����α׷���");
		kkk.disp(50, "�ڹ����α׷���" , 2.4);
		kkk.disp("�ڹ����α׷��ֱ���");
	}
}
