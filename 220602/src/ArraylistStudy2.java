import java.util.ArrayList;

public class ArraylistStudy2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(6);
		list.add("������");
		list.add("ȭ����");
		list.add("������");
		list.add("�����");
		list.add("�ݿ���");
		list.add("�����");
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
	}

}
