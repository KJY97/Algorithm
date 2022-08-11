package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15664 {

	/**
	 * 문제
	 *  N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	 *  한 줄에 하나씩 문제의 조건을 만족하는 수열을 사전 순으로 증가하는 순서로 출력한다. 
	 *  단, 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 고른 수열은 비내림차순이어야 한다. 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
	 *   - 1 ≤ M ≤ N ≤ 8
	 *   - 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
	 *   
	 * 시간: 80 ms
	 * 메모리: 11572 kb
	 */
	
	private static int N, M;
	private static int input[], output[];
	private static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		output = new int[M+1]; // 오름차순으로 저장됨
		visited = new boolean[N]; // 해당 숫자를 저장했는지 체크하는 배열
		
		// N개의 자연수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순으로 정렬
		Arrays.sort(input);
		
		permutation(1);
	}
	
	private static void permutation(int idx) {
		if (idx == M+1) {
			
			for (int i = 1; i <= M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		int tmp = 0; // 이전에 저장된 수 저장하는 변수
		for (int i = 0; i < N; i++) {
			// 이미 저장한 수 or 오름차순으로 저장되지 않는다면 skip
			if (visited[i] || output[idx-1] > input[i]) continue;
			
			// 이전과 동일한 수가 나온 경우 skip (중복되는 경우)
			if (tmp == input[i]) continue;
			
			output[idx] = input[i];
			visited[i] = true;
			
			permutation(idx+1);
			
			tmp = input[i];
			visited[i] = false;
		}
	}

}
