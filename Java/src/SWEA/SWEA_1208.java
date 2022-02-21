package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208 {

	/**
	 * 문제
	 *  한 쪽 벽면에 다음과 같이 노란색 상자들이 쌓여 있다.
	 *  높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.
	 *  평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.
	 *  평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 
	 *  제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하기
	 *   - 가로 길이는 100
	 *   - 모든 위치에서 상자 높이는 1 ~ 100
	 *   - 덤프 횟수는 1 ~ 1000
	 *   - 덤프란 최고점에 있는 상자 최저점으로 이동
	 *   
	 * 시간: 105 ms
	 * 메모리: 19,356 kb
	 */
	static int max_i, min_i;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 덤프 횟수
			int[] map = new int[100];
			
			// 상자 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			max_i = 0; min_i = 0; // 최대값, 최소값을 가진 인덱스 저장
			
			for (int i = 0; i < N; i++) {
				// 최고점과 최저점 찾기
				findMaxMin(map);
				
				// 평탄화가 덤프 이내에 완료됨
				if(map[max_i] - map[min_i] <= 1) break;
				
				// 덤프 작업 실행
				map[max_i]--;
				map[min_i]++;
			}
			
			// 마지막 덤프 이후 바뀐 최고점, 최저점 찾기
			findMaxMin(map);
			
			int ans = map[max_i] - map[min_i];
			System.out.println("#" + test_case + " " + ans);
		}

	}
	
	// 최고점, 최저점 찾기
	public static void findMaxMin(int[] arr) {
		int max = 0, min = 100;
		
		for (int i = 0; i < 100; i++) {
			if(max < arr[i]) {
				max = arr[i];
				max_i = i;
			}
			
			if(min > arr[i]) {
				min = arr[i];
				min_i = i;
			}
		}
	}

}
