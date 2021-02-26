import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int min, n, m;
	static boolean[][] maze;
	static int[][] visited;
	
	
	static public void main (String []args ) throws IOException {
		input();
		bfs();
		System.out.println(visited[n-1][m-1]);
	}
	
	static private void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new boolean[n][m];
		visited = new int[n][m];
		
		for (int i=0; i<n; i++) {
			String input = br.readLine();
			for (int j=0; j<m; j++) maze[i][j] = input.charAt(j)=='1'? true:false;
		}
	}
	
	static private void bfs() {
		visited[0][0] = 1;
		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(0,0));
		
		int[] x = {1, 0, -1, 0};
		int[] y = {0, -1, 0, 1};

		while(!q.isEmpty()) {
			Edge now = q.remove();
			int row = now.row;
			int col = now.col;

			for (int i=0; i<x.length; i++) {
				int _x = row + x[i];
				int _y = col + y[i];
				
				if (valid(_x, _y)) {
					q.add(new Edge(_x, _y));
					visited[_x][_y] = visited[row][col]+1;
				}
			}
		}
	}
	
	static private boolean valid(int row, int col) {
		// row, col이 0보다 작거나 row가 n-1 보다 크거나, col이 m-1보다 크면 탐색불가능 
		if (row<0 || row>n-1 || col<0 || col>m-1) return false;
		// 칠해져있지 않거나, 이미 visited된곳은 탐색불가능
		if (!maze[row][col] || visited[row][col]>0) return false;
		return true;
	}
}

class Edge {
	int row;
	int col;
	
	Edge(int row, int col) {
		this.row = row;
		this.col = col;
	}
}