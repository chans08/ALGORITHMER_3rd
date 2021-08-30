package Graph;

public class 순위 {
	static int [][] matrix;
	public static int solution(int n, int[][] results) {
		// 0 초기화
        matrix = new int [n][n];
		for(int i=0; i<n;i++)	for(int j=0; j<n; j++) matrix[i][j]=0;
    	// 승패 기록
    	for(int[] a : results)	update(a[0]-1,a[1]-1);
    	// 승리한 사람의 승리정보 가져와 update
    	for(int i=0; i<n;i++) {	
    		for(int j=0; j<n; j++) {
    			if(matrix[i][j]==1) {
    				for(int k=0;k<n;k++)
    					if(matrix[j][k]==1)
    						update(i,k);
    			}
    			else if(matrix[i][j]==-1){
    				for(int k=0;k<n;k++)
    					if(matrix[i][k]==1)
    						update(j,k);
    			}
    		}
    	}
    	int sum,answer=0;
    	for(int[] a : matrix) {
    		sum=0;
    		for(int b : a) {
    			//System.out.print(b+" ");
    			if(b==0) sum+=1;
    		}
    		//System.out.println();
    		if(sum==1)
    			answer+=1;
    	}
    	
    	return answer;
    }
	public static void update(int i, int j) {
		matrix[i][j] = 1;
		matrix[j][i] = -1;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{1, 2}, {4, 5}, {3, 4}, {2, 3}};
		System.out.println(solution(n, results));

	}

}
