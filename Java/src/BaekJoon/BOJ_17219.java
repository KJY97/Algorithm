package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {

	/**
	 * 문제
	 *  2019 HEPC - MAVEN League의 "비밀번호 만들기"와 같은 방식으로 비밀번호를 만든 경민이는 한 가지 문제점을 발견하였다. 
	 *  비밀번호가 랜덤으로 만들어져서 기억을 못 한다는 것이었다! 그래서 경민이는 메모장에 사이트의 주소와 비밀번호를 저장해두기로 했다. 
	 *  하지만 컴맹인 경민이는 메모장에서 찾기 기능을 활용하지 못하고 직접 눈으로 사이트의 주소와 비밀번호를 찾았다. 
	 *  메모장에 저장된 사이트의 수가 늘어나면서 경민이는 비밀번호를 찾는 일에 시간을 너무 많이 쓰게 되었다. 
	 *  이를 딱하게 여긴 문석이는 경민이를 위해 메모장에서 비밀번호를 찾는 프로그램을 만들기로 결심하였다! 
	 *  문석이를 도와 경민이의 메모장에서 비밀번호를 찾아주는 프로그램을 만들어보자.
	 *   - 저장된 사이트 주소 수 N (1 ≤ N ≤ 100,000)
	 *   - 비밀번호를 찾으려는 사이트 주소 수 M (1 ≤ M ≤ 100,000)
	 *   - 사이트 주소는 알파벳 소문자, 알파벳 대문자, 대시('-'), 마침표('.')로 이루어져 있고, 중복되지 않는다.
	 *   - 비밀번호는 알파벳 대문자로만 이루어져 있다. 모두 길이는 최대 20자이다.
	 *  
	 * 시간 : 1648 ms
	 * 메모리 : 66648 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 수
		int M = Integer.parseInt(st.nextToken()); // 비밀번호 찾으려는 사이트 수
		
		// 사이트 주소 및 비밀번호 저장
		HashMap<String, String> note = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String address = st.nextToken();
			String password = st.nextToken();
			
			note.put(address, password);
		}
		
		// 비밀번호 찾기
		for (int i = 0; i < M; i++) {
			String find = br.readLine();
			
			System.out.println(note.get(find));
		}
	}

}
