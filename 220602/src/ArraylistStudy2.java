import java.util.ArrayList;

public class ArraylistStudy2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(6);
		list.add("월요일");
		list.add("화요일");
		list.add("수요일");
		list.add("목요일");
		list.add("금요일");
		list.add("토요일");
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
	}

}
