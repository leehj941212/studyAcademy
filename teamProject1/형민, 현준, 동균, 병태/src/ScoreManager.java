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
	/*�� Ŭ������ ȣ���� JFrame ��ü�� �Ű����� �߰��� �޽��ϴ�.
	 * �� ������ ����� �ش� �������� �ٽ� ǥ���Ҷ� ����մϴ�.*/
	public ScoreManager(JFrame frame, String s){
		this(s);
		this.setFrame(frame);
	}
	/*�� Ŭ������ �ܵ����� ����ɽ� ȸ�� ID���� �Ű������� �޽��ϴ�.*/
	public ScoreManager(String s){
		super.setTitle("���� ����");
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
	/*���� ����Ʈ�� �����ϰ� ��ü �л��� ���� ������ ����Ͽ� �߰��մϴ�.*/
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
	/*Ư�� ID�� �л��� ���� ������ ����մϴ�.*/
	public int readScore(String file) {
		/*�ش� �л��� ���� ������ ���� ��� -1�� ��ȯ�մϴ�.*/
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
	/*Ư�� ID�� �л��� ���� ���� ������ �����մϴ�.*/
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
		this.addLabel(x, y * 2, width, height, "");
		this.addLabel(x, y * 3, width, height, "");
		this.addButton(x, y * 5, width / 3, height, "");
		this.addButton((width / 3) * 2 + x, y * 5, width / 3, height, "");
	}
	/*�о���� ������ GUI�� ����մϴ�.*/
	public void printRank() {
		String text = "";
		double sum = 0, avg = 0;
		this.resetLabelName();
		this.resetButtonName();
		text = String.format("���� ������ ����� �л��� �� %d���Դϴ�.",this.getList().size());
		this.changeLabelByName("label0", text);
		Collections.sort(this.getList(), Collections.reverseOrder());
		for (int i : this.getList()) {
			sum += i;
		}
		if (this.readScore(this.getId()) == -1) {
			text = String.format("%s���� ���� ������ ��ϵǾ����� �ʽ��ϴ�.", this.getId());
			this.changeLabelByName("label1", text);
			this.changeButtonByName("button0", "�������");
		} else {
			for (int i = 0; i < this.getList().size(); i++) {
				if (this.readScore(this.getId()) == this.getList().get(i)) {
					text = String.format("%s���� ������ %d�� �Դϴ�.", this.getId(), i+1);
					this.changeLabelByName("label1", text);
					break;
				}
			}
			this.changeButtonByName("button0", "��������");
		}
		if (this.getList().size() > 0) {
			avg = sum / this.getList().size();
			text = String.format("������ ����� �л����� ��� ������ %1.1f�� �Դϴ�.",avg);
		} else {
			text = "������ ����� �л��� �����ϴ�.";
		}
		this.changeLabelByName("label2", text);
		this.changeButtonByName("button1", "�ݱ�");
	}
	/*��ư Ŭ���� �Ʒ��� ����� �����մϴ�.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		int score = 0;
		String scoreStr = "";
		switch(e.getActionCommand()) {
		case "�������":
			scoreStr = JOptionPane.showInputDialog("������ �Է��ϼ���.");
			try {
				score = Integer.parseInt(scoreStr);
				this.writeScore(this.getId(), scoreStr);
				this.printRank();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է����ּ���.");
			}
			break;
		case "��������":
			scoreStr = JOptionPane.showInputDialog("������ �Է��ϼ���.", this.readScore(this.getId()));
			try {
				score = Integer.parseInt(scoreStr);
				this.writeScore(this.getId(), scoreStr);
				this.printRank();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է����ּ���.");
			}
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