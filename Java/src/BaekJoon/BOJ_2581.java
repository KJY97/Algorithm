package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581 {

	/**
	 * 문제
	 *  자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
	 *  단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
	 *  예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 
	 *  이들 소수의 합은 620이고, 최솟값은 61이 된다.
	 *   - M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
	 * 
	 * => 에라토스테네스의 체 사용
	 * 
	 * 시간: 76 ms
	 * 메모리: 11456 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		
		// 에라토스테네스의 체 알고리즘
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N+1); i++) {
			if(prime[i]) continue; // 이미 체크된 경우 pass
			for(int j = i*i; j <= N; j += i) {
				prime[j] = true;
			}
		}
		
		// 소수 합과 최솟값 구하기
		int sum = 0; // 합
		int min = Integer.MAX_VALUE; // 최솟값
		for(int i = M; i <= N; i++) {
			if(!prime[i]) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		// 소수가 없으면 -1 출력
		if(sum == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
