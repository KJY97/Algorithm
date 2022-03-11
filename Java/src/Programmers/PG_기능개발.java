package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PG_기능개발 {

	/**
	 * 문제
	 *  프로그래머스 팀에서는 기능 개선 작업을 수행 중이다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있다.
	 *  또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
	 *  이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다.
	 *  먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
	 *  각 배포마다 몇 개의 기능이 배포되는지 solution을 작성한다.
	 *  
	 *   - 작업의 개수(progresses, speeds배열의 길이)는 100개 이하
	 *   - 작업 진도는 100 미만의 자연수
	 *   - 작업 속도는 100 이하의 자연수
	 *   - 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
	 *     예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어진다.
	 */
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55}; // 각 작업의 진도
		int[] speeds = {1, 30, 5}; // 각 작업의 개발 속도
		
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
		System.out.println(Arrays.toString(solution(progresses2, speeds2)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        
		// 남은 작업 기간 구하기
        int[] day = new int[speeds.length];
        
        for(int i = 0; i < speeds.length; i++) {
        	int tmp = 100 - progresses[i];
        	
        	if(tmp % speeds[i] == 0) day[i] = tmp/speeds[i];
        	else day[i] = tmp/speeds[i] + 1;
        }
        
        // 각 배포마다 몇 개의 기능이 같이 배포되는지 구하기
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < day.length; i++) {
        	int cnt = 1;
        	if(day[i] < 0) continue; // 이미 배포된 기능은 pass
        	
        	for (int j = i+1; j < day.length; j++) {
        		if(day[i] >= day[j]) {
                    day[j] = -1; // 함께 배포되므로 대상에서 제외
                    cnt++;
                }
				else break;
			}
        	answer.add(cnt);
        }
        
        // List를 배열 형식으로 변환
        return answer.stream().mapToInt(i ->i).toArray();
    }
}
