package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

	/**
	 * 문제
	 *  N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. 
	 *  N개의 자연수는 모두 다른 수이다. (중복X)
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 1 ≤ M ≤ N ≤ 8
	 *   - 입력으로 주어지는 수 N개는 10,000보다 작거나 같은 자연수
	 *   - 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	 * 
	 * 시간: 2796 ms
	 * 메모리: 88576 kb
	 */
	
	private static int input[], output[]; // 입력 배열, 출력 배열
	private static boolean visited[];
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		output = new int[M+1];
		visited = new boolean[N+1];
		
		// input N까지 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(input);
		
		permutation(1);
	}
	
	public static void permutation(int idx) {
		// 기저조건: idx가 output 크기가 된 경우
		if (idx == M+1) {
			// 만족하는 수열 출력
			for (int i = 1; i <= M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			// 이미 고른 자연수 pass
			if (visited[i]) continue;
			
			visited[i] = true;
			output[idx] = input[i];
			
			permutation(idx+1);
			
			visited[i] = false;
		}
	}

}
