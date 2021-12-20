package week2;
// dfs - 넓이우선 재귀호출
public class combination_bfs {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
        String arr = "abcdefghijk"; 
        int n = arr.length(); 
        boolean[] chosen = new boolean[n];
        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination_BFS(arr, chosen, 0, n, i);
        }
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("\n\n사용메모리 : "+usedMemory/1024 + " KB");
        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start)/1000.0);
        
    }
    // 사용 예시 : 문자열 값, 선택여부 체크 배열 chosen, 시작위치 start, 전체개수 n, 앞으로 선택할 개수 r)
    static void combination_BFS(String arr, boolean[] chosen, int start, int n, int r) {
        if (r == 0) {
            print(arr, chosen, n);
            return;
        }

        for (int i = start; i < n; i++) {
        	chosen[i] = true;
        	combination_BFS(arr, chosen, i + 1, n, r - 1);
            chosen[i] = false;
        } 
    }	
    // 배열 출력
    static void print(String arr, boolean[] chosen, int n) {
        for (int i = 0; i < n; i++) 
            if (chosen[i]) 
                System.out.print(arr.charAt(i) + " ");            
        System.out.println();
    }
    
}