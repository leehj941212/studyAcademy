import java.awt.FileDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileDialogExam extends JFrame {
	FileDialog load = new FileDialog(this, "������");
	FileDialog save = new FileDialog(this, "������",FileDialog.SAVE);
	JFileChooser jf = new JFileChooser();
	
	public FileDialogExam() {
		super("FileDialogExam");
		load.setVisible(true);
		save.setVisible(true);
		
		jf.setDialogTitle("�������Դϴ�");
		jf.showOpenDialog(this);
		jf.setDialogTitle("�������Դϴ�");
		jf.showSaveDialog(this);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FileDialogExam();

	}

}
