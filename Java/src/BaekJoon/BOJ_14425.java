package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {

	/**
	 * 문제
	 *  총 N개의 문자열로 이루어진 집합 S가 주어진다.
	 *  입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
	 *   - 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)
	 *   - N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
	 *   - M개의 줄에는 검사해야 하는 문자열들이 주어진다.
	 *   - 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 
	 *   - 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
	 *   - 시간제한 2초
	 *   
	 * 시간: 328 ms
	 * 메모리: 38956 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>(); // 집합 S
		
		// 집합 S의 문자열 입력
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int cnt = 0; // 집합 S에 포함되어 있는 문자의 개수 카운트
		for (int i = 0; i < M; i++) {
			String find = br.readLine();
			
			// 집합 S에 있는 문자라면
			if(set.contains(find)) cnt++;
		}
		
		System.out.println(cnt);
	}

}
