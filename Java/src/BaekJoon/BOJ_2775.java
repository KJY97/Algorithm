package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775 {

	/**
	 * 문제
	 *  아파트에 비어있는 집이 없고, 거주민이 조건을 지키고 있다 가정했을 때 K층 N호에는 몇명이 살고 있는가?
	 *   - 조건: a층 b호에 살려면 자신의 아래층의 1호부터 b호까지 사람들의 수의 합만큼 사람들이 살고있어야 한다
	 *   - 각층은 1호부터 시작. 0층부터 시작
	 *   - 0층 i호에는 i명 거주
	 * 
	 * 시간: 80 ms
	 * 메모리: 11396 kb
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			
			// 1 ≤ k, n ≤ 14
			int K = Integer.parseInt(br.readLine()); // 층 수
			int N = Integer.parseInt(br.readLine()); // 호실
			
			int[][] memo = new int[K+1][N+1];
			
			// 0층 초기화
			for (int i = 1; i <= N; i++) {
				memo[0][i] = i;
			}
			
			for (int i = 1; i <= K; i++) {
				for (int j = 1; j <= N; j++) {
					memo[i][j] = memo[i][j-1] + memo[i-1][j];
				}
			}
			
			// K층 N호 인원수 출력
			System.out.println(memo[K][N]);
		}
	}
}
