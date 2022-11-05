package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {

	/**
	 * 문제
	 *  1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
	 *  ============================================
	 *    1234567891011121314151617181920212223...
	 *  ============================================
	 *  이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
	 *   - N(1 ≤ N ≤ 100,000,000)
	 *   - 제한시간 0.15초
	 * 
	 * 시간: 252 ms
	 * 메모리: 11560 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long size = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i < 10) size += 1;
			else if (i < 100) size += 2;
			else if (i < 1000) size += 3;
			else if (i < 10000) size += 4;
			else if (i < 100000) size += 5;
			else if (i < 1000000) size += 6;
			else if (i < 10000000) size += 7;
			else if (i < 100000000) size += 8;
			else if (i == 100000000) size += 9;
		}
		
		System.out.println(size);
	}

}
