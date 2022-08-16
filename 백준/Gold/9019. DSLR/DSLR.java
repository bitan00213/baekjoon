/*
 * https://www.acmicpc.net/problem/9019
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static String[] order;
	public static boolean[] visit;
	public static int start;
	public static int result;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T  = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			result = Integer.parseInt(st.nextToken());
			order = new String[10001];
			visit = new boolean[10001];
			BFS();
		}
		System.out.println(sb);
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		visit[start] = true;
		queue.add(start);
		order[start] = "";
		while(!queue.isEmpty()) {
			int temp  = queue.poll();
			int D = (2*temp)%10000;
			int S;
			if(temp==0) S = 9999;
			else S = temp-1;
			int L = temp/1000+(temp%1000)*10;
			int R = (temp%10)*1000 + temp/10;
			
			if(!visit[D]) {
				queue.add(D);
				visit[D] = true;
				order[D] = order[temp]+"D";
			}
			if(!visit[S]) {
				queue.add(S);
				visit[S] = true;
				order[S] = order[temp]+"S";
			}
			if(!visit[L]) {
				queue.add(L);
				visit[L] = true;
				order[L] = order[temp]+"L";
			}
			if(!visit[R]) {
				queue.add(R);
				visit[R] = true;
				order[R] = order[temp]+"R";
			}
		}
		sb.append(order[result]).append('\n');
	}
}