package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_12004 {

	/**
	 * 문제
	 *  정수 N이 주어졌을 때, N 이 1 이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있는지 판단하라.
	 *   - N 이 1 이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있으면 “Yes”, 아니면 “No” 를 출력
	 *   - 1≤N≤100
	 *  
	 * 시간: 114 ms
	 * 메모리: 18,220 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); 
			String ans = "No";
			
			for (int i = 1; i <= 9; i++) {
				if(N % i == 0) {
					ans = (N / i) >= 10 ? "No" : "Yes"; 
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}

	}

}
