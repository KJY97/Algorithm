package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206 {

	/**
	 * 문제
	 *  강변에 빌딩들이 옆으로 빽빽하게 밀집한 지역이 있다. 이곳에서는 빌딩들이 너무 좌우로 밀집하여, 
	 *  강에 대한 조망은 모든 세대에서 좋지만 왼쪽 또는 오른쪽 창문을 열었을 때 바로 앞에 옆 건물이 보이는 경우가 허다하였다. 
	 *  그래서 이 지역에서는 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
	 *  빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램 작성하기
	 *   - 가로 길이는 항상 1000이하
	 *   - 맨 왼쪽 2칸과 맨 오른쪽 2칸에는 건물이 지어지지 않는다.
	 *   - 각 빌딩 높이는 최대 255
	 *   
	 * 시간: 125 ms
	 * 메모리: 22,752 kb
	 */
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        for(int test_case = 1; test_case <= 10; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	// 초기화
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] riverSide = new int[N];
        	
        	for (int i = 0; i < N; i++) {
        		riverSide[i] = Integer.parseInt(st.nextToken());
			}
        	
        	int ans = 0; // 조망권이 확보된 세대 수
        	for (int i = 2; i < N-2; i++) { // 맨 왼쪽과 맨 오른쪽 2칸에는 건물이 없다.
        		
        		int min = riverSide[i]; // 해당 건물에서 조망권이 확보된 세대 수
        		for (int j = i-2; j <= i+2; j++) {
        			if(i == j) continue; // 빌딩 본인은 pass
        			
        			// 거리내에 있는 건물의 크기가 같거나 크면 더이상 체크할 필요가 없다.
					if(riverSide[i] <= riverSide[j]) {
						min = 0;
						break;
					}
					// 거리내 있는 큰 건물(i보단 작은) 기준으로 조망권이 확보되기 때문!
					min = Math.min(min, riverSide[i] - riverSide[j]);
				}
        		ans += min; // 모든 세대수를 구해야 하므로 덧셈을 해준다.
			}
        	
        	System.out.println("#" + test_case + " " + ans);
        }

	}

}
