package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {

	/**
	 * 문제
	 *  눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 
	 *  이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
	 *  예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다
	 *    ... 이미지 생략 ...
	 *  <그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.
	 *  M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 
	 *  그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 오름차순으로 출력하는 프로그램을 작성하시오.
	 *   - M, N, K는 모두 100 이하의 자연수이다.
	 *   - 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다
	 *   - 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다
	 *   - 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
	 *   
	 * 시간: 92 ms
	 * 메모리: 12056 kb
	 */
	
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static boolean[][] map;
	private static boolean[][] visited;
	private static int M, N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로 길이 
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		K = Integer.parseInt(st.nextToken()); // 직사각형 개수
		
		map = new boolean[M][N]; // 모눈종이
		
		// 1. 직사각형 좌표를 받고 그리기
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// 왼쪽 아래 꼭짓점
			int xl = Integer.parseInt(st.nextToken()); 
			int yl = Integer.parseInt(st.nextToken());
			// 오른쪽 위 꼭짓점
			int xr = Integer.parseInt(st.nextToken());
			int yr = Integer.parseInt(st.nextToken());
			
			// 2. 좌표 크기만큼의 직사각형 표시하기
			printRect(xl, yl, xr, yr);
		}
		
		// 3. 영역의 개수와 각 영역의 넓이 구하기
		List<Integer> area = new LinkedList<>(); // 각 영역의 넓이 저장
		visited = new boolean[M][N]; // 영역 방문 체크
		int cnt = 0; // 영역의 개수 카운트
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 이미 확인한 영역 or 사각형이 그려진 범위라면 skip
				if(visited[i][j] || map[i][j]) continue;
				cnt++;
				area.add(BFS(i, j));
			}
		}
		
		// 오름차순으로 출력하기 위해 영역 넓이 기준 정렬
		Collections.sort(area);
		
		// 4. 출력
		System.out.println(cnt);
		for (Integer size : area) {
			System.out.print(size + " ");
		}
	}
	
	public static void printRect(int xl, int yl, int xr, int yr) {
		for (int i = yl; i < yr; i++) {
			for (int j = xl; j < xr; j++) {
				map[i][j] = true;
			}
		}
	}
	
	public static int BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		
		visited[x][y] = true;
		queue.add(new int[] {x, y});
		
		int size = 0; // 영역의 개수 세기
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			size++;
			
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + deltas[d][0];
				int ny = cur[1] + deltas[d][1];
				
				// 범위 밖이거나, 이미 확인한 영역 or 사각형이 그려진 범위라면 skip
				if(!isRange(nx, ny) || visited[nx][ny] || map[nx][ny]) continue;
				
				visited[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}
		
		return size;
	}
	
	// 범위 확인
	public static boolean isRange(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N; 
	}

}
