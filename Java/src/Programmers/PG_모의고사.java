package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PG_모의고사 {

	/**
	 * 문제
	 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 한다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍는다.
	 *  1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	 *  2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	 *  3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,...
	 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인가?
	 *  - 시험은 최대 10,000 문제로 구성
	 *  - 문제의 정답은 1, 2, 3, 4, 5중 하나
	 *  - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요
	 */
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		int[] answers2 = {1,3,2,4,2};
		
		System.out.println(Arrays.toString(solution(answers)));
		System.out.println(Arrays.toString(solution(answers2)));
	}
	
	public static int[] solution(int[] answers) {
        
		// 1~3번 수포자 찍는 방식
        int[][] students = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] score = new int[3]; // 각 학생들의 점수
        
        // 학생 별 점수 
        for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < 3; j++) {
				if(students[j][i % students[j].length] == answers[i])
					score[j]++;
			}
		}
        
        // 가장 큰 점수는?
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 가장 큰 점수와 동일한 학생 찾기(오름차순으로 저장)
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
        	if(max == score[i]) answer.add(i+1);
		}
        
        // List를 배열 형식으로 변환
        return answer.stream().mapToInt(i ->i).toArray();
    }
}
