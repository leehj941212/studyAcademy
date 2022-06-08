import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PopMenuExam extends Frame {
	PopupMenu pm = new PopupMenu();
	MenuItem pm_item1 = new MenuItem("전체선택");
	MenuItem pm_item2 = new MenuItem("복사하기");
	MenuItem pm_item3 = new MenuItem("잘라내기");
	MenuItem pm_item4 = new MenuItem("붙여넣기");

	PopMenuExam(){
		super("팝업메뉴 만들기");
		pm.add(pm_item1);
		pm.addSeparator();
		pm.add(pm_item2);
		pm.add(pm_item3);
		pm.add(pm_item4);

		add(pm);
		setSize(200,400);
		setVisible(true);

		this.addWindowListener(new WindowListener(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}		
		});

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3)
					pm.show(PopMenuExam.this, e.getX(), e.getY());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
	public static void main(String[] args) {
		new PopMenuExam();

	}

}
