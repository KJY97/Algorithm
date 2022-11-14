package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_10867 {

	/**
	 * 문제
	 *  N개의 정수가 주어진다. 이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 같은 정수는 한 번만 출력한다.
	 *   - 수의 개수 N (1 ≤ N ≤ 100,000)
	 *   - 주어지는 수는 절댓값이 1,000보다 작거나 같은 정수이다.
	 *   - 제한시간 1초
	 *   
	 * 시간: 352 ms
	 * 메모리: 24792 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		
		// 자동 정렬(오름차순) 및 중복 저장 불가
		TreeSet<Integer> heap = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			heap.add(Integer.parseInt(st.nextToken()));
		}

		for (Integer num : heap) {
			System.out.print(num + " ");
		}
	}

}
