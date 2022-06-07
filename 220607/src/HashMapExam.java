import java.util.HashMap;
import java.util.Set;

//key �� String  , value �� Integer Ÿ���� ������
public class HashMapExam extends HashMap<String, Integer> {
	//������
	public HashMapExam() {
		// put(key , value); <<- key �� ������ value �� ��Ÿ����
		//super �� �ٿ��� , �����ص� �������
		put("a", 10);
		super.put("b", 20);
		put("c", 30);
		
		System.out.println("size = " + super.size());
		
		//keySet(); <<- key ���� �����Ѵ�
		Set<String> s = super.keySet();
		for (String str : s) {
			int i = super.get(str);
			System.out.printf("key = %s => value = %d%n" , str , i);
		}
	}

	public static void main(String[] args) {
		//������ ȣ��
		new HashMapExam();

	}

}
