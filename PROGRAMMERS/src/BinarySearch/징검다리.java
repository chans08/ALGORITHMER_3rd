package BinarySearch;
import java.util.Arrays;

public class 징검다리 {
	
	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		long answer=0;
		long start=0;
        long end=distance;
        while(start<=end) {
        	long mid = (start+end)/2;
    		System.out.println("mid"+mid);
        	long removeCnt=0;
        	long prev=0;
        	for(int i=0;i<rocks.length;i++) {// 모든 돌들의 사이값을 순회하면서 비교
        		if(rocks[i] - prev < mid) 	//사이값이 예상값보다 작은경우
        			removeCnt+=1;			// 돌을 제거가능하다고 판단
        		else prev=rocks[i];
        	}
        	if(distance - prev < mid)	removeCnt+=1;	// 마지막돌과 끝거리사이도 제거가능한지 확인
        	// removeCnt를 이용해 탐색값 ,범위 재설정
        	if(removeCnt<=n) {
        		System.out.println(mid);
        		answer=Math.max(answer, mid);	//removeCnt==n이면 가능한 최소의 경우이므로 답으로 기록해야함
        		start=mid+1;
        	}
        	else {
        		end = mid-1;	
        	}
        }
        return (int)answer;
    }
	
	public static void main(String[] args) {
		int distance=25;
		int[] rocks= {2,14,11,21,17};
		int n=2;
		System.out.println(solution(distance, rocks, n));
	}
}
/*
//강사이 거리값이 들어온다
//강에 돌 위치값이 난잡하게 들어온다 (정렬필요)
//들어온 돌 사이 간격을 구한다 (시작점과 강끝지점도 포함)
//그 사이 N개만큼 제거하는 케이스별로 거리값을 다시구한다 
//사이값중 최소값을 구한다.

//이게 왜 이분탐색인지 모르겠다. 올바로 이해한게 맞는가?

//바위를 N개 제거할때, 제거될때마다 사이값이 달라지므로 다시구해야함  

나쁜건지 모르겠지만, 외로워서 가끔 생각나
근데 나도 연애관을 바꿀필요가 있어,
너무 목매지 않고, 구속하지않고 만나도록

*/
