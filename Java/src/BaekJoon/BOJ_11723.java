package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11723 {

	/**
	 * 문제
	 *  비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
	 *  
	 *    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
	 *    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
	 *    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
	 *    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
	 *    all: S를 {1, 2, ..., 20} 으로 바꾼다.
	 *    empty: S를 공집합으로 바꾼다.
	 *    
	 *    - 연산의 수 M (1 ≤ M ≤ 3,000,000)
	 *    - 시간 제한 존재 (1.5 초)
	 * 
	 * => 값 하나만 저장하면 되므로 HashMap이 아닌 HashSet 사용
	 * => HashMap으로 해도 상관없다.
	 * => System.out.println()으로 할 경우 시간 초과가 발생하므로 StringBuiler 사용
	 * 
	 * [set으로 할 경우]
	 * 시간 : 1032 ms
	 * 메모리 : 325776 kb
	 * 
	 * [map으로 할 경우]
	 * 시간 : 1016 ms
	 * 메모리 : 326436 kb
	 */ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine()); // 연산의 수
		
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		String command;
		int num;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			command = st.nextToken();
			
			switch(command) {
			case "add": 
				num = Integer.parseInt(st.nextToken());
				map.put(num, num); 
//				set.add(num); // 값 중복되면 저장 x
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				map.remove(num); 
//				set.remove(num); // 있으면 true, 없으면 false
				break;
			case "check": 
				num = Integer.parseInt(st.nextToken());
//				set.contains(num);
				if(map.containsKey(num)) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
//				set.contains(num);
				if(map.containsKey(num)) 
					map.remove(num);
//					set.remove(num);
				else 
					map.put(num, num);
//					set.add(num);
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					map.put(j, j);
//					set.add(j);
				}
				break;
			case "empty":
				map.clear(); // 모두 삭제
//				set.clear();
			}
		}
		
		System.out.println(sb);
	}
}
