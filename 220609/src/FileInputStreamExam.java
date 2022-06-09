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
			
			//1글자씩 파일이 끝나지 않을때동안 반복 , -1 은 EOF(end of file)를 뜻한다
			while (f.read(b) != -1) {}

			String data = new String(b);
			System.out.println(b);
			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println(e + " => 파일생성 실패");
		} catch (IOException e) {
			System.out.println(e + " => 파일읽기 실패");
		}finally {
			try {
				f.close();
			} catch (Exception e) {
				System.out.println(e + " => 닫기 실패");
			}

		}

	}

}
