package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_11478 {

	/**
	 * 문제
	 *  문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
	 *  부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
	 *  예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
	 *   - 문자열 S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
	 *   - 제한시간 1초
	 * 
	 * => 그리디 알고리즘 활용
	 * => 문자열의 최대 길이가 1000 이기 때문에 2중 반복문을 사용해도 1초를 넘기지 않는다.
	 *    1초 = 약 1억. 1000 x 1000 = 1000000 이므로 사용 가능하다.
	 * => Set은 중복을 허용하지 않는다.
	 * 
	 * 시간: 1044 ms
	 * 메모리: 582216 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] Str = br.readLine().toCharArray(); // 문자열 S
		
		// 중복없이 가능한 모든 부분 문자열의 개수를 구하는 것이므로 set 사용
		HashSet<String> hash = new HashSet<>();

		// 모든 경우의 수 접근(그리디 알고리즘)
		for (int i = 0; i < Str.length; i++) {
			String tmp = "";
			for (int j = i; j < Str.length; j++) {
				tmp += Str[j];
				hash.add(tmp); // 중복 허용 X
			}
		}
		
		System.out.println(hash.size());
	}

}
