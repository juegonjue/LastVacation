import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m;
	static int[] parent;
	
	static public void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		for (int i = 1; i<parent.length; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (type==0) {
				union(a, b);
			}
			else {
				if (isSameSet(a, b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
	
	static private int findParent(int x) {
		if (x==parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	static private void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a!=b) {
			parent[b] = a;
		}
	}
	
	static private boolean isSameSet(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		return a==b;
	}
}
