import java.util.ArrayList;
import java.util.Collections;

public class ArrayListStudy3 {

	public static void main(String[] args) {
		//�ڸ����� 10�� Integer Ÿ���� ArrayList ��ü ����
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		// list1 �� 0��°�� Integer ������ 5���� ������
		list1.add(5);
		// list1 �� 1��°�� Integer ������ 4���� ������
		list1.add(4);
		// list1 �� 2��°�� Integer ������ 2���� ������
		list1.add(2);
		// list1 �� 3��°�� Integer ������ 0���� ������
		list1.add(0);
		// list1 �� 4��°�� Integer ������ 1���� ������
		list1.add(1);
		// list1 �� 5��°�� Integer ������ 3���� ������
		list1.add(3);
		
		//list1�� 1��°���� 4��° �������� ���� ������ ��ü ����
		//���׸�Ÿ���� ����� �������� �����ϸ� ������ �Ұ�
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		//list1 �� ���� ���� ������ �����Ѵ�
		Collections.sort(list1);
		//list2 �� ���� ���� ������ �����Ѵ�
		Collections.sort(list2);
		print(list1,list2);
		
		//System.out.println(list2.get("4") );
		
		//list2 �� ��� ���� list1 �� ������ true �� �����Ѵ�
		System.out.println("list1.containsAll(list2)" 
		+ list1.containsAll(list2));
		
		//list2 �� 3��° ���� ���� {0,2,4,B}
		list2.add("B");
		//list2 �� 4��° ���� ���� {0,2,4,B,C}
		list2.add("C");
		//list2 �� ���� 3��° ������ 1�ڸ��� �ڷ� ������ 3��° ���� ���� {0,2,4,A,B,C}
		list2.add(3,"A");
		print(list1,list2);
		
		list2.set(3, "AA");
		print(list1,list2);
		
		//list1�� ���� list2 �� ���� ���� �����ϰ� ������ �Ǿ��ٸ� true �� �����Ѵ�
		System.out.println("list1.retainAll(list2)" 
		+ list1.retainAll(list2));
		print(list1,list2);
		
		//6�� �ݺ�
		for (int i = list2.size()-1; i >= 0; i--) {
			//list2�� i��° ���� list1�� ������ �ش� ���� �����Ѵ�
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
