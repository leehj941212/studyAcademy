
//Exception Ŭ������ ��ӹ޴´� (���� ���� �����)
class MyEx extends Exception {
	public MyEx() {
		System.out.println("error");
	}
}

class Score{
	private int score;
	//�޼ҵ� ���� ��ü�� try�� ���� Ȯ���� �ϰ� �����߻��� throw ���Ŀ� ���ǵ� ���ܰ� ����ȴ�
	public void setS(int j) throws MyEx {
		//���� setter ���� , j�� 0���� �۰ų� 100���� ũ�� MyEx();�� ���ǵ� ���ܽ���
		if (j<0 || j > 100) {
			throw new MyEx();
		}else {
			this.score = j;
		}
	}
}
public class Ec {
	public static void main(String[] args) {
		//��ü ����
		Score a = new Score();
		try {
			//a.setS(110) �϶� 
			a.setS(110);
		} catch (Exception e) {
			System.out.println("����");
		}

	}
}

