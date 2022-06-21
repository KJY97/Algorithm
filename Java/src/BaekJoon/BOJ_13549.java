package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {

	/**
	 * 문제
	 *  수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
	 *  수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
	 *  순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
	 *  수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
	 *   - 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
	 * 
	 * => 가장 빠른 시간을 구하는 문제이므로 BFS 사용
	 * => 단, 가중치가 다르기 때문에 일반적인 BFS로 하면 오류 발생.
	 * => 순간이동 시 0초가 걸리므로 걷는 것보다 우선해서 처리
	 * => 즉, 우선순위 큐를 사용하며, 경과시간을 기준으로 오름차순 정렬한다.
	 * 
	 * => 방문체크를 현재 위치에서 해줘야 한다.. 이동했을 위치에서 처리하면 오류 발생
	 * 
	 * 시간: 152 ms
	 * 메모리: 16652 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치
		
		int answer = 0;
		
		if (K <= N) // 동생의 위치가 수빈이보다 뒤라면 초당 X-1하면서 찾아갈 수 밖에 없다.
			answer = N-K;
		else 
			answer = BFS(N, K);
		
		System.out.println(answer);
	}
	
	public static int BFS(int start, int end) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[100001]; // 방문체크
		int[] move = new int[3]; // 이동했을 때의 좌표 저장
		
		queue.add(new Point(start, 0));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			// 현재 위치 방문 체크
			visited[cur.x] = true;
			
			// 순간이동 혹은 걷고 난 후의 위치 저장
			move[0] = cur.x * 2;
			move[1] = cur.x - 1;
			move[2] = cur.x + 1;
			
			// 수빈이가 동생을 찾음
			if (cur.x == end) return cur.time;
			
			for (int d = 0; d < 3; d++) {
				int time = cur.time;
				
				// 범위 벗어나거나, 이미 방문했으면 skip
				if (!isRange(move[d]) || visited[move[d]]) continue;
				
				// 걷는다면 1초가 지남
				if (d != 0) time++;
				
				queue.add(new Point(move[d], time));
			}
		}
		
		// 여기까지 왔다는 것은 수빈이가 결국 동생을 못 찾았다는 것
		return -1;
	}
	
	// 범위 체크
	public static boolean isRange(int x) {
		return 0 <= x && x <= 100000;
	}
	
	public static class Point implements Comparable<Point> {
		int x, time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}

		// 오름차순으로 정렬
		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}

}
