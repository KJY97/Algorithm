package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

	/**
	 * 문제
	 *  N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
	 *  당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
	 *  최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
	 *  만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
	 *  한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
	 *  맵이 주어졌을 때, 최단 경로를 구하고, 불가능할 때는 -1을 출력한다.
	 *   - 1 ≤ N ≤ 1,000
	 *   - 1 ≤ M ≤ 1,000
	 *   -  (1, 1)과 (N, M)은 항상 0이라고 가정한다.
	 *   
	 * => 벽을 부쉈는지 여부도 함께 체크한다.
	 * 
	 * 시간 : 688 ms
	 * 메모리 : 145224 kb
	 */
	
	private static int N, M;
	private static int[][] map;
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// map 초기화
		map = new int[N+1][M+1]; // (1,1)부터 사용
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = tmp.charAt(j-1) - '0';
			}
		}
		
		// (1,1)에서 출발
		// 최단거리 구하는 것이 불가능하면 -1 출력
		System.out.println(BFS(new Point(1, 1, 0)));
	}
	
	private static int BFS(Point start) {
		Queue<Point> queue = new LinkedList<>();
		int[][][] distance = new int[N+1][M+1][2]; // 행, 열, 벽을 부쉈는가?
		
		queue.add(start);
		distance[start.x][start.y][start.brokenWall] = 1;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int BW = cur.brokenWall;
			
			// 도착지점 (N, M)까지의 이동거리 반환
			if (x == N && y == M) {
				return distance[x][y][BW];
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				// 범위를 벗어나거나, 이미 지나간 경로라면
				if (!isRange(nx, ny) || distance[nx][ny][BW] != 0) 
					continue;
				
				// 빈 공간을 만나 이동 가능한 경우
				if (map[nx][ny] == 0) {
					queue.add(new Point(nx, ny, BW));
					distance[nx][ny][BW] = distance[x][y][BW] + 1;
				}
				
				// 벽이 있는 곳이지만, 벽을 부수고 이동이 가능한 경우
				if (map[nx][ny] == 1 && BW == 0) {
					queue.add(new Point(nx, ny, BW+1));
					distance[nx][ny][BW+1] = distance[x][y][BW] + 1;
				}
			}
		}
		
		// 도착지점에 도착하지 못한 경우
		return -1;
	}
	
	private static boolean isRange(int x, int y) {
		return 1 <= x && x <= N && 1 <= y && y <= M;
	}
	
	private static class Point {
		int x, y, brokenWall; // 행, 열, 벽을 부쉈는가?

		public Point(int x, int y, int brokenWall) {
			this.x = x;
			this.y = y;
			this.brokenWall = brokenWall;
		}
	}

}
