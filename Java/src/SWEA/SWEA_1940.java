package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940 {

	/**
	 * 문제
	 *  입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 거리를 계산해보기
	 *   - 명령어 종류 : 0(현재 속도 유지), 1(가속), 2(감속)
	 *   - 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.
	 *   - 가속 단위는 m/s²이며, 모두 양의 정수
	 *   - 초기 속도는 0 m/s
	 * 
	 * 제약사항
	 *  - 2 ≤ N ≤ 30
	 *  - 가속도 값은 1 or 2
	 *  - 현재 속도보다 감속할 속도가 클 경우, 속도는 0이 된다
	 *  
	 * 시간: 99 ms
	 * 메모리: 18,748 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int velocity = 0; // 초기 속도는 0
			int a = 0; // 더해지는 가속도
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken()); // 0(현재 속도 유지), 1(가속), 2(감속)
				
				if(command == 1) {
					a += Integer.parseInt(st.nextToken());
				} else if(command == 2){
					a -= Integer.parseInt(st.nextToken());
				}
				
				velocity += a;
				
				// 감속 속도(=a)가 현재 속도보다 크면 속도는 0이 된다.
				if(velocity < 0) {
					velocity = 0;
					 a = 0; // 감속하는 가속도 0으로 초기화
				}
			}
			
			System.out.println("#" + test_case + " " + velocity);
		}

	}

}
