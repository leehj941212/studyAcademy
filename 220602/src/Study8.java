import java.util.ArrayList;

//사이즈가 6 ArrayList 선언
//1~45 사이의 랜덤값 저장 -> 중복되지 않아야함.
//출력

public class Study8 {

	public static void main(String[] args) {
		//사이즈가 6 ArrayList 선언 (6 선언은 의미없음)
		ArrayList<Integer> arrayList = new ArrayList<Integer>(6);
		
		//사이즈가 45 ArrayList2 선언 (45 선언은 의미없음)
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(45);
		//ArrayList2 의 i번째는 i라는 값을 가진다
		for (int i = 1; i < 46; i++) {
			arrayList2.add(i);
		}
		
		//i 가 0부터 5까지 6번 반복
		for (int i = 0; i < 6; i++) {
			int a = (int)(Math.random()*arrayList2.size());
			//arrayList2의 값중 랜덤으로 값을 받는다
			arrayList.add(arrayList2.get(a));
			//arrayList에 포함된 값은 arrayList2 에서 제외한다
			arrayList2.remove(a);

		}
		
		System.out.println(arrayList);
	}

}
