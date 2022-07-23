/*
 * https://www.acmicpc.net/problem/10845
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
		LinkedList<Integer> que = new LinkedList<Integer>();
		int time = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<time; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String order = st.nextToken();
			if(order.equals("push")) {
				que.add(Integer.parseInt(st.nextToken()));
			} else if(order.equals("pop")) {
				if(que.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(que.pop()).append("\n");
				};
			} else if(order.equals("size")) {
				sb.append(que.size()).append("\n");
			} else if(order.equals("empty")) {
				if(que.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				};
			} else if(order.equals("front")) {
				if(!que.isEmpty()) {
					sb.append(que.peekFirst()).append("\n");
				} else {
					sb.append("-1").append("\n");
				};
			} else if(order.equals("back")) {
				if(!que.isEmpty()) {
					sb.append(que.peekLast()).append("\n");
				} else {
					sb.append("-1").append("\n");
				};
			};
		};
		System.out.println(sb);
	};
};