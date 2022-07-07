package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {

	/**
	 * 문제 
	 *  어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
	 *  N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
	 *   - 1,000보다 작거나 같은 자연수 N이 주어진다..
	 * 
	 * 시간: 88 ms
	 * 메모리: 11544 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); 
		int cnt = 0; // 한수의 개수
    
    // 1부터 N까지 한수의 개수 구하기
		for (int i = 1; i <= N; i++) {
      // 각 자리의 수를 비교하기 위해 문자열로 변환한다.
			String num = Integer.toString(i);

			// 일의 자릿수(1 ~ 9)의 경우
			if (num.length() == 1) cnt++;
			else {
				int diff = num.charAt(1) - num.charAt(0); // 공차 구하기
				// 한수라면 카운트 증가
				if (isAvailable(num, diff)) cnt++;
			}
		}

		System.out.println(cnt);
	}
	
	// 공차(diff)만큼 두 수가 차이가 난다면 한수이다.
	public static boolean isAvailable(String num, int diff) {
		for (int i = 2; i < num.length(); i++) {
			if (num.charAt(i) - num.charAt(i-1) != diff) return false;
		}
		return true;
	}
}
