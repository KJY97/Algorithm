package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {

	/**
	 * 문제
	 *  신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 
	 *  한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
	 *   예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 가정한다. 
	 *   1번 컴퓨터가 웜 바이러스에 걸리면 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 4대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
	 *   하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
	 *  어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
	 *  컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하라.
	 *   - 1 <= 컴퓨터 수 <= 100
	 * 
	 * => BFS 사용
	 * 
	 * 시간 : 84 ms
	 * 메모리 : 11704 kb
	 */
	private static int N, E;
	private static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		E = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
		
		// N개의 컴퓨터 초기화
		list = new List[N+1]; // 1번부터 사용
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 그래프 초기화 (무방향 그래프)
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());
			
			list[V1].add(V2);
			list[V2].add(V1);
		}
		
		// 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수 구하기
		BFS();
	}
	
	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(1); // 1번 컴퓨터부터 웜 바이러스 감염
		visited[1] = true;
		
		int cnt = 0; // 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수 카운트
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;
			
			for (Integer next : list[cur]) {
				// 이미 방문한 컴퓨터(=정점)은 제외
				if(visited[next]) continue;
				
				visited[next] = true;
				queue.add(next);
			}
		}
		
		// 자기자신(1번 컴퓨터)는 제외
		System.out.println(cnt-1);
	}

}
