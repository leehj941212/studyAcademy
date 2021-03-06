class OperatorExam 
{
	public static void main(String[] args) 
	{
		int num1;
		int num2;

        num1 = 100;
		num2 = 50;

        //산술
		System.out.println("num1" + (num1 + num2));
		System.out.println("num1" + (num1 - num2));
		System.out.println("num1" + (num1 * num2));
		System.out.println("num1" + (num1 / num2));
		System.out.println("num1" + (num1 % num2));
		// %(나머지)는 double 형은 사용 할 수 없다

        //비교
		System.out.println("result : " +  (num1 > num2) );
		System.out.println("result : " +  (num1 >= num2) );
		System.out.println("result : " +  (num1 < num2) );
		System.out.println("result : " +  (num1 <= num2) );
		System.out.println("result : " +  (num1 != num2) );
		System.out.println("result : " +  (num1 == num2) );
		// == (동등비교)는 String 형은 사용 할 수 없다

		//대입
		System.out.println("대입 : " + (num1 = 120));
		System.out.println("대입 : " + (num1 += 120));
		// += -> 원래 값에 더하여 대입한다
		System.out.println("대입 : " + (num1 -= 120));
		// -= -> 원래 값에 빼서 대입한다
		System.out.println("대입 : " + (num1 *= 120));
		// *= -> 원래 값에 곱하여 대입한다
		System.out.println("대입 : " + (num1 /= 120));
		// /= -> 원래 값에 나눠서 대입한다

        //증감
		System.out.println("증감 : " + ++num1);
		System.out.println("증감 : " + --num1);
		System.out.println("증감 : " + num1++);
		System.out.println("증감 : " + num1--);
		System.out.println("결과 : " + num1);

        //논리
		System.out.println("논리 : " + ((num1>num2) && (num1 == num2)));
		System.out.println("논리 : " + ((num1>num2) && (num1 != num2)));
		// a && b -> a 와 b 둘 다 참인지 여부 확인
		System.out.println("논리 : " + ((num1>num2) || (num1 == num2)));
		System.out.println("논리 : " + ((num1>num2) || (num1 != num2)));
		// a || b -> a 와 b 중 하나라도 참인지 여부 확인

        //변환
		System.out.println("변환 " + num1/11);
		System.out.println("변환 " + num1/11.0);
		// int + int -> int , int + double -> double
		System.out.printf("formet 형식 %.2f\n" , num1/11.0);
		double d = 13;
		System.out.println("변환 " + (int)d/3);

	}
}
