/*
 * https://www.acmicpc.net/problem/11279
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp ==0) {
				if(!heap.isEmpty()) {
					sb.append(heap.poll()).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if(temp >0 ) {
				heap.add(temp);
			};
		}
		System.out.println(sb);
	}
}