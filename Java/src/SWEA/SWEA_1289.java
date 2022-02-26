package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1289 {

	/**
	 * 문제
	 *  실수로 컴퓨터 메모리가 초기화되었다. 다행히 원래 값을 알고 있어 되돌리려고 했으나 문제가 생겼다.
	 *  메모리 bit 중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌운다.
	 *  예를 들어 지금 메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111이 된다.
	 *  원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번을 고쳐야 할까?
	 *   - 메모리의 길이는 1이상 50이하
	 *   
	 * 시간: 100 ms
	 * 메모리: 18,700 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] origin = br.readLine().toCharArray(); // 원래 상태
			char[] reset = new char[origin.length]; // 초기화 상태
			Arrays.fill(reset, '0'); // 모든 bit가 0인 상태
			
			int ans = 0; // 원래 상태로 돌아가기 위해 고친 횟수
			for (int i = 0; i < origin.length; i++) {
				if(origin[i] == reset[i]) continue;
				
				ans++;
				for (int j = i; j < origin.length; j++) {
					if(origin[i] == '1') reset[j] = '1';
					else reset[j] = '0';
				}
				
				if(String.valueOf(origin).equals(String.valueOf(reset))) break;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
