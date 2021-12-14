package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1152 {

	/**
	 * 문제
	 *  공백으로 이루어진 문자열에 몇 개의 단어가 있는지 구하기
	 *   - 단어는 공백으로 구분
	 *   - 한 단어가 여러 번 등장해도 등장 횟수 모두 세기
	 *   - 공백이 연속해서 나오는 경우는 없다.
	 *   - 문자열은 공백으로 시작하거나 끝날 수 있다.
	 *   - 문자열 길이는 0 <= str.length < 1,000,000
	 *   
	 * => split()을 사용해서 공백으로 문자열 구분
	 * => 공백 하나만 들어오고 끝나는 경우 체크
	 * 
	 * 시간 : 204 ms
	 * 메모리 : 27616 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 공백만 들어왔다면..
		if(str.equals(" ")) {
			System.out.println(0);
			return ;
		}

		String[] arr = str.split(" ");
		// 처음 공백으로 시작하면..
		if(arr[0].equals("")) System.out.println(arr.length-1);
		else System.out.println(arr.length);
	}

}
