import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener{
	private String id;
	private JFrame frame;
	private ArrayList<JButton> btList;
	private ArrayList<JLabel> lbList;
	/*�� Ŭ������ ȣ���� JFrame ��ü�� �Ű����� �߰��� �޽��ϴ�.
	 * �� ������ ����� �ش� �������� �ٽ� ǥ���Ҷ� ����մϴ�.*/
	public Menu(JFrame frame, String s) {
		this(s);
		this.setFrame(frame);
	}
	/*�� Ŭ������ �ܵ����� ����ɽ� ȸ�� ID���� �Ű������� �޽��ϴ�.*/
	public Menu(String s) {
		super.setTitle("�޴�");
		super.setLayout(null);
		super.setSize(370, 220);

		this.setId(s);
		this.setBtList(new ArrayList<JButton>());
		this.setLbList(new ArrayList<JLabel>());
		this.addUI();
		this.printMenu();
		super.getContentPane().setBackground(new Color(255,255,204));
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public ArrayList<JButton> getBtList() {
		return btList;
	}
	public void setBtList(ArrayList<JButton> btList) {
		this.btList = btList;
	}
	public ArrayList<JLabel> getLbList() {
		return lbList;
	}
	public void setLbList(ArrayList<JLabel> lbList) {
		this.lbList = lbList;
	}
	public void addLbList(JLabel lb) {
		this.lbList.add(lb);
	}
	public void addBtList(JButton bt) {
		this.btList.add(bt);
	}
	public void addLabel(int x, int y, int width, int height, String s) {
		JLabel lb = new JLabel(s);
		lb.setBounds(x, y, width, height);
		this.addLbList(lb);
		super.add(lb);
	}
	public void addButton(int x, int y, int width, int height, String s) {
		JButton bt = new JButton(s);
		bt.setBounds(x, y, width, height);
		bt.addActionListener(this);
		bt.setBackground(new Color(255,255,255));
		this.addBtList(bt);
		super.add(bt);
	}
	/*�� ������Ʈ�� �̸��� ������� �� �̸��� �����մϴ�.*/
	public void changeLabelByName(String name, String alter) {
		for (JLabel lb : this.getLbList()) {
			if (lb.getText().equals(name)) {
				lb.setText(alter);
				break;
			}
		}
	}
	/*��ư ������Ʈ�� �̸��� ������� ��ư �̸��� �����մϴ�.*/
	public void changeButtonByName(String name, String alter) {
		for (JButton bt : this.getBtList()) {
			if (bt.getText().equals(name)) {
				bt.setText(alter);
				break;
			}
		}
	}
	/*�� ������Ʈ�� �̸��� ����Ʈ�� �ε����� �������� ���� �ο��մϴ�.*/
	public void resetLabelName(){
		for (int i = 0; i < this.getLbList().size(); i++) {
			this.getLbList().get(i).setText("label" + i);
		}
	}
	/*��ư ������Ʈ�� �̸��� ����Ʈ�� �ε����� �������� ���� �ο��մϴ�.*/
	public void resetButtonName(){
		for (int i = 0; i < this.getBtList().size(); i++) {
			this.getBtList().get(i).setText("button" + i);
		}
	}
	/*�󺧰� ��ư�� Ư�� ��ġ�� �߰��մϴ�.*/
	public void addUI(){
		int x = 24, y = 24, width = 300, height = 32;
		this.addLabel(x, y * 1, width, height, "");
		this.addButton(x, y * 3, width / 3, height, "");
		this.addButton((width / 3) * 1 + x, y * 3, width / 3, height, "");
		this.addButton((width / 3) * 2 + x, y * 3, width / 3, height, "");
		this.addButton((width / 3) * 2 + x, y * 5, width / 3, height, "");
	}
	/*������ GUI�� ����մϴ�.*/
	private void printMenu() {
		int n;
		String text;
		this.resetLabelName();
		this.resetButtonName();

		text = String.format("�ȳ��ϼ���, %s��", this.getId());
		this.changeLabelByName("label0", text);
		text = "";
		for (int i = 0; i < 6; i++) {
			n = (int)(Math.random() * 45 + 1);
			text += String.format("[%2d]", n);
		}
		this.changeLabelByName("label1", text);
		this.changeButtonByName("button0", "��������");
		this.changeButtonByName("button1", "��������");
		this.changeButtonByName("button2", "�ζ���÷");
		this.changeButtonByName("button3", "�ݱ�");
	}
	/*��ư Ŭ���� �Ʒ��� ����� �����մϴ�.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "��������":
			this.setVisible(false);
			new EditScreen(frame, this, this.getId());
			break;
		case "��������":
			this.setVisible(false);
			new ScoreManager(this, this.getId());
			break;
		case "�ζ���÷":
			this.setVisible(false);
			new Lotto(this, this.getId());
			break;
		case "�ݱ�":
			/*�� ������ ����� ȣ���ߴ� �������� �ٽ� ǥ���մϴ�.*/
			if (this.getFrame() != null) {
				this.getFrame().setVisible(true);
			}
			this.dispose();
			break;
		}
	}
}
