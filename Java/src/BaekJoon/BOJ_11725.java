package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {

	/**
	 * 문제
	 *  루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
	 *  첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
	 *   - 노드의 개수 N (2 ≤ N ≤ 100,000)
	 *   
	 * 시간: 2084 ms
	 * 메모리: 82464 kb
	 */
	
	private static List<Integer> tree[];
	private static int[] parent;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 노드의 개수
		
		// 트리 초기화 (1번 정점부터 사용)
		tree = new List[N+1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new LinkedList<>();
		}
		
		// 연결된 정점 정보 입력받기
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			tree[A].add(B);
			tree[B].add(A);
		}
		
		// 트리의 루트를 1이라 정하고, 각 노드 부모 구하기
		BFS();
		
		// 각 노드의 부모 노드 번호 2번 노드부터 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		parent = new int[N+1]; // 각 노드의 부모를 저장하는 배열
		
		queue.add(1);
		parent[1] = 1; // 루트의 부모는 자기 자신으로 표시
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Integer next : tree[cur]) {
				// 이미 부모를 확인한 노드는 skip
				if(parent[next] != 0) continue;
				
				queue.add(next);
				parent[next] = cur; // next 노드의 부모는 cur로 저장
			}
		}
	}

}
