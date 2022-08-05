/*
 * https://www.acmicpc.net/problem/2178
 * BFS
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public static int M;
	public static int[][] numArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numArr = new int[N+1][M+1];
		queue = new LinkedList<descartes>();
		for(int i = 1; i<=N; i++) {
			String temp = br.readLine();
			String[] tempArr = temp.split("");
			for(int j = 1; j<=M; j++) {
				numArr[i][j] = Integer.parseInt(tempArr[j-1]);
			};
		};
		queue.add(new descartes(1, 1));
		BFS();
		System.out.println(numArr[N][M]);
	};
	public static void BFS() {
		while(!queue.isEmpty()) {
			descartes temp = queue.remove();
			int x = temp.x;
			int y = temp.y;
			
			for(int i =0; i<4; i++) {
				int tempX = x + dx[i];
				int tempY = y + dy[i];
				if(tempX>=1 && tempX<=N && tempY>=1 && tempY <= M) {
					if(numArr[tempX][tempY] ==1) {
						numArr[tempX][tempY] = numArr[x][y]+1;
						if(tempX ==N && tempY == M) return;
						queue.add(new descartes(tempX, tempY));
					}
				}
			}
		}
	}
};
