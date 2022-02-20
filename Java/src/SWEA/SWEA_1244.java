package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1244 {

	/**
	 * 문제
	 *  퀴즈 대회에 참가해서 우승을 하게 되면 보너스 상금을 획득할 수 있는 기회를 부여받는다.
	 *  우승자는 주어진 숫자판들 중에 두 개를 선택에서 정해진 횟수만큼 서로의 자리를 위치를 교환할 수 있다.
	 *  정해진 횟수만큼 교환이 끝나면 숫자판의 위치에 부여된 가중치에 의해 상금이 계산된다.
	 *  숫자판의 오른쪽 끝에서부터 1원이고 왼쪽으로 한자리씩 갈수록 10의 배수만큼 커진다.
	 *  최종적으로 숫자판들이 8,8,8,3,2의 순서가 되면 88832원의 보너스 상금을 획득한다.
	 *  여기서 주의할 것은 반드시 횟수만큼 교환이 이루어져야 하고 동일한 위치의 교환이 중복되어도 된다.
	 *  정해진 횟수만큼 숫자판을 교환했을 때 받을 수 있는 가장 큰 금액을 계산해보자.
	 * 
	 * => 완전탐색 이용
	 * => ["1", "2", "3"]을 "123"으로 바꾸는 메소드 String.join 사용
	 *   -> 시간초과 발생.. 
	 *   -> toCharArray를 이용해 문자배열을 만들고 String.valueOf로  형변환
	 *   
	 * 시간: 8,627 ms
	 * 메모리: 106,620 kb
	 */
	
	static char input[];
	static int changeCnt, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = st.nextToken().toCharArray(); // 숫자판
			changeCnt = Integer.parseInt(st.nextToken()); // 교환할 횟수
			
			// 가장 큰 금액 만들기
			max = 0;
			DFS(0, 0);
			sb.append('#').append(test_case).append(' ').append(max).append('\n');
		}
		System.out.print(sb);
	}
	
	// n은 교환한 횟수
	public static void DFS(int idx, int n) {
		if(changeCnt == n) {
			max = Math.max(max, Integer.parseInt(String.valueOf(input)));
			return ;
		}
		
		for (int i = idx; i < input.length - 1; i++) { // 마지막 인덱스에 있는 문자는 하지 않아도 됨
			
			for (int j = i+1; j < input.length; j++) { // i의 다음 인덱스부터 하나씩 교환 시작
				swap(i, j);
				DFS(i, n+1);
				swap(j, i); // 원래대로 돌리기
			}
		}
	}
	
	public static void swap(int i, int j) {
		char tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
}
