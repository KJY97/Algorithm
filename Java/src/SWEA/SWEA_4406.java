package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4406 {

	/**
	 * 문제
	 *  불의의 교통사고를 당한 당신은 얼마 후 자신의 인식 속에서 모음이라는 것이 사라진 것을 알게 되었다.
	 *  알파벳 소문자 만으로 이루어진 단어를 당신은 어떤 식으로 보게 될까?
	 *  예를 들어 “congratulation”이라는 단어를 당신이 보게 되면 “cngrtltn”으로 인식하게 될 것이다.
	 *   - 모음은 ‘a’, ‘e’, ‘i’, ‘o’, ‘u’
	 *   - 길이가 50이하이고 알파벳 소문자만으로 이루어진 단어가 주어진다.
	 *   
	 * 시간: 100 ms
	 * 메모리: 18,668 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			String ans = ""; // 자음만 저장한 문자열
			
			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				
				if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') continue;
				
				ans += tmp;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
