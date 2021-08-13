package DFSBFS;

import java.util.Arrays;

public class 여행경로 {
	static String[] answer;
	public static void comparePath(String[] path) {
		if(answer[0]==null) {
			answer= path.clone();
			return;
		}
		for(int i=0;i<path.length;i++) {
			if(answer[i].compareTo(path[i])==0)	continue;
			else if(answer[i].compareTo(path[i])<0)	return;
			else if(answer[i].compareTo(path[i])>0) {
				answer=path.clone();
				return;
			}
		}
	} 
	public static String[] solution(String[][] tickets) {
	    answer = new String[tickets.length+1];
	    String[] path = new String[tickets.length+1];
	    Arrays.sort(tickets,(String[] a,String[] b)-> a[1].compareTo(b[1]));
	    Boolean [] flags = new Boolean[tickets.length];
	    for(int i=0;i<flags.length;i++) 	flags[i]=true;
	    dfs(flags, tickets, "ICN",0, path);
	    return answer;
	}
	public static void dfs(Boolean[] flags, String[][] tickets, String from, int cnt, String[] path) {
		path[cnt]=from;
		if(cnt==tickets.length) {
			comparePath(path);
			return;
		}			
		for(int i=0;i<tickets.length;i++) {            
        	if(flags[i] && tickets[i][0].equals(from)) {   
    			flags[i]=false;
    			dfs(flags, tickets, tickets[i][1], cnt+1, path);
    			flags[i]=true;
    		}
		}	    
	}
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
		//String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] x = solution(tickets);
		for(String s: x)
			System.out.print(s+" ");
	}
}
// 모든 경로를 기억해야함
// 결과를 비교해야함
// 짜는건 짜는건데 맞겠지?