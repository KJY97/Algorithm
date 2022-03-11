package Programmers;

import java.util.ArrayList;

public class PG_프린터 {

	/**
	 * 문제
	 *  일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
	 *  그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
	 *  이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
	 *  이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
	 *  ==========================================================================
	 *   1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	 *   2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	 *   3. 그렇지 않으면 J를 인쇄합니다.
	 *  ==========================================================================
	 *  
	 *  예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
	 *  내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
	 *  현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 
	 *  어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 구하시오
	 *  
	 *   - 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
	 *   - 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻
	 *   - location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현
	 */
	public static void main(String[] args) {
		int[] priorities1 = {2, 1, 3, 2};
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		
		System.out.println(solution(priorities1, 2));
		System.out.println(solution(priorities2, 1));
	}
	
	public static int solution(int[] priorities, int location) {
		
		ArrayList<int[]> list = new ArrayList<>();
		ArrayList<int[]> answer = new ArrayList<>();
		
		// int -> list로 변환
		for (int i = 0; i < priorities.length; i++) {
			// 중요도, 위치 저장
			list.add(new int[] {priorities[i], i});
		}
        
		// list 문서를 돌면서 중요도가 높은 순서대로 answer에 저장
        while(!list.isEmpty()) {
        	// 가장 앞에 있는 값 가져오기
        	int[] tmp = list.remove(0);
        	if(!isHigherThanMe(list, tmp)) answer.add(tmp);
        }
        
        // 원래 location 위치에 있던 값이 현재 어느 위치에 존재하는지 출력
        for (int i = 0; i < answer.size(); i++) {
			if(answer.get(i)[1] == location) return i+1;
		}
        return 0; // 존재하지 않았던 location이라면 어느 위치에도 존재하지 않는다.
    }
	
	// compare보다 중요도가 높은가?
	public static boolean isHigherThanMe(ArrayList<int[]> list, int[] compare) {
		for (int j = 0; j < list.size(); j++) {
    		// i보다 중요한 문서(순위가 높은 문서)가 있으면 list의 맨 뒤에 이동
			if(compare[0] < list.get(j)[0]) {
				list.add(compare);
				return true;
			}
		}
		return false;
	}
}
