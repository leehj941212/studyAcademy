class ArrayOne
{
	public static void main(String[] args) 
	{
		int a , b , c , d , e ;
		int []f = new int[5]; // ���� ���ȣ�� ������ ����,���� ��� �־ ������� []f == f[]

		f[0] = 123;
		f[1] = 456;
		f[2] = 789;

		System.out.println(f[0] + f[1] );

		int i;
		for (i = 0 ; i <= 4 ; i++ ){ //i�� 0���� 4���� 1�� �����ϸ� �� 5�� �����Ѵ�
		System.out.println(f[i]);
		}

		//����� 5�� double�� �迭 ����
	    //������ ���� �����Ͽ� �迭 �� ���
		double []num = new double[5];
		num[0] = 1.1;
		num[1] = 2.2;
		num[2] = 3.3;
		num[3] = 4.4;
		num[4] = 5.5;

		for (int n = 0; n < 5 ; n++ ){ //n�� 0���� 4���� 1�� �����ϸ� �� 5�� �����Ѵ�
			System.out.println(num[n]);
		}

		//����� 5�� String�� �迭 ����
		//������ ���� �����Ͽ� �迭 �� ���
		String []txt = new String[5];
		txt[0] = "����";			
		txt[1] = "��";
		txt[2] = "����";
		txt[3] = "����";
		txt[4] = "����ġ";

		for ( int n = 0; n < 5 ; n++ ){ //n�� 0���� 4���� 1�� �����ϸ� �� 5�� �����Ѵ�
			System.out.println(txt[n]);
		}
	}
}
