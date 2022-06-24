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
	/*본 클래스를 호출한 JFrame 객체를 매개변수 추가로 받습니다.
	 * 본 프레임 종료시 해당 프레임을 다시 표시할때 사용합니다.*/
	public Lotto(JFrame frame, String s) {
		this(s);
		this.frame = frame;
	}
	/*본 클래스가 단독으로 실행될시 회원 ID만을 매개변수로 받습니다.*/
	public Lotto(String s) {
		super.setTitle("로또 번호 생성기");
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
	/*라벨 컴포넌트의 이름을 기반으로 라벨 이름을 변경합니다.*/
	public void changeLabelByName(String name, String alter) {
		for (JLabel lb : this.lbList) {
			if (lb.getText().equals(name)) {
				lb.setText(alter);
				break;
			}
		}
	}
	/*라벨 컴포턴트의 이름을 리스트의 인덱스를 기준으로 임의 부여합니다.*/
	public void resetLabelName(){
		for (int i = 0; i < this.lbList.size(); i++) {
			this.lbList.get(i).setText("label" + i);
		}
	}
	/*라벨과 버튼을 특정 위치에 추가합니다.*/
	public void addUI(){
		int x = 24, y = 24, width = 300, height = 32;
		this.addLabel(x, y * 1, width, height, "");
		this.addLabel(x, y * 2, width, height, "");
		this.addButton(x, y * 5, width / 3, height, "재추첨");
		this.addButton((width / 3) * 2 + x, y * 5, width / 3, height, "닫기");
	}
	/*정보를 GUI에 출력합니다.*/
	private void printLotto() {
		int n;
		String text;
		this.resetLabelName();

		text = String.format("%s님에게 추천드리는 오늘의 로또 번호", this.id);
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
	/*버튼 클릭시 아래의 기능이 동작합니다.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "재추첨":
			printLotto();
			break;
		case "닫기":
			/*본 프레임 종료시 호출했던 프레임을 다시 표시합니다.*/
			if (this.frame != null) {
				this.frame.setVisible(true);
			}
			this.dispose();
			break;
		}
	}
}