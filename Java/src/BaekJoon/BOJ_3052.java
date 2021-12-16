package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052 {

	/**
	 * 문제
	 *  10개의 수들을 각각 42로 나눈 나머지를 구하고, 서로 다른 나머지 값이 몇 개인지 구하기
	 *   - 10개의 수의 범위는 0 <= n <= 1000
	 *    
	 * 시간 : 72 ms
	 * 메모리 : 11484 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 42로 나누면 나머지는 0 ~ 41까지 나온다. (카운팅하기)
		int []num = new int[42];
		for (int i = 0; i < 10; i++) {
			num[Integer.parseInt(br.readLine()) % 42]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 42; i++) {
			if(num[i] != 0) cnt++;
		}
		
		System.out.println(cnt);
	}

}
