package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {

	/**
	 * 문제
	 *  N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. 
	 *  N개의 자연수는 모두 다른 수이다.
	 *  중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 증가하는 순서로 출력해야 한다.
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 고른 수열은 오름차순이어야 한다.
	 *   - 1 ≤ M ≤ N ≤ 8
	 *   - 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
	 *   
	 * 시간: 80 ms
	 * 메모리: 11612 kb
	 */
	
	private static int[] input, output;
	private static boolean[] visited;
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		output = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		permutation(0);
	}
	
	public static void permutation(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			// 이미 방문했거나, 고른 수열이 오름차순이 아니면 skip
			if (visited[i]) continue;
			if (idx != 0 && output[idx-1] > input[i]) continue;
			
			output[idx] = input[i];
			visited[i] = true;
			
			permutation(idx+1);
			
			output[idx] = 0;
			visited[i] = false;
		}
	}

}
