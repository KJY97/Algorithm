package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {

	/**
	 * 문제
	 * 	A x B x C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지 구하기
	 *   - 예를 들어 A = 150, B = 266, C = 427 이라면 
	 *   	A × B × C = 17037300이고 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번이 쓰였다.
	 *   
	 * 시간 : 72 ms
	 * 메모리 : 11476 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 1;
		for (int i = 0; i < 3; i++) {
			ans *= Integer.parseInt(br.readLine());
		}
		
		int[] num = new int[10];
		while(ans != 0) {
			num[ans % 10]++;
			ans /= 10;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
	}

}
