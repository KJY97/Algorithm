package Programmers;

import java.util.Arrays;

public class PG_HIndex {

	/**
	 * 문제
	 *  H-Index는 과학자의 생산성과 영향력을 나타내는 지표로, 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 한다.
	 *  위키백과에 따르면, H-Index는 다음과 같이 구합니다.
	 *  어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 
	 *  h의 최댓값이 이 과학자의 H-Index입니다.
	 *  어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 
	 *  이 과학자의 H-Index를 return 하도록 solution 함수 작성하기
	 *   - 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하
	 *   - 논문별 인용 횟수는 0회 이상 10,000회 이하
	 *   
	 * => h번 이상 인용된 논문이 h편 이상인 h의 최댓값 구하기
	 */
	public static void main(String[] args) {
		// 논문 인용 수가 있는 배열
		int[] citations1 = {5, 5, 5, 5}; // 결과는 4
		int[] citations2 = {3, 0, 6, 1, 5}; // 결과는 3
		
		System.out.println(solution(citations1));
		System.out.println(solution(citations2));
	}
	
	public static int solution(int[] citations) {
        int answer = 0; // H-index는 h의 최댓값
        int n = citations.length; // 발표한 논문의 개수
        
        // 논문 인용 수 배열 오름차순 정렬
        Arrays.sort(citations);
       
        // h번 이상 인용된 논문이 h편 이상인 h의 최댓값 구하기
        for (int i = 0; i < n; i++) {
        	int h = n - i; // h편
        	if(citations[i] >= h)
        		answer = Math.max(answer, n-i);
		}
        return answer;
    }
}
