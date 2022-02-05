package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_1285 {

	/**
	 * 문제
	 *  N명의 사람들이 던진 돌이 떨어진 위치를 측정한 자료가 주어질 때, 
	 *  가장 0에 가깝게 돌이 떨어진 위치와 0 사이의 거리 차이와 몇 명이 그렇게 돌을 던졌는지를 구하기
	 *   - 1≤N≤1,000
	 *   - 돌이 떨어지는 위치 범위 : -100,000에서 100,000사이 범위의 정수
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 돌 던지는 사람 수. 1≤N≤1,000
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int min = 100_000; // 가장 가깝게 떨어진 돌의 위치
			int cnt = 0; // 가장 가깝게 던진 사람 수 체크
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				int tmp = Math.abs(num);
				
				if(min > tmp) {
					min = tmp;
					cnt = 1;
				} 
				else if(min == tmp) cnt++;
			}
			
			System.out.println("#" + test_case + " " + min + " " + cnt);
		}

	}

}
