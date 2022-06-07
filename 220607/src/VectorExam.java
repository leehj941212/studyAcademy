import java.util.Vector;

public class VectorExam extends Vector {
	//Object 타입 1개 , int 타입 1개
	Object ob ;
	int i;

	public VectorExam() {
		//초기용량은 1개고...하나씩 증가

		//Vector v = new Vector(1,1); 와 같다
		super(1,1);
	}

	//method이름  리턴타입  인수

	/*addInt  없음  정수 (int)1개
	 * 하는일 : 인수로 받은 정수를 객체로 만들어 Vector에 추가
	 */
	void addInt(int x) {
		add(x);
	}

	/*addFloat  없음  실수(float)1개
	 * 하는일 : 인수로 받은 실수를 객체로 만들어 Vector에 추가
	 */
	void addFloat(float x) {
		add(x);
	}

	/*addString  없음  String 문자열 1개
	 * 하는일 : 인수로 받은 String 을 Vector에 추가
	 */
	void addString(String x) {
		add(x);
	}

	/*printVector  없음  없음
	 * 정수형 전역변수에 현재 Vector에 들어있는 객체의 개수 입력한 후 전역변수 출력
	 * 각 객체를 출력
	 */
	void printVector() {
		i = size();
		System.out.println("size: "+i);
		System.out.println("capacity: "+capacity());
		for (int z = 0; z < i; z++) {
			System.out.println(get(z));
		}

	}

	public static void main(String[] args) {
		VectorExam ve = new VectorExam();
		String s = new String("newString");
		ve.addInt(5);
		System.out.println(ve.get(0));
		ve.addFloat(5.5F);
		ve.addString(s);
		ve.printVector();

	}

}
