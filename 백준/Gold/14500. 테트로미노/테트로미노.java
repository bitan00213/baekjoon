/*
 * https://www.acmicpc.net/problem/9019
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public static int[][] numArr;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N;
	public static int M;
	public static int result = -1;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numArr= new int[N][M];
		visit= new boolean[N][M];
		StringTokenizer str;
		for(int i = 0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				numArr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				visit[i][j] = true;
				func(i, j, numArr[i][j], 1);
				visit[i][j] = false;
				func2(i,j);
			}
		}
		System.out.println(result);
	}
	
	public static void func(int x, int y, int sum, int cnt) {
		if(cnt == 4 ) {
			result = Math.max(sum, result);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int tempX = x + dx[i];
			int tempY = y + dy[i];
			if(tempX>=0 && tempX<N && tempY>=0 && tempY<M && !visit[tempX][tempY]) {
				visit[tempX][tempY] = true;
				func(tempX,tempY,sum+numArr[tempX][tempY],cnt+1);
				visit[tempX][tempY] = false;
			}
		};
	};
	
	public static void func2(int x, int y) {
		if(x<N-2&&y<M-1)result=Math.max(result ,numArr[x][y]+ numArr[x+1][y]+ numArr[x+2][y]+ numArr[x+1][y+1]);
		if(x<N-2&&y>0)  result=Math.max(result ,numArr[x][y]+ numArr[x+1][y]+ numArr[x+2][y]+ numArr[x+1][y-1]);
		if(x<N-1&&y<M-2)result=Math.max(result ,numArr[x][y]+ numArr[x][y+1]+ numArr[x][y+2]+ numArr[x+1][y+1]);
		if(x>0&&y<M-2)  result=Math.max(result ,numArr[x][y]+ numArr[x][y+1]+ numArr[x][y+2]+ numArr[x-1][y+1]);
	}
}