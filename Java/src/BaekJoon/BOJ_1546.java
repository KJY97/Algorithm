package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {

	/**
	 * 문제
	 *  세준이의 성적을 새로 계산했을 때, 새로운 평균 구하기
	 *   - 자기 점수 중 최대값 M 선택 후 모든 점수를 "점수/M * 100"으로 고치기
	 *   
	 * 시간 : 88 ms
	 * 메모리 : 12260 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 과목 개수 0<= N <= 1000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] score = new double[N];
		double max = 0; 
		for (int i = 0; i < N; i++) {
			score[i] = Double.parseDouble(st.nextToken()); // 0 <= score <= 100
			max = Math.max(score[i], max);
		}

		double ans = 0;
		for (int i = 0; i < N; i++) {
			ans += score[i]/max * 100;
		}
		
		System.out.println(ans / N);
	}

}
