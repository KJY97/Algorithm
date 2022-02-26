package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1216 {

	/**
	 * 문제
	 *  거꾸로 읽어도 앞에서부터 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
	 *  주어진 100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제
	 *   - EX) "기러기" 또는 "level"
	 *   - 'A', 'B', 'C' 중 하나가 들어감
	 *   - A 또한 길이 1짜리 회문
	 *   - 가로, 세로 각각에 대해서 직선으로만 판단
	 * 
	 * => 1억을 계산하는데 1초가 걸린다.
	 * => 100 x 100 x 100 = 1000000 이므로 시간제한를 벗어나지 않으므로 괜찮다.
	 * 
	 * 시간: 461 ms
	 * 메모리: 107,008 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine()); //테스트 케이스 번호
			
			// 초기화
			char[][] map = new char[100][100];	// 행x열
			char[][] reMap = new char[100][100]; // 열x행
			
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j);
					reMap[j][i] = str.charAt(j);
				}
			}
			
			// 가로 방향에서의 가장 긴 회문 길이 vs 세로 방향에서의 가장 긴 회문 길이
			int ans = Math.max(findMaxLength(map), findMaxLength(reMap));
			System.out.println("#" + test_case + " " + ans);
		}
		
	}
	
	// 해당 방향으로 가장 긴 회문의 길이 구하기
	public static int findMaxLength (char[][] arr) {
		int max = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = j+1; k <= 100; k++) {
					char[] tmp = Arrays.copyOfRange(arr[i], j, k); // i행의 배열을 j부터 k길이만큼 자르기
					if(palindrome(tmp, tmp.length)) max = Math.max(max, tmp.length);
				}
			}
		}
		return max;
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
