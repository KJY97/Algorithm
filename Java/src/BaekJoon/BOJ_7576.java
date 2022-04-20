package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

	/**
	 * 문제
	 *  철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
	 *  창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
	 *  보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	 *  하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 
	 *  대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
	 *  철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
	 *  토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
	 *  며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
	 *   - 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
	 *   - 2 ≤ M,N ≤ 1,000
	 *   - 익은 토마토 1, 익지 않은 토마토 0, 토마토가 없는 칸 -1
	 *   - 토마토가 모두 익지 못하는 상황이면 -1 출력
	 *   
	 * => BFS 사용
	 * 
	 * 시간 : 548 ms
	 * 메모리 : 120252 kb
	 */
	private static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
		Queue<int[]> queue = new LinkedList<>();
		
		// ========= 상자 초기화 =========
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수
		
		int[][] box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				// 저장될 때부터 익은 토마토 저장
				if(box[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		// ========= BFS 활용한 토마토가 모두 익을 때까지의 최소 날짜 구하기 =========
		
		// 토마토가 모두 익는데 얼마나 걸리는지 날짜 세는 변수
		// 처음 모든 토마토의 상태를 확인할 때, 모든 토마토가 익은 상태라면 0이 되면서 종료
		// 처음 익어있는 상태는 카운트에서 제외해야 한다.
		int day = -1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + deltas[d][0];
					int ny = cur[1] + deltas[d][1];
					
					// 범위 밖이거나, 토마토가 없는 칸 혹은 이미 익은 토마토라면 pass
					if(!isRange(nx, ny) || box[nx][ny] != 0) continue;
					
					box[nx][ny] = 1; // 하루 지나면서 토마토가 익음
					queue.add(new int[] {nx, ny});
				}
			}
			// 하루가 지남!
			day++;
		}
		
		// 토마토가 모두 익어있지 않다면
		if(!isAllOne(box)) day = -1;
		
		System.out.println(day);
	}
	
	// 좌표가 범위 안에 위치하는가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
	
	// box 안 토마토가 모두 익었는가?(=1)
	private static boolean isAllOne(int[][] box) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) return false;
			}
		}
		return true;
	}

}
