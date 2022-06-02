import java.util.ArrayList;
import java.util.Collections;

//����� 6 ArrayList ����
//1~45 ������ ������ ���� -> �ߺ����� �ʾƾ���.
//�����ؼ� ���

public class Study7 {

	public static void main(String[] args) {
		//����� 6 ArrayList ���� (6 ������ �ǹ̾���)
		ArrayList<Integer> arrayList = new ArrayList<Integer>(6);
		
		//arrayList.size() �� 6�� �ɶ����� �ݺ�
		for (; arrayList.size() < 6;) {
			Integer x = (int)(Math.random()*45+1);
				if (!arrayList.contains(x)) {
				arrayList.add(x);
				}	
		}
		
		//���� ������ ����
		Collections.sort(arrayList);
		
		//System.out.println(arrayList);
		for (Integer i : arrayList) {
			System.out.println(i);
		}

	}

}
