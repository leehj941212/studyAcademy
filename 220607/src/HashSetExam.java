import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetExam {
	//��ü ����
	HashSet<String> hash = new HashSet<String>();
	
	public void addset() {
		//���� �߰��Ѵ� , ���� ���� add �ص� �ǹ� ����
		hash.add("java");
		hash.add("hello");
		hash.add("web");
		hash.add("db");
		hash.add("green");
		hash.add("blue");
		hash.add("hello");
	}
	public void printset() {
		//���� �����Ѵ�
		Iterator<String> it = hash.iterator();
		//hasNext(); <<- ���� ���� ������ true �� �����Ѵ�
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
