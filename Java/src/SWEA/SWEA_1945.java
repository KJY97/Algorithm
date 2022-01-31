package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1945 {

	/**
	 * 문제
	 *  숫자 N은 N = 2^a x 3^b x 5^c x 7^d x 11^e 로 되어 있다.
	 *  a, b, c, d, e를 출력하라.
	 *   - 2 <= N <= 10_000_000
	 * 
	 * 시간: 101 ms
	 * 메모리: 19,264 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] decimal = {2, 3, 5, 7, 11};
			int[] cnt = new int[5]; // 소수의 개수 저장
			
			while(N != 1) {
				for (int i = 0; i < 5; i++) {
					if(N % decimal[i] == 0) {
						cnt[i]++;
						N = N / decimal[i];
					}
				}
			}
			
			// 출력
			System.out.print("#" + test_case);
			for (int i = 0; i < 5; i++) {
				System.out.print(" " + cnt[i]);
			}
			System.out.println();
		}

	}

}
