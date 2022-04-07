package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {

	/**
	 * 문제
	 *  정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
	 *  ======================================
	 *   1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
	 *   2. X가 2로 나누어 떨어지면, 2로 나눈다.
	 *   3. 1을 뺀다.
	 *  ======================================
	 *  정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
	 *  연산을 사용하는 횟수의 최솟값을 출력하시오.
	 *  - 1 <= N <= 10⁶
	 *  
	 * 시간 : 104 ms
	 * 메모리 : 15700 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] memo = new int[N+1];
		
		for (int i = 2; i <= N; i++) {
			int min = memo[i-1] + 1; // 3. 1을 뺀다.
			
			if(i % 2 == 0) // 2. 2로 나누어 떨어지면 2로 나눈다.
				min = Math.min(memo[i/2] + 1, min);
			
			if(i % 3 == 0) // 1. 3으로 나누어 떨어지면 3으로 나눈다. 
				min = Math.min(memo[i/3] + 1, min);
			
			// 연산의 횟수 저장
			memo[i] = min;
		}
		
		System.out.println(memo[N]);
	}

}
