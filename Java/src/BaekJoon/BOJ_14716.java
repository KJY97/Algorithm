package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14716 {

	/**
	 * 문제
	 *  ANT가 처음 알고리즘 대회를 개최하게 되면서 현수막을 내걸었다.
	 *  저번 학기 영상처리 수업을 듣고 배웠던 지식을 최대한 응용 해보고 싶은 혁진이는 이 현수막에서 글자가 몇 개인지 알아보는 프로그램을 만들려 한다.
	 *  혁진이는 우선 현수막에서 글자인 부분은 1, 글자가 아닌 부분은 0으로 바꾸는 필터를 적용하여 값을 만드는데 성공했다.
	 *  그런데 혁진이는 이 값을 바탕으로 글자인 부분 1이 상, 하, 좌, 우, 대각선으로 인접하여 서로 연결되어 있다면 한 개의 글자라고 생각만 하였다.
	 *  혁진이가 필터를 적용하여 만든 값이 입력으로 주어졌을 때, 혁진이의 생각대로 프로그램을 구현하면 글자의 개수가 몇 개인지 출력하여라.
	 *   - 현수막의 크기인 M와 N(1 ≤ M, N ≤ 250)
	 *   - 현수막의 정보가 1과 0으로 주어지며, 1과 0을 제외한 입력은 주어지지 않는다.
	 *   - 시간제한 2초
	 * 
	 * => 너비 우선 탐색(BFS) 활용
	 * 
	 * 시간: 204 ms
	 * 메모리: 21340 kb
	 */
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N, M;
	private static int[][] banner;
	private static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		banner = new int[N][M];
		
		// 글자가 있는 부분은 1, 없는 부분은 0으로 저장된다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				banner[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0; // 현수막에 있는 글자 수
		boolean[][] visited = new boolean[N][M]; // 글자 확인 처리 용도
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 이미 확인했거나 글자가 없는 곳이라면 skip
				if (visited[i][j] || banner[i][j] == 0) continue;
				BFS(visited, i, j);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	private static void BFS(boolean[][] visited, int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위를 벗어났거나, 이미 확인 or 글자가 없는 곳이라면 skip
				if (!isRange(nx, ny) || visited[nx][ny] || banner[nx][ny] == 0) continue;
				
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	// 범위 안인가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}
