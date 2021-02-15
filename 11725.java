import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] parent;
	
	static public void main(String[] args) throws NumberFormatException, IOException {
		
		int num = Integer.parseInt(br.readLine());
		graph = new ArrayList[num+1];
		visited = new boolean[num+1];
		parent = new int[num+1];
		
		for (int i=1; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1);
		for (int i=2; i<parent.length; i++) System.out.println(parent[i]);
		
	}
	
	static private void dfs(int node) {
		visited[node] = true;
		for (int i=0; i<graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (visited[next]==false) {
				parent[next] = node;
				dfs(next);
			}
		}
	}
	
}
