package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

	/**
	 * 문제
	 *  N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 
	 *  한 칸에는 물고기가 최대 1마리 존재한다. 아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다.
	 *  가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
	 *  아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 
	 *  아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
	 *  아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
	 *    - 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
	 *    - 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
	 *    - 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
	 *      - 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
	 *      - 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
	 *  아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다.
	 *  즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
	 *  아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
	 *  공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
	 *  첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
	 *   - 공간의 크기 N(2 ≤ N ≤ 20)
	 *   - 둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.
	 *     - 0: 빈 칸
	 *     - 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
	 *     - 9: 아기 상어의 위치
	 *   - 아기 상어는 공간에 한 마리 있다.
	 *   - 시간제한은 2초
	 * 
	 * => 물고기와 아기 상어 까지의 최단 거리 구하기 - BFS 사용
	 * 
	 * 시간: 156 ms
	 * 메모리: 20016 kb
	 */
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N;
	private static int[][] map, distance;
	private static int shark_size, min_dist; // 아기 상어 크기, 가장 가까운 물고기와의 거리
	private static Point babyShark, minFish; // 아기 상어, 가장 가까운 물고기
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		N = Integer.parseInt(br.readLine()); // 공간의 크기
		map = new int[N][N]; // 공간 정보 저장
		distance = new int[N][N]; // 아기 상어의 이동 거리 저장
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 아기 상어 처음 위치
				if (map[i][j] == 9) {
					babyShark = new Point(i, j);
					map[i][j] = 0; // 초기화
				}
			}
		}
		
		shark_size = 2; // 처음 아기 상어 크기
		int eat_cnt = 0, result = 0; // 잡아먹은 개수, 잡아먹은 시간
		
		while(true) {
			
			// 가장 가까운 물고기 및 이동 거리 초기화
			init();
			
			// 가장 가까운 물고기 탐색
			BFS(babyShark);
			
			if (minFish != null) { // 먹을 수 있는 물고기가 있다면
				
				// 이동과 동시에 물고기 사냥. 상어 위치 갱신
				babyShark = minFish;
				
				// 물고기 위치로 이동했으므로 잡아먹은 시간에 이동 시간 더하기 
				result += distance[minFish.x][minFish.y];
				
				// 물고기 먹은 수 1 증가
				eat_cnt++; 
				
				// 물고기를 먹으면, 해당 칸은 빈 칸이 된다.
				map[minFish.x][minFish.y] = 0; 
				
				// 자신의 크기와 같은 수의 물고기를 먹었다면 아기 상어 크기 1 증가
				if (shark_size == eat_cnt) {
					shark_size++;
					eat_cnt = 0;
				}
			} 
			else { // 더 이상 먹을 물고기가 없다면 엄마 상어에게 도움 요청
				break;
			}
			
		}
		
		System.out.println(result);
	}
	
	// 물고기 및 이동 거리 초기화
	public static void init() {
		// 접근하지 않은 영역의 이동 거리는 -1로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], -1);
		}
		
		// 가장 가까운 물고기 초기화
		minFish = null;
		min_dist = Integer.MAX_VALUE;
	}
	
	// 가장 가까운 물고기 탐색하기
	public static void BFS(Point start) {
		Queue<Point> queue = new LinkedList<>(); // 아기 상어가 지나갈 수 있는 모든 영역 저장
		
		queue.add(start);
		distance[start.x][start.y] = 0; // 출발 위치 이므로 0
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 밖, 아기 상어보다 큰 물고기, 이미 접근한 영역이라면 skip
				if (!isRange(nx, ny) || map[nx][ny] > shark_size || distance[nx][ny] != -1) continue;
				
				// 이동 거리 1 증가
				distance[nx][ny] = distance[cur.x][cur.y] + 1; 
				
				// -- 가장 가까운 거리의 먹을 수 있는 물고기 구하기 --
				// 아기 상어는 자신의 크기보다 작은 물고기만 먹는다. 같은 크기의 물고기는 지나감
				if (map[nx][ny] != 0 && map[nx][ny] < shark_size) {
					
					if (min_dist > distance[nx][ny]) { // 거리가 가장 가까운 물고기를 먹는다.
						minFish = new Point(nx, ny);
						min_dist = distance[nx][ny];
					}
					else if (min_dist == distance[nx][ny]) { // 거리가 가까운 물고기가 많다면
						if (minFish.x > nx) { // 가장 위에 있는 물고기를 먹는다.
							minFish.setXY(nx, ny);
						} 
						else if (minFish.x == nx) { // 가장 위에 있는 물고기가 여러 마리면
							if (minFish.y > ny) { // 가장 왼쪽에 있는 물고기를 먹는다.
								minFish.setXY(nx, ny);
							}
						}
					}
				}
				
				queue.add(new Point(nx, ny));
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
}
