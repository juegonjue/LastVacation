import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static public void main(String[] args) throws NumberFormatException, IOException {
		
		int[] dwarf = new int[9];
		int sum = 0;
		for (int i=0; i<dwarf.length; i++) {
			int value = Integer.parseInt(br.readLine()); 
			dwarf[i] = value;
			sum += value;
		}

		Arrays.sort(dwarf);
		
		sum = sum-100;		
		
		int a=0, b=0;	// 일곱난쟁이가 아닌 나머지 두명의 난쟁이
		
		for (int i=0; i<dwarf.length; i++) {
			for (int j=0; j<dwarf.length;j++) {
				if (i!=j) {
					if (dwarf[i] + dwarf[j]==sum) {
						a = i;
						b = j;
						break;
					}
				}
			}
		}
		
		for (int i=0; i<dwarf.length; i++) {
			if (i!=a && i!=b) System.out.println(dwarf[i]);
		}
		
	}
}
