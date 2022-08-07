/*
 * https://www.acmicpc.net/problem/11286
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)>Math.abs(o2)) {
					return 1;
				} else if(Math.abs(o1)==Math.abs(o2)) {
					return o1 - o2;
				} else {
					return -1;
				}
			}
		});
		int temp;
		for(int i = 0; i<n;i++) {
			temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(que.size()==0) {
					sb.append(0).append('\n');
				} else {
					sb.append(que.poll()).append('\n');
				}
			} else {
				que.add(temp);
			}
		}
		System.out.println(sb);
	}
};