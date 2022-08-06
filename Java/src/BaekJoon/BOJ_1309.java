package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309 {

	/**
	 * 문제
	 *  어떤 동물원에 가로로 두칸 세로로 N칸인 아래와 같은 우리가 있다.
	 *   .. 그림 생략 ..
	 *  이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다.
	 *  이 동물원 조련사는 사자들의 배치 문제 때문에 골머리를 앓고 있다.
	 *  동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자.
	 *  사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.
	 *  첫째 줄에 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력하여라.
	 *   - 우리의 크기 N(1≤N≤100,000)
	 *  
	 * => DP 사용
	 * 
	 * 시간: 324 ms
	 * 메모리: 34884 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 우리의 크기
		
		int[][] memo = new int[N][3]; // 우리

		// 초기화
		memo[0][0] = 1; // N번째 줄에 사자가 모두 없는 경우
		memo[0][1] = 1; // N번째 줄에 왼쪽 칸에만 사자가 있는 경우
		memo[0][2] = 1; // N번째 줄에 오른쪽 칸에만 사자가 있는 경우
		
		for (int i = 1; i < N; i++) {
			// i번재 줄 사자 없으면, 그 윗줄에는 모두 미배치 or 왼쪽 칸 배치 or 오른쪽 칸 배치 가능
			memo[i][0] = (memo[i-1][0] + memo[i-1][1] + memo[i-1][2]) % 9901;
			// i번째 줄 왼쪽 칸에 사자 있으면, 그 윗줄에는 모두 미배치 or 오른쪽 칸에 배치
			memo[i][1] = (memo[i-1][0] + memo[i-1][2]) % 9901;
			// i번째 줄 오른쪽 칸에 사자 있으면, 그 윗줄에는 모두 미배치 or 왼쪽 칸에 배치
			memo[i][2] = (memo[i-1][0] + memo[i-1][1]) % 9901;
		}
		
		int ans = 0; // 모든 경우의 수 합
		for (int i = 0; i < 3; i++) {
			ans += memo[N-1][i];
		}
		
		System.out.println(ans % 9901);
	}

}
