		//����� 10�� �迭 ����
		//�迭��� �� ����(1~100������ ������)
		//��� �迭 �� ���

class Q21 
{
	public static void main(String[] args) 
	{
		int []txt = new int [10]; //txt �迭�� 10���� ���� ������
		for ( int n = 0; n < txt.length ; n++ ){ //n�� 0���� 9���� 10�� �ݺ��Ѵ�
			txt[n] = (int)(Math.random()*100+1);
				System.out.println("txt[" + n + "]�� �� : " + txt[n]);
		}
	}
}
