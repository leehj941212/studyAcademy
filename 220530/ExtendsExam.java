class SuperClass{
	int i;
}

class SubClass extends SuperClass{ //SuperClass 클래스를 상속받는다
	double d;
}

class  ExtendsExam{
	public static void main(String[] args) {
		SuperClass x = new SuperClass();
		SubClass y = new SubClass();
		x.i = 123;
		y.d = 10.32;
		y.i = 456;
		//x.d = 456.123; SuperClass는 SubClass를 상속받지 않기 때문에 불가하다
	}
}
