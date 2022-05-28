package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * => 브루트포스 알고리즘으로 하면 시간 초과 발생해서 50점
	 *   => 문자열 길이와 패턴의 길이가 길수록 시간 복잡도가 증가하게 됨
	 * => KMP알고리즘을 사용하여 시간 줄이기
	 *   
	 * 시간: 232 ms
	 * 메모리: 25320 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine()); // S의 길이
		char[] S = br.readLine().toCharArray(); // 패턴
		
		// 찾을 패턴 구하기
		char[] P = new char[2*N+1];
		P[0] = 'I';
		
		for (int i = 1; i < 2*N+1; i+=2) {
			P[i] = 'O';
			P[i+1] = 'I';
		}
		
		// KMP 알고리즘 활용하여 두 문자열(S와 P) 비교
		KMP(S, P, M, 2*N+1);
	}
	
	/**
	 * 접두사와 접미사가 일치하는 최대길이를 구한 부분 일치 테이블 생성
	 * @param pattern : 찾는 패턴
	 * @param size : pattern의 길이
	 */
	private static int[] makeTable(char[] pattern, int size) {
		int[] table = new int[size];
		
		int idx = 0;
		for (int i = 1; i < size; i++) {
			// 일치하는 문자가 발생했을 대(idx > 0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다
			while (idx > 0 && pattern[i] != pattern[idx]) {
				idx = table[idx-1];
			}
			
			// 일치하는 경우
			if (pattern[i] == pattern[idx]) {
				// i길이 문자열의 공통 길이는 j의 위치 + 1 
				idx += 1;
				table[i] = idx;
			}
		}

		return table;
	}
	
	private static void KMP(char[] search, char[] pattern, int s_size, int p_size) {
		int[] table = makeTable(pattern, p_size);
		
		int idx = 0; // 현재 대응되는 글자 수
		int result = 0; // search 안에 있는 pattern의 개수
		
		for (int i = 0; i < s_size; i++) {
			// idx번 글자와 짚더미의 해당 글자가 불일치할 경우
			// 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
			while(idx > 0 && search[i] != pattern[idx]) {
				idx = table[idx-1];
			}
			
			// 글자가 대응할 경우
			if (search[i] == pattern[idx]) {
				if (idx == p_size-1) {
					idx = table[idx];
					result++;
				}
				// 맞았지만 pattern이 끝나지 않았다면
				else idx += 1;
			}
		}
		
		// 결과 출력
		System.out.println(result);
	}

}
