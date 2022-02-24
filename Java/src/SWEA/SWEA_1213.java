package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1213 {

	/**
	 * 문제
	 *  주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하기
	 *   - 문장의 길이는 1000자를 넘어가지 않는다.
	 *   - 한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.
	 *   
	 * 시간: 101 ms
	 * 메모리: 18,356 kb
	 */
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        for(int test_case = 1; test_case <= 10; test_case++) {
        	int T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
        	String find = br.readLine();
        	String sentence = br.readLine();
        	
        	int cnt = 0; // 특정 문자열 개수 카운트
        	while(sentence.indexOf(find) != -1) {
        		// find 문자열의 index는 find가 시작하는 index를 반환한다.
        		// 찾은 find를 제외한 나머지 문자열에서 찾기 위해 find 길이를 더한다.
        		sentence = sentence.substring(sentence.indexOf(find)+find.length());
        		cnt++;
        	}
        	
        	System.out.println("#" + test_case + " " + cnt);
        }
        
    }
}
