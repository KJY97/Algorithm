package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

	/**
	 * 문제
	 *  N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 
	 *  이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
	 *   - N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)
	 *   - 각각의 A[x]는 30,000을 넘지 않는 자연수이다.
	 *   - 시간 제한은 0.5초
	 * 
	 * => 30,000 * 10,000 = 300,000,000 이므로 int 범위에서 가능하다
	 * => 투포인터 알고리즘 활용하기
	 * 
	 * 시간: 112 ms
	 * 메모리: 14308 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1]; // end가 N까지 접근할 수 있도록 하기 위해
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0; // M이 되는 경우의 수
		int start = 0, end = 0, sum = 0; // 투 포인터 활용
		
		while(end <= N) {
			
			if (sum < M) {
				sum += arr[end++];
			} else if (sum >= M) {
				sum -= arr[start++];
			}
			
			if (sum == M) cnt++;
		}
		
		System.out.println(cnt);
	}

}
