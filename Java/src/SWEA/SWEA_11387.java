package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11387 {

	/**
	 * 문제
	 *  용사가 몬스터를 공격할 때는 기본적으로 D만큼의 데미지를 입힌다. 여기에, 용사가 익힌 공격의 레벨 L에 따라 추가적인 데미지가 있는데,
	 *  지금까지 몬스터를 때린 횟수가 n번이라고 하면, 다음 공격이 몬스터에게 입히는 데미지는 D(1+nㆍL%)가 된다. %는 1/100을 의미한다.
	 *  지금까지 용사가 몬스터를 때린 횟수가 0번이라고 할 때, 앞으로 총 N번의 공격을 하면 몬스터에게 가한 총 데미지가 몇이 되는지 구하기
	 *   - 10² ≤ D ≤ 10⁴
	 *   - 0 ≤ L ≤ 100
	 *   - 1 ≤ N ≤ 10²
	 *   -  D는 100의 배수로만 주어진다
	 * 
	 * => N번째 공격시 때린 횟수는 n-1
	 * => 즉, 0 ~ (N-1)까지 데미지 합을 식으로 표현하면 다음과 같다.
	 *    D(1+0L%) + D(1+1L%) + D(1+2L%) + ... + D(1+(N-1)L%)
	 *    이것을 시그마를 통해 표현하면 D{∑(1+(k-1)L%)} (k=1, N까지)
	 * => 시그마 공식을 통해 위의 정리된 식을 풀어보면 다음과 같아진다.
	 *    D{∑1 + L% * ∑(k-1)} = D{N + L% * (N(N-1)/2)}
	 * => 이렇게 수학공식을 유도해 풀으면 시간복잡도는 O(1)
	 * 
	 * 시간: 211 ms
	 * 메모리: 35,212 kb
	 */
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
     
        for(int test_case = 1; test_case <= T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	long D = Integer.parseInt(st.nextToken());
        	long L = Integer.parseInt(st.nextToken());
        	long N = Integer.parseInt(st.nextToken());
        	
        	long ans = (D * N) + ((D * L * N * (N - 1)) / 200);
        	System.out.println("#" + test_case + " " + ans);
        }
	}
}
