package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PG_위장 {

	/**
	 * 문제
	 *  스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
	 *  예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
	 *  다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
	 *  스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 작성하기
	 *   - clothes의 각 행은 [의상의 이름, 의상의 종류]로 모든 원소는 문자열로 이루어져 있습니다.
	 *   - 의상의 수는 1개 이상 30개 이하
	 *   - 같은 이름을 가진 의상은 존재하지 않음
	 *   - 문자열의 길이는 1 이상 20 이하인 자연수
	 *   - 알파벳 소문자 또는 '_' 로만 이루어져 있다.
	 *   - 스파이는 하루에 최소 한 개의 의상은 입습니다.
	 *   
	 * => 조합 이용
	 * => 최소 한 개 의상은 잆는다 = 안 입는 날이 없다 = 전체 경우의 수 - 1 (의상 종류가 2이상인 경우)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
		// => yellowhat,headgear bluesunglasses,eyewear green_turban,headgear 형태로 입력값 받기 
		// 입력값 받기
		String[] tmp = br.readLine().split(" ");
		String[][] clothes = new String[tmp.length][];
		for (int i = 0; i < tmp.length; i++) {
			clothes[i] = tmp[i].split(",");
		}
		
		System.out.println(solution(clothes));;
	}
	
	public static int solution(String[][] clothes) {
		int answer = 1; 
		
		HashMap<String, Integer> type = new HashMap<>(); // 의상의 종류
		
		// 의상 종류와 각 개수 입력
		for (int i = 0; i < clothes.length; i++) {
			type.put(clothes[i][1], type.getOrDefault(clothes[i][1], 0)+1);
			System.out.println(type.get(clothes[i][1]));
		}
		
		// 의상 종류가 하나일 때는 의상의 개수가 답이 된다.
		if(type.size() == 1) answer = clothes.length;
		else { 
			// 옷의 종류가 2개 이상이면
			// 해당 종류의 옷을 입지 않은 경우 때문에 +1
			for (String key : type.keySet()) {
				answer *= type.get(key) + 1;
			}
			// 옷을 모두 안입은 경우의 수 제외
			answer = answer - 1;
		}

		return answer;
	}
}
