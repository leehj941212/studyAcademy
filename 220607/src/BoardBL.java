import java.util.Enumeration;
import java.util.Hashtable;

public class BoardBL extends Hashtable<String, BoardVO> {
	// 1) Hashtable �� key �� �ش��ϴ� value�� �����ϴ� �޼ҵ带 �����.
	public void addBoard() {

		BoardVO post1 = new BoardVO();
		post1.setNum(22060701);
		post1.setWriter("ö��");
		post1.setSubject("����");
		post1.setContent("����");

		BoardVO post2 = new BoardVO();
		post2.setNum(22060702);
		post2.setWriter("�μ�");
		post2.setSubject("����");
		post2.setContent("����");

		BoardVO post3 = new BoardVO();
		post3.setNum(22060703);
		post3.setWriter("����");
		post3.setSubject("����");
		post3.setContent("������");

		BoardVO post4 = new BoardVO();
		post4.setNum(22060704);
		post4.setWriter("�ٵ�");
		post4.setSubject("����");
		post4.setContent("����");

		put("ö��", post1);
		put("�μ�", post2);
		put("����", post3);
		put("�ٵ�", post4);
	}

	// 2) Hashtable �� key �� �ش��ϴ� value�� ����ϴ� �޼ҵ带 �����.
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
