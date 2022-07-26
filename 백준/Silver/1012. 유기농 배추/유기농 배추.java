/*
 * https://www.acmicpc.net/problem/1012
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
	public static int[][] numArr = null;
	public static Queue<descartes> queue;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N;
	public static int M;
	public static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K;
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			numArr= new int[N][M];
			StringTokenizer str;
			queue = new LinkedList<descartes>();
			for(int j = 0; j<K;j++) {
				str = new StringTokenizer(br.readLine());
				int temp1= Integer.parseInt(str.nextToken());
				int temp2= Integer.parseInt(str.nextToken());
				numArr[temp1][temp2] = 1;
			}
			cnt = 0;
			for(int k = 0; k<N;k++) {
				for(int l =0; l<M; l++) {
					if(numArr[k][l] == 1) {
						queue.add(new descartes(k, l));
						BFS();
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}
	
	
	public static void BFS() {
		while(!queue.isEmpty()) {
			descartes temp = queue.remove();
			int x = temp.x;
			int y = temp.y;
			for(int i = 0; i<4; i++) {
				int tempX = x+dx[i];
				int tempY = y+dy[i];
				if(tempX>=0 && tempX <N && tempY>=0 && tempY<M ) {
					if(numArr[tempX][tempY] == 1 ) {
						numArr[tempX][tempY] = 0;
						queue.add(new descartes(tempX, tempY));
					}
				}
			}
		}
	}
}