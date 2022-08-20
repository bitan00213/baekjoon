/*
 * https://www.acmicpc.net/problem/15654
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int[] numArr;
	public static int[] result;
	public static boolean[] visit;
	public static int N;
	public static int M;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	numArr= new int[N];
    	result= new int[M];
    	visit= new boolean[N+1];
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++) {
    		numArr[i] = Integer.parseInt(str.nextToken());
    	}
    	Arrays.sort(numArr);
    	DFS(0);
    	System.out.println(sb);
	}
    public static void DFS(int start) {
    	if(start == M) {
    		for(int i =0; i<M; i++) {
    			sb.append(result[i]).append(' ');
    		}
    		sb.append('\n');
    	} else {
    		for(int i= 0; i<N; i++) {
    			if(!visit[i]) {
    				visit[i] =true;
    				result[start] = numArr[i];
    				DFS(start+1);
    				visit[i] = false; 
    			}
    		}
    	}
    }
}