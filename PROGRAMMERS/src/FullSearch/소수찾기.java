package FullSearch;

import java.util.HashSet;
import java.util.Iterator;


public class 소수찾기 {
    public static void permutation(String prefix, String str, HashSet<Integer> set) { 
        int n = str.length();        
        System.out.println(str);
        if(!prefix.equals("")) {
           set.add(Integer.valueOf(prefix)); //스트링을 Interger로 변환
        }        
        // 문자열이 공백이 들어오면 더이상 재귀호출 하지 못함
        for (int i = 0; i < n; i++){
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }

    }	
	// 소수 판별 메소드
	public static boolean isPrime(Integer a) {
		if(a==0 || a==1) {
			return false;
		}
		else {
			for(int i=2;i<=Math.sqrt(a);i++)
				if(a%i==0) 	return false;
		}
		return true;
	}
	public static int solution(String numbers) {
		HashSet<Integer> set = new HashSet<Integer>();
     	
		permutation("", numbers, set); //순열
     	
		Iterator<Integer> it = set.iterator();
		int count=0;
		while(it.hasNext()) {
			int a = it.next();
			if(isPrime(a))
				count++;
		}		
		return count;
 
	}
	
	// 메인
	public static void main(String[] args) {		
		System.out.println(solution("72105"));
	}
}
