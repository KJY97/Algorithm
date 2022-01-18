package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2056 {

	/**
	 * 문제
	 *  연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
	 *  ”YYYY/MM/DD”형식으로 출력하고, 날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하기
	 *   - 2월의 경우 28일인 경우만 고려(윤년 X)
	 *   
	 * 시간: 102 ms
	 * 메모리: 20,148 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String date = br.readLine();
			
			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);
			
			boolean flag = false;
			switch(Integer.parseInt(month)) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					flag = Integer.parseInt(day) <= 31 ? true : false;
					break;
				case 4: case 6: case 9: case 11:
					flag = Integer.parseInt(day) <= 30 ? true : false;
					break;
				case 2:
					flag = Integer.parseInt(day) <= 28 ? true : false;
					break;
			}
			
			if(flag) System.out.printf("#%d %s/%s/%s\n",test_case, year, month, day);
			else System.out.println("#" + test_case + " -1");
		}
	}

}
