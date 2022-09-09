package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_1302 {

	/**
	 * 문제
	 *  김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 
	 *  김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
	 *  오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
	 *  만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
	 *   - 오늘 하루 동안 팔린 책의 개수 N (0 < N <= 1000)
	 *   - 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
	 *
	 * => HashMap과 TreeMap의 차이 알기!
	 *   => HashMap : 순서 유지하지 않음. Hashing 구현 사용. O(1)과 같은 일정한 시간 성능을 나타냄
	 *   => TreeMap : 자동 정렬. Red-Black 트리 구현 사용. log(n) 시간 보장
	 *   
	 * 시간: 76 ms
	 * 메모리: 11724 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 하루 동안  팔린 책 개수
		
		// SotredMap 인터페이스를 상속받은 클래스 TreeMap
		// Comparator가 자동으로 동작하며, 기본으로 문자열 사전 순으로 오름차순 정렬된다.
		TreeMap<String, Integer> books = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			String title = br.readLine();
			books.put(title, books.getOrDefault(title, 0) + 1);
		}
		
		int max = 0; // 최대 판매량
		String name = ""; // 가장 많이 팔린 책 제목 
		
		for (String title : books.keySet()) {
			if (max < books.get(title)) {
				max = books.get(title);
				name = title;
			}
		}
		
		System.out.println(name);
	}

}
