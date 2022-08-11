/*
 * https://www.acmicpc.net/problem/10026
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static char[][] arr;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr= new char[N][N];
		visit= new boolean[N][N];
		for(int i =0; i<N; i++) {
			String temp = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		int cnt = 0;
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j]) {
					DFS(i,j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");
		cnt = 0;
		visit = new boolean[N][N];
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 'G') arr[i][j] = 'R';
			}
		}
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j]) {
					DFS(i,j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
		
	}
	public static void DFS(int x, int y) {
		visit[x][y] = true;
		char temp = arr[x][y];
		for(int i = 0; i<4; i++) {
			int tempX = x +dx[i];
			int tempY = y +dy[i];
			
			if(tempX>=0 && tempX<N && tempY>=0 && tempY < N) {
				if(!visit[tempX][tempY] && arr[tempX][tempY] == temp) {
					DFS(tempX, tempY);
				}
			}
		}
	}
}