class ConstructorStudyTwo{
	int a;
	ConstructorStudyTwo(int b){ 
		// ������ , Ŭ������� ���� , �Ű������� ���� �� �ִ� ,returnType �� ����
		System.out.println("Ŭ���� �޼ҵ�");
	}
	String m(){
		System.out.println("�޼ҵ�");
		return "java";
	}
}

public class  ConstructorStudyOne{
	public static void main(String[] args) {
		ConstructorStudyTwo  constructorStudyTwo = new ConstructorStudyTwo(789);
		// ��ü ������ �ڵ� ȣ��
		// constructorStudyTwo.ConstructorStudyTwo(); ������ ���� ȣ���� �Ұ�
		constructorStudyTwo.a = 123;
		String str = constructorStudyTwo.m();
	}
}
