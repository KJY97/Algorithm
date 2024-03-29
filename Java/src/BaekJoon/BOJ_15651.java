package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {

	/**
	 * 문제
	 *  자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	 *  중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	 *  수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	 *   - 1부터 N까지 자연수 중에서 M개를 고른 수열
	 *   - 같은 수를 여러 번 골라도 된다.
	 *   - 1 ≤ M ≤ N ≤ 7
	 *   - 제한시간 1초
	 * 
	 * 시간: 324 ms
	 * 메모리: 111532 kb
	 */
	
	private static int N,M;
	private static int[] output;
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		output = new int[M];
		func(0);
		
		System.out.println(sb.toString());
	}
	
	private static void func(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			output[idx] = i;
			func(idx+1);
		}
	}

}
