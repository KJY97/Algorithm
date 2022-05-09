package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	/**
	 * 문제
	 *  RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다. 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 
	 *  각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
	 *   =========================================================
	 *    1번 집의 색은 2번 집의 색과 같지 않아야 한다.
	 *    N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
	 *    i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
	 *   =========================================================
	 *   - 집의 수 N(2 ≤ N ≤ 1,000)
	 *   - 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
	 *   
	 * 시간 : 88 ms
	 * 메모리 : 11940 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 집의 수
		
		int[][] RGB = new int[N+1][3]; // 1번부터 사용
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken()); // 각 집 RGB 비용
			}
		}
		
		// N번 집까지의 RGB로 칠했을 때의 최소 비용 구하기
		int[][] memo = new int[N+1][3]; // 1번부터 사용
		for (int i = 1; i <= N; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + RGB[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + RGB[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + RGB[i][2];
		}
		
		System.out.println(Math.min(memo[N][0], Math.min(memo[N][1], memo[N][2])));
	}

}
