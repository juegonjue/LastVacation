import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<String> sentences;
	
	static public void main(String[] args) throws IOException {
		sentences = new ArrayList<>();
		input();
		
		for (String sentence : sentences) {
			System.out.println(isBalanced(getBracket(sentence)) ? "yes" : "no");
		}
	}
	
	//괄호만 추출
	static private String getBracket(String sentence) {
		String brackets = "";
		
		for (int i=0; i<sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c=='(' || c==')' || c=='[' || c==']') brackets += c;
		}
		return brackets;
	}
	
	//괄호가 짝을 이루는지 bool값 리턴
	static private boolean isBalanced(String brackets) {
		boolean balance = false;
		if (brackets.length()==0) return true;
		else {
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<brackets.length(); i++) {
				char c = brackets.charAt(i);
				if (c=='(' || c=='[') stack.push(c);
				else {	// ), ]
					if (stack.isEmpty()) {
						balance = false;
						break;
					}
					else {
						char open = stack.pop();
						if (c==')') {
							if (open=='(') balance = true;
							else {
								balance = false;
								break;
							}
						}
						else {	// ]
							if (open=='[') balance = true;
							else {
								balance = false;
								break;
							}
						}
					}
				}
				//끝까지 도달했는데 스택이 비어있지 않으면 false
				if (i==brackets.length()-1 && !stack.isEmpty()) balance = false;
			}		
		}
		return balance;
	}
	
	//input
	static private void input() throws IOException {
		while (true) {
			String sentence = br.readLine();
			if (sentence.equals(".")) return;
			sentences.add(sentence);
		}
	}
}