package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {

	/**
	 * 문제
	 *  주어진 N개 중에서 소수가 몇 개인지 찾아서 출력하기
	 *   - 주어지는 수는 1,000 이하의 자연수
	 * => 에라토스테네스의 체 사용하기
	 * 
	 * 시간 : 80 ms
	 * 메모리 : 11544 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 100이하
		
		// 소수 구하는 배열 - 에라토스테네스의 체
		// 소수는 false, 소수가 아니면 true 값을 가진다.
		boolean[] isNotPrime = new boolean[1001];
		isNotPrime[0] = isNotPrime[1] = true; // 0과 1인 소수가 아니다.
		
		for (int i = 2; i <= 1000; i++) {
			// 이미 지워진 수 pass
			if(isNotPrime[i]) continue; 
		
			// 지워진 숫자가 아니라면, 그 배수부터 출발하여 모든 숫자 비교 & 지우기
			for (int j = 2 * i; j <= 1000; j += i) {
				isNotPrime[j] = true; // 소수가 아님
			}
		}
		
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if(!isNotPrime[idx]) cnt++;
		}
		System.out.println(cnt);
	}

}
