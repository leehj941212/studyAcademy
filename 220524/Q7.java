import java.util.Scanner; // Scanner�� ����ϱ� ���Ͽ� import �Ѵ�

class Q7 {
	public static void main(String[] args) {

		//���� ���������� �Է¹޾�
		//���� ������ ǥ���ϴ� ���α׷��� �ۼ�
		//3,4,5 -> ��
		//6,7,8 -> ����
		//9,10,11 -> ����
		//12,1,2 - > �ܿ�
		//���� 1~12 �̿��� ���� �Էµ� ��쿡�� ���Է� �ϵ��� �Ұ�

		Scanner sc = new Scanner(System.in); // Ű�ε�� �Է°��� �Է� �� �� �ִ�
		int num = sc.nextInt(); // �Է°��� num �� �Ҵ� �ȴ� , ���ڸ� �ν�(���ڴ� ����)
		
		for (num = num ; num < 1 || num > 12; num = sc.nextInt() ){ 
			//�Է°��� 1���� �۰ų� 12���� ũ�� �ٽ� �Է¹޴´�
			System.out.println("�ٽ� �Է��ϼ���");
		}

		switch (num){
			
		case 3: case 4: case 5: System.out.println("��"); break ; //�Է°��� 3,4,5 �϶�
		case 6: case 7: case 8: System.out.println("����"); break ; //�Է°��� 6,7,8 �϶�
		case 9: case 10: case 11: System.out.println("����"); break ; //�Է°��� 9,10,11 �϶�
		case 12: case 1: case 2: System.out.println("�ܿ�"); break ; //�Է°��� 12,1,2 �϶�
		//1~12 ���� �Է°��� for���� Ȯ���߱⶧���� default�� ������� ����
		}
	}
}
