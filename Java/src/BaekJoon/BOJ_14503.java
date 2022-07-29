package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {

	/**
	 * 문제
	 *  로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
	 *  로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 
	 *  각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 
	 *  지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
	 *  로봇 청소기는 다음과 같이 작동한다.
	 *   1. 현재 위치를 청소한다.
	 *   2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
	 *      1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	 *      2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	 *      3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	 *      4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
	 *  로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다. 로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
	 *   - 세로 크기 N과 가로 크기 M(3 ≤ N, M ≤ 50)
	 *   - 바라보는 방향 d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
	 *   - N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 
	 *   - 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.
	 *  
	 * 시간: 80 ms
	 * 메모리: 11840 kb
	 */
	
	private static int N, M, cnt;
	private static int[][] map;
	private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 로봇 청소기가 있는 칸의 세로 좌표
		int c = Integer.parseInt(st.nextToken()); // 로봇 청소기가 있는 칸의 가로 좌표
		int d = Integer.parseInt(st.nextToken()); // 로봇 청소기가 바라보는 방향
		
		// 1 : 벽, 0 : 빈칸
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0; // 청소하는 영역의 개수 세기
		
		// 청소 시작
		vacuumTheRoom(r, c, d);
		
		System.out.println(cnt);
	}
	
	public static void vacuumTheRoom(int r, int c, int dir) {
		
		while(true) {
			if (map[r][c] == 0) {
				map[r][c] = -1; // 청소한 표시
				cnt++;
			}
			
			boolean isAllCheck = true; // 네 방향 모두 체크
			
			// 현재 위치에서 현재 방향 기준으로 탐색 시작
			for (int d = 1; d <= 4; d++) {
				int nd = dir-d < 0 ? dir-d+4 : dir-d; // 왼쪽방향으로 회전
				
				int nr = r + direction[nd][0];
				int nc = c + direction[nd][1];
			
				// 주어진 장소 안이면서 벽이 아니고 청소하지 않은 공간이라면 전진
				if (isRange(nr, nc) && map[nr][nc] == 0) {
					r = nr; 
					c = nc;
					dir = nd;
					isAllCheck = false;
					break;
				}
			}
			
			// 네 방향 모두 청소가 이미 되어 있거나 벽인 경우
			if (isAllCheck) {
				// 바라보는 방향 유지한 채 한 칸 후진
				r = r - direction[dir][0];
				c = c - direction[dir][1];
				
				// 주어진 장소 밖이거나 벽을 만난 경우 작동을 멈춘다.
				if (!isRange(r, c) || map[r][c] == 1) return ;
			}
		}
	}
	
	// 주어진 장소 범위를 벗어나지 않았는가?
	public static boolean isRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

}
