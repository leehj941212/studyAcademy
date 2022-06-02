import java.util.ArrayList;

//사이즈가 6 ArrayList 선언
//1~45 사이의 랜덤값 저장 -> 중복되지 않아야함.
//출력

public class Study7 {

	public static void main(String[] args) {
		//사이즈가 6 ArrayList 선언 (6 선언은 의미없음)
		ArrayList<Integer> arrayList = new ArrayList<Integer>(6);
		
		//0번째부터 5번째까지 6번 반복
		for (int i = 0; i < 6; i++) {
			arrayList.add((int)(Math.random()*45+1));
			//0번째부터 i-1까지 i번 반복 , i가 0일때는 실행x
			for (int j = 0; j < i; j++) {
				//i번째 값보다 전 순번의 값 중 같은 값이 있으면
				//i번째 값을 새로 받고 같은 값이 없을때까지 이 반복문을 반복한다
				if (arrayList.get(i) == arrayList.get(j)) {
					arrayList.set(i,(int)(Math.random()*45+1));
					j = -1;
				}
				
			}
		}
		
		System.out.println(arrayList);

	}

}
