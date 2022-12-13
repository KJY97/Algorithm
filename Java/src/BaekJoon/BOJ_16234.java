package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

	/**
	 * 문제
	 *  N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 
	 *  각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
	 *  인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
	 *  오늘부터 인구 이동이 시작되는 날이다.
	 *  인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
	 *   - 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
	 *   - 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
	 *   - 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
	 *   - 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
	 *   - 연합을 해체하고, 모든 국경선을 닫는다.
	 *  각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
	 *   -  N, L, R(1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
	 *   - N개의 줄에 각 나라의 인구수가 주어진다.
	 *     r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)
	 *   - 인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.
	 *   - 제한시간 2초
	 *   
	 * 시간: 692 ms
	 * 메모리: 295636 kb
	 */
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N, L, R;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N]; // 나라
		visited = new boolean[N][N]; // 각 나라의 국경선이 열렸는지 확인
		
		// 나라 인구 수 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0; // 인구 이동 횟수
		boolean flag = true; // 반복문 탈출 flag
		while(flag) {
			// 국경선 초기화
			init();
			
			// 나라끼리 공유하는 구경선 open
			// 더 이상 이동이 불가능하다면 flag 변경
			if (!lineOpen()) 
				flag = false;
			else 
				ans++;
		}
		
		System.out.println(ans);
	}
	
	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}

	// 국경선 맞닿아있는 모든 나라끼리 인구 차이 확인 및 국경선 오픈
	private static boolean lineOpen() {
		boolean isUnion = false; // 연합이 형성되는가?
		
		// (0,0) ~ (N-1, N-1)을 돌면서 각 구역의 연합 형성하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 이미 확인한 구역이면 skip
				if (visited[i][j]) continue;
				
				// BFS를 통해 그룹 형성
				Queue<Point> queue = new LinkedList<>();
				List<Point> union = new LinkedList<>(); // 연합국 저장
				
				queue.add(new Point(i ,j));
				union.add(new Point(i, j));
				visited[i][j] = true; // 국경선 open
				
				int sum = map[i][j]; // 연합 인구의 합
				
				while(!queue.isEmpty()) {
					Point cur = queue.poll();
					
					for (int d = 0; d < 4; d++) {
						int nx = cur.x + deltas[d][0];
						int ny = cur.y + deltas[d][1];
												
						// 땅 범위를 벗어났거나, 이미 확인했다면 skip
						if (!isRange(nx, ny) || visited[nx][ny]) continue;
						// 인구 차이가 조건을 만족하지 못한다면 skip
						if (!isOpen(cur.x, cur.y, nx, ny)) continue;
						
						queue.add(new Point(nx, ny));
						union.add(new Point(nx, ny));
						visited[nx][ny] = true;
						sum += map[nx][ny];
						isUnion = true;
					}
				}
				
				// 연합이 형성되면 해당 연합끼리 이동
				// 인구는 똑같이 분배한다.
				if (isUnion) move(union, sum);
			}
		}
		
		return isUnion;
	}
	
	// 연합국끼리 인구 이동
	// 인구는 똑같이 분배
	private static void move(List<Point> union, int sum) {
		int tmp = sum / union.size();
		
		for (Point cur : union) {
			map[cur.x][cur.y] = tmp; 
		}
	}
	
	// 범위를 벗어났는가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	// 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하인가?
	private static boolean isOpen(int cx, int cy, int nx, int ny) {
		// 두 나라 인구 차이
		int diff = Math.abs(map[cx][cy] - map[nx][ny]);
		return L <= diff && diff <= R;
	}

}
