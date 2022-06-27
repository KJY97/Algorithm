package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2525 {

	/**
	 * 문제
	 *  KOI 전자에서는 건강에 좋고 맛있는 훈제오리구이 요리를 간편하게 만드는 인공지능 오븐을 개발하려고 한다. 
	 *  인공지능 오븐을 사용하는 방법은 적당한 양의 오리 훈제 재료를 인공지능 오븐에 넣으면 된다. 
	 *  그러면 인공지능 오븐은 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다. 
	 *  또한, KOI 전자의 인공지능 오븐 앞면에는 사용자에게 훈제오리구이 요리가 끝나는 시각을 알려 주는 디지털 시계가 있다. 
	 *  훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때, 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.
	 *  단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다. 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.
	 *   - 현재 시각은 시 A (0 ≤ A ≤ 23), 분 B (0 ≤ B ≤ 59)
	 *   - 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어짐.
	 *   
	 * 시간: 76 ms
	 * 메모리: 11520 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken()); // 시
		int min = Integer.parseInt(st.nextToken()); // 분
		
		int cook_time = Integer.parseInt(br.readLine()); // 요리하는데 필요한 시간(분 단위)
		
		min = min + cook_time;
		
		if (min >= 60) {
			hour = hour + min / 60;
			min = min % 60;
		}
		
		if (hour >= 24) hour = hour % 24;
		
		System.out.println(hour + " " + min);
	}

}
