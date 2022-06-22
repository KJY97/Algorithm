package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {

	/**
	 * 문제
	 *  수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
	 *  수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
	 *  순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
	 *  수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
	 *  또한, 어떻게 이동해야 하는지 공백으로 구분해 출력하라.
	 *   - 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
	 *  
	 * 시간: 944 ms
	 * 메모리: 44084 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치
		
		BFS(N, K);
	}
	
	public static void BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		int[] time = new int[100001]; // 이동 시간 저장 및 방문 체크
		int[] next = new int[3]; // 다음 이동하는 위치 값 저장
		int[] move = new int[100001]; // 이동된 위치의 이전 위치, 즉 부모 위치 저장
		
		queue.add(start);
		time[start] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			next[0] = cur * 2;
			next[1] = cur + 1;
			next[2] = cur - 1;
			
			for (int i = 0; i < 3; i++) {
				// 범위 밖이거나, 이미 방문했다면 skip
				if(!isRange(next[i]) || time[next[i]] != 0) continue;
				
				queue.add(next[i]);
				time[next[i]] = time[cur] + 1;
				move[next[i]] = cur;
			}
		}
		
		// 수빈이가 동생을 찾은 가장 빠른 시간
		System.out.println(time[end] - 1);
		
		// stack을 사용하여 move에 저장된 부모 위치들 저장하기. pop하면 start부터 출력 가능하기 때문이다. 
		Stack<Integer> stack = new Stack<>();
		
		while(end != start) {
			stack.push(end);
			end = move[end];
		}
		// start 저장
		stack.push(end);
		
		// 이동해야 하는 위치 출력
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static boolean isRange(int x) {
		return 0 <= x && x <= 100000;
	}

}
