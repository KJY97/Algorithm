package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {

	/**
	 * 문제
	 *  M이상 N이하의 소수를 모두 출력하기
	 *   - 1 ≤ M ≤ N ≤ 1,000,000
	 * 
	 * => 약수의 중심을 구하는 방법 원리 사용
	 * 	  예를 들어 80의 약수는 {1, 2, 4, 5, 8, 10, 16, 20, 40, 80}이고 √80 = 8.xxx
	 *    즉, 약수들의 곱(1x80, 2x40, 4x20 ..)으로 봤을 때 루트를 씌운 값이 중간값이 된다.
	 *    그러므로 2 ~ √num 값 까지 값을 탐색하고 그 이후 값은 확인하지 않는다. 
	 *    시간복잡도는 O(√N)
	 *    
	 * 시간: 1460 ms
	 * 메모리: 28284 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = M; i <= N; i++) {
			if(isPrime(i)) System.out.println(i);
		}
	}
	
	// 소수인지 아닌지 판단
	public static boolean isPrime(int num) {
		// 2 미만 수는 소수가 아님
		if(num < 2) return false;
		
		// 해당 숫자의 √num 까지 체크
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false; 
		}
		return true;
	}

}
