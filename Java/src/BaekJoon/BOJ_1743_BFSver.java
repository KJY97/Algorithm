package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_BFSver {

	/**
	 * 문제
	 *  코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 
	 *  그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 
	 *  이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다.
	 *  통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 
	 *  선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.
	 *  첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.
	 *   - 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100), 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)
	 *   
	 * => 인접한 음식물 끼리 붙을 수 있으므로 상화좌우로만 따진다. (대각선 ㄴㄴ)
	 * => BFS 이용
	 * 
	 * 시간: 136 ms
	 * 메모리: 13920 kb 
	 */
	
	private static int N, M, K;
	private static int map[][];
	private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1]; // (1,1)에서부터 시작
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1; // 음식물 쓰레기 표시
		}
		
		int ans = 0; // 가장 큰 음식물의 크기
		boolean visited[][] = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				// 이미 확인한 구역 or 빈 공간이라면 skip
				if (visited[i][j] || map[i][j] == 0) continue; 
				
				ans = Math.max(ans, BFS(i, j, visited));
			}
		}
		
		System.out.println(ans);
	}
	
	// 음식물 쓰레기가 인접하게 있다면 queue에 저장한다.
	private static int BFS(int x, int y, boolean visited[][]) {
		Queue<Point> queue = new LinkedList<>();
		
		visited[x][y] = true;
		queue.add(new Point(x, y));
		
		int cnt = 0; // 현재 서로 인접하게 있는 음식물의 개수 카운트
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			cnt++;
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 구역을 벗어나거나 이미 확인한 구역 or 빈 구역인 경우 skip
				if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true;
				queue.add(new Point(nx, ny));
			}
		}
		
		return cnt;
	}
	
	// 구역안에 있는가?
	private static boolean isRange(int x, int y) {
		return 1 <= x && x <= N && 1 <= y && y <= M;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

}
