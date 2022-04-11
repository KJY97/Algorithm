package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1676 {

	/**
	 * 문제
	 *  N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
	 *   - 0 ≤ N ≤ 500
	 * 
	 * 시간 : 76 ms
	 * 메모리 : 11512 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 0이 나오는 것은 10의 배수이므로 10을 만드는 숫자 2,5 개수 세기
		int two = 0;
		int five = 0;
		
		for (int i = 2; i <= N; i *= 2) {
			two += N/i;
		}
		
		for (int i = 5; i <= N; i *= 5) {
			five += N/i;
		}
		
		// 결과값은 5의 개수와 같다.
		System.out.println(five);
	}

}
