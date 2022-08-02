/*
 * https://www.acmicpc.net/problem/11403
 * DFS. 하나 방문하고 그 다음을 방문하는 형태
 * abcd
 * a==>d 는 a==>c + c=>d ==> a=>b + b=>c + c=> d와 같으므로
 * 분할정복처럼 가장 작은 단위로 반복
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] numArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		numArr= new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
			};
		};
		DFS();
		for(int i = 0; i<N;i++) {
			for(int j =0; j<N; j++) {
				sb.append(numArr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	};
	
	
	public static void DFS() { /*만들고 보니까 DFS가 아닌데...*/
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					if(numArr[i][k] ==1 && numArr[j][i] ==1) {
						numArr[j][k] =1;
					}
				}
			}
		}
	};
};