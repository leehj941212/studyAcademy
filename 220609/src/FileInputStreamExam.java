import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExam {

	public static void main(String[] args) {
		FileInputStream f = null;

		try {
			f = new FileInputStream("studyIO.txt");
			System.out.println("available = " + f.available());
			byte b[] = new byte[f.available()];
			
			//1���ھ� ������ ������ ���������� �ݺ� , -1 �� EOF(end of file)�� ���Ѵ�
			while (f.read(b) != -1) {}

			String data = new String(b);
			System.out.println(b);
			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println(e + " => ���ϻ��� ����");
		} catch (IOException e) {
			System.out.println(e + " => �����б� ����");
		}finally {
			try {
				f.close();
			} catch (Exception e) {
				System.out.println(e + " => �ݱ� ����");
			}

		}

	}

}
