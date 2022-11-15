package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11728 {

	/**
	 * 문제
	 *  정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
	 *   - 배열 A의 크기 N, 배열 B의 크기 M (1 ≤ N, M ≤ 1,000,000)
	 *   - 배열에 들어있는 수는 절댓값이 10⁹보다 작거나 같은 정수이다.
	 *   - 제한시간 1.5초
	 * 
	 * => Arrays.sort() 대신 Collections.sort() 사용
	 *    왜냐하면 Collections.sort()는 TimeSort(삽입+합병정렬) 사용해서 시간 복잡도가 O(n log n) 이기 때문이다.
	 *    Arrays.sort()는 최악의 경우 O(N²) 이므로 10억은 넘긴다.
	 * => 중복 제거는 할 필요 없다.
	 * => 시간 초과가 발생하므로 StringBuilder 사용
	 * 
	 * 시간: 1432 ms
	 * 메모리: 412004 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
		int M = Integer.parseInt(st.nextToken()); // 배열 B의 크기
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		// Collections.sort를 사용하기 위해 List 사용
		List<Integer> list = new ArrayList<>();
		
		// 배열 A의 내용
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			list.add(A[i]);
		}

		// 배열 B의 내용
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			list.add(B[i]);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (Integer num : list) {
			sb.append(num).append(' ');
		}
		
		System.out.println(sb.toString());
		
	}

}
