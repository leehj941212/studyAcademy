abstract class ShapeExam { //abstract �޼��带 1�� �̻� ������ �ִ�
	abstract void draw();
}

//abstractŬ������ ��ӹ޾� override �ؾ���
class PointExam extends ShapeExam { 
	
	public PointExam() {
		//super();
	}
	@Override
	void draw() {
		System.out.println('+');
	}
	
}

//abstractŬ������ ��ӹ޾� override �ؾ���
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
		//��ü �迭 a ���� (�ڸ���2)
		ShapeExam[] a = new ShapeExam[2];
		//PointExam(); ��üȭ
		a[0] = new PointExam();
		//RectangleExam(4, 3); ��üȭ
		//width = 4 , height = 3
		a[1] = new RectangleExam(4, 3);
		
		//a[0].draw(); << + ���
		//a[1].draw();
//		{
//			for (int i = 1; i <= 3; i++) { //3�� �ݺ�
//				for (int j = 1; j <= 4; j++) { //4�� �ݺ�
//					System.out.println('*');
//				}	
//					System.out.println();	
//			}
//			
//		}
		//�迭�� �ڸ�����ŭ �ݺ��Ѵ�
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
