package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_6588 {
	
	/**
	 * 문제
	 *  1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
	 *  4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
	 *  예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 
	 *  또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
	 *  이 추측은 아직도 해결되지 않은 문제이다.
	 *  백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
	 *  테스트 케이스에 대해서, n = a + b 형태로 출력한다. 이때, a와 b는 홀수 소수이다. 숫자와 연산자는 공백 하나로 구분되어져 있다.
	 *  만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다. 
	 *  또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
	 *   - 테스트 케이스의 개수는 100,000개를 넘지 않는다.
	 *   - 짝수 정수 n. 6 ≤ n ≤ 1000000
	 *   - 입력의 마지막 줄에는 0이 하나 주어진다.
	 *   - 시간 제한 1초
	 *   
	 * 시간: 324 ms
	 * 메모리: 34884 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 소수 찾기. 에라토스테네스의 체 활용
		boolean[] isNotPrime = new boolean[1000001];
		
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i <= 1000000; i++) {
			// 소수가 아니라고 체크되어 있다면 skip
			if (isNotPrime[i]) continue;
			
			// 소수가 아닌 수 체크
			for (int j = i+i; j <= 1000000; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		// 테스트 케이스 입력 시작
		while(true) {
			
			int N = Integer.parseInt(br.readLine()); // 짝수
			
			if (N == 0) break;
			
			boolean flag = false; // N을만드는 방법 체크
			
			// N/2 이후는 수의 위치만 다를 뿐 결과는 중복되므로 절반까지만 한다.
			for (int i = 2; i <= N/2; i++) {
				// i, N-i가 모두 소수가 아니라면 skip
				if (isNotPrime[i] || isNotPrime[N-i]) continue;
				
				// b-a의 차이가 가장 큰 경우는 i가 가장 작은 경우
				// 즉, 처음 나오는 골드바흐 수이다
				bw.write(N + " = " + i + " + " + (N-i));
				flag = true;
				
				break;
			}
			
			if (!flag) { // N을 만드는 방법이 없다면
				bw.write("Goldbach's conjecture is wrong.");
			}
			
			bw.write('\n');
		}

		bw.close();
		br.close();
	}

}
