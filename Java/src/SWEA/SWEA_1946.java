package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1946 {

	/**
	 * 문제
	 *  원본 문서는 너비가 10인 여러 줄의 문자열로 이루어져 있다.
	 *  문자열은 마지막 줄을 제외하고 빈 공간 없이 알파벳으로 채워져 있고 마지막 줄은 왼쪽부터 채워져 있다.
	 *  이 문서를 압축한 문서는 알파벳과 그 알파벳의 연속된 개수로 이루어진 쌍들이 나열되어 있다.
	 *  압축된 문서를 입력 받아 원본 문서를 만드시오.
	 *   - 압축된 문서의 알파벳과 숫자 쌍의 개수 N: 1 ≤ N ≤ 10
	 *   - 주어지는 알파벳 Ci: A ~ Z
	 *   - 연속된 개수로 주어지는 Ki: 1 ≤ Ki ≤ 20
	 *   - i는 줄의 번호로 1~N까지의 수
	 *   - 원본 문서의 너비는 10으로 고정
	 * 
	 * => 주의! isEmpty()는 문자열의 길이가 0인지 체크하는 것.
	 *    String의 초기값은 null이기 때문에 isEmpty() 사용할 수 없다.
	 * => 처음에는 배열을 만들어서 풀었는데, 배열 범위를 넘어가는 경우 발생.(flag 이용해서 끊을 수 있으나 지저분함)
	 *    다른 방법 생각하다 하나의 문자열에 문서를 나열하고 길이 10만큼 끊어서 출력해보았다.
	 *    
	 * 시간: 124 ms
	 * 메모리: 21,012 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 압축된 문서의 알파벳 개수
			
			String ans = "";
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String C = st.nextToken(); // 주어지는 알파벳
				int K = Integer.parseInt(st.nextToken()); // 알파벳이 연속되는 개수
				
				for (int j = 0; j < K; j++) {
					ans += C;
				}
			}
			
			// 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < ans.length(); i++) {
				// 10번째 단어이면 \n도 같이 출력
				if((i+1) % 10 == 0) System.out.println(ans.charAt(i));
				else System.out.print(ans.charAt(i));
			}
			System.out.println();
		}

	}

}
