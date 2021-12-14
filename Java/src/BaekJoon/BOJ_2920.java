package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2920 {

	/**
	 * 문제
	 *  연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하기
	 *   - ascending: 1부터 8까지 차례대로 연주(오름차순)
	 *   - descending: 8부터 1까지 차례대로 연주(내림차순)
	 *   - mixed : 둘 다 아님 
	 * => 현재 인덱스의 수가 이전 인덱스 수에 +1 하거나 -1를 더한 수인지 확인한다
	 * => 만약 한번이라도 ±1 만큼의 차이가 아니라면 mix이다
	 *  
	 * 시간 : 76 ms
	 * 메모리 : 11508 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[8];
		for (int i = 0; i < 8; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		String ans = "";
		for (int i = 1; i < 8; i++) {
			if(num[i] == num[i-1]+1) ans = "ascending";
			else if(num[i] == num[i-1]-1) ans = "descending";
			else {
				ans = "mixed"; 
				break;
			}
		}
		System.out.println(ans);
	}
}
