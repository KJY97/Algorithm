package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153 {

	/**
	 * 문제
	 *  주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하기
	 *   - 각 변들의 길이가 3,4,5인 삼각형이 직각 삼각형
	 *   - 0 0 0 입력되면 종료
	 *   
	 * 시간 : 72 ms
	 * 메모리 : 11532 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			// 30,000보다 작은 양의 정수
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) break;
			
			if ((a * a + b * b) == c * c) {
				System.out.println("right");
			}
			else if ((b * b + c * c) == a * a) {
				System.out.println("right");
			}
			else if ((a * a + c * c) == b * b) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
				
		}
	}

}
