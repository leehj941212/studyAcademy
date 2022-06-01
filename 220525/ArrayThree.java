class ArrayThree {
	public static void main(String[] args) {

        //배열의 가장 작은 값(min) , 가장 큰 값(max) , 전체 합계(hap) 를 표시한다

		int []data = {67,54,11,34,99,87,21,44,73,2}; //data에 10개의 값을 입력
		int i , max , min , hap = 0; //i,max,min은 변수만 지정 , hap는 초기값 설정

		System.out.println("*** result ***\n");
		max = data[0];
		min = data[0];
		//max,min의 초기값 설정

		for ( i = 0 ; i < data.length ; i++) //i가 0부터 data의 배열의수(10개) -1 까지 총 10번 반복
		{
			if ( max < data[i]) //현재 max 값이 data[i] 보다 작을때
			{
				max = data[i]; // max 값에 data[i] 입력
			}
			//data[0]=67은 data[0]=67보다 작지 않으므로 실행하지 않는다
			//data[0]=67은 data[1]=54보다 작지 않으므로 실행하지 않는다
			//data[0]=67은 data[2]=11보다 작지 않으므로 실행하지 않는다
			//data[0]=67은 data[3]=34보다 작지 않으므로 실행하지 않는다
			//data[0]=67은 data[4]=99보다 작으므로 실행한다
			//data[4]=99은 data[5]=87보다 작지 않으므로 실행하지 않는다
			//data[4]=99은 data[6]=21보다 작지 않으므로 실행하지 않는다
			//data[4]=99은 data[7]=44보다 작지 않으므로 실행하지 않는다
			//data[4]=99은 data[8]=73보다 작지 않으므로 실행하지 않는다
			//data[4]=99은 data[9]=2보다 작지 않으므로 실행하지 않는다

			if ( min > data[i]) //현재 min 값이 data[i] 보다 클때
			{
				min = data[i]; // min 값에 data[i] 입력
			}
			//data[0]=67은 data[0]=67보다 크지 않으므로 실행하지 않는다
			//data[0]=67은 data[1]=54보다 크므로 실행한다
			//data[1]=54은 data[2]=11보다 크므로 실행한다
			//data[2]=11은 data[3]=34보다 크지 않으므로 실행하지 않는다
			//data[2]=11은 data[4]=99보다 크지 않으므로 실행하지 않는다
			//data[2]=11은 data[5]=87보다 크지 않으므로 실행하지 않는다
			//data[2]=11은 data[6]=21보다 크지 않으므로 실행하지 않는다
			//data[2]=11은 data[7]=44보다 크지 않으므로 실행하지 않는다
			//data[2]=11은 data[8]=73보다 크지 않으므로 실행하지 않는다
			//data[2]=11은 data[9]=2보다 크므로 실행한다

			hap += data[i];
		}
		System.out.println("minimum == " + min);
		System.out.println("maximum == " + max);
		System.out.println("total == " + hap);
	}
}
