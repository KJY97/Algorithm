package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_다리를지나는트럭 {

	/**
	 * 문제
	 *  트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 한다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 한다. 
	 *  다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있다. 
	 *  단, 다리에 완전히 오르지 않은 트럭의 무게는 무시한다.
	 *  예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있다.
	 *  무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 한다.
	 *  따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸린다.
	 *  solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 
	 *  트럭 별 무게 truck_weights가 주어진다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 구하라.
	 *   - bridge_length는 1 이상 10,000 이하
	 *   - weight는 1 이상 10,000 이하
	 *   - truck_weights의 길이는 1 이상 10,000 이하
	 *   - 모든 트럭의 무게는 1 이상 weight 이하
	 *   
	 * => 빠진 조건 존재
	 *     트럭은 다리를 1초에 1칸 전진
	 *     트럭이 다리에 올라가는 순서는 주어진 순서로 해야한다.
	 * => 다리 길이가 bridge_length
	 */
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7,4,5,6})); // 8
		System.out.println(solution(100, 100, new int[] {10})); // 101
		System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		// 다리를 큐로 표현. 다리 길이를 고려하기 위해 0으로 채우기(초기 세팅)
		// 마치 bridge_length길이 만큼의 공기(0)가 다리 위에 있다고 가정한다.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
			queue.offer(0);
		}
        
     	int current_weight = 0;  // 현재 다리를 건너는 트럭의 무게 합
     	int time = 0; // 모든 트럭이 다리를 통과하는데 걸린 시간
     	
     	for (int truck : truck_weights) {
     		// 트럭이 다리에 올라가면 최대 용량을 넘기는 경우
     		while(current_weight + truck - queue.peek() > weight) {
     			// 현재 다리에 남아있는 트럭 이동
     			current_weight -= queue.poll();
     			// 다리에 못올라오므로 공기가 대신 들어온다.
     			queue.offer(0);
     			time++;
     		}
     		// 트럭이 올라갈 수 있는 경우
     		current_weight -= queue.poll();
     		current_weight += truck;
     		queue.offer(truck);
     		time++;
		}
     	// 마지막 트럭이 다리에 올라간 상태에서 다리 길이 더하기(다리 길이가 곧 한 트럭의 이동 시간이기 때문)
        return bridge_length+time;
    }

}
