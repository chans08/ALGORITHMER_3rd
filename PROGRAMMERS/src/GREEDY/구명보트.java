package GREEDY;
import java.util.ArrayDeque;
import java.util.Arrays;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int ans = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        Arrays.sort(people);        
        for(int i : people)
        	dq.add(i);
        
        while(!dq.isEmpty()) {
        	if(dq.peekFirst()+dq.pollLast()<=limit &&!dq.isEmpty())
        		dq.pollFirst();        	
        	ans++;
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] people = {70,80,50};
		int limit=100;
		System.out.println(solution(people, limit));
	}
}
