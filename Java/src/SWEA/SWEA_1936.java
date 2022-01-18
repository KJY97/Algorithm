package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1936 {

	/**
	 * 문제
	 *  A와 B가 가위바위보를 하는데, A와 B중에 누가 이겼는지 판별해보기
	 *   - 단, 비기는 경우는 없다
	 *   - 가위는 1, 바위는 2, 보는 3으로 표현
	 *   
	 * 시간: 98 ms
	 * 메모리: 16,080 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		if(A == 1 && B == 3) 
			System.out.println("A");
		else if(A == 3 && B == 1) 
			System.out.println("B");
		else if(A > B) 
			System.out.println("A");
		else 
			System.out.println("B");
	}

}
