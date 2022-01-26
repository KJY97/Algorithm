package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1970 {

	/**
	 * 문제
	 *  S마켓에서 손님에게 거슬러 주어야 할 금액 N이 입력되면 돈의 최소 개수로 거슬러 주기 위하여 
	 *  각 종류의 돈이 몇 개씩 필요한지 출력
	 *   - 돈의 종료: 5만원, 1만원, 5천원, 1천원, 5백원, 1백원, 50원, 10원
	 *   - 10 ≤ N ≤ 1,000,000
	 *   - N의 마지막 자릿수는 항상 0
	 *   
	 * 시간: 99 ms
	 * 메모리: 19,476 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append('#').append(test_case).append('\n');
			
			int N = Integer.parseInt(br.readLine()); // 금액
			
			for (int i = 0; i < 8; i++) {
				int ans = N / money[i]; // 몇 개 필요한지
				N = N % money[i];		// 나머지 돈
				sb.append(ans).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
