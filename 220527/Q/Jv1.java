class Box{
	int width;
	int height;
	int depth;
}

class Jv1 {
	public static void main(String[] args) {

		Box box1 = new Box();
		Box box2 = new Box();
		int volume1 , volume2;

		box1.width = 50;
		box1.height = 40;
		box1.depth = 30;

		box2.width = 60;
		box2.height = 70;
		box2.depth = 80;

		System.out.println("*** ��ü�� ���� �� ���� ***");
		volume1 = box1.width * box1.height * box1.depth;
		System.out.print("ù��° ������ ����: " + volume1);
		System.out.println(" = " + box1.width + "*" + box1.height + "*" + box1.depth);

		volume2 = box2.width * box2.height * box2.depth;
		System.out.print("�ι�° ������ ����: " + volume2);
		System.out.println(" = " + box2.width + "*" + box2.height + "*" + box2.depth);
	}
}
