package Programmers;

import java.util.PriorityQueue;

public class PG_더맵게 {

	/**
	 * 문제
	 *  매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶다.
	 *  모든 음식의 스코빌 지수를 K이상으로 만들기 위해 Leo는 
	 *  스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식울 만든다.
	 *   ==============================================================================
	 *   섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 *   ==============================================================================
	 *  Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다. 
	 *  Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
	 *  모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 구하라.
	 *   - scoville의 길이는 2 이상 1,000,000 이하
	 *   - K는 0 이상 1,000,000,000 이하
	 *   - scoville의 원소는 각각 0 이상 1,000,000 이하
	 *   - 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다
	 *   
	 * => 우선순위큐를 사용하여 최소힙을 만든다.
	 * => 루트에 있는 값이 가장 작은 값이므로 이 값이 K보다 크다면 모든 음식의  스코빌 지수는 K 이상임을 알 수 있다.
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 최소힙(오름차순으로 정렬)으로 변경
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
			minHeap.add(scoville[i]);
		}
        
        while(minHeap.peek() < K) {
        	int min = minHeap.poll(); // 가장 맵지 않은 음식의 스코빌 지수
        	if(minHeap.isEmpty()) {
        		answer = -1;
        		break;
        	}
        	int second = minHeap.poll(); // 두번째로 맵지 않은 음식의 스코빌 지수
        	minHeap.add(min + second * 2);
        	answer++;
        }
        
        return answer;
    }
	
}
