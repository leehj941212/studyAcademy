import java.util.ArrayList;

class BBBB{
	protected ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(int i) {
		this.list.add(i);
	}
}

public class AAAA {
	BBBB bbbb = new BBBB();

	void abc() {
		
		bbbb.setList(2);
		bbbb.setList(5);
	}
	
	void zxc() {
		System.out.println(bbbb.getList());
	}

	public static void main(String[] args) {
		AAAA aaaa= new AAAA();	
		aaaa.abc();
		aaaa.zxc();
	}

}
