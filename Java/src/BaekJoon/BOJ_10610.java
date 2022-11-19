package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_10610 {

	/**
	 * 문제
	 *  어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다.
	 *  미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
	 *  미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
	 *  미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.
	 *   - N는 최대 10⁵개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
	 *   - 제한시간 1초
	 * 
	 * => 30은 10의 배수이면서 3의 배수
	 *    그러므로 30의 배수가 되려면 모든 자릿수의 합이 3의 배수이고, 0이 존재해야 한다.
	 *    
	 * 시간: 252 ms
	 * 메모리: 23824 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		List<Integer> nums = new ArrayList<>();
		
		for (int i = 0; i < N.length(); i++) {
			int tmp = N.charAt(i) - '0';
			nums.add(tmp);
		}
		
		// 가장 큰 30의 배수를 만들어야 하므로 내림차순 정렬
		Collections.sort(nums, Collections.reverseOrder());
		
		boolean isZero = false; // 0이 존재하나? (10의 배수 확인)
		int sum = 0; // 3의 배수 확인
		
		// N에 0이 존재하는지 확인
		for (Integer num : nums) {
			if (num == 0) isZero = true;
			sum += num;
		}
		
		// 0이 없다면 30의 배수가 될 수 없으므로 -1 출력
		// 모든 자릿 수의 합이 3의 배수가 아니라면 -1 출력
		if (!isZero || sum % 3 != 0) {
			sb.append(-1);
		} else {
			for (Integer num : nums) {
				sb.append(num);
			}
		}
		
		System.out.println(sb.toString());
	}

}
