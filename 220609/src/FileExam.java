import java.io.File;
import java.util.Date;

//IO�� �Ҷ��� �� Exception ó�� �ؾ��Ѵ�
public class FileExam {

	public static void main(String[] args) {
		//File ��üȭ
		File f = new File("studyIO.txt");
		//�����Ҷ�
		if (f.exists()) {
			System.out.println("�����մϴ�");
			//Directory �϶�
			if (f.isDirectory()) {
				System.out.println("*** ���� ���� ***");
				//Directory �ȿ� �ִ� ������ �̸��� ���� ����Ѵ�
				String[] data = f.list();
				for (String s : data) {
					System.out.println(s);
				}
				//Directory �� �ƴҶ�
			}else {
				System.out.println("*** ���� ���� ***");
				System.out.println("���� �̸� :" + f.getName());
				System.out.println("���� ��� :" + f.getAbsolutePath());
				System.out.println("�б� ��� :" + f.canRead());
				System.out.println("���� ��� :" + f.canWrite());
				System.out.println("���� �뷮 :" + f.length()+"byte");

				//������ ���� ��¥�� ��üȭ
				long time = f.lastModified();
				//���� ��¥�� Date ���·� �ٲ۴�
				Date lastModifier = new Date(time);
				System.out.println("���� ��¥ :" + lastModifier);
				//File�� ����
				f.delete();
			}
			//�������� ������
		} else {
			System.out.println("�����ϴ�");
			//Directory ����
			f.mkdir();
		}

	}

}
