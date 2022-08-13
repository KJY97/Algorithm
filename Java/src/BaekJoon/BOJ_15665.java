package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15665 {

	/**
	 * 문제
	 *  N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	 *  중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	 *  수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 같은 수를 여러 번 골라도 된다.
	 *   - 1 ≤ M ≤ N ≤ 7
	 *   - 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
	 *   - 시간 제한은 1초이다.
	 * 
	 *  => System.out.println으로 하면 시간 초과 발생
	 *     그러므로 StringBuilder를 사용한다.
	 *     
	 * 시간: 300 ms
	 * 메모리: 44996 kb
	 */
	
	private static int N, M;
	private static int input[], output[];
	
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
		
		// 사전 순으로 출력하기 위해 정렬
		Arrays.sort(input);
		
		StringBuilder sb = new StringBuilder();
		permutation(0, sb);
		
		System.out.println(sb.toString());
	}
	
	private static void permutation(int idx, StringBuilder sb) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(' ');
			}
			sb.append('\n');
			return ;
		}
		
		int tmp = 0; // 중복을 방지하기 위한 이전 수 저장 변수
		for (int i = 0; i < N; i++) {
			
			// 이전 수와 동일하다면 skip
			if (tmp == input[i]) continue;
			
			output[idx] = input[i];
			
			permutation(idx+1, sb);
			
			tmp = input[i];
		}
	}

}
