class SuperClass{
	int i;
}

class SubClass extends SuperClass{ //SuperClass Ŭ������ ��ӹ޴´�
	double d;
}

class  ExtendsExam{
	public static void main(String[] args) {
		SuperClass x = new SuperClass();
		SubClass y = new SubClass();
		x.i = 123;
		y.d = 10.32;
		y.i = 456;
		//x.d = 456.123; SuperClass�� SubClass�� ��ӹ��� �ʱ� ������ �Ұ��ϴ�
	}
}
