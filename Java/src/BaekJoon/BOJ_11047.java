package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {

	/**
	 * 문제
	 *  준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
	 *  동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하기
	 *   - 1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000
	 *   - 1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수
	 *   - 동전 가치는 오름차순으로 
	 *   
	 * 시간: 80 ms
	 * 메모리: 11524 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 동전의 종류
		int K = Integer.parseInt(st.nextToken()); // 가치의 합. 1 ≤ K ≤ 100,000,000
		
		// K원을 만드는데 필요한 동전의 최소 개수 구하기
		// 각각의 동전은 매우 많이 가지고 있다(오름차순으로 주어짐)
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		// 1. 자릿수가 비슷한 큰 수로 나누기
		// 2. 나머지 값에서 1번 반복
		int cnt = 0;
		for (int i = N-1; i >= 0; i--) {
			cnt += K / coin[i];
			K = K % coin[i];
		}
		System.out.println(cnt);
	}
}
