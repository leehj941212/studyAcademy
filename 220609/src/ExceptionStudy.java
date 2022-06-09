
public class ExceptionStudy {
	
	void m() throws Exception {
		//code
	}

	public static void main(String[] args) {
		ExceptionStudy exceptionStudy = new ExceptionStudy();
		try {
			exceptionStudy.m();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		int[] arr = new int[3];
		
		int su = (int)(Math.random()*3);
		if (su == 1) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println("숫자 = " + su);
			}		
		}

		try {
			
//			int i = 10;
//			System.out.println(i/0);
//			System.out.println(i/2);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("출력");
		}

	}

}
