import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static public void main(String[] args) throws IOException {
		
		int caseNum =Integer.parseInt(br.readLine());
		int[] cases = new int[caseNum];
		
		for (int c=0; c<caseNum; c ++) {
			st = new StringTokenizer(br.readLine());	
			int country = Integer.parseInt(st.nextToken());
			int airline = Integer.parseInt(st.nextToken());
			
			for (int i=0; i<airline; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			}
			cases[c] = country-1;	
		}
	
		for(int value : cases) System.out.println(value); 
		
	}
}
