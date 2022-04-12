package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_1764 {

	/**
	 * 문제
	 *  김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
	 *   - 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어짐
	 *   - 이름의 길이는 20이하
	 *   - 1 <= N, M <= 500_000
	 *   - 듣도 못한 사람 명단, 보도 못한 사람 명단에는 중복이 존재하지 않는다.
	 *   
	 * 시간 : 352 ms
	 * 메모리 : 25776 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
		
		HashMap<String, Integer> noHear = new HashMap<>();
		
		// 듣도 못한 사람 명단에도 있고 보도 못한 사람 명단에도 있는 듣보잡을 사전순으로 출력
		List<String> nugu = new ArrayList<>();
				
		// 듣도 못한 사람의 이름 받기
		for (int i = 0; i < N; i++) {
			noHear.put(br.readLine(), 1);
		}
		
		// 보도 못한 사람의 이름 받기
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			
			// 듣보잡에 해당한다면 nugu에 저장
			if(noHear.containsKey(name)) {
				nugu.add(name);
			}
		}
		
		Collections.sort(nugu);
		
		System.out.println(nugu.size());
		for (int i = 0; i < nugu.size(); i++) {
			System.out.println(nugu.get(i));
		}
	}

}
