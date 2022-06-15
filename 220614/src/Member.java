
public class Member {
	String id , pw , addres , email;
	int[] jumsu = new int[3]; 
	
	public Member(String id, String pw, String addres, String email, int[] jumsu) {
		super();
		this.id = id;
		this.pw = pw;
		this.addres = addres;
		this.email = email;
		this.jumsu = jumsu;
	}
	
	public int[] getJumsu() {
		return jumsu;
	}

	public void setJumsu(int[] jumsu) {
		this.jumsu = jumsu;
	}
	
	public void result() {
		System.out.println("--학생의 정보--");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("addres : " + addres);
		System.out.println("email : " + email);
		System.out.print("성적1 : " + jumsu[0] +"점");
		System.out.print(" , 성적2 : " + jumsu[1] +"점");
		System.out.println(" , 성적3 : " + jumsu[2] +"점");
		System.out.println("성적 총점 : " + (jumsu[0] + jumsu[1] + jumsu[2]) +"점");
		System.out.println("성적 평균 : " + (jumsu[0] + jumsu[1] + jumsu[2])/3 +"점");
	}
	
	public static void main(String[] args) {
		int[] x = {3 ,5 ,10};
		Member member = new Member("qwer", "1234", "마포구 상수동", "jihogu@naver.com" , x);
		member.result();
		
	}
}
