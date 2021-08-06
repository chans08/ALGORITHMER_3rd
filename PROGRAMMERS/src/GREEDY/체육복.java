package GREEDY;

import java.util.ArrayList;

public class 체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i : reserve)  list.add(i);
        int ans = n-lost.length;
        // 일단 중복제거
        for(int i : lost)  {
        	if(list.contains(i)){
        		for(int j=0;j<list.size();j++) {
        			if(list.get(j)==i) {
        				list.remove(j);
        				ans++;
        				break;
        			}
        		}
        	}
        }
        for(int i : lost)  {        		
        	for(int j=0;j<list.size();j++) {
        		if(i+1>=list.get(j) && list.get(j)>=i-1) {
        			list.remove(j);
        			ans++;
        			break;
        		}
        	}
        }		
		return ans;
    }
	public static void main(String[] args) {
		int n=3;
		int[] lost = {1,2};
		int[] reserve= {2,3};
		System.out.println(solution(n,lost,reserve));
	}
}
