import java.util.HashMap;
import java.util.Set;

//key 는 String  , value 는 Integer 타입을 가진다
public class HashMapExam extends HashMap<String, Integer> {
	//생성자
	public HashMapExam() {
		// put(key , value); <<- key 를 받으면 value 를 나타낸다
		//super 은 붙여도 , 생략해도 상관없음
		put("a", 10);
		super.put("b", 20);
		put("c", 30);
		
		System.out.println("size = " + super.size());
		
		//keySet(); <<- key 값을 리턴한다
		Set<String> s = super.keySet();
		for (String str : s) {
			int i = super.get(str);
			System.out.printf("key = %s => value = %d%n" , str , i);
		}
	}

	public static void main(String[] args) {
		//생성자 호출
		new HashMapExam();

	}

}
