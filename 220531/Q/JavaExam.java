class Super01{
	void display() {
		System.out.println("== Super01 Ŭ������ Display() �޼ҵ� ==");
	}
}

class Override01 extends Super01{ //Super01 Ŭ������ ��ӹ޴´�
	void display(){ //overriding
		System.out.println("== Override01 Ŭ������ Display() �޼ҵ� ==");
	}
}

class NoOverride extends Super01{ //Super01 Ŭ������ ��ӹ޴´�
	void display(String name){ //super Ŭ������ ���� �̸��� �޼ҵ����� �Ű������� �޶� overloading
		System.out.println("== NoOverride Ŭ������ Display() �޼ҵ� ==" + "�Ű�����: " + name);
	}
}

class JavaExam {
	public static void main(String[] args) {
		System.out.println("*** �޼ҵ��� ������(overriding) ***");

		Override01 obj1 = new Override01();
		//Override01 Ŭ������ ��ü���� (superŬ������ subŬ���� �����ڿ� ������ ���� ����)
		NoOverride obj2 = new NoOverride();
		//NoOverride Ŭ������ ��ü���� (superŬ������ subŬ���� �����ڿ� ������ ���� ����)

		obj1.display();
		//overriding �Ǿ��� ������ super Ŭ������ display()�� ������� �ʴ´�
		obj2.display("kkk");
		//NoOverride.display("kkk"); ����
		obj2.display();
		//Super01.display(); ����
	}
}
