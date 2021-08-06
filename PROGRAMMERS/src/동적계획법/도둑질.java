package 동적계획법;

import java.util.Arrays;
import java.util.HashSet;

public class 도둑질 {
	public static int solution(int[] money) {
		int[][] a = new int[money.length][2];
		for(int i=0;i<money.length;i++) {
			a[i][0] = i;
			a[i][1] = money[i];
		}
		Arrays.sort(a, (int[] o1,int[] o2)-> o2[1] - o1[1]);
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		int ans=a[0][1];
		set.add(a[0][0]);
		set.add(a[0][0]+1==a.length?0:a[0][0]+1);
		set.add(a[0][0]-1==-1?a.length-1:a[0][0]-1);
		int ans2=a[1][1];
		set2.add(a[1][0]);
		set2.add(a[1][0]+1==a.length?0:a[1][0]+1);
		set2.add(a[1][0]-1==-1?a.length-1:a[1][0]-1);
		for(int i=0;i<a.length;i++) {
			if(!set.contains(a[i][0])){
				set.add(a[i][0]);
				set.add(a[i][0]+1==a.length?0:a[i][0]+1);
				set.add(a[i][0]-1==-1?a.length-1:a[i][0]-1);
				ans+=a[i][1];
			}
			if(!set2.contains(a[i][0])){
				set2.add(a[i][0]);
				set2.add(a[i][0]+1==a.length?0:a[i][0]+1);
				set2.add(a[i][0]-1==-1?a.length-1:a[i][0]-1);
				ans2+=a[i][1];
			}
		}
		System.out.println(ans+" "+ans2);
		return Math.max(ans,ans2);
	}
	public static void main(String[] args) {
		//int[] money = {1000,0,0,0,0,1000,0,0,0,0,0,1000};
		//int[] money = {90, 0, 0, 95, 1, 1}; //185
		//int[] money = {91, 90, 5, 7, 5, 7}; //104
		int[] money = {1,2,3}; //3
		System.out.println(solution(money));	
	
	}
}
