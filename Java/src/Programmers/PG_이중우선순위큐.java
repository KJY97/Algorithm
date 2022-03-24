package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PG_이중우선순위큐 {

	/**
	 * 문제
	 *  이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말한다.
	 *  ==========================
	 *   I 숫자  : 큐에 주어진 숫자를 삽입
	 *   D 1   : 큐에서 최댓값을 삭제
	 *   D -1  : 큐에서 최솟값을 삭제
	 *  ==========================
	 *  이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
	 *  모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 RETURN 하라.
	 *   - operations는 길이가 1 이상 1,000,000 이하인 문자열 배열
	 *   - operations의 원소는 큐가 수행할 연산을 나타낸다.
	 *     - 원소는 “명령어 데이터” 형식으로 주어집니다.
	 *     - 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제한다.
	 *   - 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시한다.
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"I 16","D 1"})));
		System.out.println(Arrays.toString(solution(new String[] {"I 7","I 5","I -5","D -1"})));
	}
	
	public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소힙
        
        for (int i = 0; i < operations.length; i++) {
			String[] op = operations[i].split(" ");
			
			String command = op[0];
			int num = Integer.parseInt(op[1]);
			
			if(command.equals("I")) {
				minHeap.offer(num);
			} 
			else if(command.equals("D")) {
				
				// 빈 큐에 삭제 연산이 들어오면 무시된다.
				if(minHeap.isEmpty()) continue;
				
				if(num == -1) { // 최소값 삭제
					 minHeap.poll();
				}
				else if(num == 1) { // 최댓값 삭제
					
					PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1); // 최대힙
					maxHeap.addAll(minHeap);
					maxHeap.poll();
					
					minHeap.clear();
					minHeap.addAll(maxHeap);
				}
			}
		}
        
        int min = minHeap.isEmpty() ? 0 : minHeap.poll();
        int max = 0;
        while(!minHeap.isEmpty()) {
        	int tmp = minHeap.poll();
        	if(max < tmp) max = tmp;
        }
        	
        int[] answer = {max, min};
        return answer;
    }

}
