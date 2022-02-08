package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12741 {

	/**
	 * 문제
	 *  두 개의 전구 X와 Y가 있다. 
	 *  당신은 0초에서부터 시작하여 100초간 두 전구가 언제 켜지는지를 관찰하였다.
	 *  관찰 결과, 전구 X는 관찰 시작 경과 후 A초에서부터 관찰 시작 경과 후 B초까지에만 켜져 있었다. 
	 *  전구 Y는 관찰 시작 경과 후 C초에서부터 관찰 시작 경과 후 D초까지에만 켜져 있었다.
	 *  당신이 두 전구를 관찰하던 100초 중 두 전구가 동시에 켜져 있던 시간은 몇 초일까?
	 *   - 0 ≤ A < B ≤ 100
	 *   - 0 ≤ C < D ≤ 100
	 *   
	 * 시간: 380 ms
	 * 메모리: 54,168 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// X전구
			int A = Integer.parseInt(st.nextToken()); // 경과 전
			int B = Integer.parseInt(st.nextToken()); // 경과 후
			
			// Y전구
			int C = Integer.parseInt(st.nextToken()); // 경과 전
			int D = Integer.parseInt(st.nextToken()); // 경과 후
			
			int time = 0; // 두 전구가 동시에 켜져있는 시간 체크
			
			if(A <= C) { // X전구가 먼저 켜진 경우
				for (int i = A; i <= B; i++) {
					// 겹쳐진 이후의 시간을 체크하는 것이기 때문에 처음 겹쳐진 시간은 체크하지 않는다.
					if(C < i && i <= D) time++;
				}
			}
			else { // Y전구가 먼저 켜진 경우
				for (int i = C; i <= D; i++) {
					if(A < i && i <= B) time++;
				}
			}
			
			System.out.println("#" + test_case + " " + time);
		}
	}

}
