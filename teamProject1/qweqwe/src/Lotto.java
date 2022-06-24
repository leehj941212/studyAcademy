import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lotto extends JFrame implements ActionListener{
	private String id;
	private JFrame frame;
	private ArrayList<JButton> btList = new ArrayList<JButton>();
	private ArrayList<JLabel> lbList = new ArrayList<JLabel>();
	/*�� Ŭ������ ȣ���� JFrame ��ü�� �Ű����� �߰��� �޽��ϴ�.
	 * �� ������ ����� �ش� �������� �ٽ� ǥ���Ҷ� ����մϴ�.*/
	public Lotto(JFrame frame, String s) {
		this(s);
		this.frame = frame;
	}
	/*�� Ŭ������ �ܵ����� ����ɽ� ȸ�� ID���� �Ű������� �޽��ϴ�.*/
	public Lotto(String s) {
		super.setTitle("�ζ� ��ȣ ������");
		super.setLayout(null);
		super.setSize(370, 220);

		this.id = s;
		this.addUI();
		this.printLotto();
		super.getContentPane().setBackground(new Color(255,255,204));
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addLabel(int x, int y, int width, int height, String s) {
		JLabel lb = new JLabel(s);
		lb.setBounds(x, y, width, height);
		this.lbList.add(lb);
		super.add(lb);
	}
	public void addButton(int x, int y, int width, int height, String s) {
		JButton bt = new JButton(s);
		bt.setBounds(x, y, width, height);
		bt.addActionListener(this);
		bt.setBackground(new Color(255,255,255));
		this.btList.add(bt);
		super.add(bt);
	}
	/*�� ������Ʈ�� �̸��� ������� �� �̸��� �����մϴ�.*/
	public void changeLabelByName(String name, String alter) {
		for (JLabel lb : this.lbList) {
			if (lb.getText().equals(name)) {
				lb.setText(alter);
				break;
			}
		}
	}
	/*�� ������Ʈ�� �̸��� ����Ʈ�� �ε����� �������� ���� �ο��մϴ�.*/
	public void resetLabelName(){
		for (int i = 0; i < this.lbList.size(); i++) {
			this.lbList.get(i).setText("label" + i);
		}
	}
	/*�󺧰� ��ư�� Ư�� ��ġ�� �߰��մϴ�.*/
	public void addUI(){
		int x = 24, y = 24, width = 300, height = 32;
		this.addLabel(x, y * 1, width, height, "");
		this.addLabel(x, y * 2, width, height, "");
		this.addButton(x, y * 5, width / 3, height, "����÷");
		this.addButton((width / 3) * 2 + x, y * 5, width / 3, height, "�ݱ�");
	}
	/*������ GUI�� ����մϴ�.*/
	private void printLotto() {
		int n;
		String text;
		this.resetLabelName();

		text = String.format("%s�Կ��� ��õ�帮�� ������ �ζ� ��ȣ", this.id);
		this.changeLabelByName("label0", text);
		text = "";

		TreeSet<Integer> tree = new TreeSet<Integer>();
		while(tree.size() < 6) {
			tree.add((int)(Math.random() * 45 + 1));
		}
		Iterator<Integer> it = tree.iterator();
		while(it.hasNext()) {
			text += String.format("[%2d]", it.next());
		}
		this.changeLabelByName("label1", text);
	}
	/*��ư Ŭ���� �Ʒ��� ����� �����մϴ�.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "����÷":
			printLotto();
			break;
		case "�ݱ�":
			/*�� ������ ����� ȣ���ߴ� �������� �ٽ� ǥ���մϴ�.*/
			if (this.frame != null) {
				this.frame.setVisible(true);
			}
			this.dispose();
			break;
		}
	}
}