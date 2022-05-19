package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {

	/**
	 * 문제
	 *  NxM 위 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간 구하기
	 *   - 하나의 치즈 격자의 4변 중 2변 이상이 실내온도(외부)와 접촉하면 한시간만에 녹아 없어진다.
	 *   - 치즈 내부의 공기는 상관없다
	 *   - map의 맨 가장자리에는 치즈가 놓이지 않는다.
	 *   - N, M (5 ≤ N, M ≤ 100)
	 *   - 치즈가 있는 부분은 1, 없는 부분은 0
	 *   
	 *  => BFS 사용
	 *  => 치즈 바깥 주변이 0으로 둘러 쌓여 있는지 판단
	 *  => 치즈가 없는 부분을 큐에 저장해서 바깥 부분만 탐색한다(치즈 안쪽 공간 저장X)
	 *  
	 * 시간: 228 ms
	 * 메모리: 43744 kb
	 */
	
	private static int N, M;
	private static int[][] map;
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 격자 수
		M = Integer.parseInt(st.nextToken()); // 가로 격자 수
		
		// 모눈종이 초기화
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		// 모든 치즈가 녹을 때까지 반복
		do {
			time++;
			melted();
		} while(!isEverythingMelted());
		
		System.out.println(time);
	}
	
	// 모든 치즈가 녹았는가?
	public static boolean isEverythingMelted() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	// 실온에 노출된 치즈 녹이기 (BFS 이용)
	public static void melted() {
		// 실내 공기의 좌표를 저장한다.
		Queue<Point> queue = new LinkedList<>();
		// 방문 처리 체크
		boolean[][] visited = new boolean[N][M];
		
		// map 복사 (원본을 지키기 위해 복사)
		// 2변 이상 실내 공기와 접촉한 치즈를 체크
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		}
		
		queue.add(new Point(0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 밖이거나 이미 체크한 경우 pass
				if (!isRange(nx, ny) || visited[nx][ny]) continue;
				
				// 실내 공기와 접촉하는 치즈라면
				if (map[nx][ny] == 1) copyMap[nx][ny]++;
				else {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		// 모든 모눈종이를 탐색이 끝나고..
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 저장된 값이 3이상인 치즈 제거 (기존 저장된 값이 1이기 때문)
				if (copyMap[i][j] >= 3) map[i][j] = 0;
			}
		}
	}
	
	// 모눈종이 범위 안인가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
