import java.util.Vector;

public class VectorStudy1 {

	public static void main(String[] args) {
		//객체 선언 ,capacity 5 할당 선언
		Vector<String> v = new Vector<String>(5);
		
		System.out.println("Original");
		//입력한 순으로 값을 저장한다
		v.add("1");
		v.add("2");
		v.add("3");
//		v.add(10);
		print(v);
		System.out.println();
		
		//capacity 값을 size 로 바꾼다
		v.trimToSize();
		System.out.println("이용후 size()");
		print(v);
		System.out.println();
		
		//capacity 를 6으로 바꾼다
		v.ensureCapacity(6);
		System.out.println("메소드 사용후 ");
		print(v);
		System.out.println();
		
		//size를 7보다 큰 값은 없애고 비어있으면 기본값 을 넣는다
		v.setSize(7);
		System.out.println("메소드 사용후 ");
		print(v);
		System.out.println();
		
		//모든 값을 없앤다 , capacity 는 유지
		v.clear();
		System.out.println("메소드 사용후 ");
		print(v);
		System.out.println();
	}
	public static void print(Vector v) {
		//v의 값 출력 , v의 size 출력
		System.out.println(v);
		System.out.println("size: "+v.size());
		System.out.println("capacity: "+v.capacity());
	}

}
