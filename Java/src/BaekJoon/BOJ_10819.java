package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {

	/**
	 * 문제
	 *  N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오
	 *   -----------------------------------------------------------
	 *     |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
	 *   -----------------------------------------------------------
	 *   - N (3 ≤ N ≤ 8)
	 *   - 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
	 *   - 시간 제한 1초
	 *   
	 * => 완전 탐색(브루트포스) 알고리즘 활용
	 * => 배열의 순서가 중요하므로 순열 알고리즘을 사용한다.
	 * => 순열 알고리즘의 시간 복잡도는 O(n!) 이므로, 8! = 40320
	 *    1억 = 1초 연산이므로 순열 알고리즘 사용 가능하다.
	 *    
	 * 시간: 108 ms
	 * 메모리: 12684 kb
	 */
	
	private static int N, MAX;
	private static int[] input, output;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		output = new int[N]; // 값의 순서를 바꾼 배열
		visited = new boolean[N]; // 순열 과정에서 이미 저장한 값 체크하는 배열
		
		// 배열 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		MAX = 0;
		permutation(0);
		
		System.out.println(MAX);
	}
	
	// 순서가 중요하므로 순열 알고리즘 (DFS 형식)
	private static void permutation(int idx) {
		if (idx == N) {
			
			int sum = 0;
			for (int i = 2; i <= N; i++) {
				sum += Math.abs(output[i-2] - output[i-1]);
			}
			
			MAX = Math.max(MAX, sum);
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			// 이미 저장한 값은 skip
			if (visited[i]) continue;
			
			visited[i] = true;
			output[idx] = input[i];
			
			permutation(idx+1);
			
			visited[i] = false;
			output[idx] = 0;
		}
	}

}
