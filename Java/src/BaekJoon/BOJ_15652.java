package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {

	/**
	 * 문제
	 *  자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	 *   - 1부터 N까지 자연수 중에서 M개를 고른 수열
	 *   - 같은 수 중복 가능
	 *   - 고른 수열은 오름차순
	 *   - 1 ≤ M ≤ N ≤ 8
	 * 
	 * 시간: 588 ms
	 * 메모리: 23488 kb
	 */
	
	private static int input[], output[]; // 입력 배열, 출력 배열
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1번 인덱스부터 사용
		input = new int[N+1];
		output = new int[M+1];
		
		// input N까지 초기화
		for (int i = 1; i <= N; i++) {
			input[i] = i;
		}
				
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
			// 증가하는 순서가 아니라면 pass
			if (output[idx-1] > input[i]) continue;
			
			output[idx] = input[i];
			permutation(idx+1);
		}
	}
	
}
