interface Sung_1 { //interface
	void sethakbun(String hakbun); 
	void setname(String name);
	//메소드는 형태만 가진다
}
interface Sung_2 { //interface
	void setjumsu(int jumsu);
	//메소드는 형태만 가진다
}
interface Sung extends Sung_1 , Sung_2 {
	//interface 는 여러개를 받아올 수 있다
	void title();
	void prt_data();
	//메소드는 형태만 가진다
}
class Sungjuk implements Sung { // interface를 받아온다
	String hakbun = " ";
	String name = " ";
	int jumsu = 0;
	//변수 선언
	
	//받아온 interface의 메소드는 전부 Override 한다
	@Override
	public void title() {
		System.out.println("*** 인터페이스(interface) 사용 ***");
		System.out.println("*** 자바의 성적 출력 ***");
		System.out.println("**학번** **성명** **점수**");
	}
	@Override
	public void sethakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	@Override
	public void setname(String name) {
		this.name = name;
	}
	@Override
	public void setjumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	@Override
	public void prt_data() {
		System.out.println(hakbun + " " + name + " " + jumsu);
	}
}

public class Jv extends Sungjuk {

	public static void main(String[] args) {
		Sungjuk ken = new Sungjuk();
		//Sungjuk 클래스를 객체 선언
		ken.sethakbun("2060001");
		//Sungjuk.hakbun = 2060001;
		ken.setname("Nam");
		//Sungjuk.name = "Nam";
		ken.setjumsu(80);
		//Sungjuk.jumsu = 80;
		ken.title();
		ken.prt_data();
//		sung.prt_data(); <<interface는 객체화 할 수 없다
	}

}
