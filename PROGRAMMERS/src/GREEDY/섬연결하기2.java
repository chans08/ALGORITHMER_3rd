package GREEDY;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기2 {
	static int[] island;
	public static int findPoint(int a) {
		if(island[a] == a)
			return a;
		else
			return findPoint(island[a]);
	}
	public static int solution(int n, int[][] costs) {
		// costs 최솟값 정렬
		Arrays.sort(costs, new Comparator<int []>() {
			@Override
			public int compare(int o1[], int o2[]) {
				return o1[2] - o2[2];
			}
		});
		int ans=0;
		island = new int[n];
		for(int i=0;i<n;i++)	island[i]=i;
		for(int[] i : costs) {
			int a = findPoint(i[0]);
			int b = findPoint(i[1]);
			System.out.println("a ->"+i[0]+" "+a);
			System.out.println("b ->"+i[1]+" "+b);
			if(a != b) {	// 연결되 있지않으면
				ans+=i[2];
				island[a] = b;	// 신규 연결
				System.out.println("연결\n");
			}
			System.out.println("패쓰\n");
				
		}		
		return ans;
	}
	public static void main(String[] args) {
		int n=5;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n, costs));

	}
}
