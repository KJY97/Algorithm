package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

	/**
	 * 문제
	 *  수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
	 *  수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
	 *  순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
	 *  수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고, 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하라.
	 *   - 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
	 *  
	 *  => 가장 빠른 시간을 찾는 것이므로 BFS 사용
	 *  => 방법의 가지 수를 구하기 위해서는 방문한 곳을 또 방문할 수 있다는 조건이 필요하다.
	 *  
	 * 시간: 188 ms
	 * 메모리: 39396 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치

		if (K <= N) {// 동생의 위치가 수빈이보다 뒤라면 초당 X-1하면서 찾아갈 수 밖에 없다.
			System.out.println(N-K);
			System.out.println(1);
		}
		else 
			BFS(N, K);
	}
	
	public static void BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		int[] time = new int[100001]; // 방문 처리 및 시간 체크
		int[] next = new int[3];
		
		queue.add(start);
		time[start] = 1; // 방문 표시를 위해 1 입력
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == end) cnt++;
			
			next[0] = cur * 2;
			next[1] = cur - 1;
			next[2] = cur + 1;
			
			for (int i = 0; i < 3; i++) {
				// 범위를 벗어나면 skip
				if(!isRange(next[i])) continue;
				
				// 한번도 방문하지 않았거나, 혹은 방문하더라도 현재 접근했을 때의 가중치 값보다 크거나 같은 경우 갱신을 위해 접근 허용
				if (time[next[i]] == 0 || time[next[i]] >= time[cur] + 1) {
					queue.add(next[i]);
					time[next[i]] = time[cur] + 1;
				}
			}
		}
		
		// 처음 시작할 때 +1을 주고 시작
		System.out.println(time[end] - 1);
		System.out.println(cnt);
	}
	
	public static boolean isRange(int x) {
		return 0 <= x && x <= 100000;
	}

}
