package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class 가장먼노드 {
	public static int solution(int n, int[][] edge) {
		HashSet<Integer> set = new HashSet<Integer>();
	    Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        set.add(1);
        int cnt=1;
        while(!q.isEmpty()) {
        	cnt=q.size();
        	for(int i=0;i<cnt;i++) {
        		int peek=q.poll();
        		for(int j=0;j<edge.length;j++) {
            		if(edge[j][0]==peek && !set.contains(edge[j][1])) {
            			set.add(edge[j][1]);
            			q.add(edge[j][1]);  
            		}
            		if(edge[j][1]==peek && !set.contains(edge[j][0])) {
            			set.add(edge[j][0]);
            			q.add(edge[j][0]);  
            		}
        		}
        	}
        }
    
        return cnt;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edge = {{4, 3}, {1, 3}, {2, 3}};
		System.out.println(solution(n, edge));
	}
}
