package week3;

import java.util.Arrays;

public class 순위검색 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		for(int i : solution(info, query))
			System.out.println(i);
	}
	
    public static int[] solution(String[] info, String[] query) {
    	int[] answer = new int[query.length];
    	String[][] sup = new String[info.length][5];
    	for(int i=0;i<info.length;i++) // 지원자 점수와 정보 담기
    		for(int j=0;j<5;j++) sup[i][j] = info[i].split(" ")[j];   
    	for(int i=0;i<query.length;i++) { // 쿼리 질문별 정답 구하기
    		query[i] = query[i].replaceAll(" and "," ");
    		String[] qry = query[i].split(" ");
    		answer[i] = ResultCount(sup,qry); 
    		
    	}
        return answer;
    }
    
    public static int ResultCount(String[][] sup, String[] qry) {
    	Arrays.sort(sup,(o1,o2) -> Integer.parseInt(o1[4]) - Integer.parseInt(o2[4]));
    	for(int i=0;i<sup.length;i++) {
    		if(Integer.parseInt(qry[4]) -Integer.parseInt(sup[i][4]) <=0) {
    			sup = Arrays.copyOfRange(sup,i,sup.length);
    			break;
    		}
    	}    	
    	for(int i=3;i>=0;i--) {
    		int idx = i;
        	Arrays.sort(sup,(o1,o2) -> o1[idx].compareTo(o2[idx]));
        	sup = BinarySearch(sup,qry[idx],i);		
    	}
    	return sup.length;
    }
    private static String[][] BinarySearch(String[][] sup, String cond, int i) {
    	if(cond.equals("-") || sup.length < 1)
    		return sup;   
    	int start=0,end=sup.length;
    	for(int j=0;j<sup.length;j++) {
			if(sup[j][i].equals(cond)) {
				start = j;
				break;
			}
		}
    	if(!sup[start][i].equals(cond))
    		return Arrays.copyOfRange(sup,0,0);
    	 for(int j=start;j<sup.length;j++) {
			if(!sup[j][i].equals(cond)) {
				end = j;
				break;
			}
		}  	
		return Arrays.copyOfRange(sup,start,end);
	}
}

