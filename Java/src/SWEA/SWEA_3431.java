package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3431 {

	/**
	 * 문제
	 *  최근 경도비만 판정을 받은 준환이는 적절한 몸을 유지하기 위하여 1주일에 L분 이상 U분 이하의 운동을 하여야 한다.
	 *  준환이는 이번 주에 X분만큼 운동을 하였다.
	 *  당신은 준환이가 제한되어 있는 시간을 넘은 운동을 한 것인지, 그것이 아니라면 몇 분 더 운동을 해야 제한을 맞출 수 있는지 구하라
	 *   - L, U, X(0≤ L ≤ U ≤ 10⁷, 0 ≤ X ≤ 10⁷)
	 *   - 더 많이 운동하고 있다면 -1, 아니라면 추가운동시간 출력
	 *   
	 * 시간: 193 ms
	 * 메모리: 21,668 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken()); // 이번주 운동한 시간
			
			int ans = 0;
			if(L <= X && X <= U) ans = 0;
			else if(L > X) ans = L - X;
			else if(X > U) ans = -1;
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
