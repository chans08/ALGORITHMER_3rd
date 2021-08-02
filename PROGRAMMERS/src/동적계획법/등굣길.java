package 동적계획법;
public class 등굣길 {
	public static int solution(int m, int n, int[][] puddles) {
		int [][] a = new int[n][m];
		// 웅덩이는 -1로 초기화
		a[0][0]=1;
		for(int[] x : puddles)
			a[x[1]-1][x[0]-1] = -1;
		// 초기 경로셋팅
		for(int i=1; i<m;i++) {
			if(a[0][i]==-1 || a[0][i-1]==0)
				a[0][i]=0;
			else
				a[0][i]=1;
		}
		for(int i=1; i<n;i++) {
			if(a[i][0]==-1 || a[i-1][0]==0)
				a[i][0]=0;
			else
				a[i][0]=1;
		}				
		
		// 경로 구하기
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				a[i][j] = a[i][j]==-1 ? 0 : (a[i-1][j] + a[i][j-1])%1000000007;
					
			}
		}		
		for(int[] i : a) {
			for(int j : i) 
				System.out.print(j+" ");
			System.out.println("");
		}
		return a[n-1][m-1]%1000000007;
	}
	public static void main(String[] args) {
		int[][] puddles = {{2,2},{1,2}};
		System.out.println(solution(4, 3, puddles));
	}
}
