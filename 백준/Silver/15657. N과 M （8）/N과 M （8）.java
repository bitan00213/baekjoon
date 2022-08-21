/*
 * https://www.acmicpc.net/problem/15657
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int[] numArr;
	public static int[] result;
	public static int N;
	public static int M;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	numArr= new int[N];
    	result= new int[M];
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++) {
    		numArr[i] = Integer.parseInt(str.nextToken());
    	}
    	Arrays.sort(numArr);
    	DFS(0, 0);
    	System.out.println(sb);
	}
    public static void DFS(int start, int depth) {
    	if(depth == M) {
    		for(int i =0; i<M; i++) {
    			sb.append(result[i]).append(' ');
    		}
    		sb.append('\n');
    	} else {
    		for(int i= start; i<N; i++) {
    			result[depth] = numArr[i];
    			DFS(i, depth+1);
    		}
    	}
    }
}