class Operator1 
{
	public static void main(String[] args) 
	{
		int i = 97;
		String s = "Java";
		double f = 3.14f;
		// printf(format) : %d(정수) , %s(문자열) , %f(실수)
		System.out.printf("%d\n",i); // 정수로 표시
		System.out.printf("%o\n",i); // 
		System.out.printf("%x\n",i);
		System.out.printf("%c\n",i);
		System.out.printf("%5d\n",i); // 5자리 표시 (자리수 부족 할 시 공간 비움)
		System.out.printf("%05d\n",i); // 5자리 표시 (자리수 부족 할 시 0으로 채움)
		System.out.printf("%s\n",s);
		System.out.printf("%5s\n",s);
		System.out.printf("%-5s\n",s);
		System.out.printf("%f\n",f);
		System.out.printf("%e\n",f);
		System.out.printf("%4.1f\n",f);
		System.out.printf("%04.1f\n",f);
		System.out.printf("%-4.1f\n",f);
	}
}