package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2046 {

	/**
	 * 문제
	 *  주어진 숫자만큼 # 을 출력하기
	 *   - 100,000 이하 숫자가 주어짐
	 * 
	 * 시간: 97 ms
	 * 메모리: 16,080 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			System.out.print("#");
		}
	}

}
