import java.awt.FileDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileDialogExam extends JFrame {
	FileDialog load = new FileDialog(this, "열기모드");
	FileDialog save = new FileDialog(this, "저장모드",FileDialog.SAVE);
	JFileChooser jf = new JFileChooser();
	
	public FileDialogExam() {
		super("FileDialogExam");
		load.setVisible(true);
		save.setVisible(true);
		
		jf.setDialogTitle("열기모드입니다");
		jf.showOpenDialog(this);
		jf.setDialogTitle("저장모드입니다");
		jf.showSaveDialog(this);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FileDialogExam();

	}

}
