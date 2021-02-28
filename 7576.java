import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 굿 파머의 틈매ㅑ이러 키우기 대작전
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int m,n;
	static int[][] tomatoes;
	static int[][] day;
	
	static public void main(String[] args) throws IOException {
		input();
		bfs();
		System.out.println(findMax(day) != -1 ? findMax(day)-1 : findMax(day));
	}
	
	// 틈매ㅑ이러 종자심기
	static private void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tomatoes = new int[m][n];
		day = new int[m][n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());
				if (tomatoes[i][j] == -1) day[i][j] = 1;
			}
		}	
	}
	
	// 틈매ㅑ이러 탐색
	static private void bfs() {
		Queue<Tomato> q = new LinkedList<>();
		//큐에 우선 1인거 다넣기
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (tomatoes[i][j] == 1) {
					q.add(new Tomato(i, j));
					day[i][j] = 1;
				}
			}
		}
		int[] x = {1, 0, -1, 0};
		int[] y = {0, 1, 0, -1};
		
		while(!q.isEmpty()) {
			Tomato now = q.remove();
			int row = now.row;
			int col = now.col;
			
			for (int i=0; i<x.length; i++) {
				int _x = row + x[i];
				int _y = col + y[i];
				
				if (valid(_x, _y)) {
					q.add(new Tomato(_x, _y));
					day[_x][_y] = day[row][col] + 1;
				}
			}
		}		
	}
	
	static private boolean valid(int row, int col) {
		// 상하좌우 탐색
		if (row < 0 || row > m-1 || col < 0 || col > n-1) return false;
		// -1이면 못지나가고, 방문되었으면 (0보다 크면) 못지나감
		if (tomatoes[row][col] == -1 || day[row][col] > 0) return false;
		return true;
	}
	
	// 2차원 배열에서 제일 큰 수 찾기
	static private int findMax(int[][] array) {
		int result = 0;
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j<array[i].length; j++) {
				if (result < array[i][j]) result = array[i][j];
				if (array[i][j] == 0) return -1;
			}
		}
		return result;
	}
}

class Tomato {
	int row;
	int col;
	Tomato(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
