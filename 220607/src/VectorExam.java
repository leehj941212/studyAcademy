import java.util.Vector;

public class VectorExam extends Vector {
	//Object Ÿ�� 1�� , int Ÿ�� 1��
	Object ob ;
	int i;

	public VectorExam() {
		//�ʱ�뷮�� 1����...�ϳ��� ����

		//Vector v = new Vector(1,1); �� ����
		super(1,1);
	}

	//method�̸�  ����Ÿ��  �μ�

	/*addInt  ����  ���� (int)1��
	 * �ϴ��� : �μ��� ���� ������ ��ü�� ����� Vector�� �߰�
	 */
	void addInt(int x) {
		add(x);
	}

	/*addFloat  ����  �Ǽ�(float)1��
	 * �ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� Vector�� �߰�
	 */
	void addFloat(float x) {
		add(x);
	}

	/*addString  ����  String ���ڿ� 1��
	 * �ϴ��� : �μ��� ���� String �� Vector�� �߰�
	 */
	void addString(String x) {
		add(x);
	}

	/*printVector  ����  ����
	 * ������ ���������� ���� Vector�� ����ִ� ��ü�� ���� �Է��� �� �������� ���
	 * �� ��ü�� ���
	 */
	void printVector() {
		i = size();
		System.out.println("size: "+i);
		System.out.println("capacity: "+capacity());
		for (int z = 0; z < i; z++) {
			System.out.println(get(z));
		}

	}

	public static void main(String[] args) {
		VectorExam ve = new VectorExam();
		String s = new String("newString");
		ve.addInt(5);
		System.out.println(ve.get(0));
		ve.addFloat(5.5F);
		ve.addString(s);
		ve.printVector();

	}

}
