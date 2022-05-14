package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {

	/**
	 * 문제
	 *  맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하라.
	 *  아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
	 *   - 삼각형의 크기는 1 이상 500 이하이다. 
	 *   - 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
	 * 
	 * => DP(다이나믹 프로그래밍) 이용
	 * 
	 * 시간 : 228 ms
	 * 메모리 : 25088 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 삼각형의 크기
		
		// 삼각형 초기화
		int[][] triagle = new int[N][N+2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i+1; j++) {
				triagle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 메모이제이션 사용
		int[][] memo = new int[N][N+2];
		memo[0][1] = triagle[0][1];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= i+1; j++) {
				memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + triagle[i][j];
			}
		}
		
		// 합이 최대가 되는 값 찾기
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, memo[N-1][i]);
		}
		
		System.out.println(max);
	}

}
