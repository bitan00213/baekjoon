/*
 * https://www.acmicpc.net/problem/9019
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	public static Map<Integer, Integer> map;
	public static int N;
	public static int M;
	public static int result = Integer.MAX_VALUE;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //사다리 갯수
		M = Integer.parseInt(st.nextToken()); //뱀 갯수
		map = new HashMap<Integer, Integer>();
		StringTokenizer str; 
		for(int i = 0; i<N+M; i++) {
			str = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		}
		BFS();
		System.out.println(sb);
	}
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visit = new boolean[101];
		visit[1] = true;
		queue.add(1);
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int k = 0 ; k < size ; k++) {
				int temp = queue.poll();
				if(temp==100) {
					sb.append(cnt);
					return;
				}
				for(int i = 1; i<=6; i++) {
					if(temp+i<=100 && !visit[temp+i]) {
						if(map.get(temp+i) == null) {
							queue.add(temp+i);
							visit[temp+i] = true;
						} else {
							int mapTemp = map.get(temp+i);
							queue.add(mapTemp);
							visit[mapTemp]= true;
						}
					}
				}
			}
			cnt++;
		}
	}
}