package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11576 {

	/**
	 * 문제
	 *  타임머신을 개발하는 정이는 오랜 노력 끝에 타임머신을 개발하는데 성공하였다.
	 *  미래가 궁금한 정이는 자신이 개발한 타임머신을 이용하여 500년 후의 세계로 여행을 떠나게 되었다.
	 *  500년 후의 세계에서도 프로그래밍을 하고 싶었던 정이는 백준 사이트에 접속하여 문제를 풀기로 하였다. 
	 *  그러나 미래세계는 A진법을 사용하고 있었고, B진법을 사용하던 정이는 문제를 풀 수가 없었다.
	 *  뛰어난 프로그래머였던 정이는 A진법으로 나타낸 숫자를 B진법으로 변환시켜주는 프로그램을 작성하기로 하였다. 
	 *  N진법이란, 한 자리에서 숫자를 표현할 때 쓸 수 있는 숫자의 가짓수가 N이라는 뜻이다.
	 *  예를 들어 N은 17일 때 한 자릿수에서 사용할 수 있는 수는 0, 1, 2, ... , 16으로 총 17가지가 된다.
	 *   - 첫 줄에는 미래세계에서 사용하는 진법 A와 정이가 사용하는 진법 B가 주어진다.
	 *     A와 B는 모두 2이상 30이하의 자연수다.
	 *   - 두 번째 줄에는 A진법으로 나타낸 숫자의 자리수의 개수 m(1 ≤ m ≤ 25)이 주어진다.
	 *   - 세 번째 줄에는 A진법을 이루고 있는 숫자 m개가 공백을 구분으로 높은 자릿수부터 차례대로 주어진다. 
	 *     각 숫자는 0이상 A미만임이 보장된다. 
	 *     또한 수가 0으로 시작하는 경우는 존재하지 않는다.
	 *   - A진법으로 나타낸 수를 10진법으로 변환하였을 때의 값은 양의 정수이며 2²⁰보다 작다.
	 *     2²⁰ = 1,048,576
	 * 
	 * => StringBuilder를 사용해서 reverse를 통해 출력해보았지만 계속 fail 발생
	 * => stack으로 문제 해결
	 * 
	 * 시간: 80 ms
	 * 메모리: 11552 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); // 미래세계에서 사용하는 진법
		int B = Integer.parseInt(st.nextToken()); // 정이가 사용하는 진법
		
		int m = Integer.parseInt(br.readLine()); // A진법으로 나타낸 숫자의 자리수의 개수
		// ex) 16진법의 12F 숫자는 자리수가 2개(12, F)
		
		// A진법 -> 10진법
		int Ato10 = 0;
		
		// 높은 자리수부터 주어진다.
		// ex) 2 16 = 2*A + 16*1
		st = new StringTokenizer(br.readLine());
		for (int i = m; i > 0; i--) {
			Ato10 += Integer.parseInt(st.nextToken()) * Math.pow(A, i-1);
		}
		
		// 10진법 -> B진법
		// 뒷자리부터 값을 저장하므로 출력 시 뒤집어야 한다. => 스택 사용
		Stack<Integer> stack = new Stack<>();
		while(Ato10 >= B) {
			stack.add(Ato10 % B);
			Ato10 /= B;
		}
		
		stack.add(Ato10);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
