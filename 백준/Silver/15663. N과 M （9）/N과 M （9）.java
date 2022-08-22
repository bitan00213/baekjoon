/*
 * https://www.acmicpc.net/problem/15657
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static HashSet<String> hash = new HashSet<>();
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
    	visit= new boolean[N];
    	result= new int[M];
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++) {
    		numArr[i] = Integer.parseInt(str.nextToken());
    	}
    	Arrays.sort(numArr);
    	DFS(0);
    	System.out.println(sb);
	}
    public static void DFS(int depth) {
    	if(depth == M) {
    		StringBuilder sb2 = new StringBuilder();
    		for(int i =0; i<M; i++) {
    			sb2.append(result[i]).append(' ');
    		}
    		if (!hash.contains(sb2.toString())) {
                sb.append(sb2.toString()).append("\n");
                hash.add(sb2.toString());
            }
    		return;
    	} else {
    		for(int i= 0; i<N; i++) {
    			if(!visit[i]) {
    				visit[i] = true;
    				result[depth] = numArr[i];
    				DFS(depth+1);
    				visit[i] = false;
    			}
    		}
    	}
    }
}