package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {

	/**
	 * 문제
	 *  N과 K가 주어지면 (N, K)-요세푸스 순열 구하기
	 *   - 1 ~ N번의 사람이 원을 이루면서 앉아있고, K번째 사람을 제거하고 새로운 원을 이룬다.
	 *   - N명이 모두 제거될 때까지 반복
	 *   
	 * => 큐 사용!!!
	 * 
	 * 시간: 132 ms
	 * 메모리: 22308 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int idx = 1;
		
		sb.append('<');
		while(!queue.isEmpty()) {
			if(idx == K) {
				idx = 1;
				sb.append(queue.poll()).append(',').append(' ');
			}
			else {
				idx++;
				queue.offer(queue.poll());
			}
		}
		sb.setLength(sb.length()-2);
		sb.append('>');
		System.out.println(sb);
	}

}
