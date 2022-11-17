package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9625 {

	/**
	 * 문제
	 *  상근이는 길을 걷다가 신기한 기계를 발견했다. 기계는 매우 매우 큰 화면과 버튼 하나로 이루어져 있다.
	 *  기계를 발견했을 때, 화면에는 A만 표시되어져 있었다. 버튼을 누르니 글자가 B로 변했다.
	 *  한 번 더 누르니 BA로 바뀌고, 그 다음에는 BAB, 그리고 BABBA로 바뀌었다.
	 *  상근이는 화면의 모든 B는 BA로 바뀌고, A는 B로 바뀐다는 사실을 알게되었다.
	 *  버튼을 K번 눌렀을 때, 화면에 A와 B의 개수는 몇 개가 될까?
	 *   - K (1 ≤ K ≤ 45)
	 *   - 제한시간 1초
	 * 
	 * => DP 알고리즘 사용
	 * 
	 * 시간: 72 ms
	 * 메모리: 11484 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		
		int[][] memo = new int[K+1][2]; // A와 B
		
		// 초기화 (A 1개, B 0개)
		memo[0][0] = 1; memo[0][1] = 0;
		
		for (int i = 1; i <= K; i++) {
			memo[i][0] = memo[i-1][1];
			memo[i][1] = memo[i-1][0] + memo[i-1][1];
		}
		
		System.out.println(memo[K][0] + " " + memo[K][1]);
	}

}
