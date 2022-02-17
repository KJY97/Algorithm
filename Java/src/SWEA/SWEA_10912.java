package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_10912 {

	/**
	 * 문제
	 *  알파벳 소문자 만으로 이루어진 문자열이 주어진다.
	 *  이 문자열에서 같은 두 문자들을 짝짓고 남는 문자가 무엇인지 사전순으로 출력하기
	 *  같은 문자를 여러 번 짝지어서는 안 된다
	 *   - 문자열의 길이는 1이상 100이하
	 *   - 어떤 문자도 남지 않는다면 "Good" 출력
	 *   
	 * 시간: 135 ms
	 * 메모리: 24,272 kb
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine(); // 문자열 길이 1 ~ 100
			
			// 각 문자가 몇번 나왔는지 체크
			int[] alphabet = new int[26];
			for (int i = 0; i < str.length(); i++) {
				alphabet[str.charAt(i) - 'a']++;
			}
			
			// 짝수로 나온 문자들은 출력하지 않는다
			String ans = "";
			for (int i = 0; i < 26; i++) {
				if(alphabet[i] % 2 == 0) continue;
				ans += (char)(i + 'a');
			}
			
			
			if(ans.equals("")) ans = "Good";
			
			System.out.println("#" + test_case + " " + ans);
		}

	}

}
