import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 적록색약
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] visited;
	static char[][] colors;
	static int num;
	
	static public void main(String[] args) throws NumberFormatException, IOException {
		
		num = Integer.parseInt(br.readLine());
		colors = new char[num][num];
		visited = new boolean[num][num];
		
		// 컬러배열 생성
		for (int i=0; i<num; i++) {
			String str = br.readLine();
			for (int j=0; j<str.length(); j++) {
				colors[i][j] = str.charAt(j);
			}
		}
		
		/* 일반인  */
		int area = 0;
		for (int row=0; row<colors.length; row++) {
			for (int col=0; col<colors.length; col++) {
				if (valid(row, col, colors[row][col])) {
					area++;
					DFS(row, col, colors[row][col]);
				}
			}
		}
		System.out.println(area);

		/* 색맹  */
		for (boolean[] visit : visited) {Arrays.fill(visit, false);}
		
		for (int i=0; i<colors.length; i++) {
			for (int j=0; j<colors[i].length; j++) {
				if (colors[i][j]=='R') {
					colors[i][j] ='G';
				}
				
			}
		}

		area = 0;
		for (int row=0; row<colors.length; row++) {
			for (int col=0; col<colors.length; col++) {
				if (valid(row, col, colors[row][col])) {
					area++;
					DFS(row,col,colors[row][col]);
				}
			}
		}
		System.out.println(area);

	}
	
	/* dfs */ 
	static private void DFS(int row, int col, char color) {
		visited[row][col] = true;
		if (valid(row-1,col,color)) DFS(row-1, col, color);
		if (valid(row,col-1,color)) DFS(row, col-1, color);
		if (valid(row+1,col,color)) DFS(row+1, col, color);
		if (valid(row,col+1,color)) DFS(row, col+1, color);
	}

	/* 유효조건  */
	static private boolean valid(int row, int col, char color) {
		// 1. 상하좌우로 갈수있는가
		if (row<0 || col<0 || row>=num || col>=num) return false;
		// 2. 아직 방문 전인가
		if (visited[row][col]) return false;	
		// 3. 타입이 같은가
		if (colors[row][col] != color) return false;
		
		//세 조건 다 통과하면 가능
		return true;
	}

}
