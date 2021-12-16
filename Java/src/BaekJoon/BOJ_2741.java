package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2741 {

	/**
	 * 문제
	 *  1부터 N까지 한 줄에 하나씩 출력하기
	 *  
	 * 시간 : 1344 ms
	 * 메모리 : 30984 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100000
		
		for (int i = 1; i <= N; i++) {
			System.out.println(i);
		}
	}

}
