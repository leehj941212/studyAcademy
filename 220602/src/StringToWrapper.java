
public class StringToWrapper {
	public static void boxingUnboxind() {
		//변수선언
		int i = 10;
		//객체생성 , 변수를 ObjcetType으로 바꾸는걸  boxing 이라 한다
		Integer in = new Integer(i);
		Boolean b = new Boolean(false);
		Long l = new Long("10");
		
		//객체를 일반 자료타입으로 바꾸는걸 unboxing 라고 한다
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
