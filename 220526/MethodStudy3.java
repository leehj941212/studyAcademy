class MethodStudy3 {
	
	void me(){
		System.out.println("me()");
	}

	void me(int a){
		System.out.println("me(int a)");
	}

	int me(double d){
		return 100;
	}

	public static void main(String[] args) {
		MethodStudy3 ob = new MethodStudy3();
		ob.me();
		ob.me(123);
		int x = ob.me(1.234);
	}
}
