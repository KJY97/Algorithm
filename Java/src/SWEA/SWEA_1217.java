package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1217 {

	/**
	 * 문제
	 *  다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현하기
	 *   - 2 5 = 2 X 2 X 2 X 2 X 2 = 32
	 *   - Integer 범위를 넘어가지 않는다.
	 *   
	 * 시간: 97 ms
	 * 메모리: 19,124 kb
	 */
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        for(int test_case = 1; test_case <= 10; test_case++) {
        	int T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	
        	System.out.println("#" + test_case + " " + Recursion(a, N));
        }
        
    }
	
	// 재귀호출을 이용한 거듭제곱
	public static int Recursion(int a, int N) {
		if(N == 0) return 1;
		
		return a * Recursion(a, N-1);
	}
		
}
