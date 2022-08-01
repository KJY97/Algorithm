package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2565 {

	/**
	 * 문제
	 *  두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 
	 *  합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
	 *  예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, 
	 *  A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.
	 *   ... 그림 생략 ...
	 *  전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 
	 *  전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하라.
	 *   - 두 전봇대 사이의 전깃줄의 개수
	 *   - 전깃줄의 개수는 100 이하의 자연수
	 *   - 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
	 * 
	 * => 구해야 하는 것은 제거해야 하는 전선 수 = 전체 전선 수 - 남아있는 전선 수
	 * => 즉, 비교적 구하기 쉬운 남아있는 전선 수를 구하고 이를 전체 전선 수에서 제외한다.
	 * => A 전봇대 기준으로 B 전봇대 확인하기
	 * 
	 * 시간: 76 ms
	 * 메모리: 11660 kb
	 */
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] wire = new int[N][2]; // 전선
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			wire[i][0] = Integer.parseInt(st.nextToken()); // A 전봇대
			wire[i][1] = Integer.parseInt(st.nextToken()); // B 전봇대
		}
		
		// A 전봇대 기준으로 B 전봇대를 확인하기 위해 A 전봇대 기준으로 정렬
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// DP 활용하기
		int[] memo = new int[N]; 
		
		for (int i = 0; i < N; i++) {
			memo[i] = 1; // 최소 개수인 1로 초기화
			
			// i번째 전봇대 기준 이전 전봇대 비교
			for (int j = 0; j < i; j++) {
				if (wire[i][1] > wire[j][1]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
		
		// 가장 많이 전선이 남아있는 경우 구하기
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, memo[i]);
		}
		
		// 전체 전선 수 - 최대 남아 있는 전선 수 = 최소 철거 전선 수
		System.out.println(N - max);
	}

}
