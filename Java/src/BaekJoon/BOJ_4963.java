package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

	/**
	 * 문제
	 *  정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
	 *  한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 
	 *  두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
	 *  지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
	 *   - 지도의 너비 w와 높이 h
	 *   - w와 h는 50보다 작거나 같은 양의 정수이다.
	 *   - 1은 땅, 0은 바다이다.
	 *   - 입력의 마지막 줄에는 0이 두 개 주어진다.
	 *   
	 * 시간: 140 ms
	 * 메모리: 13808 kb
	 */

	private static int w, h;
	private static int[][] map;
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken()); // 지도의 너비
			h = Integer.parseInt(st.nextToken()); // 지도의 높이
			
			// 테스트 케이스 입력 종료
			if (w == 0 && h == 0) break;
			
			// 지도 초기화
			map = new int[h][w]; 
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0; // 섬의 개수
			boolean[][] visited = new boolean[h][w]; // 구역 체크용
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 이미 확인한 구역 or 바다 구역인 경우 skip
					if (visited[i][j] || map[i][j] == 0) continue;
					
					BFS(i, j, visited);
					ans++;
				}
			}
			
			System.out.println(ans);
		}
		
	}
	
	private static void BFS(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			// 가로, 세로, 대각선 모두 체크
			for (int d = 0; d < 8; d++) {
				int nx = cur[0] + deltas[d][0];
				int ny = cur[1] + deltas[d][1];
				
				// 지도 범위를 벗어나거나 이미 확인한 구역 or 바다 구역인 경우 skip
				if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
				
				queue.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
	
	// 지도 범위 내인가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < h && 0 <= y && y < w;
	}

}
