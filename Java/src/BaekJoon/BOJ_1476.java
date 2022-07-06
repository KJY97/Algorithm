package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {

	/**
	 * 문제 
	 *  준규가 사는 나라는 우리가 사용하는 연도와 다른 방식을 이용한다. 준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다. 
	 *  각각의 수는 지구, 태양, 그리고 달을 나타낸다.
	 *  지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M이라고 했을 때, 이 세 수는 서로 다른 범위를 가진다.
	 *  우리가 알고있는 1년은 준규가 살고있는 나라에서는 1 1 1로 나타낼 수 있다. 1년이 지날 때마다, 세 수는 모두 1씩 증가한다.
	 *  만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.
	 *  예를 들어, 15년은 15 15 15로 나타낼 수 있다. 하지만, 1년이 지나서 16년이 되면 16 16 16이 아니라 1 16 16이 된다.
	 *  이유는 1 ≤ E ≤ 15 라서 범위를 넘어가기 때문이다.
	 *  E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때, 준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하라.
	 *  E S M으로 표시되는 가장 빠른 연도를 출력한다. 1 1 1은 항상 1이기 때문에, 정답이 음수가 나오는 경우는 없다.
	 *   - 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
	 * 
	 * => 완전탐색
	 * => 탐색 범위는 15 x 28 x 19 = 7980
	 * 
	 * 시간: 76 ms
	 * 메모리: 11500 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken()); // 지구를 나타내는 수
		int S = Integer.parseInt(st.nextToken()); // 태양을 나타내는 수
		int M = Integer.parseInt(st.nextToken()); // 달을 나타내는 수

		// 준규가 사는 나라에서는 1 1 1이다.
		int e = 1, s = 1, m = 1; 
		
		int year = 1;
		for (year = 1; year <= 7980; year++) {
		
			// 주어진 입력과 일치하면 반복문 탈출
			if (e == E && s == S && m == M) break;
			
			e++; s++; m++;
			
			if (e == 16) e = 1;
			if (s == 29) s = 1;
			if (m == 20) m = 1;
		}
		
		// 우리가 알고 있는 연도
		System.out.println(year);
	}
}
