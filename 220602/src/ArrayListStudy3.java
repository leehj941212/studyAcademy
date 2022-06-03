import java.util.ArrayList;
import java.util.Collections;

public class ArrayListStudy3 {

	public static void main(String[] args) {
		//자리수가 10인 Integer 타입의 ArrayList 객체 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		// list1 의 0번째는 Integer 형태의 5값을 가진다
		list1.add(5);
		// list1 의 1번째는 Integer 형태의 4값을 가진다
		list1.add(4);
		// list1 의 2번째는 Integer 형태의 2값을 가진다
		list1.add(2);
		// list1 의 3번째는 Integer 형태의 0값을 가진다
		list1.add(0);
		// list1 의 4번째는 Integer 형태의 1값을 가진다
		list1.add(1);
		// list1 의 5번째는 Integer 형태의 3값을 가진다
		list1.add(3);
		
		//list1의 1번째부터 4번째 전까지의 값을 가지는 객체 생성
		//제네릭타입을 안적어도 괜찮으나 가능하면 적도록 할것
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		//list1 의 값을 작은 순으로 정렬한다
		Collections.sort(list1);
		//list2 의 값을 작은 순으로 정렬한다
		Collections.sort(list2);
		print(list1,list2);
		
		//System.out.println(list2.get("4") );
		
		//list2 의 모든 값을 list1 이 가지면 true 를 리턴한다
		System.out.println("list1.containsAll(list2)" 
		+ list1.containsAll(list2));
		
		//list2 의 3번째 값을 선언 {0,2,4,B}
		list2.add("B");
		//list2 의 4번째 값을 선언 {0,2,4,B,C}
		list2.add("C");
		//list2 의 기존 3번째 값부터 1자리씩 뒤로 보내고 3번째 값을 선언 {0,2,4,A,B,C}
		list2.add(3,"A");
		print(list1,list2);
		
		list2.set(3, "AA");
		print(list1,list2);
		
		//list1의 값중 list2 에 없는 값은 제거하고 변경이 되었다면 true 를 리턴한다
		System.out.println("list1.retainAll(list2)" 
		+ list1.retainAll(list2));
		print(list1,list2);
		
		//6번 반복
		for (int i = list2.size()-1; i >= 0; i--) {
			//list2의 i번째 값이 list1에 있으면 해당 값을 제거한다
			if (list1.contains(list2.get(i))) 
				list2.remove(i);
		}
		print(list1,list2);
	}
	
	static void print(ArrayList list1,ArrayList list2) {
		System.out.println("list1" + list1);
		System.out.println("list2" + list2);
		System.out.println();
	}
}
