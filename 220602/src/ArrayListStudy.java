import java.util.ArrayList;

public class ArrayListStudy {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>(5);
		arrList.add(123);
		arrList.add(456);
		
		System.out.println(arrList.get(0));
		System.out.println(arrList.get(1));
	}

}
