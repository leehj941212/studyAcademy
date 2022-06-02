
public class VarargsExam {
	
	public void aa(int i) {
		System.out.println("aa 호출됨");
	}
	public void bb(int...i) { 
		//가변인자 : 인자의 개수를 유동적으로 받을 수 있다
		System.out.println("\n==== bb호출");
		for (int a : i) {
			System.out.println(a+"\t");
		}
		System.out.println();
	}
	public void cc(String...s) {
		System.out.println("\n==== cc호출");
		for (String str : s) {
			System.out.println(str + "\n");
		}
	}
	public void dd(Object...obj) { 
		//Object 데이터 타입은 모든 형태의 값을 받을 수 있다
		System.out.println("dd호출");
	}
	public void ee(int i , String...s) {
		System.out.println("ee호출");
	}

	public static void main(String[] args) {
		VarargsExam ve = new VarargsExam();
		ve.aa(3);
		
		ve.bb();
		ve.bb(1,2);
		ve.bb(3,4,5);
		
		ve.cc("String");
		ve.cc("String1" , "String2");
		
		ve.dd();
		ve.dd(3,2,"hello","haha");
		ve.dd(2.5,'a',"hoho",7);
		
		ve.ee(2);
		ve.ee(3, "a" , "b" , "c");
	}

}
