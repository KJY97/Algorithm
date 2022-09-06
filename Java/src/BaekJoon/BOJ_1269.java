package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269 {

	/**
	 * 문제
	 *  자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오.
	 *  두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
	 *  예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
	 *   - 각 집합의 원소의 개수는 200,000을 넘지 않으며, 모든 원소의 값은 100,000,000을 넘지 않는다.
	 *
	 * => HashMap으로 하면 시간 초과 발생하므로 HashSet 사용
	 * 
	 * 시간: 732 ms
	 * 메모리: 93276 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A_size = Integer.parseInt(st.nextToken()); // A의 원소 개수
		int B_size = Integer.parseInt(st.nextToken()); // B의 원소 개수
		
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A_size; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B_size; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0; // 대칭 차집합 원소 개수
		
		// A-B
		for (Integer num : B) {
			if(!A.contains(num)) sum++;
		}
		
		// B-A
		for (Integer num : A) {
			if(!B.contains(num)) sum++;
		}
		
		System.out.println(sum);
	}

}
