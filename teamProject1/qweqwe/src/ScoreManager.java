import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ScoreManager extends JFrame implements ActionListener{
	private String id, path, fileName;
	private ArrayList<Integer> list;
	private ArrayList<JButton> btList;
	private ArrayList<JLabel> lbList;
	private JFrame frame;
	/*본 클래스를 호출한 JFrame 객체를 매개변수 추가로 받습니다.
	 * 본 프레임 종료시 해당 프레임을 다시 표시할때 사용합니다.*/
	public ScoreManager(JFrame frame, String s){
		this(s);
		this.setFrame(frame);
	}
	/*본 클래스가 단독으로 실행될시 회원 ID만을 매개변수로 받습니다.*/
	public ScoreManager(String s){
		super.setTitle("성적 관리");
		super.setLayout(null);
		super.setSize(370, 220);
		super.getContentPane().setBackground(new Color(255,255,204));
		this.setId(s);
		this.setPath("UserData");
		this.setFileName("Score.txt");
		this.setBtList(new ArrayList<JButton>());
		this.setLbList(new ArrayList<JLabel>());
		this.readData();
		this.addUI();
		this.printRank();

		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	public void addList(int i) {
		if (i >= 0) {
			this.list.add(i);
		}
	}
	public ArrayList<JButton> getBtList() {
		return btList;
	}
	public void setBtList(ArrayList<JButton> btList) {
		this.btList = btList;
	}
	public void addBtList(JButton bt) {
		this.btList.add(bt);
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
	/*정수 리스트를 생성하고 전체 학생의 성적 정보를 취득하여 추가합니다.*/
	public void readData() {
		this.setList(new ArrayList<Integer>());
		File f = null;
		try {
			f = new File(this.getPath());
			String[] data = f.list();
			for(String s : data) {
				addList(this.readScore(s));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/*특정 ID의 학생의 성적 정보를 취득합니다.*/
	public int readScore(String file) {
		/*해당 학생의 성적 정보가 없는 경우 -1을 반환합니다.*/
		int data = -1;
		String fileName = String.format("%s/%s/%s", this.getPath(), file, this.getFileName());
		File f = null;
		try {
			f = new File(fileName);
			if (f.exists()) {
				FileInputStream fi = null;
				try {
					fi = new FileInputStream(fileName);
					byte b[] = new byte [ fi.available()];
					while(fi.read(b)!=-1) {}
					data = Integer.parseInt(new String(b));
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					try {
						fi.close();
					} catch (IOException e){
						System.out.println(e);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}
	/*특정 ID의 학생의 성적 정보 파일을 생성합니다.*/
	public void writeScore(String id, String score) {
		String fileName = String.format("%s/%s/%s", this.getPath(), id, this.getFileName());
		File f = null;
		try {
			f = new File(fileName);
			if (f.exists()) {
				f.delete();
			}
			FileOutputStream fo = null;
			try {
				fo = new FileOutputStream(fileName);
				byte[] b = score.getBytes();
				fo.write(b);
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					fo.close();
				} catch (IOException e){
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		this.readData();
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
		this.addLabel(x, y * 2, width, height, "");
		this.addLabel(x, y * 3, width, height, "");
		this.addButton(x, y * 5, width / 3, height, "");
		this.addButton((width / 3) * 2 + x, y * 5, width / 3, height, "");
	}
	/*읽어들인 정보를 GUI에 출력합니다.*/
	public void printRank() {
		String text = "";
		double sum = 0, avg = 0;
		this.resetLabelName();
		this.resetButtonName();
		text = String.format("현재 성적을 등록한 학생은 총 %d명입니다.",this.getList().size());
		this.changeLabelByName("label0", text);
		Collections.sort(this.getList(), Collections.reverseOrder());
		for (int i : this.getList()) {
			sum += i;
		}
		if (this.readScore(this.getId()) == -1) {
			text = String.format("%s님의 성적 정보가 등록되어있지 않습니다.", this.getId());
			this.changeLabelByName("label1", text);
			this.changeButtonByName("button0", "성적등록");
		} else {
			for (int i = 0; i < this.getList().size(); i++) {
				if (this.readScore(this.getId()) == this.getList().get(i)) {
					text = String.format("%s님의 성적은 %d위 입니다.", this.getId(), i+1);
					this.changeLabelByName("label1", text);
					break;
				}
			}
			this.changeButtonByName("button0", "성적수정");
		}
		if (this.getList().size() > 0) {
			avg = sum / this.getList().size();
			text = String.format("성적을 등록한 학생들의 평균 성적은 %1.1f점 입니다.",avg);
		} else {
			text = "성적을 등록한 학생이 없습니다.";
		}
		this.changeLabelByName("label2", text);
		this.changeButtonByName("button1", "닫기");
	}
	/*버튼 클릭시 아래의 기능이 동작합니다.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		int score = 0;
		String scoreStr = "";
		switch(e.getActionCommand()) {
		case "성적등록":
			scoreStr = JOptionPane.showInputDialog("성적을 입력하세요.");
			try {
				score = Integer.parseInt(scoreStr);
				this.writeScore(this.getId(), scoreStr);
				this.printRank();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
			}
			break;
		case "성적수정":
			scoreStr = JOptionPane.showInputDialog("성적을 입력하세요.", this.readScore(this.getId()));
			try {
				score = Integer.parseInt(scoreStr);
				this.writeScore(this.getId(), scoreStr);
				this.printRank();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
			}
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