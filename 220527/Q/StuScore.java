//5명의 학생의 성적을 처리하는 클래스를 생성하시오
//학번, 이름 , java , html , jsp 성적 , 합계 , 평균 데이터를 처리 후
//평균이 높은순으로 결과를 출력하시오

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
		stuDataName[0].stuName = "철수";
		stuDataName[0].javaScore = 1;
		stuDataName[0].htmlScore = 2;
		stuDataName[0].jspScore = 3;

		stuDataName[1].stuNum = 220102;
		stuDataName[1].stuName = "영희";
		stuDataName[1].javaScore = 4;
		stuDataName[1].htmlScore = 5;
		stuDataName[1].jspScore = 6;

		stuDataName[2].stuNum = 220103;
		stuDataName[2].stuName = "바둑";
		stuDataName[2].javaScore = 7;
		stuDataName[2].htmlScore = 8;
		stuDataName[2].jspScore = 9;

		stuDataName[3].stuNum = 220104;
		stuDataName[3].stuName = "길동";
		stuDataName[3].javaScore = 10;
		stuDataName[3].htmlScore = 9;
		stuDataName[3].jspScore = 8;

		stuDataName[4].stuNum = 220105;
		stuDataName[4].stuName = "민수";
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
		System.out.println("평균이 높은 학생순");
		
		for (int i = 0; i < stuDataName.length; i++) {
			System.out.print(stuDataName[i].stuName + " ");
			System.out.print(stuDataName[i].scoreAve + "점");
			System.out.println();
		}
		}
	}
