package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PARENTHESES {
	public static char st[] = new char[100];
	public static int top;
	
	public static void initStack() {
		top = -1;
	}
	
	public static boolean isEmpty() {
		return (top < 0);
	}
	
	public static void push(char x) {
		// ++top ~ top = top + 1 --> st[top] = x
		st[++top] = x;
	}
	
	public static char pop() {
		if (top > -1) {
			top--;
			return st[top + 1];
		}
		else {
			return ' ';
		}
	}
	
	public static char peek() {
		if (top > -1) {
			return st[top];
		}
		else {
			return ' ';
		}
	}
	
	public static boolean CheckParentesis(String str, int n) {
		if(str.isEmpty()) {
			return true;
		}
		
		for(int i = 0; i < n; i++) {
			char current = str.charAt(i);
			if(current == '<' || current == '{' || current == '[' || current == '(') {
				push(current);
			}
			
			if (current == '>' || current == '}' || current == ']' || current == ')') {
				if(isEmpty()) {
					return false;
				}
				
				char last = peek();
				if(current == '>' && last == '<' || current == '}' && last == '{' || current == ']' && last == '[' || current == ')' && last == '(') {
					pop();
				}
				else {
					return false;
				}
			}
		}
		return isEmpty();
	}
	
	public static void main(String[] args) throws IOException {				
		FileReader fReader = new FileReader("src\\input7.txt");			
		Scanner scanner = new Scanner(fReader);			
					
		// https://www.spoj.com/problems/PARENTHESES/
		int tc = 10;
		for(int count = 1; count <= tc; count++) {
			initStack();
			int n = scanner.nextInt();
			scanner.nextLine();
			scanner.nextLine();
			String str = scanner.nextLine();
			if (CheckParentesis(str, n)) {
				System.out.println("#" + count + " " + 1);
				System.out.println();
			}
			else {
				System.out.println("#" + count + " " + 0);
				System.out.println();
			}
		}
		
		fReader.close();	
	}				
}
