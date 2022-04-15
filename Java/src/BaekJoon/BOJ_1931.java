package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {

	/**
	 * 문제
	 *  한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
	 *  각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
	 *  단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
	 *  회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
	 *   - 회의의 수 N(1 ≤ N ≤ 100,000)
	 *   - 0 <= 시작 시간, 끝나는 시간 <= 2³¹ - 1
	 * 
	 * => 회의를 최대한 많이 해야하므로 종료시간이 빠른 회의시간 순으로 정렬해야 한다!
	 * 
	 * 시간 : 488 ms
	 * 메모리 : 43096 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 회의의 수
		
		// 각 회의에 대해 시작시간과 끝나는 시간이 주어진다. (초기화)
		Meeting[] meeting = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meeting[i] = new Meeting(start, end);
		}

		// 회의를 최대한 많이 하므로 종료시간을 기준으로 오름차순 정렬
		Arrays.sort(meeting);
		
		int answer = 1; // 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
		Meeting min = meeting[0]; // 종료시간이 가장 작은 회의
		
		for (int i = 1; i < N; i++) {
			if(meeting[i].start - min.end >= 0) {
				min = meeting[i];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end)
				return this.start - o.start;
			else
				return this.end - o.end;
		}
	}

}
