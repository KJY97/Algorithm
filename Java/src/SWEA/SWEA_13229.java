package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_13229 {

	/**
	 * 문제
	 *  주어지는 문자열 S는 “MON”(월), “TUE”(화), “WED”(수), “THU”(목), “FRI”(금), “SAT”(토), “SUN”(일) 중 하나이다
	 *  다음 (즉, 내일 이후의 가장 빠른) 일요일까지는 며칠 남았을까?
	 *   
	 * 시간: 98 ms
	 * 메모리: 18,712 kb
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String S = br.readLine();
			int ans = 0; // 다음 일요일과 며칠 차이 나는지 저장
			
			for (int i = 0; i < 7; i++) {
				if(week[i].equals(S)) {
					ans = 7 - i;
					break;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
