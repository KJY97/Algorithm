package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11048 {

	/**
	 * 문제
	 *  준규는 N×M 크기의 미로에 갇혀있다. 미로는 1×1크기의 방으로 나누어져 있고, 각 방에는 사탕이 놓여져 있다.
	 *  미로의 가장 왼쪽 윗 방은 (1, 1)이고, 가장 오른쪽 아랫 방은 (N, M)이다.
	 *  준규는 현재 (1, 1)에 있고, (N, M)으로 이동하려고 한다.
	 *  준규가 (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고, 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다. 또, 미로 밖으로 나갈 수는 없다.
	 *  준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값을 구하시오.
	 *   - 1 ≤ N, M ≤ 1,000
	 *   - 사탕의 개수는 0보다 크거나 같고, 100보다 작거나 같다.
	 *   - 1초
	 * 
	 * => BFS로 풀 경우 시간초과 발생
	 *     - 시간복잡도 O(n²) 이므로 1000*1000 = 1000000번의 경우의 수 모두 체크해야 함 
	 * => 만약 이동이 상하좌우와 같이 4방, 8방인 경우는 BFS, DFS등의 방법으로 전체 경우를 보면서 풀어야 한다!
	 * => 하지만 이 문제는 우측, 아래, 우측 대각선 처럼 한쪽 사분면으로 고정되어 있기 때문에 DP를 활용한다!!!
	 * 
	 * 시간: 480 ms
	 * 메모리: 76884 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1]; // 준규는 (1,1)에서 출발한다.
		
		// 사탕의 개수 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// DP 메모이제이션 활용하기
		int[][] memo = new int[N+1][M+1]; // 가져올 수 있는 사탕 최대값 저장
		
		// Bottom-up 방식
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				// 좌측, 위 두 방향 중 값이 가장 큰 것을 저장한다.
				// 최종 목표가 사탕을 최대한 많이 가져오는 것이기 때문에 대각선은 고려하지 않는다. (가장 짧은 루트임)
				memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]) + map[i][j];
			}
		}
		
		System.out.println(memo[N][M]);
	}

}
