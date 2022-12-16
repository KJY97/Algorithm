package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_11931 {

	/**
	 * 문제
	 *  N개의 수가 주어졌을 때, 이를 내림차순으로 정렬하는 프로그램을 작성하시오.
	 *   - 수의 개수 N(1 ≤ N ≤ 1,000,000)
	 *   - 주어지는 N개의 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
	 *   - 시간제한 2초
	 * 
	 * => N의 범위가 크기 때문에 시간복잡도가 O(N²)인 Arrays.sort 사용 불가
	 *    합병정렬 사용하는 Collection.sort 이용
	 *    
	 * 시간: 1376 ms
	 * 메모리: 215092 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		// 내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		
		for (Integer num : list) {
			sb.append(num).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
