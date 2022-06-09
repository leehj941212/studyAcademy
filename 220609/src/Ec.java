
//Exception 클래스를 상속받는다 (직접 예외 만들기)
class MyEx extends Exception {
	public MyEx() {
		System.out.println("error");
	}
}

class Score{
	private int score;
	//메소드 내용 전체를 try로 오류 확인을 하고 오류발생시 throw 이후에 정의된 예외가 실행된다
	public void setS(int j) throws MyEx {
		//변수 setter 생성 , j가 0보다 작거나 100보다 크면 MyEx();에 정의된 예외실행
		if (j<0 || j > 100) {
			throw new MyEx();
		}else {
			this.score = j;
		}
	}
}
public class Ec {
	public static void main(String[] args) {
		//객체 생성
		Score a = new Score();
		try {
			//a.setS(110) 일때 
			a.setS(110);
		} catch (Exception e) {
			System.out.println("오류");
		}

	}
}

