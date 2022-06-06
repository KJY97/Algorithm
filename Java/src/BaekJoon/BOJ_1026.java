package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1026 {

	/**
	 * 문제
	 *  옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
	 *  길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
	 *       S = A[0] × B[0] + ... + A[N-1] × B[N-1]
	 *  S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
	 *  S의 최솟값을 출력하는 프로그램을 작성하시오.
	 *   - N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
	 * 
	 * => A의 최소값 * B의 최대값
	 * => 최대 100 * 100 * 50 = 500000이므로 결과 S의 범위는 int
	 *  
	 * 시간 : 80 ms
	 * 메모리 : 11800 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // A, B의 길이
		int[] B = new int[N]; // 정렬되지 않은 배열의 형태를 저장하기 위해 선언함
		
		PriorityQueue<Integer> A_pqueue = new PriorityQueue<>(); // 오름차순 정렬
		PriorityQueue<Integer> B_pqueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
		
		// A 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A_pqueue.add(Integer.parseInt(st.nextToken()));
		}
		
		// B 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			B[i] = num; // 정렬되지 않는 배열
			B_pqueue.add(num);
		}
		
		int S = 0;
		for (int i = 0; i < N; i++) {
			S += A_pqueue.poll() * B_pqueue.poll();
		}

		System.out.println(S);
	}

}
