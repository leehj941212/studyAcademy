class Q10 {
	public static void main(String[] args) {

		//1~100���� ����ϰ� �� ������ �ٽ� �Ųٷ�
		//100�������� 1���� ����� �ϴ� ���α׷��� �ۼ��Ѵ� =>while�� �ѹ��� ���

		int num = 1 , su = 1; // �ʱⰪ ����

		while ( num <= 100){ //1���� 100���� �� 100�� ����
			if (num <= 50){ //1���� 50������ �Ʒ� ������ ����Ѵ�
				System.out.println((num-1)*2 + 1);
				System.out.println((num-1)*2 + 2);

				num++;
			} else { //51���� 100������ �Ʒ� ������ ����Ѵ�
				System.out.println((num-su)*2);
				System.out.println((num-su)*2 - 1);

                su +=2;
				num ++;				
			}
		}		
	}
}