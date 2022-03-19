package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_단어변환 {

	/**
	 * 문제
	 *  두 개의 단어 begin, target과 단어의 집합 words가 있다.
	 *  아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 한다.
	 *  ====================================
	 *   1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
	 *   2. words에 있는 단어로만 변환할 수 있습니다.
	 *  ==================================== 
	 *  예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 
	 *  "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있다.
	 *  두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 
	 *  최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
	 *   - 각 단어는 알파벳 소문자로만 이루어져 있다.
	 *   - 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같다.
	 *   - words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없다.
	 *   - begin과 target은 같지 않다.
	 *   - 변환할 수 없는 경우에는 0를 return 한다.
	 */
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
		System.out.println(solution("aaa", "abc", new String[] {"aac", "bac", "ccb", "abc", "cba", "bbb"}));
	}
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // BFS 사용
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length]; // 방문처리
        
        queue.add(new Point(begin, 0));
        
        while(!queue.isEmpty()) {
        	Point current = queue.poll();
        	
        	if(current.word.equals(target)) {
        		answer = current.cnt;
        		break;
        	}
        	
        	for (int i = 0; i < words.length; i++) {
        		String next = words[i];
        		int next_cnt = current.cnt + 1;
        		
        		// 방문하지 않았고, 변환이 가능한 문자라면
				if(!visited[i] && isAvailable(current.word, next)) {
					visited[i] = true;
					queue.add(new Point(next, next_cnt));
				}
			}
        }
        
        return answer;
    }
	
	public static class Point {
		String word; // 단어
		int cnt; // 바뀌는 단계의 수
		
		public Point(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}
	
	// word와 compare의 차이가 1이라면 compare는 변환 가능한 단어이다.
	public static boolean isAvailable(String word, String compare) {
		int different = 0;
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != compare.charAt(i)) different++;
		}
		return different == 1;
	}

}
