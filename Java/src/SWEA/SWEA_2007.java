package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2007 {

	/**
	 * 문제
	 *  패턴에서 반복되는 부분을 마디라고 부른다. 
	 *  문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하기
	 *   - 문자열 길이는 30
	 *   - 마디 최대 길이는 10
	 *   
	 * 시간: 98 ms
	 * 메모리: 19,280 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = br.readLine();
			int ans = 0; // 문자열에서 반복되는 마디의 길이
			
			// 마디의 최대 길이는 10이므로 
			for (int i = 2; i <= 10; i++) {
				String str = input.substring(0, i); // 0 ~ i까지의 문자열 자르기
				
				// 문자열에서 마디가 반복되는지 체크
				boolean flag = true;
				for (int j = 0; j < input.length() - i; j+=i) {
					String tmp = input.substring(j, j+i); // 마디길이 만큼 자르기
					// 반복되지 않으면 탈출
					if(!str.equals(tmp)) {
						flag = false;
						break;
					}
				}
				
				// 마디를 발견했다면? 
				if(flag) {
					ans = str.length();
					break;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}

}
