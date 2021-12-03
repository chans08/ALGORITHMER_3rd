package Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class K번째수 {
    public static  int[] solution(int[] array, int[][] commands) {
    	int answer[] = new int[commands.length];
    	for(int i = 0 ; i<commands.length; i++) {
        	int [] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        	Arrays.sort(arr);
        	answer[i] = arr[commands[i][2]-1];
    	}
        return answer;
    }
    public static void main(String[] args) {
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		arr = solution(arr, commands);
		for(int i : arr)
			System.out.print(i + " ");
    }
}
