/*
 * https://www.acmicpc.net/problem/6064
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static int M;
	public static int N;
	public static int x;
	public static int y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); /*x최대값*/
			N = Integer.parseInt(st.nextToken()); /*y최대값*/
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			/*
			 * 전체 개수는 몇개일까?
			 * 두 수가 같은 수가 될 경우 초기화 
			 * ==> 최소공배수의 개수
			 * */
			
			int gcd = gcd(M,N);
			int temp = x;
			int cnt = x%(M+1); //mod값으로 세팅
			
			int useY;
			for(int j = 0; j<N; j++) {
				if(temp%N != 0) {
					useY = temp%N;
				} else {
					useY = N;
				}
				if(useY == y) break;
				temp = useY+M;
				cnt +=M;
			}
			if(cnt>M*N/gcd) {
				sb.append(-1).append('\n');
			} else {
				sb.append(cnt).append('\n');
			}
			
			/*
			 * 메모리 초과...
			 * 시작 지점을 바꾸자.
			while(temp != M*N/gcd) {
				numArr[temp%M][temp%N] = temp;
				temp++;
			}
			
			if(numArr[x][y] != 0) {
				sb.append(numArr[x][y]).append('\n');
			} else {
				sb.append(-1).append('\n');
			}
			*/
		}
		System.out.println(sb);
	}
	
	
	public static int gcd(int x, int y) {
		while(y != 0) {
			int temp = x%y;
			x = y;
			y = temp;
		}
		return x;
	}
};
