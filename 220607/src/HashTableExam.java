import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExam {
	Hashtable<String,UserInfo> table = new Hashtable<String,UserInfo>();
	
	public HashTableExam() {
		UserInfo u = new UserInfo();
		u.setName("��");
		u.setAge(20);
		u.setAddr("������");
		
		UserInfo u2 = new UserInfo();
		u2.setName("ȫ�浿");
		u2.setAge(25);
		u2.setAddr("���ﵿ");
		
		UserInfo u3 = new UserInfo();
		u3.setName("��ö��");
		u3.setAge(42);
		u3.setAddr("û�㵿");
		
		table.put("na" , u);
		table.put("hong" , u2);
		table.put("su" , u3);
		
		Enumeration<String> e = table.keys();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			UserInfo value = table.get(key);
			System.out.println(key + " = " + value);
			System.out.printf("%s , %d , %s%n" , value.getName(),
					value.getAge(), value.getAddr());
			
		}
	}

	public static void main(String[] args) {
		new HashTableExam();

	}

}
