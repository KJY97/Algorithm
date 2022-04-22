package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {

	/**
	 * 문제
	 *  정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
	 *   - 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1
	 *  정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	 *   - 1 <= n < 11
	 *   
	 * => 다이나믹 프로그래밍
	 * 
	 * 시간 : 84 ms
	 * 메모리 : 11452 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] memo = new int[n+1]; // 인덱스 1부터 사용한다.
			
			// 초기화 (그러나 n의 값은 1부터 들어오므로 범위 주의)
			if (n >= 1) memo[1] = 1;
			if (n >= 2) memo[2] = 2;
			if (n >= 3) memo[3] = 4;
			
			for (int i = 4; i <= n; i++) {
				memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
			}
			
			System.out.println(memo[n]);
		}
	}

}
