package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {

	/**
	 * 문제
	 *  심해에는 두 종류의 생명체 A와 B가 존재한다. A는 B를 먹는다. A는 자기보다 크기가 작은 먹이만 먹을 수 있다.
	 *  예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에 A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다.
	 *  8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.
	 *  두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇 개나 있는지 구하는 프로그램을 작성하시오.
	 *  각 테스트 케이스마다, A가 B보다 큰 쌍의 개수를 출력한다.
	 *   - 테스트 케이스의 개수 T
	 *   - A의 수 N과 B의 수 M (1 ≤ N, M ≤ 20,000)
	 *   - 제한시간 1초
	 * 
	 * => Arrays.sort() 사용
	 * 
	 * 시간: 1144 ms
	 * 메모리: 42804 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // A의 수
			int M = Integer.parseInt(st.nextToken()); // B의 수
			
			int[] Arr = new int[N];
			int[] Brr = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Brr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(Arr);
			Arrays.sort(Brr);
			
			int cnt = 0;
			for (int i = N-1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (Arr[i] <= Brr[j]) break;
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}

	}

}
