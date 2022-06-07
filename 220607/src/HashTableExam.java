import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExam {
	Hashtable<String,UserInfo> table = new Hashtable<String,UserInfo>();
	
	public HashSetExam() {
		UserInfo u = new UserInfo();
		u.setName("³ª");
		u.setAge(20);
		u.setAddr("°­³²±¸");
		
		UserInfo u2 = new UserInfo();
		u.setName("È«±æµ¿");
		u.setAge(25);
		u.setAddr("¿ª»ïµ¿");
		
		UserInfo u3 = new UserInfo();
		u.setName("±èÃ¶¼ö");
		u.setAge(42);
		u.setAddr("Ã»´ãµ¿");
		
		table.put("na" , u);
		table.put("hong" , u2);
		table.put("su" , u3);
		
		Enumeration<String> e = table.keys();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			UserInfo value = table.get(key);
			System.out.println(key + " = " + value);
			System.out.println("%s,%d,%s%n" , value.getName(),
					value.getAge(), value.getAddr());
			
		}
	}

	public static void main(String[] args) {
		new HashTableExam();

	}

}
