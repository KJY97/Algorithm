package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_11652 {

	/**
	 * 문제
	 *  준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -2⁶²보다 크거나 같고, 2⁶²보다 작거나 같다.
	 *  준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오.
	 *  만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
	 *   - 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)
	 * 
	 * => int는 4byte의 크기로 4 x 8bit = 32bit
	 *    즉 2³²까지 크기 표현이 가능하다.
	 * => 숫자 카드의 값 범위는 2⁶²이므로 long을 사용한다.
	 * 
	 * 시간: 340 ms
	 * 메모리: 32036 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 숫자 카드의 개수
		
		// 오름차순으로 자동 정렬
		TreeMap<Long, Integer> map = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int maxCnt = 0; // 가장 많은 정수의 개수
		long ans = 0; // 가장 많이 가지고 있는 정수
		
		for (Long num : map.keySet()) {
			if (maxCnt < map.get(num)) {
				maxCnt = map.get(num);
				ans = num;
			}
		}
		
		System.out.println(ans);
	}

}
