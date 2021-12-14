package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10952 {
	
	/**
	 * 문제
	 *  A+B 출력하기
	 *   - 입력이 0이면 종료
	 *   
	 * 시간 : 84 ms
	 * 메모리 : 11600 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A == 0 && B == 0) break;
			
			System.out.println(A+B);
		}

	}

}
