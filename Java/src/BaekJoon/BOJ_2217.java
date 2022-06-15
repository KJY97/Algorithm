package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {

	/**
	 * 문제
	 *  N(1 ≤ N ≤ 100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다. 
	 *  각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.
	 *  하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
	 *  k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
	 *  각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오. 
	 *  모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.
	 *   - 최대 중량 값은 10,000을 넘지 않는 자연수이다.
	 *   
	 * => 그리디 알고리즘
	 * => 병렬로 하는 경우, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
	 *   => 즉, 버티는 최대 중량이 가장 작은 로프 x 로프의 개수 (g x k)
	 *   => 그러나 모든 로프를 사용할 필요는 없으므로, 모든 로프를 사용한 경우부터 시작해서 버티는 최대 중량이 가장 큰 로프만 사용하는 경우까지 모두 고려
	 *   
	 * 시간: 272 ms
	 * 메모리: 24644 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 로프 개수
		int[] rope = new int[N];
		
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		// 오름차순으로 정렬
		Arrays.sort(rope);
		
		// 버티는 최대 중량이 가장 작은 로프부터 시작해서(병렬) 가장 큰 로프만 사용하는 경우까지 모두 계산
		// 병렬로 사용할 경우, 모든 로프에 적용되는 중량은 w/k이므로 가장 작은 로프를 기준으로 물체의 중량을 구한다.
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, rope[i] * (N-i));
		}
		
		System.out.println(max);
	}
	
}
