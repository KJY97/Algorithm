package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_11445 {

	/**
	 * 문제
	 *  영어 알파벳으로 만들 수 있는 모든 단어(그것이 뜻이 없어도)가 수록된 무한 사전이 있다.
	 *  두 단어 P, Q가 주어질 때, 사전 상에서 P와 Q사이에 다른 단어가 있는지(Y) 없는지(N) 판별하는 프로그램을 작성하라.
	 *   - P, Q의 길이는 1 ~ 10
	 *   - P는 Q보다 사전 상 먼저 오는 단어
	 *   - 단, 사전에는 10자보다 더 긴 단어가 존재 할 수 있다.
	 * 
	 * => 다양한 경우의 수가 존재하므로 하나하나 체크해보면서 풀이하자.
	 *  => man vs mana
	 *  => cat vs dog
	 *  => apple vs cat 
	 *  => dog vs dog
	 *  => banana vs bananaaa
	 * 
	 * 시간: 112 ms
	 * 메모리: 19,476 kb
	 */
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
     
        for(int test_case = 1; test_case <= T; test_case++) {
        	// 공백 제거 : 입력값에 공백이 존재한다.
        	String P = br.readLine().replace(" ", ""); // 먼저 오는 단어
        	String Q = br.readLine().replace(" ", ""); // 뒤에 오는 단어
        	
        	// P다음에 바로 다른 단어가 있는가?
        	char ans = 'Y';
        	if(P.length() > Q.length()) {
        		ans = checkNextWord(P, Q);
        	} else {
        		ans = checkNextWord(Q, P);
        	}
        	
        	System.out.println("#" + test_case + " " + ans);
        }
    }
	
	// P다음이 바로 Q인지 체크
	public static char checkNextWord(String big, String small) {
		
		int s_size = small.length();
		int b_size = big.length();
		
		for (int i = 0; i < s_size; i++) {
    		if(big.charAt(i) != small.charAt(i)) return 'Y'; 
		}
		
		if(b_size == s_size) return 'N';
		
		// 글자 길이가 1 차이나면서 바로 그 다음 문자가 a로 시작한다면..
		if(b_size == s_size + 1 && big.charAt(s_size) == 'a') return 'N';
		
		// 글자 길이가 차이가 2이상 나는 경우
		return 'Y';
	}
}