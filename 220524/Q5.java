import java.util.Scanner; // Scanner�� ����ϱ� ���Ͽ� import �Ѵ�

class Q5 {
	public static void main(String[] args) {

		// �Է��� �������� ��� ����� �� ������ ǥ���ϴ� ���α׷�

		Scanner sc = new Scanner(System.in); // Ű�ε�� �Է°��� �Է� �� �� �ִ�
		int num = sc.nextInt(); // �Է°��� num �� �Ҵ� �ȴ� , ���ڸ� �ν�(���ڴ� ����)
		int yakSu = 0 , geSu = 0 ;

		System.out.print("�Է°� : " + num + "�� ��� : ");
		if ( num > 0){ // �Է°��� ����� �����Ҷ�(�ڿ����϶�)

				for (yakSu = num; yakSu >= 1; yakSu-- ){ //yakSu�� �Է°����� 1���� 1�� �پ��� �����Ѵ�
					if (num % yakSu == 0){ // �Է°��� yakSu�� �������� �������� 0�̸� ���
						geSu++;
						System.out.print(yakSu +" ");
					}
				}
        System.out.print(" (" + geSu + " ��)");
		} else { // �Է°��� ����� �������� ������(�ڿ����� �ƴҶ�)
			System.out.println("�����ϴ�");
		}
	}
}