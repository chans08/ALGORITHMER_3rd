package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class 기능개발 {
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3)); // 리스트형으로 초기화를 한번에
		HashSet<Integer> set2 = new HashSet<>();	// 객체생성후 나중에 초기화
		for (int i = 0; i <= 10; i++) 
			set2.add(i);			// add() 반복문 초기화가 일반적임

		// for 출력
		for(int i : set1)
			System.out.print(i + " ");
		
		// Iterator 출력 (Collection은 모두가능)
		Iterator<Integer> it = set2.iterator();
		System.out.println("\n");
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		// 존재하면 삭제시 true , 아니면 False 반환
		System.out.println("\n\n"+set1.remove(1));
		System.out.println(set1.remove(1));
		
		// contains를 통해 존재여부 검색
		System.out.println("\n"+set1.contains(1));
		System.out.println(set2.contains(1));
	
		HashSet<Integer> set = new HashSet<>(Arrays.asList(5,2,3,7,10,4)); // 리스트형으로 초기화를 한번에
		
		// 리스트로 받아서 Collections.sort !
		ArrayList<Integer> arr = new ArrayList<Integer>(set);
		Collections.sort(arr);
		for(int i: arr)
			System.out.println(i);
			
	}
}
