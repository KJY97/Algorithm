package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2043 {

	/**
	 * 문제
	 *  비밀번호 P와 주어지는 번호 K가 주어지면 K부터 시작하여 몇 번 만에 P를 맞출 수 있는지 출력하기
	 *   - 비밀번호 P는 000부터 999까지 번호 중의 하나
	 *   - 주어지는 번호 K부터 1씩 증가하며 비밀번호를 확인
	 * 
	 * => P가 K보다 큰 경우, P가 K보다 작은 경우 체크해야 함
	 * => 즉 절대값을 사용한다
	 * 
	 * 시간: 97 ms
	 * 메모리: 19,576 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int password = Integer.parseInt(st.nextToken());
		int key = Integer.parseInt(st.nextToken());
		
		// key도 카운트에 들어가야 한다
		System.out.println(Math.abs(password - key) + 1);
	}

}
