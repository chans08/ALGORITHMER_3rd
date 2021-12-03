package week1;

import java.util.Scanner;

public class 신규아이디추천 {
	public static void main(String[] args) {
		String new_id = "z-+.^."; // bat.y.abcdefghi
		// debug - 무제한 입력
		while(true){
			Scanner sc = new Scanner(System.in);
			new_id = sc.next();
			System.out.println(solution(new_id));
		}
	}
	private static String solution(String new_id) {
		new_id = new_id.toLowerCase().replaceAll("[^-_.a-z0-9]", ""); //1,2단계
		while(new_id.contains("..")) new_id = new_id.replaceAll("\\.\\.", "\\."); // 3
		if(new_id.startsWith(".")) new_id = new_id.substring(1); // 4
		if(new_id.equals("")) new_id = "a"; //5
		if(new_id.length()>15) new_id = new_id.substring(0,15);  
		if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1); 		
		if(new_id.length()<3) for(int i=0;new_id.length()<3;i++) new_id = new_id + new_id.charAt(new_id.length()-1); // 7
		return new_id;
    }
} 
