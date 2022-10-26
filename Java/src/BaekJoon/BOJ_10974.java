package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {

	/**
	 * 문제
	 *  N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
	 *  첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
	 *   - N(1 ≤ N ≤ 8)
	 *   
	 * 시간: 2796 ms
	 * 메모리: 89796 kb
	 */
	
	private static int N;
	private static int[] output;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		output = new int[N];
		visited = new boolean[N];
		
		DFS(0);
	}
	
	public static void DFS(int idx) {
		if (idx == N) {
			for (int num : output) {
				System.out.print(num + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			// 이미 저장한 수는 skip
			if (visited[i]) continue;
			
			output[idx] = i+1;
			visited[i] = true;
			
			DFS(idx+1);
			
			output[idx] = 0;
			visited[i] = false;
		}
	}

}
