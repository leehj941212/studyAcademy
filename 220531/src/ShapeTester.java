abstract class ShapeExam { //abstract 메서드를 1개 이상 가지고 있다
	abstract void draw();
}

//abstract클래스를 상속받아 override 해야함
class PointExam extends ShapeExam { 
	
	public PointExam() {
		//super();
	}
	@Override
	void draw() {
		System.out.println('+');
	}
	
}

//abstract클래스를 상속받아 override 해야함
class RectangleExam extends ShapeExam {
	private int width;
	private int height;
	
	public RectangleExam(int width, int height) {
		//super();
		this.width = width;
		this.height = height;
	}

	@Override
	void draw() {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				System.out.println('*');
			}	
				System.out.println();	
		}
		
	}
	
}

public class ShapeTester {

	public static void main(String[] args) {
		//객체 배열 a 생성 (자리수2)
		ShapeExam[] a = new ShapeExam[2];
		//PointExam(); 객체화
		a[0] = new PointExam();
		//RectangleExam(4, 3); 객체화
		//width = 4 , height = 3
		a[1] = new RectangleExam(4, 3);
		
		//a[0].draw(); << + 출력
		//a[1].draw();
//		{
//			for (int i = 1; i <= 3; i++) { //3번 반복
//				for (int j = 1; j <= 4; j++) { //4번 반복
//					System.out.println('*');
//				}	
//					System.out.println();	
//			}
//			
//		}
		//배열의 자리수만큼 반복한다
		for (ShapeExam s : a) {
		s.draw();
		System.out.println();
		}
		
//		int[] arr = new int[5];
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		for (int value : arr) {
//			System.out.println(value);
//		}
	}

}
