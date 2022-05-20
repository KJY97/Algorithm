package Programmers;

public class PG_정수삼각형 {

	/**
	 * 문제
	 * ============
	 * 	    7
	 * 	   3 8
	 * 	  8 1 0
	 * 	 2 7 4 4
	 * 	4 5 2 6 5
	 * ============
	 * 
	 *  위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 한다.
	 *  아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능하다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능하다.
	 *  삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 출력하라.
	 *   - 삼각형의 높이는 1 이상 500 이하입니다.
	 *   - 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
	 *   
	 * => DP 문제
	 * => 최대 9999 x 500 = 4999500 까지 나오므로 int형 사용 가능
	 * => 아래로 이동한다 = 1은 대각선 방향 한 칸 오른쪽 위(=3) 또는 왼쪽 위(=8)의 값을 더할 수 있다
	 */
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
		System.out.println(solution(triangle)); // 30
	}
	
	public static int solution(int[][] triangle) {
        int answer = 0;       
        int N = triangle.length; // 정삼각형 높이

        // 정삼각형이므로 NxN의 사각형을 만든다.
        // 삼각형의 가장 맨 왼쪽, 오른쪽에 있는 숫자도 값을 가져올 수 있도록 0번째 열, N+1번째 열을 빈공간(0)으로 사용
        int[][] memo = new int[N][N+2];
        
        // 1번째 열부터 값 저장
        memo[0][1] = triangle[0][0];
        
        // 삼각형 아래로 이동하면서 최대값 구하기
        for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				// 왼쪽 위, 오른쪽 위 중 가장 큰 값과 (i,j)의 값을 더한다.
				memo[i][j+1] = Math.max(memo[i-1][j], memo[i-1][j+1]) + triangle[i][j];
			}
		}
        
        // memo에서 가장 큰 값 찾기
        for (int i = 1; i < N+2; i++) {
			answer = Math.max(memo[N-1][i], answer);
		}
        
        return answer;
    }

}
