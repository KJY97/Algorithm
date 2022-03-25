package Programmers;

import java.util.Arrays;

public class PG_체육복 {

	/**
	 * 문제
	 *  점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했다.다행히  여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 한다.
	 *  학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
	 *  예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있다.
	 *  체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 한다.
	 *  전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
	 *  여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 리턴하라.
	 *   - 전체 학생의 수는 2명 이상 30명 이하
	 *   - 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없다.
	 *   - 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없다.
	 *   - 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있다.
	 *   - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있다. 
	 *     이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없다.
	 */
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5})); // 5
		System.out.println(solution(5, new int[] {2, 4}, new int[] {3})); // 4
		System.out.println(solution(3, new int[] {3}, new int[] {1})); // 2
		System.out.println(solution(5, new int[] {1, 2, 4}, new int[] {2, 4, 5})); // 4
		System.out.println(solution(5, new int[] {1, 2, 4}, new int[] {2, 3, 4, 5})); // 4
	}

	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 체육수업 들을 수 있는 학생 수
        
        // 오름차순으로 정렬한다.
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우, 여벌 체육복은 해당 학생이 입는다.
        // 즉, 체육 수업에 참여할 수 있다.
        for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if(reserve[i] == lost[j]) {
					answer++;
					lost[j] = -1;
					reserve[i] = -1;
				}
			}
		}
        
        // 체육복을 도난당한 학생이 여벌 체육복을 빌려 입을 수 있는 경우, 체육 수업에 참여할 수 있다.
        // 즉, 여벌 체육복을 가져온 학생은 자신의 앞/뒤 학생에게 체육복을 빌려준다. 
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {
					answer++;
					lost[i] = -1;
					reserve[j] = -1;
				}
			}
		}
        return answer;
    }

}
