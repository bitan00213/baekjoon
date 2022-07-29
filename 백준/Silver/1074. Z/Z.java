/*
 * https://www.acmicpc.net/problem/1074
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static int[][] numArr;
	public static int tempCnt = 0;
	public static int[] dx = {0, 0, 1, 1};
	public static int[] dy = {0, 1, 0, 1};
	public static int N;
	public static int r;
	public static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int length =(int) Math.pow(2,N);
		/*
		numArr = new int[length][length];
		 func(N,0,0); 
		*/
		func2(length,0,0,0);
	}
	
	public static void func2(int len, int x, int y, int cnt) {
		if(x>r || y>c || r>=x+len || c>=y+len) {
			return; 
		}
		 
		if(len == 2) {
			for(int i = 0; i<4;i++) {
				int tempX = x+dx[i];
				int tempY = y+dy[i];
				
				if(tempX == r && tempY == c) {
					System.out.println(cnt+i);
					return;
				}
			}
			return;
		}
		int tempLen = len/2;
		int tempCnt =(int) Math.pow(tempLen, 2);
		func2(tempLen,x			,y			,cnt);
		func2(tempLen,x			,y+tempLen	,cnt+tempCnt);
		func2(tempLen,x+tempLen	,y			,cnt+tempCnt*2);
		func2(tempLen,x+tempLen	,y+tempLen	,cnt+tempCnt*3);
	};
	
	/*
	 * 메모리 초과된 함수.
	 * 
	public static void func(int N, int X, int Y) {
		if(N==1) {
			numArr[X][Y]= tempCnt++;
			numArr[X][Y+1]= tempCnt++;
			numArr[X+1][Y]= tempCnt++;
			numArr[X+1][Y+1]= tempCnt++;
			return;
		};
		
		int tempPow =(int) Math.pow(2, N-1); 
		func(N-1,X,Y);
		func(N-1,X,Y+tempPow);
		func(N-1,X+tempPow,Y);
		func(N-1,X+tempPow,Y+tempPow);
		return;
	};
	*/
};
