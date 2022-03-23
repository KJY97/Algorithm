package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG_디스크컨트롤러 {

	/**
	 * 문제
	 *  하드디스크는 한 번에 하나의 작업만 수행할 수 있다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있다. 
	 *  가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것이다.
	 *  각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 
	 *  작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 구하라.
	 *  (단, 소수점 이하의 수는 버립니다)
	 *   - jobs의 길이는 1 이상 500 이하
	 *   - jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
	 *   - 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하
	 *   - 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하
	 *   - 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리
	 *   
	 * => cpu 스케줄링 중 SJF
	 * => 실행 작업 중 가장 빨리 끝나는 작업 선택하기
	 * => 단, 현재 시점에서 실행할 수 있는 작업이 없지만, 아직 수행할 작업이 남은 경우 주의하기
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,3}, {1,9}, {2,6}})); // 9
		System.out.println(solution(new int[][] {{1,3}, {5,6}, {1,9}})); // 9
	}
	
	public static int solution(int[][] jobs) {
        
		// jobs는 요청시간 순서대로 들어오지 않는다.
        // 요청시간 기준으로 정렬하되 동일한 시간이면 소요시간으로 정렬한다.
        Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) 
					return o1[1] - o2[1]; // 소요시간으로 정렬
				return o1[0] - o2[0]; // 요청시간 정렬
			}
		});
        
        return scheduling_SJF(jobs);
    }
	
	public static int scheduling_SJF(int[][] jobs) {
		// 우선순위큐를 이용해서 작업시간 기준으로 오름차순 정렬하는 힙 생성
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		int working_time = 0; // 작업 시간 
		int sum = 0; // 평균 작업 시간을 구하기 위한 변수
		int idx = 0; // 앞으로 수행할 작업을 가리키는 변수
		
        while(idx < jobs.length || !heap.isEmpty()) {
        	// 현재 작업 시간 내에 실행할 수 있는 작업이 있다면 큐에 저장
        	while(idx < jobs.length && jobs[idx][0] <= working_time) {
        		heap.offer(jobs[idx++]);
        	}
        	
        	// 앞으로 수행할 작업은 남아있는데 현재 시점에 실행할 작업이 없다면 가장 먼저 해야하는 작업의 요청 시간으로 시간 변경
        	if(heap.isEmpty()) {
        		working_time = jobs[idx][0];
        	}
        	else {
        		// 작업 처리
        		int[] job = heap.poll();
            	sum += working_time - job[0] + job[1];
            	working_time += job[1]; 
        	}
        }
        
        return sum / jobs.length;
	}

}
