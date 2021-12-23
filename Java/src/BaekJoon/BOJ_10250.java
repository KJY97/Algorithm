package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {

	/**
	 * 문제
	 *  손님들은 호텔 정문으로부터 걸어서 짧은 거리에 있는 방을 선호한다. 손님에게 빈 방을 배정해본다.
	 *   - 엘리베이터는 가장 왼쪽에 있다.
	 *   - 엘리베이터로 이동하는 거리는 신경 쓰지 않는다.
	 *   - 거리가 같을 때는 아래층 방을 더 선호
	 *   - 호텔은 H x W 형태
	 *   - 정문은 일층 엘리베이터 바로 앞에 있다.(정문과 엘리베이터 사이 거리 무시)
	 *   - 인접한 두 방 사이의 거리는 1
	 *   - YY는 층 수, XX는 엘리베이터에서부터 세었을 때의 번호
	 *   
	 * => 반복문으로 행부터 접근해서 처리하는 방법1과 계산식으로 처리하는 방법2
	 * 
	 * [방법1]
	 * 시간: 128 ms
	 * 메모리: 13332 kb
	 * 
	 * [방법2]
	 * 시간: 116 ms
	 * 메모리: 12272 kb
	 */
	
//	private static int H, W, N;
//	private static boolean hotel[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 층 수. 1 ≤ H ≤ 99
			int W = Integer.parseInt(st.nextToken()); // 층의 방 수. 1 ≤ W ≤ 99
			int N = Integer.parseInt(st.nextToken()); // 손님의 순번. 1 ≤ N ≤ H × W
			
			// [방법1]: 배열로 행을 먼저 탐색하기
//			// 1번부터 바로 사용하기 위해서
//			hotel = new boolean[W+1][H+1];
//			
//			int[] res = find();
//			System.out.printf("%d%02d\n",res[1],res[0]);
			
			// [방법2]: 나눗셈, 나머지 계산으로 구하기 - H개로 되어있는 묶음이 W개
			int floor = N%H == 0 ? H : N%H;
			int room = N%H == 0 ? N/H : N/H+1;
			System.out.printf("%d%02d\n", floor, room);
		}
	}
	
//	public static int[] find() {
//		for (int i = 1; i <= W; i++) {
//			for (int j = 1; j <= H; j++) {
//				if(--N == 0) return new int[]{i, j};
//				if(hotel[i][j]) continue;
//				hotel[i][j] = true;
//			}
//		}
//		return new int[] {W, H};
//	}

}