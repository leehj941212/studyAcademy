     /*class UsingMethodExam{
     Method�̸� :  methodExam03_01
     ReturnType : ����
     Parameter : ���� 1��
	(�����ο���)�ϴ� �� : 	methodExam03_01�� ȣ��Ǿ����ϴ�. ���
	                                �μ��� ���� ���� ��� 
	                               ����*2 ����. 
	 
	 Method�̸� :  methodExam03_02
     ReturnType : String
     Parameter : String 1��, ���� 1��
	 (�����ο���)�ϴ� �� : 		methodExam03_02�� ȣ��Ǿ����ϴ�. ���
		                                �μ��� ���� String �� �ٺ��� �ٿ��� ���
		                                 �μ��� ���� String �� �ٺ��� �ٿ��� ����
	
	 Method�̸� :  methodExam03_03
     ReturnType : ���Ͼ���
     Parameter : ���� 1���� String 1��
     (�����ο���)�ϴ� �� : 		methodExam03_03�� ȣ��Ǿ����ϴ�. ���	

     
     Method�̸� :  methodExam03_04
     ReturnType : �Ǽ�(�ε��Ҽ���)
     Parameter : ù��° �μ�(����),�ι�° �μ�(�Ǽ�), ����°�μ�(����)
	(�����ο���)�ϴ� �� : 		methodExam03_04�� ȣ��Ǿ����ϴ�. ���
	                                   �Ǽ��� ����

    } 
    */

class UsingMethodExam {

	int methodExam03_01(int num01){
		//Method�̸� :  methodExam03_01
        //ReturnType : ����
        //Parameter : ���� 1��
		System.out.println("methodExam03_01�� ȣ��Ǿ����ϴ�"); //methodExam03_01�� ȣ��Ǿ����ϴ�. ���
		System.out.println(num01); //�μ��� ���� ���� ���
		int num02 = num01*2;
		return num02; //����*2 ����.
	}

	String methodExam03_02(String txt01 , int num01){
		//Method�̸� :  methodExam03_02
        //ReturnType : String
        //Parameter : String 1��, ���� 1��
		System.out.println("methodExam03_02�� ȣ��Ǿ����ϴ�"); //methodExam03_02�� ȣ��Ǿ����ϴ�. ���
		String txt02 = txt01 + "�ٺ�"; 
		System.out.println(txt02); //�μ��� ���� String �� �ٺ��� �ٿ��� ���
		return txt02; //�μ��� ���� String �� �ٺ��� �ٿ��� ����
	}

	void methodExam03_03(int num01 , String txt01){
		//Method�̸� :  methodExam03_03
        //ReturnType : ���Ͼ���
        //Parameter : ���� 1���� String 1��
		System.out.println("methodExam03_03�� ȣ��Ǿ����ϴ�"); //methodExam03_03�� ȣ��Ǿ����ϴ�. ���
	}

	double methodExam03_04(int num01 , double num02 , int num03){
		//Method�̸� :  methodExam03_04
        //ReturnType : �Ǽ�(�ε��Ҽ���)
        //Parameter : ù��° �μ�(����),�ι�° �μ�(�Ǽ�), ����°�μ�(����)
		System.out.println("methodExam03_04�� ȣ��Ǿ����ϴ�"); //methodExam03_04�� ȣ��Ǿ����ϴ�. ���
		return num02; //�Ǽ��� ����
	}

	public static void main(String[] args) {
		UsingMethodExam exam = new UsingMethodExam(); 
		//UsingMethodExam Ŭ������ ���� exam�� ����
		int x = exam.methodExam03_01(10); 
		// methodExam03_01 �޼��忡 10 �̶�� ���ڸ� �־� ȣ���ϰ� ���ϰ��� x�� �ο�
		String y = exam.methodExam03_02("ȫ�浿" , 15); 
		//exam.methodExam03_02 �޼��忡 "ȫ�浿" , 15 �̶�� ���ڸ� �־� ȣ���ϰ� ���ϰ��� y�� �ο�
		exam.methodExam03_03(11 , "�ٳ���");
		//methodExam03_03 �޼��忡 11 , "�ٳ���" �̶�� ���ڸ� �־� ȣ��
		double z = exam.methodExam03_04(11 , 1.5 , 4);
		//exam.methodExam03_04 �޼��忡 11 , 1.5 , 4 �̶�� ���ڸ� �־� ȣ���ϰ� ���ϰ��� z�� �ο�
	}
}
