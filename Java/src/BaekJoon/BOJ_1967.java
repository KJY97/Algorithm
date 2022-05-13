package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967 {

	/**
	 * 문제
	 *  트리(tree)는 사이클이 없는 무방향 그래프이다. 트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다. 
	 *  이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.
	 *   ...
	 *  이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다. 정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.
	 *   - 노드의 개수 n(1 ≤ n ≤ 10,000)
	 *   - 간선에 대한 정보는 3개의 정수로 이뤄짐
	 *   - 부모 노드 번호 ,자식 노드 번호, 간선의 가중치
	 *   - 루트 노드의 번호는 항상 1이라고 가정하며, 간선의 가중치는 100보다 크지 않은 양의 정수이다.
	 *   
	 * 시간 : 180 ms
	 * 메모리 : 20164 kb
	 */
	private static List<Point> list[];
	private static int maxDis, maxV;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수
		
		// 무향 그래프 초기화
		list = new List[N+1]; // 1번 정점부터 사용
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 간선 정보 입력받기
		for (int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken()); // 부모 노드 번호
			int v = Integer.parseInt(st.nextToken()); // 자식 노드 번호
			int w = Integer.parseInt(st.nextToken()); // 간선의 가중치
			
			list[u].add(new Point(v, w));
			list[v].add(new Point(u, w));
		}
		
		maxDis = 0; maxV =0 ;
		
		// 루트에서 가장 먼 노드 구하기
		DFS(1, 0, new boolean[N+1]);
		// maxV에서 가장 먼 노드 구하기
		DFS(maxV, 0, new boolean[N+1]);
		
		// 트리의 지름 출력
		System.out.println(maxDis);
	}
	
	public static void DFS(int curV, int sumDis, boolean[] visited) {
		if (sumDis >= maxDis) {
			maxDis = sumDis;
			maxV = curV;
		}
		
		visited[curV] = true;
		
		for (Point next : list[curV]) {
			if (visited[next.v]) continue;
			DFS(next.v, sumDis + next.dis, visited);
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
