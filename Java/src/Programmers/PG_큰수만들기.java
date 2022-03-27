package Programmers;

public class PG_큰수만들기 {

	/**
	 * 문제
	 *  어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 한다.
	 *  예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있다. 이 중 가장 큰 숫자는 94이다.
	 *  문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어진다.
	 *  number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하라.
	 *   - number는 1자리 이상, 1,000,000자리 이하인 숫자
	 *   - k는 1 이상 number의 자릿수 미만인 자연수
	 *   
	 * => 재귀(조합)으로 하면 시간초과 발생
	 * => 테스트 10번 조심..ㅠ (시간초과 발생)
	 *    문자열에 문자를 추가하는 형식으로 하면 시간이 오래 걸리므로, StringBuilder 사용
	 */
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
	}
	
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
        int start = 0;
        
        // k를 제외한 만큼의 자릿수를 만들어야 함
        for (int i = 0; i < number.length() - k; i++) {
			char max = '0';
			
			// 가장 큰 인덱스의 값 찾기
			for (int j = start; j <= k+i; j++) {
				if(max - '0' < number.charAt(j) - '0') {
					max = number.charAt(j);
					start = j+1;
				}
			}
			sb.append(max);
		}
        return sb.toString();
    }
}
