package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2742 {

	/**
	 * 문제
	 *   N부터 1까지 한 줄에 하나씩 출력하기
	 *  
	 * 시간 : 1344 ms
	 * 메모리 : 31644 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100000
		
		for (int i = N; i >= 1; i--) {
			System.out.println(i);
		}
	}

}
