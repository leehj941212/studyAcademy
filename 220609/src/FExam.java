import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FExam {

	public static void main(String[] args) {
		String fileName = JOptionPane.showInputDialog("������ ���� �̸�������");
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try {
			fi = new FileInputStream("studyIO.txt");
			fo = new FileOutputStream(fileName);
			
			int i = 0;
			while ((i=fi.read()) != -1) {
				fo.write(i);
			}
			System.out.println(fileName + "���� �Ϸ�");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				fi.close();
				fo.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
