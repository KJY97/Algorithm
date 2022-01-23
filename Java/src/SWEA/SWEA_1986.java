package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SWEA_1986 {

	/**
	 * 문제
	 *  1부터 N까지의 숫자에서 홀수는 더하고 짝수는 뺐을 때 최종 누적된 값을 구해보자.
	 *   - 1 ≤ N ≤ 10
	 *   
	 * 시간: 107 ms
	 * 메모리: 17,428 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if(i % 2 != 0) sum += i;
				else sum -= i;
			}
			
			System.out.println("#" + test_case + " " + sum);
		}

	}

}
