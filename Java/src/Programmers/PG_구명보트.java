package Programmers;

import java.util.Arrays;

public class PG_구명보트 {

	/**
	 * 문제
	 *  무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 한다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있다.
	 *  예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 
	 *  2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없다.
	 *  구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 한다.
	 *  사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
	 *  모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하라.
	 *   - 무인도에 갇힌 사람은 1명 이상 50,000명 이하
	 *   - 각 사람의 몸무게는 40kg 이상 240kg 이하
	 *   - 구명보트의 무게 제한은 40kg 이상 240kg 이하
	 *   - 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없다.
	 *   
	 * => 정렬 후 몸무게가 많이 나가는 사람과 적게 나가는 사람끼리 보트에 태워 보낸다.
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100)); // 3
		System.out.println(solution(new int[] {70, 80, 50}, 100)); // 3
		System.out.println(solution(new int[] {40, 40, 40}, 100)); // 2
		System.out.println(solution(new int[] {50, 30, 20, 70, 10}, 100)); // 3
	}
	
	public static int solution(int[] people, int limit) {
		int answer = 0; // 구명보트 개수
        int index = 0;
        
		// 오름차순 정렬
		Arrays.sort(people);
		
        for (int i = people.length - 1; i >= index; i--) {
        	// 몸무가게 많이 나가는 사람과 적게 나가는 사람끼리 보트 탑승 가능한 경우
			if(people[i] + people[index] <= limit) {
				index++;
				answer++;
			}
			// 몸무게가 많이 나가는 사람 혼자 탑승해야 함
			else answer++;
		}
        return answer;
    }
}
