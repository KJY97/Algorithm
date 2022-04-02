package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1003 {

	/**
	 * 문제
	 *  N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하라.
	 *   - 0 <= N <= 40
	 *   - 시간 제한 (0.25 초)
	 *   
	 * => 다이나믹 활용
	 * 
	 * 시간 : 80 ms
	 * 메모리 : 11428 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] memo = new int[N+1][2];
			// 0번째 열 0의 횟수, 1번째 열 1의 횟수를 저장
			
			memo[0][0] = 1; memo[0][1] = 0;
			
			if(N > 0) {
				memo[1][0] = 0; memo[1][1] = 1;
			}
			
			for (int i = 2; i <= N; i++) {
				memo[i][0] = memo[i-1][0] + memo[i-2][0];
				memo[i][1] = memo[i-1][1] + memo[i-2][1];
			}
			
			System.out.println(memo[N][0] + " " + memo[N][1]);
		}
	}

}
