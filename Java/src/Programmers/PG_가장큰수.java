package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG_가장큰수 {
	
	/**
	 * 문제
	 *  0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	 *  0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 출력하기
	 *  
	 *  예를 들어, 주어진 정수가 [6, 10, 2]라면 
	 *  [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
	 *  이중 가장 큰 수는 6210입니다.
	 *  
	 *   - numbers의 길이는 1 이상 100,000 이하
	 *   - numbers의 원소는 0 이상 1,000 이하
	 *   - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	 *   
	 * => 정수형 배열을 문자열 배열로 바꾸기
	 * => 내림차순으로 정렬. {30, 3}에서 303이 아닌 330이 나오도록 주의
	 * => 주어진 정수가 모두 0인 경우 주의
	 */
	public static void main(String[] args) {
		int[] numbers1 = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 5, 9};
		int[] numbers3 = {0, 0, 0};
		
		System.out.println(solution(numbers1));
		System.out.println(solution(numbers2));
		System.out.println(solution(numbers3));
	}
	
	public static String solution(int[] numbers) {
        // int형 배열 string 배열로 변환
        String[] tmp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
			tmp[i] = Integer.toString(numbers[i]);
		}
        
        // 람다식을 이용한 내림차순 정렬
        Arrays.sort(tmp, new Comparator <String>() {
            @Override
            public int compare(String o1, String o2) {
            	return (o1+o2).compareTo(o2+o1) * -1;
            }
        });
       
        // {0,0,0}과 같은 경우가 들어온 경우
        if(tmp[0].equals("0")) return "0";
        
        // Arrays.toString만 하면 [1,2]이 나오므로 숫자만 나오게 한다
        return Arrays.toString(tmp).replaceAll("[^0-9]","");
    }
	
}
