package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2058 {

	/**
	 * 문제
	 *  하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하기
	 *   - 1 ≤ N ≤ 9999
	 *  
	 * 시간: 97 ms
	 * 메모리: 16,080 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int sum = 0;
		for (int i = N.length() - 1; i >= 0; i--) {
			sum += N.charAt(i) - '0';
		}
		System.out.println(sum);		
	}

}
