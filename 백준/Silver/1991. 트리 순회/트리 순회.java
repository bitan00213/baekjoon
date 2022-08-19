/*
 * https://www.acmicpc.net/problem/1991
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;

		}
	}
	public static List<Node>[] list;
	public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int data = st.nextToken().charAt(0) -64;
			int left = st.nextToken().charAt(0) -64;
			int right = st.nextToken().charAt(0) -64;
			list[data].add(new Node(left, right));
		}
		
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		System.out.println(sb);
		
	}
	
	static void preorder(int start) {
		for(Node node : list[start]) {
			int l = node.left;
			int r = node.right;
			
			sb.append((char)(start+'A'-1));
			if(l != -18) preorder(l);
			if(r != -18) preorder(r);
		}
	}
	
	static void inorder(int start) {
		for(Node node : list[start]) {
			int l = node.left;
			int r = node.right;
			
			if(l != -18) inorder(l);
			sb.append((char)(start+'A'-1));
			if(r != -18) inorder(r);
		}
	}
	
	static void postorder(int start) {
		for(Node node : list[start]) {
			int l = node.left;
			int r = node.right;
			
			if(l != -18) postorder(l);
			if(r != -18) postorder(r);
			sb.append((char)(start+'A'-1));
		}
	}
}