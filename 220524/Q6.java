import java.util.Scanner; // Scanner�� ����ϱ� ���Ͽ� import �Ѵ�

class Q6{
	public static void main(String[] args) {

		//2���� �������� �Է¹޾� ���ڰ� ������ ����̸�
		//"���"��� ǥ���ϰ� �ƴϸ� "����ƴ�"�̶�� ǥ���Ѵ�

		Scanner sc = new Scanner(System.in); // Ű�ε�� �Է°��� �Է� �� �� �ִ�
		int num1 = sc.nextInt(); // �Է°��� num �� �Ҵ� �ȴ� , ���ڸ� �ν�(���ڴ� ����)
		int num2 = sc.nextInt(); // 2��° �Է°��� �޴´�

		System.out.print(num2 + "�� " + num1 + "�� ");


		if (num1%num2 ==0){ //num2�� num1�� ��� �϶�
		
			System.out.println("���");
		} else { //num2�� num1�� ����� �ƴҶ�
			System.out.println("����ƴ�");
		}
	}
}
