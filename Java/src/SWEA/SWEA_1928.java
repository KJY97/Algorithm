package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class SWEA_1928 {

	/**
	 * 문제
	 *  입력으로 Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여, 원문을 출력하기
	 *   - 우선 24비트 버퍼에 위쪽(MSB)부터 한 byte씩 3 byte의 문자를 집어넣는다
	 *   - 버퍼의 위쪽부터 6비트씩 잘라 그 값을 읽고, 각각의 값을 아래 [표-1] 의 문자로 Encoding 한다
	 *  
	 * 제약사항
	 *  - 문자열의 길이는 항상 4의 배수
	 *  - 문자열 길이는 100000 을 넘지 않는다.
	 *  
	 * => Base64 라이브러리 사용!
	 * 
	 * 시간: 99 ms
	 * 메모리: 18,748 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// encoding된 string이 주어짐
			String encoding = br.readLine();
			
			// decoding 하기
			byte[] decodedBytes = Base64.getDecoder().decode(encoding);
			String decoding = new String(decodedBytes);
			
			System.out.println("#" + test_case + " " + decoding);
		}

	}

}
