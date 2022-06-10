package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {

	/**
	 * 문제
	 *  재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다. 먼저 어떤 지역의 높이 정보를 파악한다. 
	 *  그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.
	 *  이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
	 *  어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다. 
	 *  예를 들어, 다음은 N=5인 지역의 높이 정보이다.
	 *    ... 이미지 생략 ...
	 *  이제 위와 같은 지역에 많은 비가 내려서 높이가 4 이하인 모든 지점이 물에 잠겼다고 하자. 이 경우에 물에 잠기는 지점을 회색으로 표시하면 다음과 같다.
	 *  물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다.
	 *  위의 경우에서 물에 잠기지 않는 안전한 영역은 5개가 된다(꼭짓점으로만 붙어 있는 두 지점은 인접하지 않는다고 취급한다). 
	 *  또한 위와 같은 지역에서 높이가 6이하인 지점을 모두 잠기게 만드는 많은 비가 내리면 물에 잠기지 않는 안전한 영역은 아래 그림에서와 같이 네 개가 됨을 확인할 수 있다. 
	 *    ... 이미지 생략 ...
	 *  이와 같이 장마철에 내리는 비의 양에 따라서 물에 잠기지 않는 안전한 영역의 개수는 다르게 된다.
	 *  위의 예와 같은 지역에서 내리는 비의 양에 따른 모든 경우를 다 조사해 보면 물에 잠기지 않는 안전한 영역의 개수 중에서 최대인 경우는 5임을 알 수 있다. 
	 *  어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오. 
	 *   - 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N (2 <= N <= 100)
	 *   - 높이는 1이상 100 이하의 정수 
	 *   - 아무 지역도 물에 잠기지 않을 수도 있다.
	 *   
	 * 시간: 292 ms
	 * 메모리: 56984 kb
	 */
	
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static int[][] map;
	private static int N, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 행과 열의 개수
		answer = 0; // 물에 잠기지 않는 안정한 영역의 최대 개수
		
		map = new int[N][N];
		
		int maxHeight = 0; // 입력된 높이 중 가장 큰 높이
		
		// 지역의 높이 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		// 내리는 비의 양에 따른 모든 경우 체크
		// 아무 지역도 물에 잠기지 않을 수도 있으므로 0부터 시작한다.
		for (int h = 0; h <= maxHeight; h++) {
			rainfall(h);
		}
		
		System.out.println(answer);
	}
	
	// height이하인 모든 지점은 물에 잠긴다. -1로 표시
	private static void rainfall(int height) {
		int[][] arr = new int[N][N];
		
		// 물에 잠긴 지점 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] <= height)  arr[i][j] = -1;
				else arr[i][j] = map[i][j];
			}
		}
		
		boolean[][] visited = new boolean[N][N];
		int cnt = 0; // 안전한 영역 개수 세기
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 이미 확인한 지역이거나 물에 잠긴 지역은 skip
				if(visited[i][j] || arr[i][j] == -1) continue;
				
				BFS(i, j, arr, visited);
				cnt++;
			}
		}
		
		answer = Math.max(cnt, answer);
	}
	
	private static void BFS(int x, int y, int[][] arr, boolean[][] visited) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 밖이거나, 물에 잠긴 지역 혹은 이미 확인한 지역이면 skip
				if (!isRange(nx, ny) || arr[nx][ny] == -1 || visited[nx][ny]) continue;
				
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	// 범위 확인
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
