package Programmers;

import java.util.ArrayList;

public class PG_소수찾기 {

	/**
	 * 문제
	 *  한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
	 *  각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 출력하라.
	 *   - numbers는 길이 1 이상 7 이하인 문자열
	 *   - numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	 *   - "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미
	 */
	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
	
	private static ArrayList<Integer> answer;
	public static int solution(String numbers) {
		
		char[] input = numbers.toCharArray();
		
		answer = new ArrayList<>();
		
		for (int i = 1; i <= input.length; i++) {
			permutation(input.length, 0, i, input, new char[i], new boolean[input.length]);
		}
        
        return answer.size();
    }
	
	public static void permutation(int N, int idx, int R, char[] input, char[] output, boolean[] visited) {
		if(idx == R) {
			int num = Integer.parseInt(String.valueOf(output));
			
			// 소수 && 이전에 나오지 않은 숫자라면
			if(isPrime(num) && !answer.contains(num)) answer.add(num);
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true; // 방문 처리
			output[idx] = input[i];
			permutation(N, idx+1, R, input, output, visited);
			visited[i] = false;
		}
	}
	
	// 소수인지 아닌지 판별
	public static boolean isPrime(int num) {
		
		// 0과 1은 소수가 아님
		if(num < 2) return false;
		
		// 2는 소수
		if(num == 2) return true;
		
		// 2 이외 num의 제곱근에서 값이 나오면 소수가 아니다. 
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}

}
