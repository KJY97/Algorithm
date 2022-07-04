package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1316 {

	/**
	 * 문제
	 *  그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
	 *  예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
	 *  aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
	 *  단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
	 *   - 단어의 개수 N (1 <= N <= 100)
	 *   - 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
	 *   - 제한시간 2초
	 * 
	 * => 100 x 100 x 100 = 1000000 이므로 제한시간 내 가능
	 *   (단어 개수) x (단어 길이) x (contains)
	 *   
	 * 시간: 80 ms
	 * 메모리: 11664 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 단어의 개수
		
		List<Character> list = null; // 각 단어에서 등장하는 문자 저장
		int answer = 0; // 그룹 단어의 개수
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			boolean isGroupWord = true; // 그룹 단어인지 아닌지 체크
			
			list = new LinkedList<>();
			list.add(word.charAt(0)); // 첫번째 단어는 무조건 저장
			
			for (int j = 1; j < word.length(); j++) {
				char ch = word.charAt(j);
				// 같은 문자가 연속해서 나오는가?
				if (word.charAt(j-1) == ch) continue;
				
				// 다른 문자가 나온다면 그 단어는 새로운 단어인가?
				if (list.contains(ch)) {
					// 이미 출현했던 문자라면 그룹단어가 될 수 없다.
					isGroupWord = false;
					break;
				}
				
				// 새로운 단어 저장
				list.add(ch);
			}
			// 그룹단어라면 카운트 증가
			if (isGroupWord) answer++;
		}
		
		System.out.println(answer);
	}

}
