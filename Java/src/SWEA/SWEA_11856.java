package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11856 {

	/**
	 * 문제
	 *  길이 4의 알파벳 대문자로 이루어진 문자열 S가 주어졌을 때, 
	 *  S에 정확히 두 개의 서로 다른 문자가 등장하고, 각 문자가 정확히 두 번 등장하는 지 판별하라.
	 *   
	 * 시간: 102 ms
	 * 메모리: 19,444 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine(); // 길이 4인 대문자로 이루어진 문자열
			
			int[] alphabet = new int[26];
			for (int i = 0; i < 4; i++) {
				int idx = str.charAt(i) - 'A';
				alphabet[idx]++;
			}
			
			String ans = checkCnt(alphabet) ? "Yes" : "No";
			System.out.println("#" + test_case + " " + ans);
		}

	}
	// 서로 다른 문자 2개가 등장하고, 각각 2번씩 등장했는지 체크
	public static boolean checkCnt(int[] arr) {
		int cnt = 0; 
		for (int i = 0; i < 26; i++) {
			if(arr[i] == 2) cnt++; 
		}
		
		if(cnt == 2) return true;
		return false;
	}

}
