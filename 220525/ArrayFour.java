class ArrayFour {
	public static void main(String[] args) {

		//배열의 값을 큰 순으로 출력한다

		int []test = {6,4,3,7,1,8,10,2,40}; //test배열은 9개의 값을 가진다
		int temp = 0; //temp 의 초기값 설정
		int i , j; // i,j는 변수만 생성

		for ( i = 0 ; i < test.length ; i++ ){ 
			//i가 0부터 8까지 9번 실행한다
			
			for ( j = i + 1 ; j < test.length ; j++ ){
				//j가 i+1부터 8까지 실행하고 i가 0부터 8까지 실행되는중 매 차례 반복한다

				if ( test[i] < test[j] ){ // 먼저 입력된 값이 다음 입력된 값보다 작을때 실행
					temp = test[i]; 
					test[i] = test[j];
					test[j] = temp;
					//현재 값보다 큰 수가 나오면 두 개의 배열 번호를 바꾼다
				}
			}
			//i가 0일때
			//test[0]=6 은 test[1]=4 보다 작지 않으므로 실행하지 않는다 test[1]=4
			//test[0]=6 은 test[2]=3 보다 작지 않으므로 실행하지 않는다 test[2]=3
			//test[0]=6 은 test[3]=7 보다 작으므로 실행한다 temp=6 , test[0]=7 , test[3]=6
			//test[0]=7 은 test[4]=1 보다 작지 않으므로 실행하지 않는다 test[4]=1
			//test[0]=7 은 test[5]=8 보다 작으므로 실행한다 temp=7 , test[0]=8 , test[5]=7
			//test[0]=8 은 test[6]=10 보다 작으므로 실행한다 temp=8 , test[0]=10 , test[6]=8
			//test[0]=10 은 test[7]=2 보다 작지 않으므로 실행하지 않는다 test[7]=2
			//test[0]=10 은 test[8]=40 보다 작으므로 실행한다 temp=10 , test[0]=40 , test[8]=10
			//test[0]=40 으로 확정

			//i가 1일때
			//test[1]=4 은 test[2]=3 보다 작지 않으므로 실행하지 않는다 test[2]=3
			//test[1]=4 은 test[3]=6 보다 작으므로 실행한다 temp=4 , test[1]=6 , test[3]=4
			//test[1]=6 은 test[4]=1 보다 작지 않으므로 실행하지 않는다 test[4]=1
			//test[1]=6 은 test[5]=7 보다 작으므로 실행한다 temp=6 , test[1]=7 , test[5]=6 
			//test[1]=7 은 test[6]=8 보다 작으므로 실행한다 temp=7 , test[1]=8 , test[6]=7 
			//test[1]=8 은 test[7]=2 보다 작지 않으므로 실행하지 않는다 test[7]=2 
			//test[1]=8 은 test[8]=10 보다 작으므로 실행한다 temp=8 , test[1]=10 , test[8]=8
			//test[1]=10 으로 확정


		}
		for ( j = 0 ; j < test.length ; j++ ){ //j가 0부터 8까지 9번 실행한다
			System.out.println(test[j] + "\t");
		}
	}
}
