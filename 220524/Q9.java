import java.util.Scanner; // Scanner�� ����ϱ� ���Ͽ� import �Ѵ�

class Q9 {
	public static void main(String[] args) {

		//�������� �����ؼ� �Է��� �޾�
		//�հ�� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
		//0 �Է½� ���α׷� ����

		Scanner sc = new Scanner(System.in); // Ű�ε�� �Է°��� �Է� �� �� �ִ�
		int num = sc.nextInt(); // �Է°��� num �� �Ҵ� �ȴ� , ���ڸ� �ν�(���ڴ� ����)

		int sum = 0 , ave = 0 , time = 1; //�հ�,���,�Է�Ƚ���� �ʱⰪ ����

		System.out.println("���� �Է°� : " + num);

		for (num = num ; num != 0 ; num = sc.nextInt() , time++ ){ 
			// �Է°��� 0�� �ƴϸ� �ٽ� �Է°��� �ް� time�� 1���� ��Ų��
			sum = sum + num; 
			ave = sum / time;

			System.out.println("���� �հ� : " + sum);
			System.out.println("���� ��� : " + ave);
		}
	}
}
