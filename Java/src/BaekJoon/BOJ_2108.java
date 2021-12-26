package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BOJ_2108 {

	/**
	 * 문제
	 *  N개 수를 대표하는 기본 통계값 4가지 구하기
	 *   - 산술평균 : N개 수들의 합 / N
	 *   - 중앙값 : N개 수들을 오름차순으로 나열했을 경우, 그 중앙
	 *   - 최빈값 : N개 수들 중 가장 많이 나타나는 값. 여러 개 있으면 두번째로 작은 값
	 *   - 범위 : N개 수들 중 최댓값과 최솟값 차이
	 * 
	 * => sum은 double 타입을 사용한다. 4000 * 500,000 = 2,000,000,000 이므로 int가 다 담을 수 없다.
	 * 
	 * 시간: 520 ms
	 * 메모리: 47672 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수의 개수. 1 ≤ N ≤ 500,000. N은 홀수
		
		int[] num = new int[N];
		int[] cnt = new int[8001];
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine()); // -4000 <= num <= 4000
			cnt[tmp + 4000]++;
			sum += tmp;
			num[i] = tmp;
		}
		
		Arrays.sort(num); // 오름차순 정렬
		
		System.out.println(Math.round(sum / N)); // 산술평균
		System.out.println(num[N/2]); // 중앙값
		
		boolean flag = false;
		int max = 0, mode = 0;
		for (int i = 0; i < 8001; i++) {
			if (cnt[i] == 0) continue;
			
			if(max < cnt[i]) {
				max = cnt[i];
				mode = i - 4000;
				flag = true;
			}
			// 이전 최빈값과 동일한 경우. 단, 중복된 경우가 2개
			// 이후 동일한 값이 나오더라도 순서가 오름차순이기 때문에 얘가 계속 두번째로 작은 값. 굳이 볼 필요X
			else if(flag && max == cnt[i]) {
				mode = i - 4000;
				flag = false;
			}
		}
		System.out.println(mode);
		System.out.println(num[N-1]-num[0]); // 범위
	}

}
