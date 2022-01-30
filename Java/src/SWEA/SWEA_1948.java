package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1948 {
	
	/**
	 * 문제
	 *  월 일로 이루어진 날짜를 2개 입력 받아, 두 번째 날짜가 첫 번째 날짜의 며칠째인지 출력하기
	 *   - 1 ~ 12
	 *   - 각 달의 마지막 날짜: 1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
	 *   - 두 번째 날짜가 항상 첫 번째 날짜보다 크다
	 *   
	 * 시간: 99 ms
	 * 메모리: 18,884 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 첫 번째 날짜
			int f_month = Integer.parseInt(st.nextToken());
			int f_day = Integer.parseInt(st.nextToken());
			
			// 두 번째 날짜
			int s_month = Integer.parseInt(st.nextToken());
			int s_day = Integer.parseInt(st.nextToken());
			
			// ----- 두 날짜 간격 구하기 -----
			// 어차피 day로 환산하는 것이기 때문에 s_day - f_day가 음수가 나와도 상관없다!
			// 첫 번째 날짜도 포함해야 함! (1 ~ 31 간격은 31)
			int sum = s_day - f_day + 1; 
			for (int i = f_month; i < s_month; i++) {
				switch(i) {
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:
						sum += 31; break;
					case 4: case 6: case 9: case 11:
						sum += 30; break;
					case 2: 
						sum += 28; break;
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
