class ObjectOne{
	int a;
}

public class  ObjectInArray{
	public static void main(String[] args) {

		ObjectOne[] obj = new ObjectOne[5]; //��ü �迭�� ���� (���� ��ü ������ �ȵ�)
		System.out.println("obj = " + obj);

		for ( int i = 0 ; i < obj.length ; i++ ){
			System.out.print("������ : obj[" + i + "] = " + obj[i]);
			obj[i] = new ObjectOne(); //��ü ����
			System.out.println(", ������ : obj[" + i + "] = " + obj[i]);
		}

		System.out.println();
		for ( int i = 0 ; i < obj.length ; i++ ){
			System.out.print("������ : obj[" + i + "].a = " + obj[i].a);
			obj[i].a = i;
			System.out.println(", ������ : obj[" + i + "].a = " + obj[i].a);
		}
		System.out.println();
		obj[0] = obj[1]; //��ü������ ������ ����

		for ( int i = 0 ; i< obj.length ; i++){
			System.out.print("obj[" + i + "].a = " + obj[i]);
			System.out.println("==>obj[" + i + "].a = " + obj[i].a);
		}
	}
}
