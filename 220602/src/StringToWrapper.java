
public class StringToWrapper {
	public static void boxingUnboxind() {
		//��������
		int i = 10;
		//��ü���� , ������ ObjcetType���� �ٲٴ°�  boxing �̶� �Ѵ�
		Integer in = new Integer(i);
		Boolean b = new Boolean(false);
		Long l = new Long("10");
		
		//��ü�� �Ϲ� �ڷ�Ÿ������ �ٲٴ°� unboxing ��� �Ѵ�
		int j = in.intValue();
		boolean bl = b.booleanValue();
		long lg = l.longValue();
	}
	public static void auttoBoxingUnboxing() {
		Integer in = 10;
		Boolean bl = true;
		int i = in;
		boolean b = bl;
	}
	public static void StringToWapper() {
		Integer in = new Integer("10");
		int i = in;
		Boolean bl = new Boolean(false);
		Long ll = new Long("abcde");
		int r = Integer.parseInt("2030");
		double d = Double.parseDouble("2030.12");
		boolean b = Boolean.parseBoolean("false");
	}
	public static void main(String[] args) {
		
	}
}
