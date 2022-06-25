package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12852 {

	/**
	 * 문제
	 *  정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
	 *    1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
	 *    2. X가 2로 나누어 떨어지면, 2로 나눈다.
	 *    3. 1을 뺀다.
	 *  정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
	 *  또한 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.
	 *  - N은 1보다 크거나 같고, 10⁶보다 작거나 같은 자연수
	 * 
	 * => DP, 역추적
	 * 
	 * 시간: 112 ms
	 * 메모리: 19448 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] memo = new int[N+1]; // 연산을 이용하는 횟수 저장
		int[] move = new int[N+1]; // 연산을 저장
		
		for (int i = 2; i <= N; i++) {
			// 3. 1 빼기
			memo[i] = memo[i-1] + 1; 
			move[i] = i-1;
			
			// 2. x가 2로 나누어 떨어지면, 2로 나눈다
			if(i % 2 ==0 && memo[i] > memo[i/2]+1) {
				memo[i] = memo[i/2]+1;
				move[i] = i / 2;
			}
			
			// 1. x가 3으로 나누어 떨어지면, 3으로 나눈다.
			if(i % 3 == 0 && memo[i] > memo[i/3]+1) {
				memo[i] = Math.min(memo[i], memo[i/3] + 1);
				move[i] = i / 3;
			}
		}
		
		// 연산하는 횟수 출력
		System.out.println(memo[N]);
		
		// N을 1로 만드는 연산 순서 출력
		while(N != 0) {
			System.out.print(N + " ");
			N = move[N];
		}
	}

}
