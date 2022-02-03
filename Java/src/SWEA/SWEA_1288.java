package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1288 {

	/**
	 * 문제
	 *  민석이는 1번 양부터 순서대로 세는 것이 재미없을 것 같아서 N의 배수 번호인 양을 세기로 하였다.
	 *  첫 번째에는 N번 양을 세고, 두 번째에는 2N번 양, … , k번째에는 kN번 양을 센다.
	 *  이렇게 숫자를 세던 민석이에게 잠은 더 오지 않고 다음과 같은 궁금증이 생겼다.
	 *  이전에 셌던 번호들의 각 자리수에서 0에서 9까지의 모든 숫자를 보는 것은 최소 몇 번 양을 센 시점일까?
	 *   - 1 ≤ N ≤ 10⁶
	 *   - 첫 번째로 N = 1295번 양을 센다. 현재 본 숫자는 1, 2, 5, 9이다.
	 *     두 번째로 2N = 2590번 양을 센다. 현재 본 숫자는 0, 2, 5, 9이다.
	 *     현재까지 본 숫자는 0, 1, 2, 5, 9이다.
	 *     
	 * 시간: 102 ms
	 * 메모리: 18,588 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());  // 양의 세는 수
			boolean[] number = new boolean[10]; // 0 ~ 9 숫자 체크
			
			int cnt = 0; // 양을 세는 사람의 번째 수
			while(true) {
				cnt++;
				String num = Integer.toString(N * cnt);
				for (int i = 0; i < num.length(); i++) {
					number[num.charAt(i) - '0'] = true;
				}
				
				// 모든 숫자를 보았는가?
				if(allNumberCheck(number)) break;
			}
			
			System.out.println("#" + test_case + " " + (cnt * N));
		}
	}
	
	// 0 ~ 9까지의 모든 숫자를 보았는지 체크하는 메소드
	public static boolean allNumberCheck(boolean[] arr) {
		for (int i = 0; i < 10; i++) {
			if(!arr[i]) return false;
		}	
		return true;
	}

}
