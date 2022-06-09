import java.io.FileOutputStream;

public class FileOutputStreamExam {

	public static void main(String[] args) {
		FileOutputStream f = null;

		try {
			f= new FileOutputStream("studyIO.txt");
			String data = "java\nasdasd";
			byte b[] = data.getBytes();
			f.write(b);
		} catch (Exception e) {
			System.out.println(e + " => ���Ͼ��� ����");
		}finally {
			try {
				f.close();
			} catch (Exception e) {
				System.out.println(e + " => close ����");
			}
		}

	}

}
