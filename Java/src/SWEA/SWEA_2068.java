package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2068 {

	/**
	 * 문제
	 *  10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하기
	 *   - 각 수는 0 이상 10000 이하의 정수
	 *  
	 * 시간: 97 MS
	 * 메모리: 16,080 KB
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0;
			for (int i = 0; i < 10; i++) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
