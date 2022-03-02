package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1221 {

	/**
	 * 문제
	 *  숫자 체계가 우리와 다른 어느 행성이 있다. 아래는 이 행성에서 사용하는 0 ~ 9의 값을 순서대로 나타낸 것이다.
	 *  "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
	 *  0 ~ 9 의 값을 나타내는 단어가 섞여 있는 문자열을 받아 작은 수부터 차례로 정렬하여 출력하기
	 *   - 입력 문자열이 "TWO NIN TWO TWO FIV FOR" 일 경우 정렬한 문자열은 "TWO TWO TWO FOR FIV NIN" 이 된다.
	 *   - 문자열의 길이 N은 100≤N≤10000
	 *   
	 * 시간: 320 ms
	 * 메모리: 53,260 kb
	 */
	private static class Number implements Comparable<Number> {
		int value; // 값
		String str_num;
		
		public Number(String str_num) {
			this.str_num = str_num;
			setValue(str_num);
		}

		// 단어에 해당하는 숫자 세팅
		public void setValue(String str_num) {
			switch(str_num) {
				case "ZRO": value = 0; break;
				case "ONE": value = 1; break;
				case "TWO": value = 2; break;
				case "THR": value = 3; break;
				case "FOR": value = 4; break;
				case "FIV": value = 5; break;
				case "SIX": value = 6; break;
				case "SVN": value = 7; break;
				case "EGT": value = 8; break;
				case "NIN": value = 9; break;
			}
		}
		
		// 오름차순 정렬
		@Override
		public int compareTo(Number o) {
			return this.value - o.value;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken(); // #기호 + 테스트 케이스 번호
			int size = Integer.parseInt(st.nextToken()); // 테스트 케이스 길이 = 단어의 개수
			
			// 단어 초기화
			Number[] str = new Number[size];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) {
				str[i] = new Number(st.nextToken());
			}
			
			// 오름차순 정렬
			Arrays.sort(str);
			
			// 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < size; i++) {
				System.out.print(str[i].str_num + " ");
			}
		}
	}
}
