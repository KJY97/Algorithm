package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475 {

	/**
	 * 문제
	 *  다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
	 *  다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
	 *  다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
	 *  (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
	 *   - N은 1,000,000보다 작거나 같은 자연수이다.
	 *   
	 * 시간: 80 ms
	 * 메모리: 11516 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] N = br.readLine().toCharArray(); // 방 번호
		
		int[] count = new int[10];
	
		for (int i = 0; i < N.length; i++) {
			int num = N[i] - '0';
			
			// 6과 9는 서로 뒤집어서 사용할 수 있다.
			if (num == 6 || num == 9) {
				if (count[6] <= count[9]) count[6]++;
				else count[9]++;
			}
			else count[num]++;
		}
		
		int answer = 0; // 필요한 세트의 개수
		for (int i = 0; i < 10; i++) {
			answer = Math.max(answer, count[i]);
		}
		
		System.out.println(answer);
	}

}
