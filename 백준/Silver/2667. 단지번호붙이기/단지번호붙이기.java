/*
 * https://www.acmicpc.net/problem/2667
 * BFS
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class descartes {
	int x;
	int y;
	descartes(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static Queue<descartes> queue;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N;
	public static int[][] numArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		numArr = new int[N+1][N+1];
		queue = new LinkedList<descartes>();
		for(int i = 1; i<=N; i++) {
			String temp = br.readLine();
			String[] tempArr = temp.split("");
			for(int j = 1; j<=N; j++) {
				numArr[i][j] = Integer.parseInt(tempArr[j-1]);
			};
		};
		int cnt = 0;
		LinkedList<Integer> temp = new LinkedList<Integer>();
		for(int i =1; i<=N; i++) {
			for(int j =1; j<=N;j++) {
				if(numArr[i][j] == 1) {
					queue.add(new descartes(i, j));
					temp.add(BFS());
					cnt++;
				};
			};
		};
		sb.append(cnt).append('\n');
		Collections.sort(temp);
		for(int i : temp) {
			sb.append(i).append('\n');
		}
		System.out.println(sb);
	};
	
	
	public static int BFS() {
		int cnt = 0;
		while(!queue.isEmpty()) {
			descartes temp = queue.remove();
			int x = temp.x;
			int y = temp.y;
			
			for(int i =0; i<4; i++) {
				int tempX = x + dx[i];
				int tempY = y + dy[i];
				if(tempX>=1 && tempX<=N && tempY>=1 && tempY <= N) {
					if(numArr[tempX][tempY] ==1) {
						numArr[tempX][tempY] = 0;
						cnt++;
						queue.add(new descartes(tempX, tempY));
					}
				} 
			}
		}
		if(cnt == 0) cnt = 1;
		return cnt;
	}
};