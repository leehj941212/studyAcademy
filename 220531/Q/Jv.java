class High{
	int x = 1000; // ���� ����
	void display(){ //�޼ҵ�
		System.out.println("== High Ŭ������ display() �޼ҵ� ==");
		System.out.println("  High Ŭ������ x ��: " + x); //x = 1000
	}
}

class Lower extends High{ //HighŬ������ ��� �޴´�
	int x = 2000;
	void display() { //overriding
		System.out.println("== Lower Ŭ������ display() �޼ҵ� ==");
		System.out.println("  Lower Ŭ������ x ��: " + x); //x = 2000
	}
	void write(){
		this.display(); //Lower.display(); ����
		super.display(); //High.display(); ����
	}
}

class Jv {
	public static void main(String[] args) {
		System.out.println("*** this �� super ����� ***");

		Lower obj = new Lower();
		//LowerŬ������ ��ü����
		obj.write() ;
		//Lower.display(); High.display(); ����
	}
}
