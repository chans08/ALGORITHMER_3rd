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
    	sup = BinarySearch(sup,qry[4]);

    	for(int i=3;i>=0;i--) {
    		int idx = i;
        	Arrays.sort(sup,(o1,o2) -> o1[idx].compareTo(o2[idx]));
        	sup = BinarySearch(sup,qry[idx]);		
    	}
    	return sup.length;
    }
    
    private static String[][] BinarySearch(String[][] sup, String cond) {
    	
    	return Arrays.copyOfRange(sup, 0, 15);
	}
}

