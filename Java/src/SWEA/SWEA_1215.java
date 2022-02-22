package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1215 {

	/**
	 * 문제
	 *  거꾸로 읽어도 앞에서부터 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
	 *  주어진 8x8 평면 글자판에서 가로, 세로를 모두 보아 제시된 길이를 가진 회문의 총 개수를 구하기
	 *   - EX) "기러기" 또는 "level"
	 *   - 'A', 'B', 'C' 중 하나가 들어감
	 *   - A 또한 길이 1짜리 회문
	 *   - 가로, 세로 각각에 대해서 직선으로만 판단
	 *   
	 * 시간: 98 ms
	 * 메모리: 19,684 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 찾아야 하는 회문의 길이
			
			// 초기화
			char[][] map  = new char[8][8]; // 행x열
			char[][] reMap = new char[8][8]; // 열x행
			
			for (int i = 0; i < 8; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = tmp.charAt(j);
					reMap[j][i] = tmp.charAt(j);
				}
			}
			
			// 회문의 개수
			int ans = countPalin(map, N) + countPalin(reMap, N); 

			System.out.println("#" + test_case + " " + ans);
		}
		
	}
	
	// 해당 방향으로 회문이 몇 개있는지 카운트
	public static int countPalin(char[][] chr, int N) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <= 8-N; j++) {
				char[] tmp = Arrays.copyOfRange(chr[i], j, j+N); // j부터 N길이만큼 자르기
				if(palindrome(tmp, N)) cnt++;
			}
		}
		return cnt;
	}
	
	// 회문인가?
	public static boolean palindrome(char[] chr, int size) {
		// 홀수일 때 가운데 단어는 굳이 체크하지 않는다
		for (int i = 0; i < size/2; i++) {
			if(chr[i] != chr[size-1-i]) return false;
		}
		return true;
	}
}
