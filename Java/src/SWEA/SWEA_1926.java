package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926 {

	/**
	 * 문제
	 *  정수 N 이 주어졌을 때, 1~N 까지의 숫자를 게임 규칙에 맞게 출력하는 프로그램을 작성하기
	 *   - 3 6 9 가 들어가 있는 수는 말하지 않는 대신, 박수를 친다.
	 *     이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다.
	 *   - 박수 치는 부분은 - 를 출력
	 *   - 2번 박수 칠 때는 -- 로 출력해야 함
	 *   - 10 ≤ N ≤ 1,000
	 *  
	 * 시간: 101 ms
	 * 메모리: 19,500 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 10 ≤ N ≤ 1,000
		
		for (int i = 1; i <= N; i++) {
			// 문자열로 변환
			String num = Integer.toString(i); 
			
			// 문자열이 3 6 9 포함하는지 확인
			if(num.contains("3") || num.contains("6") || num.contains("9")) {
				// 문자열 인덱스별로 접근해서 3 6 9 이면 출력
				for (int j = 0; j < num.length(); j++) {
					int tmp = num.charAt(j) - '0';
					if(tmp != 0 && tmp % 3 == 0) System.out.print("-");
				}
			}
			else System.out.print(i);
			
			System.out.print(" ");
		}
	}	
}
