package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

	/**
	 * 문제
	 *  체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 
	 *   ... 그림 생략 ...
	 *  나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
	 *   - 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)
	 *   - 체스판의 크기는 l × l
	 * 
	 * => BFS (너비 우선 탐색) 이용
	 * 
	 * 시간: 252 ms
	 * 메모리: 77244 kb
	 */
	
	private static int L;
	private static int[][] map;
	// 나이트는 ㄱ자 모양으로 움직인다. 
	private static int[][] deltas = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		
		for (int test_case = 0; test_case < T; test_case++) {
			L = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
			
			map = new int[L][L]; // 체스판
			
			// 나이트가 현재 있는 칸
			st = new StringTokenizer(br.readLine());
			int cur_x = Integer.parseInt(st.nextToken());
			int cur_y = Integer.parseInt(st.nextToken()); 
			
			// 나이트가 이동하려고 하는 칸
			st = new StringTokenizer(br.readLine());
			int arr_x = Integer.parseInt(st.nextToken());
			int arr_y = Integer.parseInt(st.nextToken()); 
			
			// current에서 arrive까지의 이동 거리 구하기
			BFS(cur_x, cur_y, arr_x, arr_y);
		}

	}
	
	// start : 현재있는 칸, end : 도착해야 하는 칸
	private static void BFS(int start_x, int start_y, int end_x, int end_y) {
		Queue<int[]> queue = new LinkedList<>();
		int[][] distance = new int[L][L]; // 이동 거리 계산하기 위한 배열
		
		queue.add(new int[] {start_x, start_y});
		distance[start_x][start_y] = 1; // 접근했다는 의미로 1을 넣는다. 
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			if (cur[0] == end_x && cur[1] == end_y) break;
			
			for (int d = 0; d < 8; d++) {
				int nx = cur_x + deltas[d][0];
				int ny = cur_y + deltas[d][1];
				
				// 범위를 벗어나거나 이미 접근했거나 
				if (!isRange(nx, ny) || distance[nx][ny] != 0) continue;
				
				distance[nx][ny] = distance[cur_x][cur_y] + 1;
				queue.add(new int[] {nx, ny});
			}
		}
		
		// 현재 있는 칸에 1을 넣었기 때문에 1 빼주기
		System.out.println(distance[end_x][end_y] - 1);
	}
	
	// 범위 안에 있는가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < L && 0 <= y && y < L;
	}

}
