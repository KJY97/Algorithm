package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948 {

	/**
	 * 문제
	 *  게임을 좋아하는 큐브러버는 체스에서 사용할 새로운 말 "데스 나이트"를 만들었다. 
	 *  데스 나이트가 있는 곳이 (r, c)라면, (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)로 이동할 수 있다.
	 *  크기가 N×N인 체스판과 두 칸 (r1, c1), (r2, c2)가 주어진다. 
	 *  데스 나이트가 (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수를 구해보자. 체스판의 행과 열은 0번부터 시작한다.
	 *  데스 나이트는 체스판 밖으로 벗어날 수 없다. 이동할 수 없는 경우에는 -1을 출력한다.
	 *   - 체스판의 크기 N(5 ≤ N ≤ 200)
	 *   
	 * 시간: 92 ms
	 * 메모리: 12348 kb
	 */
	
	private static class Point {
		int x, y, cnt; // 행, 열, 이동 횟수

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static int N;
	private static int[][] deltas = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 체스판 크기
		
		// 출발 좌표와 도착 좌표 받기
		st = new StringTokenizer(br.readLine());
		int start_x = Integer.parseInt(st.nextToken());
		int start_y = Integer.parseInt(st.nextToken());
		int target_x = Integer.parseInt(st.nextToken());
		int target_y = Integer.parseInt(st.nextToken());
		
		System.out.println(BFS(start_x, start_y, target_x, target_y));
	}
	
	public static int BFS(int start_x, int start_y, int target_x, int target_y) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.add(new Point(start_x, start_y, 0));
		visited[start_x][start_y] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if (cur.x == target_x && cur.y == target_y) {
				return cur.cnt;
			}
			
			for (int d = 0; d < 6; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				int ncnt = cur.cnt + 1;
			
				// 범위를 벗어나거나 이미 확인한 경우
				if (!isRange(nx, ny) || visited[nx][ny]) continue;
				
				queue.add(new Point(nx, ny, ncnt));
				visited[nx][ny] = true;
			}
		}
		
		// 이동할 수 없는 경우
		return -1;
	}
	
	// 범위 안인가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}
