import java.util.ArrayList;

//����� 6 ArrayList ����
//1~45 ������ ������ ���� -> �ߺ����� �ʾƾ���.
//���

public class Study7 {

	public static void main(String[] args) {
		//����� 6 ArrayList ���� (6 ������ �ǹ̾���)
		ArrayList<Integer> arrayList = new ArrayList<Integer>(6);
		
		//0��°���� 5��°���� 6�� �ݺ�
		for (int i = 0; i < 6; i++) {
			arrayList.add((int)(Math.random()*45+1));
			//0��°���� i-1���� i�� �ݺ� , i�� 0�϶��� ����x
			for (int j = 0; j < i; j++) {
				//i��° ������ �� ������ �� �� ���� ���� ������
				//i��° ���� ���� �ް� ���� ���� ���������� �� �ݺ����� �ݺ��Ѵ�
				if (arrayList.get(i) == arrayList.get(j)) {
					arrayList.set(i,(int)(Math.random()*45+1));
					j = -1;
				}
				
			}
		}
		
		System.out.println(arrayList);

	}

}
