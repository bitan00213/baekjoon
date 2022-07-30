/*
 * https://www.acmicpc.net/problem/1697
 * 토마토 문제처럼 +1값으로 계산
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	public static int[] cntArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =  Integer.parseInt(st.nextToken());
		int K =  Integer.parseInt(st.nextToken());
		cntArr= new int[100001];
		BFS(N,K);
	
	};
	public static void BFS(int N, int K) {
		if(N==K) {
			System.out.println(0);
			return;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		cntArr[N] = 1;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			int test1 = temp-1;
			int test2 = temp+1;//오타.... 
			int test3 = temp*2;
			
			if(test1 == K) {
				System.out.println(cntArr[temp]);
				return;
			} else if(test2 == K) {
				System.out.println(cntArr[temp]);
				return;
			} else if(test3 == K) {
				System.out.println(cntArr[temp]);
				return;
			}
			if(test1>=0 && test1< cntArr.length && cntArr[test1] == 0) {
				queue.add(test1);
				cntArr[test1] = cntArr[temp]+1; 
			}
			if(test2>=0 && test2< cntArr.length && cntArr[test2] == 0) {
				queue.add(test2);
				cntArr[test2] = cntArr[temp]+1; 
			}
			if(test3>=0 && test3< cntArr.length && cntArr[test3] == 0) {
				queue.add(test3);
				cntArr[test3] = cntArr[temp]+1; 
			}
		}
	}
};