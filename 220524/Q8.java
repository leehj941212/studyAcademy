import java.util.Scanner; // Scanner�� ����ϱ� ���Ͽ� import �Ѵ�

class Q8 {
	public static void main(String[] args) {

		//�ΰ��� ���ڸ� �Է¹޴�. ������� 3,5�� �Է¹ް� �Ǹ� 3���� 5������ �հ踦 ���� ���
		//��, ������ �Է��ϰų� �Ǵ� 5,3 �Է��� �ǰų�
		//1~9 ���� ������ �Ѿ�� ��� ���ڸ� �ٽ� �Է¹޾� ó��

		Scanner sc = new Scanner(System.in); // Ű�ε�� �Է°��� �Է� �� �� �ִ�
		int num1 = sc.nextInt(); // �Է°��� num �� �Ҵ� �ȴ� , ���ڸ� �ν�(���ڴ� ����)
		int num2 = sc.nextInt(); // 2��° �Է°��� �޴´�
		int sum = 0; // �հ� �ʱⰪ ����

		for (num1 = num1 ;
		num1 < 0 || num2 < 0 || num2 - num1 <0 || num1 > 9 || num2 >9 ; 
		num1 = sc.nextInt() , num2 = sc.nextInt() ){
			//�Է°�1,�Է°�2�� 0���� �۰ų� 9���� ũ�ų� �Է°�1�� �Է°�2���� ũ�� �ٽ� �Է¹޴´�
			System.out.println("�ٽ� �Է��ϼ���");
		}

		for (num1 = num1 ; num1 <= num2 ; num1++){ //�Է°�1�� 1�� �����Ͽ� �Է°�2�� �������������� �����Ѵ�
			sum = sum + num1;
		}

		System.out.println(sum);
	}
}
