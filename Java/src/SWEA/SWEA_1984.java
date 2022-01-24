package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1984 {

	/**
	 * 문제
	 *  10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램 작성하기
	 *   - 0 이상 10000 이하의 정수
	 *   - 소수점 첫째 자리에서 반올림한 정수를 출력
	 *   
	 * 시간: 112 ms
	 * 메모리: 18,692 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0, min = 10000;
			int[] numbers = new int[10];
			for (int i = 0; i < 10; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, numbers[i]);
				min = Math.min(min, numbers[i]);
			}
			
			float sum = 0;
			for (int i = 0; i < 10; i++) {
				if(max == numbers[i] || min == numbers[i]) continue;
				sum += numbers[i];
			}
			
			System.out.printf("#%d %.0f\n", test_case, sum/8);
		}

	}

}
