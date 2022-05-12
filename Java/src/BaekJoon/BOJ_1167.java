package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1167 {

	/**
	 * 문제
	 *  트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.
	 *   - 트리의 정점의 개수 V (2 ≤ V ≤ 100,000)
	 *   - 간선의 정보는 정점의 번호와 그 정점까지의 거리를 제공
	 *   - 각 줄의 마지막에는 -1이 입력으로 주어진다
	 *   - 주어지는 거리는 모두 10,000 이하의 자연수이다.
	 *   
	 * 시간 : 876 ms
	 * 메모리 : 102712 kb
	 */
	private static List<Point> list[];
	private static int maxDis, maxV;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int V = Integer.parseInt(br.readLine()); // 트리의 정점 수
		
		// 무향 그래프 초기화
		list = new List[V+1]; // 1번 정점부터 사용
		for (int i = 1; i <= V; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 간선 정보 입력받기
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken()); // 정점 번호
			while(true) {
				int v = Integer.parseInt(st.nextToken()); // 정점 u에 연결된 정점 번호
				
				// 마지막줄
				if (v == -1) break;
				
				int dis = Integer.parseInt(st.nextToken()); // 두 정점 사이의 거리
				list[u].add(new Point(v, dis));
			}
		}
		
		maxDis = 0; maxV = 0;

		// 1번 정점에서 가장 먼 정점
		DFS(1, 0, new boolean[V+1]);
		// maxV 정점에서 가장 먼 정점
		DFS(maxV, 0, new boolean[V+1]);
		
		// 트리의 지름
		System.out.println(maxDis);
	}
	
	// 깊이 우선 탐색
	// 처음 시작한 정점에서 계속 깊게 내려가서 가장 끝에 있는 정점을 찾는다
	public static void DFS(int cur, int disSum, boolean[] visited) {
		if (disSum >= maxDis) {
			maxDis = disSum;
			maxV = cur;
		}
		
		visited[cur] = true;
		
		for (Point next : list[cur]) {
			if (visited[next.v]) continue;
			DFS(next.v, disSum + next.dis, visited);
		}
	}
	
	public static class Point {
		int v, dis;

		public Point (int v, int dis) {
			this.v = v;
			this.dis = dis;
		}
	}
}
