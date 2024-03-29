package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_15688 {

	/**
	 * 문제
	 *  N개의 수가 주어졌을 때, 이를 비내림차순으로 정렬하는 프로그램을 작성하시오.
	 *  길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
	 *   - 수의 개수 N(1 ≤ N ≤ 1,000,000)
	 *   - 주어지는 수는 절댓값이 1,000,000보다 작거나 같은 정수이며, 같은 수가 여러 번 중복될 수도 있다.
	 *   - 시간제한 30초
	 * 
	 * => Collection.sort는 합병정렬을 사용한다.
	 * 
	 * 시간: 20268 ms
	 * 메모리: 214180 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> num = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(num);
		
		for (Integer n : num) {
			sb.append(n).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
}
