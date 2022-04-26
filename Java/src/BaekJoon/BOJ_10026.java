package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

	/**
	 * 문제
	 *  적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
	 *  크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 
	 *  또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
	 *  예를 들어, 그림이 아래와 같은 경우에
	 *      RRRBB
	 *      GGBBB
	 *      BBBRR
	 *      BBRRR
	 *      RRRRR
	 *  적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
	 *  그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
	 *   - 1 ≤ N ≤ 100
	 * 
	 * 시간 : 100 ms
	 * 메모리 : 13052 kb
	 */
	
	private static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] isNotMan_Map = new char[N][N]; // 색약이 아닌 사람이 본 그림
		char[][] isMan_Map = new char[N][N]; // 색약인 사람이 본 그림
		
		// 그림 모습 초기화  (색약이 아닌 사람과 색약이 본 그림의 모습을 각각 담는다)
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				isNotMan_Map[i][j] = tmp[j];
				
				if(tmp[j] == 'G') isMan_Map[i][j] = 'R';
				else isMan_Map[i][j] = tmp[j];
			}
		}

		// 각각의 구역 수 구하기
		boolean[][] isNotMan_Visited = new boolean[N][N];
		boolean[][] isMan_Visited = new boolean[N][N];
		
		int isNot = 0, is = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 적록색약이 아닌 사람이 봤을 때의 구역 수 구하기
				if(!isNotMan_Visited[i][j]) {
					// 방문하지 않은 구역에만 접근
					BFS(new Point(i,j), isNotMan_Map, isNotMan_Visited);
					isNot++;
				}
				
				// 적록색약인 사람이 봤을 때의 구역 수 구하기
				if(!isMan_Visited[i][j]) {
					// 방문하지 않은 구역에만 접근
					BFS(new Point(i,j), isMan_Map, isMan_Visited);
					is++;
				}
			}
		}
		
		System.out.println(isNot + " " + is);
	}
	
	private static void BFS(Point start, char[][] map, boolean[][] visited) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start.x][start.y] = true;
		
		char target = map[start.x][start.y];
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위를 벗어난 경우, 타겟이 아닌 경우, 이미 방문한 경우는 pass
				if(!isRange(nx, ny) || map[nx][ny] != target || visited[nx][ny])
					continue;
				
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}
