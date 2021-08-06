package FullSearch;

public class 카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int sum = brown+yellow;
        for(int x=2; x<sum; x++) {
        	if(sum%x==0) {
        		int y= sum/x;
        		if((2*x+2*y-4)==brown){
        			answer[0]=y;
        			answer[1]=x;
        			return answer;
            	}
        	}
        	else 
        		continue;
        }        
        return answer;
    }
    public static void main(String[] args) {
		int brown=10,yellow=2;
		//int brown=24,yellow=24;
    	int[] arr =solution(brown, yellow);
		System.out.println("가로 : " + arr[0]);
		System.out.println("세로 : " + arr[1]);
	}
}
