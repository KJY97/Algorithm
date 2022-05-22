package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5525 {

	/**
	 * 문제
	 *  N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.
	 *  ========================
	 *   P1 IOI
	 *   P2 IOIOI
	 *   P3 IOIOIOI
	 *   PN IOIOI...OI (O가 N개)
	 *  ========================  
	 *  I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하라.
	 *   - 1 ≤ N ≤ 1,000,000
	 *   - 2N+1 ≤ M ≤ 1,000,000
	 *   - S는 I와 O로만 이루어져 있다.
	 *   
	 * 시간: 96 ms
	 * 메모리: 14048 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 1,000,000
		int M = Integer.parseInt(br.readLine()); // 문자열 길이. 2N+1 ≤ M ≤ 1,000,000
		String str = br.readLine();
		
		String Pn = "";
		for (int i = 0; i < 2*N+1; i++) {
			if(i % 2 == 0) Pn += "I";
			else Pn += "O";
		}
		
		int cnt = 0;
		for (int i = 0; i < M-(2*N+1); i++) {
			if(str.charAt(i) == 'O') continue;
			else if(str.substring(i, i+(2*N+1)).equals(Pn)) cnt++;
		}
		System.out.println(cnt);
	}

}
