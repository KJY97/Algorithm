package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

	/**
	 * 문제
	 *  철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
	 *  토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
	 *  창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
	 *  보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	 *  하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
	 *  대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
	 *  철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
	 *  토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 최소 일수를 구하라.
	 *   단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
	 *    - 상자의 크기 가로 M, 세로 N (2 ≤ M,N ≤ 100)
	 *    - 쌓아올려진 상자의 수 H (1 ≤ H ≤ 100)
	 *    - 익은 토마토 1, 익지 않은 토마토 0, 토마토가 없는 칸 -1
	 *    - 토마토가 모두 익지 못하는 상황이면 -1 출력
	 * 
	 * => BFS 사용
	 * 
	 * 시간 : 624 ms
	 * 메모리 : 122600 kb
	 */
	
	private static int[][] deltas = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	private static int[][][] box;
	private static Queue<Point> queue;
	private static int M, N, H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 상자 크기의 가로
		N = Integer.parseInt(st.nextToken()); // 상자 크기의 세로
		H = Integer.parseInt(st.nextToken()); // 쌓아올려진 상자 수
		
		// 토마토 상자 초기화
		box = new int[H][N][M];
		queue = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					
					// 초기 익은 토마토 정보 저장(큐 초기화)
					if(box[i][j][k] == 1) {
						queue.add(new Point(k, j, i));
					}
				}
			}
		}
	
		System.out.println(BFS());
	}
	
	private static int BFS() {

		// 토마토가 모두 익을 때까지 걸리는 수 카운트
		// 처음 큐를 도는 것은 box에 있는 첫날 저장될 때부터 모든 토마토가 익어있는지 상태를 확인하는 용도
		// 즉, 처음부터 모두 익었다면 한번 탐색 후 0이 되고 끝나는 것이다.
		int day = -1; 
		while(!queue.isEmpty()) {
			// 하루 동안 인접부분을 탐색해야 할 익은 토마토 수
			int size = queue.size(); 
			
			// 하루가 지나면 익을 익지 않은 토마토 탐색
			for (int i = 0; i < size; i++) {
				Point cur = queue.poll();
				
				for (int d = 0; d < 6; d++) {
					int next_h = cur.h + deltas[d][0];
					int next_n = cur.n + deltas[d][1];
					int next_m = cur.m + deltas[d][2];
					
					// 범위 밖 or 익은 토마토가 아니거나 or 이미 접근했던 토마토라면 pass
					if (!isRange(next_m, next_n, next_h) 
							|| box[next_h][next_n][next_m] != 0) continue;
					
					queue.add(new Point(next_m, next_n, next_h));
					box[next_h][next_n][next_m] = 1; // 하루가 지나서 익은 토마토 표시
				}
			}
			day++; // 하루가 지남
		}
		
		// 토마토가 모두 익지 못했다면 
		if(!isAllOne()) day = -1;
		
		return day;
	}
	
	// 3차원 좌표 저장하는 클래스 생성
	private static class Point {
		int m, n, h;

		public Point(int m, int n, int h) {
			this.m = m;
			this.n = n;
			this.h = h;
		}
	}
	
	// 각 좌표가 모두 범위안에 존재하는가?
	private static boolean isRange(int m, int n, int h) {
		return 0 <= m && m < M && 0 <= n && n < N && 0 <= h && h < H;
	}
	
	// box에 있는  토마토는 모두 익은 토마토(=1)인가?
	private static boolean isAllOne() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(box[h][n][m] == 0) return false; 
				}
			}
		}
		return true;
	}
}
