package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2029 {

	/**
	 * 문제
	 *  2개의 수 a, b를 입력 받아, a를 b로 나눈 몫과 나머지를 출력하는 프로그램을 작성하기
	 *   - 각 수는 1이상 10000이하의 정수
	 *  
	 * 시간: 97 ms
	 * 메모리: 18,180 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
            //제약사항
            if(1 > a || a > 10000) {
                continue;
            }
             
            if(1 > b || b > 10000) {
                continue;
            }
             
            System.out.println("#" + test_case + " " + a/b + " " + a%b);
        }
	}

}
