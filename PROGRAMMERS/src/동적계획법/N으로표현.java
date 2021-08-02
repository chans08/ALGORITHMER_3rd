package 동적계획법;

public class N으로표현 {
    static int answer=-1;
	public static void dfs(int N, int number, int count, int sum) {
		if(count>8) return;
		if(number==sum)	{
			//System.out.printf("N,number,count,sum : %d, %d, %d, %d \n",N,number,count,sum);
			if(answer==-1)	answer=count;
			else answer=Math.min(answer, count);
		}
		int X=N;
		for(int i=1;i<=8-count;i++) {
			dfs(N,number,i+count,sum+X);
			dfs(N,number,i+count,sum-X);
			dfs(N,number,i+count,sum*X);
			dfs(N,number,i+count,sum/X);
			X=(10*X)+N;
		}
		
	}
    public static int solution(int N, int number) {
        dfs(N,number,0,0);
		return answer;
    }
    public static void main(String[] args) {
		int N=8;
		int number = 53;
		System.out.println(solution(N, number));
	}
}
