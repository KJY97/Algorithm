package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {

	/**
	 * 문제
	 *  오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
	 *  예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
	 *  수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
	 *   - 1 ≤ N ≤ 1,000
	 *   - 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.
	 * 
	 * => DP(다이나믹 프로그래밍) 방식 활용하기
	 * 
	 * 시간: 80 ms
	 * 메모리: 11524 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수의 길이
		int[][] memo = new int[N+1][10];
		int MOD = 10007;
		
		// 초기화
		for (int i = 0; i < 10; i++) {
			memo[0][i] = 1;
		}
		
		// memo[N][j] = memo[N-1][0] + ~ + memo[N-1][j];의 규칙을 가진다.
		for (int i = 1; i <= N; i++) {
			memo[i][0] = 1;
			for (int j = 1; j < 10; j++) {
				memo[i][j] = (memo[i][j-1] + memo[i-1][j]) % MOD;
			}
		}
		
		System.out.println(memo[N][9] % MOD);
	}

}
