package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class 가장큰수 {
	
    public static String solution(int[] numbers) {
    	StringBuffer sb = new StringBuffer();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort(numbers);
    	int d1,d2,d3,tmp;
    	for(int i : numbers) {
        	if(i<10)		// 한자리면 역순으로 넣어줌
        		list.add(0,i);
        	else if(i<100 && i>=10){	// 두자릿수에 경우
        		d1 = i/10;	//첫째자리수
        		d2 = i%10;	//둘쨰자리수
        		for(int j=list.size()-1; j>=0; j--) {
        			tmp = list.get(j);
        			if(tmp/10==0) { //비교값이 한자리수 인 경우
        				if(d1>tmp && j>0)	// 첫째자리가 더 크면 더 앞쪽에 넣어주도록 continue
        					continue;
        				else {
        					if(d2>d1)
        						list.add(j,i);	// 바로 뒤에 넣는다
        					else
        						list.add(j+1,i);
        					break;
        				}
        			}
        			else {			// 비교값이 두자리수 인 경우
        				if(i>tmp && j>0)	// 값이 더 크다면 더 진행
        					continue;
        				else {
        					list.add(j,i);	// 그 자리에 넣는다.
        					break;
        				}
        			}
        		}
        	}
    	}
    	for(int i : list) {
    		sb.append(i);
    	}
    	return sb.toString();
        
    }
	public static void main(String[] args) {
		int[] numbers = {3, 30,0,5,9,99,98, 34};
		System.out.println(solution(numbers)); //9534330

	}
}