package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {

	/**
	 * 문제
	 *  달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하기
	 *   - 높이가 V미터인 나무 막대
	 *   - 낮에는 A미터만큼 올라가고, 밤에는 B미터 미끄러진다. 
	 *   - 시간 제한 존재. while문으로 하면 시간 초과
	 *   
	 * 시간: 76 ms
	 * 메모리: 11504 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1 ≤ B < A ≤ V ≤ 1,000,000,000
		int A = Integer.parseInt(st.nextToken()); // 올라가는 길이
		int B = Integer.parseInt(st.nextToken()); // 미끄러지는 길이
		int V = Integer.parseInt(st.nextToken()); // 나무 막대 높이
		
		// (A-B) * cnt = V - B
		int cnt = (V-B) % (A-B) == 0 ? (V-B)/(A-B) : (V-B)/(A-B)+1;
		System.out.println(cnt);
		
	}

}
