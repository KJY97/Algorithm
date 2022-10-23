package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {

	/**
	 * 문제
	 *  N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	 *  N개의 자연수는 모두 다른 수이다.
	 *  중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 사전 순으로 증가하는 순서로 출력해야 한다.
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 같은 수를 여러 번 골라도 된다.
	 *   - 1 ≤ M ≤ N ≤ 7
	 *   - 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
	 *   - 제한시간 1초
	 * 
	 * => System.out.println()을 사용하는 경우 시간 초과가 발생하여, StringBuilder를 사용
	 * => 일종의 DFS 방식
	 * 
	 * 시간: 552 ms
	 * 메모리: 219988 kb
	 */
	
	private static int N, M;
	private static int[] input, output;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		output = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 증가하는 순서대로 출력하기 위해 오름차순 정렬
		Arrays.sort(input);
		
		permutation(0);
		System.out.println(sb.toString());
	}
	
	public static void permutation(int idx) {
		if (idx == M) {
			
			for (int num : output) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			output[idx] = input[i];
			permutation(idx+1);
		}
	}

}
