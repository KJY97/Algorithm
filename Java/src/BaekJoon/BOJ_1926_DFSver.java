package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926_DFSver {

	/**
	 * 문제
	 *  어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
	 *  단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 
	 *  그림의 넓이란 그림에 포함된 1의 개수이다.
	 *  첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
	 *   - 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)
	 *   - 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다
	 *   
	 * 시간: 304 ms
	 * 메모리: 54164 kb
	 */
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static int maxSize, size, picCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		
		map = new int[N][M]; // 도화지
		
		// 도화지 그림 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		picCnt = 0; // 그림의 개수
		maxSize = 0; // 그림이 하나도 없는 경우 그림의 넓이는 0
		visited = new boolean[N][M]; // 방문 체크용
		
		// 그림의 넓이 중 가장 넓은 넓이 구하기. 1로 연결된 것이 한 그림이다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 이미 확인한 부분이거나 그림이 아니라면 skip
				if (visited[i][j] || map[i][j] == 0) continue;
				size = 0;
				DFS(i, j);
				picCnt++;
			}
		}
		
		// 그림의 개수 출력
		System.out.println(picCnt);
		// 가장 넓은 그림의 넓이 출력
		System.out.println(maxSize);
	}
	
	public static void DFS(int x, int y) {
		
		visited[x][y] = true;
		size++;
		
		if (maxSize < size) maxSize = size;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			// 범위 벗어나거나, 이미 확인한 영역, 색칠이 안되어 있는 영역이면 skip
			if(!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
			
			DFS(nx, ny);
		}
	}
	
	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}
