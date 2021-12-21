package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {

	/**
	 * 문제
	 *  자연수 N과 정수 K가 주어졌을 때 이항 계수를 구하기
	 *  
	 * => ₀C₀               = 1
	 * 	  ₁C₀ ₁C₁           = 1 1
	 *    ₂C₀ ₂C₁ ₂C₂       = 1 2 1
	 *    ₃C₀ ₃C₁ ₃C₂ ₃C₃   = 1 3 3 1
	 *    ...
	 * => DP
	 * 
	 * 시간 : 88 ms
	 * 메모리 : 11504 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 10
		int K = Integer.parseInt(st.nextToken()); // 0 <= K <= N
		
		int[][] memo = new int[N+1][N+1];
		memo[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if(j == 0) {
					memo[i][j] = memo[i-1][j];
				} else {
					memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
				}
			}
		}

		System.out.println(memo[N][K]);
	}

}
