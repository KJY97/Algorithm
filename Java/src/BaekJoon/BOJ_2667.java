package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {

	/**
	 * 문제
	 *  <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
	 *  철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
	 *  여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. 
	 *  <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하라.
	 *   - 지도의 크기(정사각형) 5≤N≤25
	 *   - N개의 자료(0혹은 1)가 입력된다.
	 *   
	 * 시간 : 100 ms
	 * 메모리 : 12304 kb
	 */
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static char[][] map;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 각 단지내 집의 수 저장하는 리스트
		List<Integer> ans = new LinkedList<>();
		
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집이 없거나 이미 체크한 집이라면 pass
				if (map[i][j] == '0' || visited[i][j]) continue;
				
				// 단지의 개수 찾기
				ans.add(BFS(new Point(i,j), visited));
			}
		}
		
		// 오름차순 정렬
		Collections.sort(ans);
		
		// 총 단지 수 및 각 단지내 집 수 출력
		System.out.println(ans.size());
		for (Integer homeCnt : ans) {
			System.out.println(homeCnt);
		}
		
	}
	
	private static int BFS(Point start, boolean[][] visited) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start.x][start.y] = true;
		
		int cnt = 0; // 연결되어 있는 집의 개수
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			cnt++;
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 밖, 이미 방문, 집이 없는 곳이면 pass
				if (!isRange(nx,ny) || visited[nx][ny] || map[nx][ny] == '0') continue;
				
				visited[nx][ny] = true;
				queue.add(new Point(nx, ny));
			}
		}
		
		return cnt;
	}
	
	private static boolean isRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	private static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
