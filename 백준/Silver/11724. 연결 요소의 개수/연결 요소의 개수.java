/*
 * https://www.acmicpc.net/problem/11724
 * https://www.acmicpc.net/problem/1260 응용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] numArr;
	public static boolean[] visit;
	/* public static StringBuilder sb; */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		/* sb = new StringBuilder(); */
		
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		numArr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		StringTokenizer str;
		for(int i = 0; i<M; i++) {
			str = new StringTokenizer(br.readLine());
			int tempN = Integer.parseInt(str.nextToken());
			int tempM = Integer.parseInt(str.nextToken());
			numArr[tempN][tempM] = 1; //없으면 0
			numArr[tempM][tempN] = 1; //큰 수에서 작은 수 탐색도 가능해야 함.
		};
		int cnt = 0;
		for(int i = 1; i<=N;i++) {
			if(!visit[i]) {
				DFS(N,M,i);
				cnt++;
			}
		}
		System.out.println(cnt);
	};
	
	public static void DFS(int N, int M, int V) {
		visit[V] = true;
		/*sb.append(V).append(' ');*/
		for(int i = 0; i<=N; i++) {
			if((numArr[V][i] == 1) && !visit[i]) {
				DFS(N, M, i);
			};
		};
	};
	/*
	public static void DFS2(int N, int M, int V) { 
		visit[V] = true;
		sb.append(V).append(' ');
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(V);
		while(!stack.isEmpty()) {
			int tempNum = stack.peek();
			boolean temp = false;
			for(int i = 0; i<=N; i++) {
				if((numArr[tempNum][i] == 1) && !visit[i]) {
					temp = true;
					visit[i] = true;
					sb.append(i).append(' ');
					stack.push(i);
					break;
				};
			};
			if(!temp) {
				stack.pop();
			};
		};
	};
	
	public static void BFS(int N, int M, int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		visit[V] = true;
		sb.append(V).append(' ');
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i = 1; i<=N; i++) {
				if((numArr[temp][i] == 1) && !visit[i]) {
					queue.add(i);
					visit[i] = true;
					sb.append(i).append(' ');
				};
			};
		};
	};
	 */
};