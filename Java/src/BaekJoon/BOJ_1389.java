package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1389 {

	/**
	 * 문제
	 *  케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 6단계 이내에서 서로 아는 사람으로 연결될 수 있다.
	 *  케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.
	 *   ...요약...
	 *  케빈 베이컨은 미국 헐리우드 영화배우들 끼리 케빈 베이컨 게임을 했을때 나오는 단계의 총 합이 가장 적은 사람이라고 한다.
	 *  오늘은 Baekjoon Online Judge의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 찾으려고 한다. 
	 *  케빈 베이컨 수는 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합이다.
	 *   ...요약...
	 *  BOJ 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람을 구하는 프로그램을 작성하시오.
	 *   - 유저의 수 N (2 ≤ N ≤ 100)
	 *   - 친구 관계의 수 M (1 ≤ M ≤ 5,000)
	 *   
	 * 시간 : 84 ms
	 * 메모리 : 11772 kb
	 */
	
	private static List<Integer> list[];
	private static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 유저의 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		
		// 그래프 초기화
		list = new List[N+1]; // 1부터 사용.
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 그래프 작성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
		
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		// 케빈 베이컨의 수가 가장 적은 사람 구하기
		int answer = 0, min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int tmp = BFS(i);
			if(min > tmp) {
				min = tmp;
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[N+1]; // 1부터 사용
		
		queue.add(start);
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Integer next : list[cur]) {
				// 다음 관계가 관계의 시작(start)이거나 이미 거리 계산이 끝난 경우 pass
				if(next == start || distance[next] != 0) continue;
				
				distance[next] = distance[cur] + 1;
				queue.add(next);
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += distance[i];
		}
		
		return sum;
	}
}
