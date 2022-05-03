package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {

	/**
	 * 문제
	 * 	방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
	 *   - 정점의 개수 N과 간선의 개수 M (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
	 *   - 간선의 양 끝점 u와 v (1 ≤ u, v ≤ N, u ≠ v)
	 *   
	 * 시간 : 620 ms
	 * 메모리 : 152284 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// 그래프 초기화 : 1번부터 사용
		List<Integer> list[] = new List[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 정점간 간선 정보 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		int cnt = 0; // 연결 요소 개수 구하기
		boolean[] visited = new boolean[N+1];
		
		// BFS를 몇 번 체크하는 지 카운트
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			BFS(list, i, visited);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	// BFS를 활용하여 각 정점간 간선 정보를 체크한다.
	private static void BFS(List<Integer>[] list, int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Integer next : list[cur]) {
				if(visited[next]) continue;
				queue.add(next);
				visited[next] = true;
			}
		}
	}
	

}
