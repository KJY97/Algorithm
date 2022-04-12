package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	/**
	 * 문제
	 *  수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
	 *  수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
	 *  순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
	 *  수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
	 *  
	 * 시간 : 152 ms
	 * 메모리 : 21716 kb
	 */
	private static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
		
		if(N >= K) System.out.println(N-K);
		else BFS();
		
	}

	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		int[] time = new int[2*K+1]; // 동생의 위치에서 순간이동을 하는 경우도 고려해야 한다.

		queue.add(N);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			// 범위 안 이면서 미방문한 곳이면..
			if(isRange(cur + 1) && time[cur + 1] == 0) {
				queue.add(cur + 1);
				time[cur + 1] = time[cur] + 1;
			}
			
			if(isRange(cur - 1) && time[cur - 1] == 0) {
				queue.add(cur - 1);
				time[cur - 1] = time[cur] + 1;
			}
			
			if(isRange(cur * 2) && time[cur * 2] == 0) {
				queue.add(cur * 2);
				time[cur * 2] = time[cur] + 1;
			}
		}
		
		System.out.println(time[K]);
	}
	
	public static boolean isRange(int x) {
		return 0 <= x && x < 2 * K + 1;
	}
	

}
