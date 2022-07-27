/*
 * https://www.acmicpc.net/problem/2606
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static int[][] numArr;
	public static boolean[] ty;
	public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		numArr= new int[T+1][T+1];
		ty = new boolean[T+1];
		int L = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			numArr[temp1][temp2] = 1;
			numArr[temp2][temp1] = 1;
		}
		DFS(1, T);
		System.out.println(result);
	}
	
	public static void DFS(int start, int T) {
		ty[start] = true;
		for(int i = 2; i<=T; i++) {
			if(!ty[i] && numArr[start][i]==1) {
				result++;
				DFS(i,T);
			}
		}
	}
}