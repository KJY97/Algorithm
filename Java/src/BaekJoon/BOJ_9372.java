package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372 {

	/**
	 * 문제
	 *  상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다. 
	 *  하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.
	 *  이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자
	 *  상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
	 *  상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.
	 *   - 테스트 케이스의 수 T(T ≤ 100)
	 *   - 첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000)
	 *   - M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ n; a ≠ b) 
	 *   - 주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
	 * 
	 * 시간: 416 ms
	 * 메모리: 57796 kb
	 */
	
	private static List<Integer>[] list;
	private static int N, M, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 국가 수
			M = Integer.parseInt(st.nextToken()); // 비행기 종류
			
			// 국가 목록 초기화
			list = new List[N+1]; // 1번부터 사용
			for (int i = 1; i <= N; i++) {
				list[i] = new LinkedList<>();
			}
			
			// 비행기 종류 입력받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				// a와 b 서로 왕복하는 비행기
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			ans = 0;
			
			BFS();
			
			System.out.println(ans-1);
		}
	}
	
	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		// 첫번째 국가부터 방문 시작
		queue.add(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			
			// 국가 방문할때마다 카운트 증가
			ans++;
			
			for (Integer next : list[idx]) {
				// 이미 여행한 국가이므로 skip
				if (visited[next]) continue;
				
				visited[next] = true;
				queue.add(next);
			}
		}
	}

}
