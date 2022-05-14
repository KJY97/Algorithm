package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_1504 {

	/**
	 * 문제
	 *  방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 
	 *  또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.
	 *  세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 
	 *  1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치는 최단 경로의 길이를 구하라. 그러한 경로가 없을 때에는 -1을 출력한다.
	 *   - 정점의 개수 N과 간선의 개수 E (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000)
	 *   - a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c (1 ≤ c ≤ 1,000)
	 *   - 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2 (v1 ≠ v2, v1 ≠ N, v2 ≠ 1)
	 *   - 임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.
	 * 
	 * => 최단경로 = 다익스트라
	 *   => INF의 개수 제한 계산 주의! Integer.MAX_VALUE 로 했다가 오류 나옴
	 *   
	 * 시간 : 720 ms
	 * 메모리 : 72076 kb
	 */
	
	private static int N, E;
	private static List<Point> list[];
	private static int INF = 200000 * 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// 무향 그래프 초기화
		list = new List[N+1]; // 1번부터 사용
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 간선 정보 초기화
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}
		
		// 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 - v1 -v2 - N
		int res1 = Dijkstra(1, v1);
		res1 += Dijkstra(v1, v2);
		res1 += Dijkstra(v2, N);
		
		// 1 - v2 - v1 - N
		int res2 = Dijkstra(1, v2);
		res2 += Dijkstra(v2, v1);
		res2 += Dijkstra(v1, N);
		
		// v1, v2를 반드시 거치는 최단 경로의 길이는? 없으면 -1
		int ans = (res1 < INF || res2 < INF) ? Math.min(res1, res2) : -1;
		System.out.println(ans);
	}
	
	public static int Dijkstra(int start, int end) {
		int[] distance = new int[N+1]; // 1번 정점부터 사용
		Arrays.fill(distance, INF);
		
		// 오름차순 정렬
		PriorityQueue<Point> queue = new PriorityQueue<>();
		
		queue.add(new Point(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			// 현재 정점이 이미 처리된 정점이라면 pass
			if (distance[cur.v] < cur.dis) continue;
			
			for (Point next : list[cur.v]) {
				// 현재의 최단거리 + 현재의 연결된 정점의 비용
				int cost = distance[cur.v] + next.dis;
				
				// 현재 정점을 거쳐서 다른 정점으로 이동하는 거리가 더 짧은 경우
				if (cost < distance[next.v]) {
					distance[next.v] = cost;
					queue.add(new Point(next.v, cost));
				}
			}
		}
		
		return distance[end];
	}

	public static class Point implements Comparable<Point>{
		int v, dis;

		public Point (int v, int dis) {
			this.v = v;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			return this.dis - o.dis;
		}
	}

}
