package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1021  {
	
	/**
	 * 문제
	 *  지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
	 *  지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
	 *   1. 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
	 *   2. 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
	 *   3. 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
	 *  큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다.(이 위치는 가장 처음 큐에서의 위치이다.) 
	 *  이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
	 *   - 큐의 크기 N과 뽑아내려고 하는 수의 개수 M (0 < N <= 50, M <= N)
	 *   - 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
	 *   - 제한시간 2초
	 * 
	 * => 양방향 큐 = 덱
	 * 
	 * 시간: 80 ms
	 * 메모리: 11604 kb
	 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N ; i++) {
            list.add(i);
        }
        
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M ; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            while (list.get(0) != num) {
            	cnt++;
                
                if (list.indexOf(num) <= (list.size()/2 ))
                    list.add(list.size()-1, list.remove(0));
                else list.add(0, list.remove(list.size()-1));
            }
            list.remove(0);
        }
        
        System.out.println(cnt);
    }
    
}
