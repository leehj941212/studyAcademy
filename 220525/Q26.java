        //사이즈 5인 배열 선언
		//배열요소 값 지정(1~5사이의 랜덤값)
		//!!! 배열의 값들이 중복되지 않음!

class Q26 {
	public static void main(String[] args){
		int []txt = new int[5];  //txt 배열은 5개의 값을 가진다
		txt[0] = (int)(Math.random()*5+1); // txt[0] 은 랜덤 값을 가진다

		for ( int n = 1 ; n < txt.length ; n++ ){ //n은 1부터 4까지 4번 반복한다
			txt[n] = (int)(Math.random()*5+1); //txt[n]은 랜덤 값을 가진다

			for ( int j = 0 ; j < n ; j++ ){ //j는 0부터 n-1까지 1씩 증가하며 반복한다(j가 가장 커도 n보다 1작음)
				if ( txt[j] == txt[n]){ // txt[j] 와 txt[n]의 값이 동일할때
					txt[n] = (int)(Math.random()*5+1); //txt[n]은 새로운 랜덤값을 가진다
					j = -1 ; // 이 for문이 끝나면 j++가 되기때문에 j=-1로 지정하고 이 for문을 처음부터 다시 시작한다
				}
			}
		
		}
		System.out.print("배열 txt 의 값 : ");
		
		for ( int n = 0 ; n < txt.length ; n++ ){
			System.out.print(txt[n] + " ");
		}
		System.out.println();
	}
}
