package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12221 {

	/**
	 * 문제
	 *  두 정수 A, B가 주어진다. 아기 석환이 두 정수를 곱셈할 수 있으면 곱을 출력하고, 아니면 -1을 출력하기
	 *   - 1 ~ 9의 자연수 2개는 곱셈 가능
	 *   - BUT, 10이상 자연수 곱셈은 모른다.
	 *   - 1 ≤ A, B ≤ 20
	 *   
	 * 시간: 98 ms
	 * 메모리: 18,644 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int ans = (B >= 10 || A >= 10) ? -1 : A*B;
			System.out.println("#" + test_case + " " + ans);
		}

	}

}
