package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2070 {

	/**
	 * 문제
	 *  2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램을 작성하기
	 *   - 각 수는 0 이상 10000 이하의 정수
	 *  
	 * 시간: 96 MS
	 * 메모리: 16,080 KB
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			char ch = ' ';
			if(num1 > num2) ch = '>';
			else if(num1 < num2) ch = '<';
			else ch = '=';
			
			System.out.println("#" + test_case + " " + ch);
		}
	}
}
