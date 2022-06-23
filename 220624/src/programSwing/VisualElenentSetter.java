package programSwing;

import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VisualElenentSetter {
	Map<String, JFrame> frames = new Hashtable<String, JFrame>();
	Map<String, JPanel> panels = new Hashtable<String, JPanel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JLabel>checkLabels = new Hashtable<String,JLabel>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	Map<String,JComboBox<String>> comboBoxs = new Hashtable<String,JComboBox<String>>();

	void setTextFields(String panelName , String K) {
		textFields.put(K,new JTextField());
		panels.get(panelName).add(textFields.get(K));
	}
	void setPasswordFields(String panelName , String K) {
		passwordFields.put(K,new JPasswordField());
		panels.get(panelName).add(passwordFields.get(K));
	}
	
	void setLabels(String panelName , String K , String V) {
		labels.put(K,new JLabel(V));
		panels.get(panelName).add(labels.get(K));

	}
	void setCheckLabels(String panelName , String K , String V) {
		checkLabels.put(K,new JLabel(V));
		panels.get(panelName).add(checkLabels.get(K));

	}
	void setButtons(String panelName , String K , String V) {
		buttons.put(K,new JButton(V));
		panels.get(panelName).add(buttons.get(K));
	}
	void setComboBoxs(String panelName , String K , String[] V) {
		comboBoxs.put(K,new JComboBox<>(V));
		panels.get("ÀüÃ¼").add(comboBoxs.get(K));
	}









}