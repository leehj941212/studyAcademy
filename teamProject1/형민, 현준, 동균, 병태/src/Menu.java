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
	/*본 클래스를 호출한 JFrame 객체를 매개변수 추가로 받습니다.
	 * 본 프레임 종료시 해당 프레임을 다시 표시할때 사용합니다.*/
	public Menu(JFrame frame, String s) {
		this(s);
		this.setFrame(frame);
	}
	/*본 클래스가 단독으로 실행될시 회원 ID만을 매개변수로 받습니다.*/
	public Menu(String s) {
		super.setTitle("메뉴");
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
	/*라벨 컴포넌트의 이름을 기반으로 라벨 이름을 변경합니다.*/
	public void changeLabelByName(String name, String alter) {
		for (JLabel lb : this.getLbList()) {
			if (lb.getText().equals(name)) {
				lb.setText(alter);
				break;
			}
		}
	}
	/*버튼 컴포넌트의 이름을 기반으로 버튼 이름을 변경합니다.*/
	public void changeButtonByName(String name, String alter) {
		for (JButton bt : this.getBtList()) {
			if (bt.getText().equals(name)) {
				bt.setText(alter);
				break;
			}
		}
	}
	/*라벨 컴포턴트의 이름을 리스트의 인덱스를 기준으로 임의 부여합니다.*/
	public void resetLabelName(){
		for (int i = 0; i < this.getLbList().size(); i++) {
			this.getLbList().get(i).setText("label" + i);
		}
	}
	/*버튼 컴포턴트의 이름을 리스트의 인덱스를 기준으로 임의 부여합니다.*/
	public void resetButtonName(){
		for (int i = 0; i < this.getBtList().size(); i++) {
			this.getBtList().get(i).setText("button" + i);
		}
	}
	/*라벨과 버튼을 특정 위치에 추가합니다.*/
	public void addUI(){
		int x = 24, y = 24, width = 300, height = 32;
		this.addLabel(x, y * 1, width, height, "");
		this.addButton(x, y * 3, width / 3, height, "");
		this.addButton((width / 3) * 1 + x, y * 3, width / 3, height, "");
		this.addButton((width / 3) * 2 + x, y * 3, width / 3, height, "");
		this.addButton((width / 3) * 2 + x, y * 5, width / 3, height, "");
	}
	/*정보를 GUI에 출력합니다.*/
	private void printMenu() {
		int n;
		String text;
		this.resetLabelName();
		this.resetButtonName();

		text = String.format("안녕하세요, %s님", this.getId());
		this.changeLabelByName("label0", text);
		text = "";
		for (int i = 0; i < 6; i++) {
			n = (int)(Math.random() * 45 + 1);
			text += String.format("[%2d]", n);
		}
		this.changeLabelByName("label1", text);
		this.changeButtonByName("button0", "정보수정");
		this.changeButtonByName("button1", "성적관리");
		this.changeButtonByName("button2", "로또추첨");
		this.changeButtonByName("button3", "닫기");
	}
	/*버튼 클릭시 아래의 기능이 동작합니다.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "정보수정":
			this.setVisible(false);
			new EditScreen(frame, this, this.getId());
			break;
		case "성적관리":
			this.setVisible(false);
			new ScoreManager(this, this.getId());
			break;
		case "로또추첨":
			this.setVisible(false);
			new Lotto(this, this.getId());
			break;
		case "닫기":
			/*본 프레임 종료시 호출했던 프레임을 다시 표시합니다.*/
			if (this.getFrame() != null) {
				this.getFrame().setVisible(true);
			}
			this.dispose();
			break;
		}
	}
}
