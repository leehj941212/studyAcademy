//���� �޼��� ������ ������ �ٸ� ��� �Է�

class OverloadedMethod {

	void setOverload(int x){
		System.out.println(x * 2);
	}

	String setOverload(){
		String x = "(int)(Math.random()*10)";
		System.out.println(x);
		return x;
	}

	void setOverload(String x , String y){
		System.out.println(x + y);
	}

	void overload(){
		System.out.println("�۵���...");
	}

	char getOverload(String x){
		System.out.println(x);
		char y = '1';
		return y;
	}

	void getOverload(String x , String y){
		System.out.println(x + y);
	}

	void getOverload(double x){
		System.out.println(x);
	}

	public static void main(String[] args) {
		OverloadedMethod om = new OverloadedMethod(); 
		//Ŭ���� OverloadedMethod�� om�� �����Ѵ�
		om.setOverload(5); 
		//setOverload �޼��忡 5��� �Ű������� �ְ� ȣ���Ѵ�
		String re = om.setOverload(); 
		//setOverload �޼��带 ȣ���ϰ� ���ϰ��� re ������ �ִ´�
		om.setOverload("A" , "Java"); 
		// setOverload �޼��忡 "A" , "Java" ��� �Ű������� �ְ� ȣ���Ѵ�
		om.overload(); 
		//overload �޼��带 ȣ���Ѵ�
		char ch = om.getOverload("hello"); 
		//getOverload �޼��忡 hello ��� �Ű������� �ְ� ȣ���ϰ� ���ϰ��� ch ������ �ִ´�
		om.getOverload("aa" , "BB"); 
		//getOverload �޼��忡 "aa" , "BB" ��� �Ű������� �ְ� ȣ���Ѵ�
		om.getOverload(5.2); 
		//getOverload �޼��忡 5.2 ��� �Ű������� �ְ� ȣ���Ѵ�
	}
}
