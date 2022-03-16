package Programmers;

public class PG_타겟넘버 {

	/**
	 * 문제
	 *  n개의 음이 아닌 정수들이 있다.이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 한다. 
	 *  예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있다.
	 *  ==================
	 *    -1+1+1+1+1 = 3
	 *    +1-1+1+1+1 = 3
	 *    +1+1-1+1+1 = 3
	 *    +1+1+1-1+1 = 3
	 *    +1+1+1+1-1 = 3
	 *  ==================
	 *  사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
	 *  숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요
	 *   - 주어지는 숫자의 개수는 2개 이상 20개 이하
	 *   - 각 숫자는 1 이상 50 이하인 자연수
	 *   - 타겟 넘버는 1 이상 1000 이하인 자연수
	 *   
	 * => 재귀 사용하기
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
		System.out.println(solution(new int[] {4, 1, 2, 1}, 4));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = DFS(numbers, 0, 0, target);
        return answer;
    }
	
	public static int DFS(int[] numbers, int sum, int n, int target) {
		// 모든 수를 사용했다면
		if(n == numbers.length) {
			if(target == sum) return 1;
			return 0;
		}
		
		// 숫자를 더할 경우 + 숫자를 뻴 경우
		return DFS(numbers, sum + numbers[n], n+1, target) + DFS(numbers, sum - numbers[n], n+1, target);
	}
}
