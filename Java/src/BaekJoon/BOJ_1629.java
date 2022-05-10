package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

	/**
	 * 문제
	 *  자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
	 *   - 시간 제한 0.5초
	 *   - A, B, C는 모두 2,147,483,647 이하의 자연수
	 * 
	 * => 분할정복 이용하기
	 *  => A x A x A x A x A = (A³)² = (A² x A)²
	 *  => O(log₂N)
	 *  => 일반 반복문 사용 시 O(N) 이므로 시간 초과
	 *  
	 * 시간 : 76 ms
	 * 메모리 : 11464 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(getExpoDivide(A,B,C));
	}
	
	/**
	 * 분할정복을 이용한 곱하기
	 * @param A : 곱하는 값
	 * @param n : 곱하는 횟수
	 * @param MOD : 나누는 값
	 * @return
	 */
	private static long getExpoDivide(int A, int n, int MOD) {
		if (n == 1) return A % MOD;
		
		// 지수가 짝수일 때
		if (n % 2 == 0) {
			long res = getExpoDivide(A, n/2, MOD);
			return (res * res) % MOD;
		}
		
		// 지수가 홀수일 때
		long res = getExpoDivide(A, (n-1)/2, MOD);
		return (((res * res) % MOD) * A) % MOD;
	}

}
