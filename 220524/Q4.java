import java.util.Scanner; // Scanner�� ����ϱ� ���Ͽ� import �Ѵ�

class Q4 {
	public static void main(String[] args) {

		//���ڸ� �Է¹޾� �Է��� �������� ¦������ �� (do~while ���)

		Scanner sc = new Scanner(System.in); // Ű�ε�� �Է°��� �Է� �� �� �ִ�
		int num ;
		int sum = 0; //�հ� �ʱⰪ ����

		do{
			num = sc.nextInt(); 
			// �Է°��� num �� �Ҵ� �ȴ� , ���ڸ� �ν�(���ڴ� ����) , ������ �Է��ϱ� ���� do �ȿ� �Է�
			System.out.println("���� �Է°� : " + num);
			

			if (num % 2 == 0 && num > 0){ // �Է°��� ¦�� �϶�
				sum = sum + num;
			} else{ // �Է°��� ¦���� �ƴҶ�
				sum = sum;
			}

				System.out.println("�Է¹��� �������� ¦������ �� : " + sum);
		}
		while (num >= 0 ); //���ǿ��� ������ ���̳ʽ� ���� ������ �����Ѵ�
	}
}
