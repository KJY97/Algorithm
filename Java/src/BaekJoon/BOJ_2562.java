package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2562 {

	/**
	 * 문제
	 *  9개의 서로 다른 자연수 중 최대값과 그 최대값이 몇 번째 수인지 찾기
	 *  
	 * 시간 : 80 kb 
	 * 메모리 : 11444 ms
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0, idx = 0;
		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > max) {
				max = num;
				idx = i;
			}
		}
		
		System.out.println(max); // 최대값
		System.out.println(idx); // 그 최대값이 몇 번째 수인지
	}

}
