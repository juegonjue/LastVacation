import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] ground, check;
	static int width, depth;
	static StringBuilder sb = new StringBuilder();
	
	static public void main(String[] args) throws NumberFormatException, IOException {
		
		int num = Integer.parseInt(br.readLine());	//케이스의 개수
		
		for (int i=0; i<num; i++) {	// 한 케이스당 배열을 생성
			int grown;
			int worm=0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			depth = Integer.parseInt(st.nextToken());
			grown = Integer.parseInt(st.nextToken());
			
			ground = new boolean[width][depth];
			check = new boolean[width][depth];
			
			for (int j=0; j<grown; j++) {
				st = new StringTokenizer(br.readLine());
				ground[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			// 이차원배열을 탐색하며 탐색조건에 맞으면 dfs한다
			for (int j=0; j<width ; j++) {
				for (int k=0; k<depth; k++) {
					if (valid(j, k) == true) {
						worm++;
						dfs(j, k);
					}
				}
			}
			
			sb.append(worm+"\n");
		}

		System.out.println(sb);
		
	}

	// 0~row, 0~col사이가 아니거나, 이미 check된 곳이거나, 1이아닌곳이면 false. 
	static public boolean valid(int row, int col) {
		if (row<0 || col<0 || row>=width || col>=depth) return false;
		if (check[row][col]==true || ground[row][col]==false) return false;
		return true;
	}
	
	// 조건에맞으면 상하좌우 dfs 재귀
	static public void dfs(int row, int col) {
		check[row][col] = true;
		if (valid(row-1, col)) dfs(row-1, col);
		if (valid(row+1, col)) dfs(row+1, col);
		if (valid(row, col-1)) dfs(row, col-1);
		if (valid(row, col+1)) dfs(row, col+1);
	}
}
