package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613 {

	/**
	 * 문제
	 *  양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
	 *   - 테스트 케이스의 개수 t (1 ≤ t ≤ 100)
	 *   - 수의 개수 n (1 < n ≤ 100)
	 *   - 입력으로 주어지는 수는 1,000,000을 넘지 않는다.
	 *   - 제한시간 1초
	 * 
	 * => N=100이고 모든 수가 100만일 때, gcd의 합이 int의 범위를 넘어가므로 long을 사용한다
	 * 
	 * 시간: 76 ms
	 * 메모리: 11556 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 수의 개수
			int[] num = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					sum += gcd(num[i], num[j]);
				}
			}
			
			System.out.println(sum);
		}

	}
	
	public static long gcd(int a, int b) {
		// a에 큰값이 오도록
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		// 유클리드 알고리즘
		// b가 0이 될때까지 반복문을 돈다.
		while(b != 0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		
		return a;
	}

}
