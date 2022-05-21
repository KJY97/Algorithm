package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

	/**
	 * 문제
	 *  상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다. 스티커는 그림 (a)와 같이 2행 n열로 배치되어 있다. 
	 *  상냥이는 스티커를 이용해 책상을 꾸미려고 한다.
	 *  상냥이가 구매한 스티커의 품질은 매우 좋지 않다. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다. 
	 *  즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.
	 *   ...사진 생략...
	 *  모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다. 
	 *  먼저, 그림 (b)와 같이 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하라. 
	 *  즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
	 *   - n (1 ≤ n ≤ 100,000)
	 *   - 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수
	 * 
	 * => DP(다이나믹 프로그래밍) 활용 - 메모이제이션
	 * 
	 * 시간: 740 ms
	 * 메모리: 124176 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 열의 개수
			int[][] sticker = new int[2][N]; // 스티커 2n개
			
			// 스티커 2n개의 점수 입력
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 두 변을 공유하지 않는 스티커 집합 - 메모이제이션 이용
			// 대각선 한 칸 or 두 칸의 스티커 중 가장 큰 값을 가진 스티커를 저장한다.
			// 세 칸째에서는 대각선 한 칸 이동을 통해 \/\ 모양으로 접근이 가능하기 때문에 최대 두 칸까지 비교한다.
			int[][] memo = new int[2][N+1]; 
			
			memo[0][0] = memo[1][0] = 0;
			memo[0][1] = sticker[0][0];
			memo[1][1] = sticker[1][0];
			
			// memo의 인덱스와 sticker의 인덱스는 1만큼 차이가 난다.
			for (int i = 2; i <= N; i++) {
				memo[0][i] = Math.max(memo[1][i-1], memo[1][i-2]) + sticker[0][i-1];
				memo[1][i] = Math.max(memo[0][i-1], memo[0][i-2]) + sticker[1][i-1];
			}
			
			// 점수의 합이 가장 큰 스티커 집합 출력
			System.out.println(Math.max(memo[0][N], memo[1][N]));
		}
	}

}
