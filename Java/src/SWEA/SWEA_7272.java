package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272 {

	/**
	 * 문제
	 *  경근이는 알파벳 대문자로 이루어진 두 문자열을 비교해야 했는데, 이 날은 공교롭게도 안경이 없었다.
	 *  경근이는 매우 눈이 나빠서 안경을 벗으면 문자열을 문자 단위로 구별할 수는 있지만, 두 문자가 정확히 같은 지는 알지 못한다.
	 *  특히 알파벳 대문자 같은 경우 문자에 나 있는 구멍의 개수가 같으면 같은 문자이고, 다르면 다른 문자라고 생각한다.
	 *  알파벳 대문자로 이루어진 두 문자열이 주어졌을 때, 경근이는 두 문자열이 같다고 판별하는지 다르다고 판별할 것인가?
	 *   - 같은 문자라고 생각하는 조합
	 *    : CEFGHIJKLMNSTUVWXYZ
	 *    : ADOPQR
	 *    : B
	 *   - 각 문자열은 길이 10이하
	 *   
	 * 시간: 220 ms
	 * 메모리: 33,860 kb
	 */
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken(); 
            String str2 = st.nextToken();
             
            int left = 0;
            int right = 0;
            String ans = "SAME";
             
            for(int i = 0; i < str1.length(); i++) 
            {
                if(str1.length() != str2.length()) {
                	ans = "DIFF";
                    break;
                }
                 
                // 왼쪽 문자열 숫자 변환
                if(str1.charAt(i) == 'B') {
                    left = 2;
                }else if(str1.charAt(i) == 'A' || str1.charAt(i) == 'D' || str1.charAt(i) == 'P' || str1.charAt(i) == 'Q' || str1.charAt(i) == 'O' || str1.charAt(i) == 'R') {
                    left = 1;
                }else {
                    left = 0;
                }
                 
                // 오른쪽 문자열 숫자 변환
                if(str2.charAt(i) == 'B') {
                    right = 2;
                }else if(str2.charAt(i) == 'A' || str2.charAt(i) == 'D' || str2.charAt(i) == 'P' || str2.charAt(i) == 'Q' || str2.charAt(i) == 'O' || str2.charAt(i) == 'R') {
                    right = 1;
                }else {
                    right = 0;
                }
                 
                if(left != right) {
                	ans = "DIFF";
                    break;
                }
            }
             
            System.out.println("#" + test_case + " " + ans);
        }
    }
}