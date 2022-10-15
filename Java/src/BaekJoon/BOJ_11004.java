package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11004 {

	/**
	 * 문제
	 *  수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
	 *   - N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)
	 *   - -10⁹ ≤ Ai ≤ 10⁹
	 *   - 시간제한 2초
	 *   
	 * => Arrays.sort(int[])를 사용하면 시간 초과 발생
	 *   왜냐하면 최악의 경우 시간이 O(N²) 걸리기 때문이다.
	 * => 래퍼 클래스를 사용한 Integer 정렬은 Collections.sort의 병합정렬을 사용하여 O(N log N) 시간이 걸린다.
	 * 
	 * 시간: 4012 ms
	 * 메모리: 743176 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 총 개수
		int K = Integer.parseInt(st.nextToken()); // 구해야 하는 수 위치
		
		List<Integer> arr = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		
		System.out.println(arr.get(K-1));
	}

}
