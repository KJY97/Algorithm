package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_10804 {
	
	/**
	 * 문제
	 *  ‘b’, ‘d’, ‘p’, ‘q’로 이루어진 문자열이 주어진다. 이 문자열을 거울에 비추면 어떤 문자열이 되는지 구하기
	 *  예를 들어, “bdppq”를 거울에 비추면 “pqqbd”처럼 나타날 것이다.
	 *  
	 * 시간: 209 ms
	 * 메모리: 99,268 kb
	 */
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
     
        for(int test_case = 1; test_case <= T; test_case++) {
        	String str = br.readLine(); // 길이는 1 ~ 1000이하
        	
        	String ans = "";
        	for (int i = str.length() - 1; i >= 0; i--) { // 거울이니까 뒤에서부터 접근
        		char ch = str.charAt(i);
        		
        		switch(ch) {
	        		case 'b' : ans += 'd'; break;
	        		case 'd' : ans += 'b'; break;
	        		case 'p' : ans += 'q'; break;
	        		case 'q' : ans += 'p'; break;
        		}
			}
        	System.out.println("#" + test_case + " " + ans);
        }

	}

}
