//5���� �л��� ������ ó���ϴ� Ŭ������ �����Ͻÿ�
//�й�, �̸� , java , html , jsp ���� , �հ� , ��� �����͸� ó�� ��
//����� ���������� ����� ����Ͻÿ�

class StuDataName {
	int stuNum;
	String stuName;
	int javaScore;
	int htmlScore;
	int jspScore;	
	int scoreSum;
	int scoreAve;
}

public class StuScore {

	public static void main(String[] args) {
		StuDataName[] stuDataName = new StuDataName[5];
		for (int i = 0; i < stuDataName.length; i++) {
			stuDataName[i] = new StuDataName();	
		}
		
		stuDataName[0].stuNum = 220101;
		stuDataName[0].stuName = "ö��";
		stuDataName[0].javaScore = 1;
		stuDataName[0].htmlScore = 2;
		stuDataName[0].jspScore = 3;

		stuDataName[1].stuNum = 220102;
		stuDataName[1].stuName = "����";
		stuDataName[1].javaScore = 4;
		stuDataName[1].htmlScore = 5;
		stuDataName[1].jspScore = 6;

		stuDataName[2].stuNum = 220103;
		stuDataName[2].stuName = "�ٵ�";
		stuDataName[2].javaScore = 7;
		stuDataName[2].htmlScore = 8;
		stuDataName[2].jspScore = 9;

		stuDataName[3].stuNum = 220104;
		stuDataName[3].stuName = "�浿";
		stuDataName[3].javaScore = 10;
		stuDataName[3].htmlScore = 9;
		stuDataName[3].jspScore = 8;

		stuDataName[4].stuNum = 220105;
		stuDataName[4].stuName = "�μ�";
		stuDataName[4].javaScore = 7;
		stuDataName[4].htmlScore = 6;
		stuDataName[4].jspScore = 5;
		
		for (int i = 0; i < stuDataName.length; i++) {
			stuDataName[i].scoreSum = stuDataName[i].javaScore 
					+ stuDataName[i].htmlScore 
					+ stuDataName[i].jspScore;
			
			stuDataName[i].scoreAve = stuDataName[i].scoreSum / 3;
		}
		
		StuDataName stuData2 = new StuDataName();
		
		for (int i = 0; i < stuDataName.length; i++) {
			for (int j = i+1; j < stuDataName.length; j++) {
				if (stuDataName[i].scoreAve < stuDataName[j].scoreAve) {
					stuData2 = stuDataName[i];
					stuDataName[i] = stuDataName[j];
					stuDataName[j] = stuData2;
				}
			}
		}
		System.out.println("����� ���� �л���");
		
		for (int i = 0; i < stuDataName.length; i++) {
			System.out.print(stuDataName[i].stuName + " ");
			System.out.print(stuDataName[i].scoreAve + "��");
			System.out.println();
		}
		}
	}
