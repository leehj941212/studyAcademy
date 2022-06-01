class ArrayFive 
{
	public static void main(String[] args) {
		int[][]a = {{1,2,3},{4,5,6}};
		int[][]b = {{6,3,4},{5,1}};

		int i,j;
		System.out.println("행렬 a");
		for ( i = 0 ; i <a.length ; i++ ){
			for ( j = 0 ; j < a[i].length ; j++ )
			System.out.print(a[i][j] + " ");
				System.out.println();
		}
			System.out.println("==========");

			System.out.println("행렬 b");
			for ( i = 0 ; i <b.length ; i++ ){
				for ( j = 0 ; j < b[i].length ; j++ )
					System.out.print(b[i][j] + " ");
					System.out.println();
				}		
	}
}
