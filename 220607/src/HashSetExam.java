import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetExam {
	//객체 선언
	HashSet<String> hash = new HashSet<String>();
	
	public void addset() {
		//값을 추가한다 , 같은 값은 add 해도 의미 없다
		hash.add("java");
		hash.add("hello");
		hash.add("web");
		hash.add("db");
		hash.add("green");
		hash.add("blue");
		hash.add("hello");
	}
	public void printset() {
		//값을 리턴한다
		Iterator<String> it = hash.iterator();
		//hasNext(); <<- 다음 값이 있으면 true 를 리턴한다
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name + "\t");
		}
		
		System.out.println("\n========");
		
		TreeSet<String> tree = new TreeSet<String>(hash);
		Iterator<String> it2 = tree.iterator();
		while (it2.hasNext()) {
			String name = it2.next();
			System.out.println(name + "\t");
		}
	}

	public static void main(String[] args) {
		HashSetExam ha = new HashSetExam();
		ha.addset();
		ha.printset();

	}

}
