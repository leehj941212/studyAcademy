import java.util.Enumeration;
import java.util.Hashtable;

public class BoardBL extends Hashtable<String, BoardVO> {
	// 1) Hashtable 에 key 에 해당하는 value를 저장하는 메소드를 만든다.
	public void addBoard() {

		BoardVO post1 = new BoardVO();
		post1.setNum(22060701);
		post1.setWriter("철수");
		post1.setSubject("영어");
		post1.setContent("점수");

		BoardVO post2 = new BoardVO();
		post2.setNum(22060702);
		post2.setWriter("민수");
		post2.setSubject("수학");
		post2.setContent("공부");

		BoardVO post3 = new BoardVO();
		post3.setNum(22060703);
		post3.setWriter("영희");
		post3.setSubject("국어");
		post3.setContent("교과서");

		BoardVO post4 = new BoardVO();
		post4.setNum(22060704);
		post4.setWriter("바둑");
		post4.setSubject("과학");
		post4.setContent("실험");

		put("철수", post1);
		put("민수", post2);
		put("영희", post3);
		put("바둑", post4);
	}

	// 2) Hashtable 에 key 에 해당하는 value를 출력하는 메소드를 만든다.
	public void printBoard() {
		Enumeration<String> e = keys();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			BoardVO value = get(key);

			System.out.println("=====");
			System.out.println(value.getNum());
			System.out.println(value.getWriter());
			System.out.println(value.getSubject());
			System.out.println(value.getContent());
			System.out.println();

		}

	}

	public static void main(String[] args) {
		BoardBL board = new BoardBL();
		board.addBoard();
		board.printBoard();


	}

}
