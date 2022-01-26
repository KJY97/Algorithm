package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1976 {

	/**
	 * 문제
	 *  시 분으로 이루어진 시각을 2개 입력 받아, 더한 값을 시 분으로 출력하는 프로그램 작성하기
	 *   - 시는 1 이상 12 이하의 정수
	 *   - 분은 0 이상 59 이하의 정수
	 * 
	 * 시간: 99 ms
	 * 메모리: 19,212 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 시 분 각각 더하기
			int hour = 0, minute = 0;
			for (int i = 0; i < 2; i++) {
				hour += Integer.parseInt(st.nextToken());
				minute += Integer.parseInt(st.nextToken());
			}
			
			hour += minute / 60; // 59분을 넘어가면 hour에 크기만큼 추가됨
			minute = minute % 60;
			
			hour = hour % 12 == 0 ? 12 : hour % 12;
			
			System.out.println("#" + test_case + " " + hour + " " + minute);
		}
	}
}
