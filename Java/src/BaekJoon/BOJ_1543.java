package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {

	/**
	 * 문제
	 *  세준이는 영어로만 이루어진 어떤 문서를 검색하는 함수를 만들려고 한다. 이 함수는 어떤 단어가 총 몇 번 등장하는지 세려고 한다.
	 *  그러나, 세준이의 함수는 중복되어 세는 것은 빼고 세야 한다. 
	 *  예를 들어, 문서가 abababa이고, 그리고 찾으려는 단어가 ababa라면, 세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다.
	 *  그러나 동시에 셀 수는 없다.
	 *  세준이는 문서와 검색하려는 단어가 주어졌을 때, 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.
	 *   - 문서의 길이는 최대 2500이다. 
	 *   - 검색하고 싶은 단어의 길이는 최대 50이다
	 *   - 문서와 단어는 알파벳 소문자와 공백으로 이루어져 있다.
	 *   - 제한시간 2초
	 *   
	 * 시간: 76 ms
	 * 메모리: 11484 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String doc = br.readLine(); // 문서
		String word = br.readLine(); // 검색하려는 단어

		countWordsInDoc(doc, doc.length(), word);
	}
	
	// 어떤 단어가 총 몇 번 나오는가?
	public static void countWordsInDoc(String doc, int size, String word) {
		int cnt = 0; // 단어 수 세기
		int idx = 0; // 시작할 위치
		
		while(true) {
			// idx 위치부터 doc에서 word 찾기
			idx = doc.indexOf(word, idx);
			
			// 단어가 존재하지 않는다면 반복문 탈출
			if (idx == -1) break;
			
			// word가 시작하는 위치를 찾았다면 카운트 증가 및 시작 위치 조정
			cnt++;
			idx += word.length(); // 찾은 위치의 뒤부터 탐색하기 위해
		}
		
		System.out.println(cnt);
	}

}
