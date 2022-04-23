package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375 {

	/**
	 * 문제
	 *  해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 
	 *  예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 
	 *  해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
	 *   - 1 <= T <= 100
	 *   - 해빈이가 가진 의상 수 N (0 <= N <= 30)
	 *   - 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
	 * 
	 * => 조합
	 * 
	 * 시간 : 84 ms
	 * 메모리 : 11796 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 해빈이가 가진 의상 수
			
			HashMap<String, Integer> hash = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				String value = st.nextToken();
				String key = st.nextToken();
				
				hash.put(key, hash.getOrDefault(key, 0)+1);
			}
			
			// 각 의상에 아무것도 착용하지 경우도 추가해서 조합을 이용하여 계산한다. 예) headgear = hat, turban, null(착용하지 않는 경우)
			// 즉, 3C1 x 2C1 - 1(=nullxnull인 경우 제외)
			int answer = 1;
			for (Integer value : hash.values()) {
				answer *= (value+1);
			}
			
			System.out.println(answer - 1);
		}
	}

}
