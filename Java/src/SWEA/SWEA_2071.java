package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2071 {

	/**
	 * 문제
	 *  10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하기
	 *   - 소수점 첫째 자리에서 반올림한 정수를 출력
	 *   - 각 수는 0 이상 10000 이하의 정수
	 *  
	 * 시간: 107 MS
	 * 메모리: 19,600 KB
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			System.out.printf("#%d %.0f\n", test_case, sum/10.0);
		}
	}
}
