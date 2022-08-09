/*
 * https://www.acmicpc.net/problem/7569
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
	int z;
	descartes(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	public static int result= 0;
	public static int[] dx = {-1,  0,  1, 0, 0, 0};
	public static int[] dy = { 0, -1,  0, 1, 0, 0};
	public static int[] dz = { 0,  0,  0, 0,-1, 1};
	public static int[][][] numArr;
	public static Queue<descartes> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //5
		int N = Integer.parseInt(st.nextToken()); //3
		int H = Integer.parseInt(st.nextToken()); //2
		numArr = new int[N+1][M+1][H+1];
		queue = new LinkedList<descartes>();
		StringTokenizer str;
		for(int i = 0 ; i <H; i++) {
			for(int j = 0; j<N; j++) {
				str = new StringTokenizer(br.readLine());
				for(int k =0; k<M; k++) {
					numArr[j][k][i] = Integer.parseInt(str.nextToken());
					if(numArr[j][k][i]==1) {
						queue.add(new descartes(j, k, i));
					} 
				}
			}
		}
		BFS(M,N,H);
		System.out.println(result);
	}
	public static void BFS(int M, int N, int H) {
		while(!queue.isEmpty()) {
			descartes temp = queue.remove();
			int x= temp.x;
			int y= temp.y;
			int z= temp.z;
			for(int i = 0; i<6; i++) {
				int tempX = x + dx[i];
				int tempY = y + dy[i];
				int tempZ = z + dz[i];
				
				if(tempX>=0 && tempX <N && tempY>=0 && tempY<M && tempZ>=0 && tempZ<H) {
					if(numArr[tempX][tempY][tempZ] ==0 ) {
						queue.add(new descartes(tempX, tempY,tempZ));
						numArr[tempX][tempY][tempZ] = numArr[x][y][z]+1; /*참고했던 부분. 날짜의 최대값을 토마토 익은 날로 계산(가장 큰 수 -1)*/
					}
				}
			}
		}
		for(int i = 0; i<H; i++) {
			for(int j =0; j<N; j++) {
				for(int k =0; k<M;k++) {
					if(numArr[j][k][i]==0) {
						result  = -1;
						return;
					} else {
						result = Math.max(result, numArr[j][k][i]);
					}
				}
			}
		}
		result -=1;
	}
}