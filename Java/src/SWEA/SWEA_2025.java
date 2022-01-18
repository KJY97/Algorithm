package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2025 {

	/**
	 * 문제
	 *  정수 N 의 약수를 오름차순으로 출력하는 프로그램을 작성하기
	 *   - 1 ≤ N ≤ 1,000
	 *   
	 * 시간: 95 ms
	 * 메모리: 16,076 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 1; i <= num; i++) {
			if(num % i == 0) System.out.print(i + " ");
		}
	}

}
