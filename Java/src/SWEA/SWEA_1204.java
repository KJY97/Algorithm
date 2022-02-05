package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {

	/**
	 * 문제
	 *  1000명의 학생들의 수학 성적을 토대로 최빈수를 출력하는 프로그램 작성하기
	 *   - 최빈수란 특정 자료에서 가장 여러 번 나타나는 값을 의미(최빈수를 이용하여 평균 수준 짐작 가능)
	 *   - 최빈수가 여러 개 일때에는 가장 큰 점수 출력
	 *   - 점수는 0점 이상 100점 이하
	 *   
	 * 시간: 122 ms
	 * 메모리: 22,892 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine(); // 테스트 케이스 번호
			
			// 점수는 0 <= score <= 100
			// 100번 idx까지 사용. 
			int[] score = new int[101];
			
			// 각 점수별 인원 수 체크
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int student = 0; student < 1000; student++) { // 1000명의 학생
				score[Integer.parseInt(st.nextToken())]++;
			}
			
			// 가장 많이 나온 수 & 큰 점수 찾기
			int max = 0; // 가장 많은 인원 수
			int max_score = 0; // 가장 큰 최빈수
			for (int i = 0; i <= 100; i++) {
				if(max <= score[i]) {
					max = score[i];
					max_score = i;
				}
			}
			
			System.out.println("#" + test_case + " " + max_score);
		}

	}

}
