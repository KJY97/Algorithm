package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

	/**
	 * 문제
	 *  N×M크기의 배열로 표현되는 미로가 있다.
	 *  미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
	 *  이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하라.
	 *  한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
	 *   - 2 ≤ N, M ≤ 100
	 *   
	 * 시간 : 92 ms
	 * 메모리 : 12292 kb
	 */
	private static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	private static char[][] map;
	private static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// (1,1)에서 출발하는 것이 나니 (0,0)에서 출발
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		BFS();
	}
	
	private static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		int[][] distance = new int[N][M]; // 지나가는 칸 수 저장
		
		// (0,0)에서 출발
		queue.add(new Point(0,0));
		distance[0][0] = 1;

		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 밖이거나 이동할 수 없는 칸 혹은 이미 방문했다면 pass
				if(!isRange(nx, ny) || map[nx][ny] == '0' || distance[nx][ny] != 0) continue;
				
				queue.add(new Point(nx, ny));
				distance[nx][ny] = distance[cur.x][cur.y] + 1;
			}
		}
		
		// (1,1)이 아닌 (0,0)에서 시작했으므로 -1을 해준다.
		System.out.println(distance[N-1][M-1]);
	}
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}
