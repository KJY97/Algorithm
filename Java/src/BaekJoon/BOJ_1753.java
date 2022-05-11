package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

	/**
	 * 문제
	 *  방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
	 *   - 단, 모든 간선의 가중치는 10 이하의 자연수이다.
	 *   - 정점의 개수 V와 간선의 개수 E (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
	 *   - 시작 정점의 번호 K(1 ≤ K ≤ V)
	 *   - 간선을 나타내는 세 개의 정수 (u, v, w) u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. 
	 *   - u와 v는 서로 다르며 w는 10 이하의 자연수이다.
	 * 
	 * => 최단거리 = 다익스트라
	 *  => 우선순위 큐 사용하기
	 *  
	 * 시간 : 1068 ms
	 * 메모리 : 121080 kb
	 */
	private static List<Point> list[];
	private static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		
		// 방향 그래프 초기화
		list = new List[V+1]; // 1번 정점부터 사용
		for (int i = 1; i <= V; i++) {
			list[i] =  new LinkedList<>();
		}
		
		// 모든 간선 정보 입력받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// u번 정점에서 v번 정점으로 가는 가중치가 w
			list[u].add(new Point(v, w));
		}
		
		// 최단경로 구하기 = 다익스트라 알고리즘 이용하기 (우선순위 큐 사용)
		Dijkstra(K, V);
	}
	
	public static void Dijkstra(int start, int size) {
		// 최단거리 테이블
		int[] distance = new int[size+1]; // 1번 정점부터 사용
		// 최단거리 테이블 모두 무한으로 초기화
		Arrays.fill(distance, INF);
				
		// 오름차순으로 정렬
		PriorityQueue<Point> queue = new PriorityQueue<>();
		
		queue.add(new Point(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			// 가장 거리가 짧은 정점에 대한 정보 꺼내기
			Point cur = queue.poll();
			
			int vertex = cur.v; // 현재 정점 번호
			int weight = cur.w; // 현재 정점의 가중치
			
			// 현재 정점이 이미 처리된 적이 있는 정점이라면 무시
			if (distance[vertex] < weight) continue;
			
			for (Point next : list[vertex]) {
				// 현재의 최단거리 + 현재의 연결된 정점의 비용
				int cost = distance[vertex] + next.w;
				
				// 현재 정점을 거쳐서 다른 정점으로 이동하는 거리가 더 짧은 경우
				if (cost < distance[next.v]) {
					distance[next.v] = cost;
					queue.add(new Point(next.v, cost));
				}
			}
		}
		
		// 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력
		for (int i = 1; i <= size; i++) {
			if (distance[i] == INF) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static class Point implements Comparable<Point> {
		int v, w;

		public Point(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}

}
