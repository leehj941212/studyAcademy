class MethodStudy1 {
	void method(){ //void �޼ҵ��() { java����; }
		System.out.println("method1");
	}
	void method2(int b){ //()�ȿ� ���θ޼��忡�� �޴� ������� �ٸ��� ��� , b -> �Ű�����,����,�μ� �� �θ���
		System.out.println("method two");
		System.out.println(" value = " + b);
	}
	int method3(){
		int value = 200; //���θ޼���� �������� ������ �ٸ� ����
		System.out.println("method3");
		System.out.println(" value = " + value);
		return value;
	}
	public static void main(String[] args) {
		int value = 100;
		MethodStudy1 txt = new MethodStudy1(); // MethodStudy1 Ŭ������ txt ������ �Ҵ��Ѵ�
		System.out.println("main method");
		System.out.println(" value = " + value);
		txt.method(); // method �޼��� ȣ��
		txt.method2(value); // ()�ȿ� �����ϰ��� �ϴ� ���� ����
		value = txt.method3(); // method3�� ȣ���ϰ� ���ϰ��� value�� ����
		System.out.println(" value = " + value);
	}
}
