import java.util.Vector;

public class VectorStudy1 {

	public static void main(String[] args) {
		//��ü ���� ,capacity 5 �Ҵ� ����
		Vector<String> v = new Vector<String>(5);
		
		System.out.println("Original");
		//�Է��� ������ ���� �����Ѵ�
		v.add("1");
		v.add("2");
		v.add("3");
//		v.add(10);
		print(v);
		System.out.println();
		
		//capacity ���� size �� �ٲ۴�
		v.trimToSize();
		System.out.println("�̿��� size()");
		print(v);
		System.out.println();
		
		//capacity �� 6���� �ٲ۴�
		v.ensureCapacity(6);
		System.out.println("�޼ҵ� ����� ");
		print(v);
		System.out.println();
		
		//size�� 7���� ū ���� ���ְ� ��������� �⺻�� �� �ִ´�
		v.setSize(7);
		System.out.println("�޼ҵ� ����� ");
		print(v);
		System.out.println();
		
		//��� ���� ���ش� , capacity �� ����
		v.clear();
		System.out.println("�޼ҵ� ����� ");
		print(v);
		System.out.println();
	}
	public static void print(Vector v) {
		//v�� �� ��� , v�� size ���
		System.out.println(v);
		System.out.println("size: "+v.size());
		System.out.println("capacity: "+v.capacity());
	}

}
