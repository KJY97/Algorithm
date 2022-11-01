package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ_11656 {

	/**
	 * 문제
	 *  접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
	 *  baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 
	 *  이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
	 *  문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
	 *   - S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.
	 *   - 제한시간 1초
	 *   
	 * 시간: 168 ms
	 * 메모리: 14060 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray(); // 문자열 S를 char 배열로 저장
		int size = S.length; // 문자열 S의 길이
		
		List<String> list = new LinkedList<>(); // S의 모든 접미사 저장
		
		for (int i = 0; i < size; i++) {
			String tmp = String.copyValueOf(S, i, size-i); // S의 i부터 size-i개 복사
			list.add(tmp);
		}
		
		// 오름차순 정렬
		Collections.sort(list);
		
		for (String word : list) {
			System.out.println(word);
		}
	}

}
