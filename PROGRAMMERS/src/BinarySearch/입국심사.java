package BinarySearch;
import java.util.Arrays;
public class 입국심사 {
	public static long solution(int n, int[] times) {
	    Arrays.sort(times); // 시간순으로 정렬 
	    long answer = 0;
	    long from=1;
	    long to=(long)times[times.length-1]*n;
	    long min;
	    while(from<=to) {
	    	min=(from+to)/2;
        	System.out.println(from+" "+min+" "+to);
    	    long person=0;
	    	for(int i=0;i<times.length;i++) {
	    		person+=min/times[i];}
	    	if(person==n) {
				return min;
			}else if(person<n){
				from=min+1;
			}else {
				to=min-1;
			}	
	    }
	    return answer;
	}	
	public static long solution2(int n,int[] times){
        long answer = 0;
        Arrays.sort(times);
        long start = 1;// 최선의 경우
        long end = (long)times[times.length-1] * n;//최악의 경우

        while(start <= end){
            long sum = 0;
            long mid = (start+end)/2;
            for(int time : times){
                sum += mid/time;// 심사관마다 중간시간을 기준으로 심사할 수 있는 사람의 수의 합
            }

            if(sum >= n){ // 심사하는 사람의 수가 더 많거나 같으므로 시간을 줄일 수 있다.
                end = mid-1;
                answer = mid;
            }else{// 심사하는 사람의 수가 적으므로 시간을 늘려야한다.
                start = mid+1;
            }
        }

        return answer;
    }
	public static void main(String[] args) {
		int n=66;
		int[] times= {1,7,10,20,45}; //47,
		System.out.println(solution2(n, times));
	}
}