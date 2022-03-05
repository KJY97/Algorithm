package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PG_전화번호목록 {
	
	/**
	 * 문제
	 *  전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	 *  전화번호부에 적힌 전화번호를 담은 배열 phone_book이 solution 함수의 매개변수로 주어질 때, 
	 *  어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return하도록 작성하라.
	 *   - 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	 *     구조대 : 119 | 박준영 : 97 674 223 | 지영석 : 11 9552 4421
	 *   - phone_book의 길이는 1 이상 1,000,000 이하
	 *   - 각 전화번호의 길이는 1 이상 20 이하
	 *   - 중복 없음
	 *   
	 * => 이중 for문으로 작성 시 해결이 가능하나 효율성 문제를 통과하지 못함
	 * => Arrays.sort()를 이용하면 for문 하나로 해결 가능
	 *    12 345 1234 -> 12 1234 345
	 * => 1. [i-1]문자열로 시작하는지 체크하는 것이기 때문에 [i]를 0에서 부터 [i-1]길이 만큼 잘라서 비교하기
	 *    물론 런타임 에러 조심해야함.
	 * => 2. startsWith() 메소드를 사용하여 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크
	 * => 1과 2방식을 효율성으로 비교했을 때 2방식이 더  빠르다. (단, 테스트2는 1이 더 빠르다.)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] phone_book = br.readLine().split(" ");
		
		if(solution2(phone_book))
			System.out.println("true");
		else System.out.println("false");
	}
	
	// 방법1 : subString() 사용
	public static boolean solution1(String[] phone_book) {
        // 문자열 정렬 - 사전순으로 정렬된다.
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++) {
        	int size = phone_book[i-1].length();
        	
        	// 자르고 싶은 길이가 잘리는 문자열보다 크면 pass (ex. 1234 345)
        	if(size > phone_book[i].length()) continue;
        	
        	// phone_book[i-1] 길이만큼 대상 문자열의 앞 부분 자르기
        	String tmp = phone_book[i].substring(0, size);
        	
        	// 일차하면 [i]는 [i-1]을 접두사로 가지고 있다
        	if(tmp.equals(phone_book[i-1])) return false;
		}
        return true;
    }

	// 방법2 : startsWith() 사용
	public static boolean solution2(String[] phone_book) {
        // 문자열 정렬 - 사전순으로 정렬된다.
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++) {
        	if(phone_book[i].startsWith(phone_book[i-1])) return false;
		}
        return true;
    }
}
