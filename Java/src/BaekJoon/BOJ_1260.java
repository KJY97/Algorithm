package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

	/**
	 * 문제
	 *  그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
	 *  단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
	 *   - 정점 번호는 1번부터 N번까지이다.
	 *   - 정점의 개수 N(1 ≤ N ≤ 1,000)
	 *   - 간선의 개수 M(1 ≤ M ≤ 10,000)
	 *   - 탐색을 시작할 정점의 번호 V
	 *   
	 * 시간 : 292 ms
	 * 메모리 : 19028 kb
	 */
	
	private static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호

		// 그래프 초기화
		list = new List[N+1]; // 1번부터 사용
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 그래프 정점 간 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		// 방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것부터 방문할 수 있도록 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		DFS(V, new boolean[N+1]);
		System.out.println();
		BFS(N, V);
	}
	
	public static void DFS(int cur, boolean[] visited) {
		visited[cur] = true;
		System.out.print(cur + " ");
		
		for (Integer next : list[cur]) {
			if(visited[next]) continue;
			DFS(next, visited);
		}
	}
	
	public static void BFS(int N, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			System.out.print(cur + " ");
			for (Integer next : list[cur]) {
				// 이미 방문한 정점은 pass
				if(visited[next]) continue;
				
				queue.add(next);
				visited[next] = true;
			}
		}
	}

}
