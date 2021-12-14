package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2675 {

	/**
	 * 문제
	 *  문자열 S에서 각 문자를 R번 반복해 새 문자열 P를 만들기
	 *   - S = AB, R = 2 라면 P = AABB
	 *   
	 * 시간 : 76 ms
	 * 메모리 : 11624 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); // 반복 횟수. 1 ≤ R ≤ 8
			String S = st.nextToken(); // 문자열 S. 길이는 1 <= S.length() <= 20
			
			String P = "";
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++) {
					P += S.charAt(i);
				}
			}
			
			System.out.println(P);
		}
	}

}
