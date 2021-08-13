package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;

public class 단어변환 {
	static int answer=50;
	public static boolean compareString(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length() && cnt < 2; i++) 
            if (str1.charAt(i) != str2.charAt(i)) 
                cnt++;       
        return cnt == 1;
	}
	public static void dfs(String begin, String target, ArrayList<String> list,int cnt) {
		if(begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(compareString(begin, list.get(i))) {
				String str = list.get(i);
				list.remove(i);
				dfs(str, target, list,cnt+1);
				list.add(i,str);
			}
		}
		
	}	
	public static int solution(String begin, String target, String[] words) {
		// 포함하지 않는 경우 0 반환후 종료
		boolean flag=false;
		for(String s : words) {
			if(s.equals(target)){
				flag = true;
				break;
			}
		}
		if(!flag)	return 0;
				
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
		dfs(begin,target,list,0);
		return answer;
    }

	public static void main(String[] args) {
		String begin="hit";
		String target="cog";
		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}
}
