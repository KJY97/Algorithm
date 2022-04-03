package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

	/**
	 * 문제
	 *  차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
	 *  농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.
	 *  이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
	 *  특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 
	 *  그 배추들 역시 해충으로부터 보호받을 수 있다. 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
	 *  한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다. 
	 *  배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 
	 *  총 몇 마리의 지렁이가 필요한지 알 수 있다. 예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다. 
	 *   - 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
	 *   - 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50)
	 *   - 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)
	 *   - K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
	 *   - 두 배추의 위치가 같은 경우는 없다.
	 * 
	 * => BFS를 이용해 인접해있는 배추들 찾기
	 * 
	 * 시간 : 116 ms
	 * 메모리 : 13776 kb
	 */
	
	private static int[][] deltas = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	private static int[][] map;
	private static int M, N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추 좌표 입력 개수
			
			map = new int[N][M]; // 배추밭
			
			// 배추밭에 배추 심기(초기화)
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken()); // 가로 위치
				int y = Integer.parseInt(st.nextToken()); // 세로 위치
				
				map[y][x] = 1;
			}
			
			int answer = 0; // 인접해있는 배추들의 개수 = 배추흰지렁이 마리 수
			
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 이미 방문했거나, 배추가 없는 땅(=0)이라면 pass
					if(visited[i][j] || map[i][j] == 0) continue;
					
					BFS(i,j,visited);
					answer++;
				}
			}
			
			System.out.println(answer);
		}

	}
	
	private static void BFS(int y, int x, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {y, x});
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = deltas[i][0] + cur[0]; // 세로 위치
				int nx = deltas[i][1] + cur[1]; // 가로 위치
				
				// 범위를 벗어나거나, 이미 방문을 했거나, 배추가 없는(0) 땅이라면 pass
				if(!isRange(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) continue;
				
				queue.add(new int[] {ny, nx});
				visited[ny][nx] = true;
			}
		}
	}
	
	private static boolean isRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}

}
