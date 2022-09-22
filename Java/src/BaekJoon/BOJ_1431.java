package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431 {

	/**
	 * 문제
	 *  다솜이는 기타를 많이 가지고 있다. 그리고 각각의 기타는 모두 다른 시리얼 번호를 가지고 있다.
	 *  다솜이는 기타를 빨리 찾아서 빨리 사람들에게 연주해주기 위해서 기타를 시리얼 번호 순서대로 정렬하고자 한다.
	 *  모든 시리얼 번호는 알파벳 대문자 (A-Z)와 숫자 (0-9)로 이루어져 있다.
	 *  시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.
	 *    1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
	 *    2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
	 *    3. 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
	 *  시리얼이 주어졌을 때, 정렬해서 출력하는 프로그램을 작성하시오.
	 *   - 기타의 개수 N (1 <= N <= 50)
	 *   - N개의 줄에 시리얼 번호가 하나씩 주어진다. 시리얼 번호의 길이는 최대 50이고, 알파벳 대문자 또는 숫자로만 이루어져 있다.
	 *   - 시리얼 번호는 중복되지 않는다.
	 *   - 제한시간 2초
	 *  
	 * 시간: 80 ms
	 * 메모리: 11676 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 기타 수
		
		String[] guitar = new String[N];
		
		// 기타 시리얼번호 저장
		for (int i = 0; i < N; i++) {
			guitar[i] = br.readLine();
		}
	
		// 조건에 맞게 정렬
		Arrays.sort(guitar, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 길이가 다르면, 짧은 것이 먼저
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else { // 만약 길이가 같다면, 
					// 모든 자리수의 합을 비교해서 작은 합이 먼저
					int res = sumOfArray(o1.toCharArray()) - sumOfArray(o2.toCharArray());
					
					if (res != 0) return res;
					else { // 위의 조건으로도 구분할 수 없으면 사전 순으로 정렬한다.
						return o1.compareTo(o2);
					}
				}
			}
		});
		
		// 정렬한 시리얼 번호대로 출력
		for (int i = 0; i < N; i++) {
			System.out.println(guitar[i]);
		}
	}
	
	// 배열의 각 자리수를 더한다.(숫자만)
	private static int sumOfArray(char[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				sum += arr[i] - '0';
			}
		}
		return sum;
	}

}
