import java.util.ArrayList;

//����� 6 ArrayList ����
//1~45 ������ ������ ���� -> �ߺ����� �ʾƾ���.
//���

public class Study8 {

	public static void main(String[] args) {
		//����� 6 ArrayList ���� (6 ������ �ǹ̾���)
		ArrayList<Integer> arrayList = new ArrayList<Integer>(6);
		
		//����� 45 ArrayList2 ���� (45 ������ �ǹ̾���)
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(45);
		//ArrayList2 �� i��°�� i��� ���� ������
		for (int i = 1; i < 46; i++) {
			arrayList2.add(i);
		}
		
		//i �� 0���� 5���� 6�� �ݺ�
		for (int i = 0; i < 6; i++) {
			int a = (int)(Math.random()*arrayList2.size());
			//arrayList2�� ���� �������� ���� �޴´�
			arrayList.add(arrayList2.get(a));
			//arrayList�� ���Ե� ���� arrayList2 ���� �����Ѵ�
			arrayList2.remove(a);

		}
		
		System.out.println(arrayList);
	}

}
