        //������ 5�� �迭 ����
		//�迭��� �� ���� (1~10������ ������)
		//����� ���� �Է�(Scanner)
		//�迭��ҿ� ��ġ�ϴ� ���� ������ ���°�� ��ġ�ϴ��� ���
		//������ ��ġ�ϴ� ���� ���ٰ� ���

import java.util.Scanner;

class Q25 {
	public static void main(String[] args) {
		int []txt = new int[5];
		int su = 0;

		for ( int n = 0 ; n < txt.length ; n++ ){
			txt[n] = (int)(Math.random()*10+1);
		}
		
		System.out.print("txt �迭�� �� : ");

		for ( int n = 0 ; n < txt.length ; n++ ){
			System.out.print(txt[n] + " ");
		}

		System.out.println();

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for ( int n = 0 ; n < txt.length ; n++ ){
			if ( num == txt[n]){
				System.out.println( (n+1) + "��° �� ��ġ �մϴ�" );
				su = 1;
			} 
		}

		if (su == 0){
			System.out.println("��ġ�ϴ� ���� �����ϴ�");
		}
	}
}
