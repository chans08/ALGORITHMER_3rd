package GREEDY;

import java.util.Stack;

public class 큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<number.length(); i++) { // 하나씩 돌면서
            char c = number.charAt(i); 
            while (k>0 && stack.isEmpty()==false && stack.peek() < c) {	// top보다 큰값이면 pop()!
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i=0; i<=stack.size(); i++) 
        	sb.append(stack.get(i));
        
        return sb.toString();
    }
	 public static void main(String[] args) {
		String number="";
		int k=61;
		//System.out.println(number.substring(number.indexOf('2')));
		System.out.println(solution(number, k));
	}
}