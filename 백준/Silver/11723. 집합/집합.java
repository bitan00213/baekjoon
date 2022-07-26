/*
 * https://www.acmicpc.net/problem/11723
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<Integer> set = new LinkedList<Integer>();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			} else if(order.equals("check")) {
				if(set.indexOf(Integer.parseInt(st.nextToken()))!=-1) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if(order.equals("remove")) {
				int temp = Integer.parseInt(st.nextToken());
				if(set.indexOf(temp)!=-1) {
					set.remove(set.indexOf(temp));
				} 
			} else if(order.equals("toggle")) {
				int temp = Integer.parseInt(st.nextToken());
				if(set.indexOf(temp)==-1) {
					set.add(temp);
				} else {
					set.remove(set.indexOf(temp));
				}
			} else if(order.equals("all")) {
				set.clear();
				for(int j = 1; j<=20; j++) {
					set.add(j);
				}
			} else if(order.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}