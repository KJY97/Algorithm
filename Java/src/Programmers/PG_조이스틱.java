package Programmers;

public class PG_조이스틱 {

	/**
	 * 문제
	 *  조이스틱으로 알파벳 이름을 완성하자. 맨 처음엔 A로만 이루어져 있다.
	 *  조이스틱을 각 방향으로 움직이면 아래와 같습니다
	 *  ==============================================================
	 *   ▲ - 다음 알파벳
	 *   ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로) 
	 *   ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
	 *   ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
     *  ==============================================================
     *  만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 출력하라.
     *   - ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
     *   - name은 알파벳 대문자로만 이루어져 있다.
     *   - name의 길이는 1 이상 20 이하
     *   
     * => 빠진 조건 존재.. 오른쪽/왼쪽으로 가다가 왼쪽/오른쪽으로 방향 전환 가능
	 */
	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
		System.out.println(solution("BBBBAAAABA")); // 12
	}
	
	public static int solution(String name) {
		int answer = 0;
		int length = name.length();
		int move = length - 1; // 오른쪽으로만 이동한 경우
		
        for (int i = 0; i < length; i++) {
        	// 상하로 움직일 때의 조작 횟수 구하기
        	char ch = name.charAt(i);
        	answer += Math.min(ch - 'A', 'Z' - ch + 1);
        	
        	int idx = i+1;
        	// 다음 단어가 A로 시작하는지, 연속된 A가 몇개나오는지 체크
        	while(idx < length && name.charAt(idx) == 'A') {
        		idx++;
        	}
        	
        	// 오른쪽으로 가다가 연속된 A를 만나고 다시 왼쪽으로 이동하는 경우
			move = Math.min(move, i+i+(length-idx));
			// 왼쪽으로 가다가 연속된 A를 만나고 다시 오른쪽으로 이동하는 경우
			move = Math.min(move, (length-idx)*2+i);
		}

        return answer+move;
    }

}
