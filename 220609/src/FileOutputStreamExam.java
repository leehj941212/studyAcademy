import java.io.FileOutputStream;

public class FileOutputStreamExam {

	public static void main(String[] args) {
		FileOutputStream f = null;

		try {
			f= new FileOutputStream("studyIO.txt");
			String data = "java\nasdasd";
			byte b[] = data.getBytes();
			f.write(b);
			
			f= new FileOutputStream("studyI123.txt");
			String data2 = "java\nad";
			byte b2[] = data2.getBytes();
			f.write(b2);
			
			f= new FileOutputStream("studyI123123123123.txt");
			String data3 = "java\nad";
			byte b3[] = data3.getBytes();
			f.write(b2);
		} catch (Exception e) {
			System.out.println(e + " => 파일쓰기 실패");
		}finally {
			try {
				f.close();
			} catch (Exception e) {
				System.out.println(e + " => close 실패");
			}
		}

	}

}
