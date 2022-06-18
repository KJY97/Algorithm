package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {

	/**
	 * 문제
	 *  효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 
	 *  효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
	 *    1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
	 *    2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
	 *  효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 
	 *  1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 
	 *  효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
	 *  예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 
	 *  첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다
	 *   - 포도주 잔의 개수 n(1 ≤ n ≤ 10,000) 
	 *   - 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
	 * 
	 * => DP(다이나믹 프로그래밍) 알고리즘 활용
	 * 
	 * 시간: 108 ms
	 * 메모리: 12892 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 포도주의 양
		int[] wine = new int[N+1];
		
		// 포도주의 양 입력
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		// 메모이제이션 사용
		// 가장 많이 마시는 방법의 값을 저장한다.
		int[] memo = new int[N+1];

		// 1번째 포도주만 마시는 경우
		memo[1] = wine[1];
		if(N >= 2) {
			// 1, 2번째 포도주 마시기
			memo[2] = wine[1] + wine[2];
		}
		
		for (int i = 3; i <= N; i++) {
			// 연속 3잔은 안되므로 2잔만 고른다.
			// 1, 2번째 포도주 마시기 or 1, 3번째 포도주 마시기 or 2, 3번째 포도주 마시기 중 가장 큰 값 저장
			memo[i] = Math.max(Math.max(memo[i-1], memo[i-2] + wine[i]), memo[i-3] + wine[i-1] + wine[i]);
		}
		
		System.out.println(memo[N]);
	}

}
