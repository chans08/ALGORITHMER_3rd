package GREEDY;

public class 조이스틱 {
	public static int minMove(char ch) {
		if(ch=='N') return 13;
		else if(ch<'N') return Character.getNumericValue(ch)-10;
		else return 36 - Character.getNumericValue(ch);
	}
	// 시작이나  끝에 A가 연속하는 경우 최소 방향에 따른 최소 이동수를 정함
	public static int minCursor(String name) {
		int cursor=name.length()-1;
		int cntA=0;
		int i=0;
		// A가 맨앞에 연속되는 경우
		if(name.charAt(i)=='A') {
			while(i<name.length() && name.charAt(i)=='A') {
				cntA++;
				i++;
			}
			cursor = name.length()-cntA;
			System.out.println("A가 앞에연속됨 cntA : "+ cntA+" "+ (name.length()-cntA));
		}
		i=name.length()-1;
		cntA=0;
		// A가 뒤에 연속되는 경우
		if(name.charAt(i)=='A') {
			while(i>=0 && name.charAt(i)=='A') {
				cntA++;
				i--;
			}
			cursor = Math.min(cursor,name.length()-1-cntA);
			System.out.println("A가 뒤에 연속됨 cntA : "+ cntA +" " +(name.length()-1-cntA));
		}	
		// A가 중간에 나오는 경우
		for(i=0; i<name.length();i++) {
			if(name.charAt(i)=='A') {
				cntA=0;
				int j=i;
				while(name.charAt(j)=='A' && j<name.length()-1) {
					cntA++;				
					j++;
				}
				cursor = Math.min(cursor, ((2*i)+name.length()-j-2));
				System.out.println("A가 중간에 연속됨 cntA : "+ cntA+" " + ((2*i)+name.length()-j-2));
				i=j;
			}
				
		}
		return cursor;
	}
	public static int solution(String name) {
		int ans =0;
		// 알파벳 최소 변경값 
		for(char ch : name.toCharArray())
			ans += minMove(ch);
        // 커서 최소변경값
		int cursor = minCursor(name);
		System.out.println("cursor : "+cursor);
		return ans + cursor;
    }
	public static void main(String[] args) {
		//System.out.println(solution("JANAAA"));
		//System.out.println(solution("JEROEN"));
		System.out.println(minCursor("EAEAAAAAER"));
	}
}