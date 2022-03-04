package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PG_완주하지못한선수 {

	/**
	 * 문제
	 *  수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
	 *  단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	 *  마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 구하라.
	 *   - 경기 참여 선수는 1 ~ 100,000명
	 *   - completion의 길이는 participant길이보다 1 작다.
	 *   - 참가자 이름은 1 ~ 20개 소문자로 구성
	 *   - 동명이인 존재
	 * 
	 * => 해시문제
	 * => 이중 for문으로도 해결이 가능하나 효율성 문제를 통과하지 못함
	 * => 빠르게 이름을 찾을 수 있는 map 사용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 마라톤 참여한 선수 초기화
		String[] participant = br.readLine().split(" ");
		String[] completion = br.readLine().split(" ");
		
		System.out.println(solution(participant, completion));
	}
	
	// 완주하지 못한 참가자 1명 찾기
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
				
		// 동명이인이 있으므로 인원 수 체크
		// 완주자 명단 hashmap에 저장
		HashMap<String, Integer> map = new HashMap<>();
		for (String key : completion) {
			// 있으면 key의 value에 +1, 없으면 1
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		// 참가자 이름이 완주자 명단에 있는지 확인
		for (String key : participant) {
			// 완주자 명단에 없는 경우
			if(!map.containsKey(key)) {
				answer = key;
				break;
			}
			
			// 완주자 명단에 동명이인인 참가자가 모두 없는 경우
			if(map.get(key) == 0) {
				answer = key;
				break;
			}
			
			// 확인한 참가자는 완주자 명단에서 제외
			map.put(key, map.get(key)-1);
		}
		return answer;
	}
}
