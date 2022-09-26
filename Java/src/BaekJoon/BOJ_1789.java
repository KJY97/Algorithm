package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {
	
	/**
	 * 문제
	 *  서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
	 *   - 자연수 S(1 ≤ S ≤ 4,294,967,295)
	 *   - 시간제한 2초
	 * 
	 * => int의 범위(최대 20억)를 초과하기 때문에 long을 사용한다.
	 * 
	 * 시간: 84 ms
	 * 메모리: 11520 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine()); // N개의 자연수 합

		long N = 0;
		long sum = 0;
		
		while(sum + N < S) {
			sum += ++N;
		}
		
		System.out.println(N);
	}
	
}
