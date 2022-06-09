import java.io.File;
import java.util.Date;

//IO를 할때는 꼭 Exception 처리 해야한다
public class FileExam {

	public static void main(String[] args) {
		//File 객체화
		File f = new File("studyIO.txt");
		//존재할때
		if (f.exists()) {
			System.out.println("존재합니다");
			//Directory 일때
			if (f.isDirectory()) {
				System.out.println("*** 폴더 정보 ***");
				//Directory 안에 있는 파일의 이름을 전부 출력한다
				String[] data = f.list();
				for (String s : data) {
					System.out.println(s);
				}
				//Directory 가 아닐때
			}else {
				System.out.println("*** 파일 정보 ***");
				System.out.println("파일 이름 :" + f.getName());
				System.out.println("절대 경로 :" + f.getAbsolutePath());
				System.out.println("읽기 기능 :" + f.canRead());
				System.out.println("쓰기 기능 :" + f.canWrite());
				System.out.println("파일 용량 :" + f.length()+"byte");

				//마지막 수정 날짜를 객체화
				long time = f.lastModified();
				//수정 날짜를 Date 형태로 바꾼다
				Date lastModifier = new Date(time);
				System.out.println("수정 날짜 :" + lastModifier);
				//File를 삭제
				f.delete();
			}
			//존재하지 않을때
		} else {
			System.out.println("없습니다");
			//Directory 생성
			f.mkdir();
		}

	}

}
