package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class BOJ_1620 {

	/**
	 * 문제
	 *  ...생략...
	 *  다솜아 이제 진정한 포켓몬 마스터가 되기 위해 도감을 완성시키도록 하여라. 
	 *  일단 네가 현재 가지고 있는 포켓몬 도감에서 포켓몬의 이름을 보면 포켓몬의 번호를 말하거나, 
	 *  포켓몬의 번호를 보면 포켓몬의 이름을 말하는 연습을 하도록 하여라. 
	 *  나의 시험을 통과하면, 내가 새로 만든 도감을 주도록 하겠네.
	 *   - N(도감에 수록되어 있는 포켓몬의 개수), M(내가 맞춰야 하는 문제의 개수)
	 *   - 1 <= N,M <= 100,000 (자연수)
	 *   - 포켓몬 이름은 모두 영어이며, 첫 글자만 대문자이고 나머지는 소문자로 이루어져 있다.
	 *   - 2 <= 포켓몬 이름의 길이 <= 20
	 *   - 문제가 알파벳으로 들어오면 포켓몬 번호를, 숫자가 들어오면 해당 번호의 포켓몬 이름을 출력한다.
	 *   - 1 <= 문제로 들어오는 숫자 <= N
	 *   - 문제로 들어오는 문자는 도감에 있는 이름만 입력된다. 
	 *   
	 * 시간 : 1756 ms
	 * 메모리 : 58096 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도감에 수록되어 있는 포켓몬 수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제 개수
		
		HashMap<String, Integer> name = new HashMap<>();
		HashMap<Integer, String> number = new HashMap<>();
		
		// 도감에 포켓몬 입력
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			name.put(str, i);
			number.put(i, str);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			
			if(Character.isDigit(str.charAt(0))) {
				// 숫자가 들어오면
				System.out.println(number.get(Integer.parseInt(str)));
			}
			else {
				System.out.println(name.get(str));
			}
		}
	}

}
