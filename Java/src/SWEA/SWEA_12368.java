package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12368 {

	/**
	 * 문제
	 *  24시간제 시계에서는 하루가 자정에서 시작해서 다음 날 자정에서 끝나며, 자정에서부터 지금까지 흐른 시간을 기준으로 시각을 표기한다. 
	 *  예를 들어, 지금이 오후 8시라면 “20시”와 같은 꼴로 표현할 수 있다.
	 *  자정을 표기하는 유일한 방법은 “0시”임에 유의하라.
	 *  지금은 자정에서부터 정확히 A시간이 지났다. 앞으로 정확히 B시간이 더 지난다면, 24시간제 시계에서 그 때는 몇 시일까?
	 *   - 0 ≤ A, B ≤ 23
	 *   
	 * 시간: 113 ms
	 * 메모리: 21,304 kb
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 현재 시각
			int B = Integer.parseInt(st.nextToken()); // 이후 지나가는 시간
			
			int result = A + B;
			
			System.out.println("#" + test_case + " " + result % 24);
		}
	}
}
