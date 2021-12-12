package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1504_배열ver {

	/**
	 * 문제
	 *  1번 정점 -> N번 정점으로 이동할 때 주어진 두 정점을 반드시 거치면서 최단 경로로 이동해야 한다.
	 *   - 방향성 없는 그래프
	 *   - 한번 이동했던 간선 다시 이동 가능
	 *   - 경로 없을 때는 -1 출력
	 *   => 다익스트라 이용하기(배열로 생성)
	 *   
	 * 풀이
	 *  INFINITY를 Integer.MAX_VALUE로 설정하면 
	 *  2 0
	 *  1 2
	 *  같은 경우에 -1이 아닌 2147483645이 출력됨(오버플로우 발생)
	 *  
	 * 시간 : 428 ms
	 * 메모리 : 57008 kb
	 */
	
	private static int N, E;
	private static int[][] matrix;
	private final static int INFINITY = 200000 * 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수. 2 ≤ N ≤ 800
		E = Integer.parseInt(st.nextToken()); // 간선 개수. 0 ≤ E ≤ 200,000
		
		// 간선 정보 입력
		matrix = new int[N+1][N+1]; // 1번부터 사용
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			// start->end의 거리는 dis
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken()); // 1 ≤ dis ≤ 1,000
			
			matrix[start][end] = matrix[end][start] = dis;
		}
		
		// 반드시 거쳐야 하는 정점 2개
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N
		int res1 = dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		// 1 -> v2 -> v1 -> N
		int res2 = dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		int ans = -1;
		if(res1 < INFINITY || res2 < INFINITY) ans = Math.min(res1, res2);
		
		System.out.println(ans);
	}
	
	// start에서 end까지의 최단 거리 찾는 알고리즘
	public static int dijkstra(int start, int end) {
		int[] distance = new int[N+1]; // 시작점에서 index까지의 최소 거리 저장 배열
		boolean[] visited = new boolean[N+1]; // 방문 정점 표시
		
		Arrays.fill(distance, INFINITY); // 배열 초기화
		distance[start] = 0;
		
		int min = 0, current = 0;
		for (int i = 1; i <= N; i++) { // 전체 정점 탐색
			
			// 1단계: 방문하지 않은 정점들 중 최소 가중치가 있는 정점 찾기
			min = INFINITY;
			for (int j = 1; j <= N; j++) {
				// 방문하지 않았고, 최소 가중치보다 작으면
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j; // 최소값 등장한 index
				}
			}
			
			visited[current] = true; // 선택 정점 방문 처리
			if(current == end) break; // end 정점에 도착하면 탈출
			
			// 2단계: current 정점을 경유지로 해서 갈 수 있는 다른 방문하지 않은 정점들이 있다면 처리하기
			for (int c = 1; c <= N; c++) {
				// 방문하지 않았고, 간선 이어져 있으며, 경유지+가중치 값이 최소 가중치보다 작다면
				if(!visited[c] && matrix[current][c] != 0 && distance[c] > min + matrix[current][c]) {
					distance[c] = min + matrix[current][c];
				}
			}
		}
		
		return distance[end];
	}
}
