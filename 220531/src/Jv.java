interface Sung_1 { //interface
	void sethakbun(String hakbun); 
	void setname(String name);
	//�޼ҵ�� ���¸� ������
}
interface Sung_2 { //interface
	void setjumsu(int jumsu);
	//�޼ҵ�� ���¸� ������
}
interface Sung extends Sung_1 , Sung_2 {
	//interface �� �������� �޾ƿ� �� �ִ�
	void title();
	void prt_data();
	//�޼ҵ�� ���¸� ������
}
class Sungjuk implements Sung { // interface�� �޾ƿ´�
	String hakbun = " ";
	String name = " ";
	int jumsu = 0;
	//���� ����
	
	//�޾ƿ� interface�� �޼ҵ�� ���� Override �Ѵ�
	@Override
	public void title() {
		System.out.println("*** �������̽�(interface) ��� ***");
		System.out.println("*** �ڹ��� ���� ��� ***");
		System.out.println("**�й�** **����** **����**");
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
		//Sungjuk Ŭ������ ��ü ����
		ken.sethakbun("2060001");
		//Sungjuk.hakbun = 2060001;
		ken.setname("Nam");
		//Sungjuk.name = "Nam";
		ken.setjumsu(80);
		//Sungjuk.jumsu = 80;
		ken.title();
		ken.prt_data();
//		sung.prt_data(); <<interface�� ��üȭ �� �� ����
	}

}
