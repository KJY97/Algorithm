package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816_해시맵ver {

	/**
	 * 문제
	 *  숫자 카드 N개가 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 몇 개 가지고 있는지 구하기
	 * => println으로 하면 시간초과 발생.. StringBuilder로 해결
	 * 
	 * 시간 : 1080 ms
	 * 메모리 : 241296 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수. 1 ≤ N ≤ 500,000
		Map<Integer, Integer> card = new HashMap<>();
		
		// 입력되는 숫자 범위는 -10,000,000 <= n <= 10,000,000
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if(card.containsKey(num))
				card.put(num, card.get(num) + 1);
			else
				card.put(num, 1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine()); // 몇 개를 가지고있는지 알고자 하는 수의 개수. 1 ≤ M ≤ 500,000
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// getOrDefault(key, defaultValue) : key가 card에 없다면 defaultValue, 있다면 저장된 value 반환
			// 굳이 containsKey로 if문 안써도 된다!
			sb.append(card.getOrDefault(num, 0)).append(' ');
		}
		System.out.println(sb);
	}

}
