/*
 * https://www.acmicpc.net/problem/7576
 * 좌표구현을 통한 토마토 전체 익은 날 BFS구현까지만 해걸
 * 다시 풀어볼 것
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
	public static int result= 0;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] numArr;
	public static Queue<descartes> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		numArr = new int[N+1][M+1];
		queue = new LinkedList<descartes>();
		StringTokenizer str;
		for(int i = 0 ; i <N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				numArr[i][j] = Integer.parseInt(str.nextToken());
				if(numArr[i][j]==1) {
					queue.add(new descartes(i, j));
				} 
			}
		}
		BFS(M,N);
		System.out.println(result);
	}
	public static void BFS(int M, int N) {
		while(!queue.isEmpty()) {
			descartes temp = queue.remove();
			int x= temp.x;
			int y= temp.y;
			for(int i = 0; i<4; i++) {
				int tempX = x + dx[i];
				int tempY = y + dy[i];
				
				if(tempX>=0 && tempX <N && tempY>=0 && tempY<M ) {
					if(numArr[tempX][tempY] ==0 ) {
						queue.add(new descartes(tempX, tempY));
						numArr[tempX][tempY] = numArr[x][y]+1; /*참고했던 부분. 날짜의 최대값을 토마토 익은 날로 계산(가장 큰 수 -1)*/
					}
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j =0; j<M; j++) {
				if(numArr[i][j]==0) {
					result  = -1;
					return;
				} else {
					result = Math.max(result, numArr[i][j]);
				}
			}
		}
		result -=1;
	}
}