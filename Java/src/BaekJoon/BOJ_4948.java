package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4948 {

	/**
	 * 문제
	 *  베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
	 *  이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
	 *  예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
	 *  자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
	 *   - 입력의 마지막에는 0이 주어진다.
	 *   - 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
	 *   - 1 ≤ n ≤ 123,456
	 * 
	 * => 에라토스 테네스의 체 활용하기
	 * => 2n까지 확인해야 하므로 범위는 123456 * 2 = 246,912
	 * 
	 * 시간: 136 ms
	 * 메모리: 12504 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isNotPrime = new boolean[246913];
		
		isNotPrime[1] = true; // 1은 소수가 아니다.
		
		// 2부터 특정 수의 배수 모두 지우기
		for (int i = 2; i < 246913; i++) {
			// 이미 소수가 아닌 수로 체크된 거라면 skip
			if (isNotPrime[i]) continue; 
			
			// 해당 수의 배수 모두 체크
			for (int j = 2*i; j < 246913; j+= i) {
				isNotPrime[j] = true;
			}
		}
		
		while(true) {
			
			int N = Integer.parseInt(br.readLine()); // 임의의 자연수
			
			// 마지막 입력이 0 들어오면 종료
			if (N == 0) break;
			
			int cnt = 0; // 소수 카운트
			
			// N 보다 크고 2N보다 작거나 같은 소수의 개수 구하기
			for (int i = N+1; i <= 2*N; i++) {
				if (!isNotPrime[i]) cnt++;
			}
			
			System.out.println(cnt);
		}
	}

}
